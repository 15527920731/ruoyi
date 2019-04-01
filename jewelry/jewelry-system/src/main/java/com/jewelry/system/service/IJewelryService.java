package com.jewelry.system.service;

import com.jewelry.system.domain.Jewelry;
import java.util.List;

/**
 * 商品管理 服务层
 * 
 * @author ruoyi
 * @date 2019-03-27
 */
public interface IJewelryService 
{
	/**
     * 查询商品管理信息
     * 
     * @param id 商品管理ID
     * @return 商品管理信息
     */
	public Jewelry selectJewelryById(Long id);
	
	/**
     * 查询商品管理列表
     * 
     * @param jewelry 商品管理信息
     * @return 商品管理集合
     */
	public List<Jewelry> selectJewelryList(Jewelry jewelry);
	
	/**
     * 新增商品管理
     * 
     * @param jewelry 商品管理信息
     * @return 结果
     */
	public int insertJewelry(Jewelry jewelry);
	
	/**
     * 修改商品管理
     * 
     * @param jewelry 商品管理信息
     * @return 结果
     */
	public int updateJewelry(Jewelry jewelry);
		
	/**
     * 删除商品管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteJewelryByIds(String ids);

	public int approvelJewelryByIds(String ids);

	public int upJewelryByIds(String ids);

	public int downJewelryByIds(String ids);

	public String importJewelry(List<Jewelry> jewelryList,String productType,boolean updateSupport ,String operName);


}
