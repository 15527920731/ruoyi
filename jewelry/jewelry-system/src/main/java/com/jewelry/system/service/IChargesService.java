package com.jewelry.system.service;

import com.jewelry.system.domain.Charges;
import java.util.List;

/**
 * 佣金管理 服务层
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public interface IChargesService 
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
     * 删除佣金管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteChargesByIds(String ids);
	
}
