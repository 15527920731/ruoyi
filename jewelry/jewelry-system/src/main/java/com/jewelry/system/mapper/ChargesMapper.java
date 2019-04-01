package com.jewelry.system.mapper;

import com.jewelry.system.domain.Charges;
import java.util.List;	

/**
 * 佣金管理 数据层
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public interface ChargesMapper 
{
	/**
     * 查询佣金管理信息
     * 
     * @param id 佣金管理ID
     * @return 佣金管理信息
     */
	public Charges selectChargesById(Long id);
	
	/**
     * 查询佣金管理列表
     * 
     * @param charges 佣金管理信息
     * @return 佣金管理集合
     */
	public List<Charges> selectChargesList(Charges charges);
	
	/**
     * 新增佣金管理
     * 
     * @param charges 佣金管理信息
     * @return 结果
     */
	public int insertCharges(Charges charges);
	
	/**
     * 修改佣金管理
     * 
     * @param charges 佣金管理信息
     * @return 结果
     */
	public int updateCharges(Charges charges);
	
	/**
     * 删除佣金管理
     * 
     * @param id 佣金管理ID
     * @return 结果
     */
	public int deleteChargesById(Long id);
	
	/**
     * 批量删除佣金管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteChargesByIds(String[] ids);
	
}