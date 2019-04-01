package com.jewelry.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jewelry.system.mapper.EmployMapper;
import com.jewelry.system.domain.Employ;
import com.jewelry.system.service.IEmployService;
import com.jewelry.common.support.Convert;

/**
 * 人才招聘 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
@Service
public class EmployServiceImpl implements IEmployService 
{
	@Autowired
	private EmployMapper employMapper;

	/**
     * 查询人才招聘信息
     * 
     * @param id 人才招聘ID
     * @return 人才招聘信息
     */
    @Override
	public Employ selectEmployById(Long id)
	{
	    return employMapper.selectEmployById(id);
	}
	
	/**
     * 查询人才招聘列表
     * 
     * @param employ 人才招聘信息
     * @return 人才招聘集合
     */
	@Override
	public List<Employ> selectEmployList(Employ employ)
	{
	    return employMapper.selectEmployList(employ);
	}
	
    /**
     * 新增人才招聘
     * 
     * @param employ 人才招聘信息
     * @return 结果
     */
	@Override
	public int insertEmploy(Employ employ)
	{
	    return employMapper.insertEmploy(employ);
	}
	
	/**
     * 修改人才招聘
     * 
     * @param employ 人才招聘信息
     * @return 结果
     */
	@Override
	public int updateEmploy(Employ employ)
	{
	    return employMapper.updateEmploy(employ);
	}

	/**
     * 删除人才招聘对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteEmployByIds(String ids)
	{
		return employMapper.deleteEmployByIds(Convert.toStrArray(ids));
	}
	
}
