package com.jewelry.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jewelry.system.mapper.ChargesMapper;
import com.jewelry.system.domain.Charges;
import com.jewelry.system.service.IChargesService;
import com.jewelry.common.support.Convert;

/**
 * 佣金管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
@Service
public class ChargesServiceImpl implements IChargesService 
{
	@Autowired
	private ChargesMapper chargesMapper;

	/**
     * 查询佣金管理信息
     * 
     * @param id 佣金管理ID
     * @return 佣金管理信息
     */
    @Override
	public Charges selectChargesById(Long id)
	{
	    return chargesMapper.selectChargesById(id);
	}
	
	/**
     * 查询佣金管理列表
     * 
     * @param charges 佣金管理信息
     * @return 佣金管理集合
     */
	@Override
	public List<Charges> selectChargesList(Charges charges)
	{
	    return chargesMapper.selectChargesList(charges);
	}
	
    /**
     * 新增佣金管理
     * 
     * @param charges 佣金管理信息
     * @return 结果
     */
	@Override
	public int insertCharges(Charges charges)
	{
	    return chargesMapper.insertCharges(charges);
	}
	
	/**
     * 修改佣金管理
     * 
     * @param charges 佣金管理信息
     * @return 结果
     */
	@Override
	public int updateCharges(Charges charges)
	{
	    return chargesMapper.updateCharges(charges);
	}

	/**
     * 删除佣金管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteChargesByIds(String ids)
	{
		return chargesMapper.deleteChargesByIds(Convert.toStrArray(ids));
	}
	
}
