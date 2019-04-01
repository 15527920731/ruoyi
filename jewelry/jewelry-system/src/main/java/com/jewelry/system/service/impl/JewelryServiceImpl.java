package com.jewelry.system.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.jewelry.common.exception.BusinessException;
import com.jewelry.common.utils.Md5Utils;
import com.jewelry.common.utils.StringUtils;
import com.jewelry.system.domain.Charges;
import com.jewelry.system.domain.Image;
import com.jewelry.system.domain.SysUser;
import com.jewelry.system.mapper.ChargesMapper;
import com.jewelry.system.mapper.ImageMapper;
import com.jewelry.system.utils.BigDecimalUtils;
import com.jewelry.system.utils.ChargesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jewelry.system.mapper.JewelryMapper;
import com.jewelry.system.domain.Jewelry;
import com.jewelry.system.service.IJewelryService;
import com.jewelry.common.support.Convert;

/**
 * 商品管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-27
 */
@Service
public class JewelryServiceImpl implements IJewelryService

{
	private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
	@Autowired
	private JewelryMapper jewelryMapper;
	@Autowired
	private ImageMapper imageMapper;
	@Autowired
	private ChargesMapper chargesMapper;

	/**
     * 查询商品管理信息
     * 
     * @param id 商品管理ID
     * @return 商品管理信息
     */
    @Override
	public Jewelry selectJewelryById(Long id)
	{
	    return jewelryMapper.selectJewelryById(id);
	}
	
	/**
     * 查询商品管理列表
     * 
     * @param jewelry 商品管理信息
     * @return 商品管理集合
     */
	@Override
	public List<Jewelry> selectJewelryList(Jewelry jewelry)
	{
		List<Jewelry> jewelryList=jewelryMapper.selectJewelryList(jewelry);
		Charges charges = chargesMapper.selectChargesById(1L);
		BigDecimal bili=ChargesUtils.getCharges(charges,jewelry.getProductType());
		jewelryList.stream().forEach(e->{
			e.setB3DuanJia(BigDecimalUtils.multiply(e.getbDuanJia(),bili));
		});
	    return jewelryList;
	}
	
    /**
     * 新增商品管理
     * 
     * @param jewelry 商品管理信息
     * @return 结果
     */
	@Override
	public int insertJewelry(Jewelry jewelry)
	{
		jewelry.setStatus(1);
		jewelry.setCreateTime(new Date());
	    return jewelryMapper.insertJewelry(jewelry);
	}
	
	/**
     * 修改商品管理
     * 
     * @param jewelry 商品管理信息
     * @return 结果
     */
	@Override
	public int updateJewelry(Jewelry jewelry)
	{
		jewelry.setStatus(1);
	    return jewelryMapper.updateJewelry(jewelry);
	}

	/**
     * 删除商品管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteJewelryByIds(String ids)
	{
		return jewelryMapper.deleteJewelryByIds(Convert.toStrArray(ids));
	}

	@Override
	public int approvelJewelryByIds(String ids) {
		return jewelryMapper.statusJewelryByIds(2,1,Convert.toStrArray(ids));
	}

	@Override
	public int upJewelryByIds(String ids) {
		return jewelryMapper.statusJewelryByIds(1,3,Convert.toStrArray(ids));
	}

	@Override
	public int downJewelryByIds(String ids) {
		return jewelryMapper.statusJewelryByIds(3,2,Convert.toStrArray(ids));
	}


	@Override
	public String importJewelry(List<Jewelry> jewelryList, String productType,boolean isUpdateSupport,String operName) {
		if (StringUtils.isNull(jewelryList) || jewelryList.size() == 0)
		{
			throw new BusinessException("导入用户数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		Image image=null;
		for (Jewelry jewelry : jewelryList)
		{
			try
			{
				//货号空就继续
				if(StringUtils.isEmpty(jewelry.getHuoHao())){
					continue;
				}

				image=new Image();
				image.setHuoHao(jewelry.getHuoHao());
				String[]  urls=imageMapper.selectImageURL(jewelry.getHuoHao());
				String img=StringUtils.join(urls, ",");

				jewelry.setProductType(productType);
				jewelry.setImages(img);
				// 验证是否存在这个用户
				Jewelry j = jewelryMapper.selectJewelryByHuoHao(jewelry.getHuoHao());

				if (StringUtils.isNull(j))
				{
					jewelry.setApproveBy(operName);
					this.insertJewelry(jewelry);
					successNum++;
					successMsg.append("<br/>" + successNum + "、货号 " + jewelry.getHuoHao() + " 导入成功");
				}
				else if (isUpdateSupport)
				{
					j.setUpdateBy(operName);
					jewelry.setId(j.getId());
					this.updateJewelry(jewelry);
					successNum++;
					successMsg.append("<br/>" + successNum +  "、货号 " + jewelry.getHuoHao() + " 更新成功");
				}
				else
				{
					failureNum++;
					failureMsg.append("<br/>" + failureNum +  "、货号 " + jewelry.getHuoHao() + " 已存在");
				}


			}
			catch (Exception e)
			{
				failureNum++;
				String msg = "<br/>" + failureNum +  "、货号 " + jewelry.getHuoHao() + " 导入失败：";
				failureMsg.append(msg + e.getMessage());
				log.error(msg, e);
			}
		}
		if (failureNum > 0)
		{
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		}
		else
		{
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		return successMsg.toString();
	}

}
