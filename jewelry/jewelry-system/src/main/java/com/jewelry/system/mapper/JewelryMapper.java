package com.jewelry.system.mapper;

import com.jewelry.system.domain.Jewelry;
import com.jewelry.system.domain.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;	

/**
 * 商品管理 数据层
 * 
 * @author ruoyi
 * @date 2019-03-27
 */
public interface JewelryMapper 
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
     * 删除商品管理
     * 
     * @param id 商品管理ID
     * @return 结果
     */
	public int deleteJewelryById(Long id);
	
	/**
     * 批量删除商品管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteJewelryByIds(String[] ids);

	/**
	 *
	 * @param ids
	 * @param oldStatus--原状态
	 * @param newStatus--要改成的状态
	 * @return
	 */
	public int statusJewelryByIds(@Param("newStatus") Integer newStatus,
								  @Param("oldStatus")Integer oldStatus,
								  @Param("ids")String[] ids);


	public Jewelry selectJewelryByHuoHao(String huoHao);
}