package com.jewelry.system.mapper;

import com.jewelry.system.domain.Packages;
import java.util.List;	

/**
 * 套餐管理 数据层
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public interface PackagesMapper 
{
	/**
     * 查询套餐管理信息
     * 
     * @param id 套餐管理ID
     * @return 套餐管理信息
     */
	public Packages selectPackagesById(Long id);
	
	/**
     * 查询套餐管理列表
     * 
     * @param packages 套餐管理信息
     * @return 套餐管理集合
     */
	public List<Packages> selectPackagesList(Packages packages);
	
	/**
     * 新增套餐管理
     * 
     * @param packages 套餐管理信息
     * @return 结果
     */
	public int insertPackages(Packages packages);
	
	/**
     * 修改套餐管理
     * 
     * @param packages 套餐管理信息
     * @return 结果
     */
	public int updatePackages(Packages packages);
	
	/**
     * 删除套餐管理
     * 
     * @param id 套餐管理ID
     * @return 结果
     */
	public int deletePackagesById(Long id);
	
	/**
     * 批量删除套餐管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePackagesByIds(String[] ids);
	
}