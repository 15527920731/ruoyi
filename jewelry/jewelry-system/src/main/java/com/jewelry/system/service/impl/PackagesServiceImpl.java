package com.jewelry.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jewelry.system.mapper.PackagesMapper;
import com.jewelry.system.domain.Packages;
import com.jewelry.system.service.IPackagesService;
import com.jewelry.common.support.Convert;

/**
 * 套餐管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
@Service
public class PackagesServiceImpl implements IPackagesService 
{
	@Autowired
	private PackagesMapper packagesMapper;

	/**
     * 查询套餐管理信息
     * 
     * @param id 套餐管理ID
     * @return 套餐管理信息
     */
    @Override
	public Packages selectPackagesById(Long id)
	{
	    return packagesMapper.selectPackagesById(id);
	}
	
	/**
     * 查询套餐管理列表
     * 
     * @param packages 套餐管理信息
     * @return 套餐管理集合
     */
	@Override
	public List<Packages> selectPackagesList(Packages packages)
	{
	    return packagesMapper.selectPackagesList(packages);
	}
	
    /**
     * 新增套餐管理
     * 
     * @param packages 套餐管理信息
     * @return 结果
     */
	@Override
	public int insertPackages(Packages packages)
	{
	    return packagesMapper.insertPackages(packages);
	}
	
	/**
     * 修改套餐管理
     * 
     * @param packages 套餐管理信息
     * @return 结果
     */
	@Override
	public int updatePackages(Packages packages)
	{
	    return packagesMapper.updatePackages(packages);
	}

	/**
     * 删除套餐管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePackagesByIds(String ids)
	{
		return packagesMapper.deletePackagesByIds(Convert.toStrArray(ids));
	}
	
}
