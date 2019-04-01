package com.jewelry.system.mapper;

import com.jewelry.system.domain.Employ;
import java.util.List;	

/**
 * 人才招聘 数据层
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public interface EmployMapper 
{
	/**
     * 查询人才招聘信息
     * 
     * @param id 人才招聘ID
     * @return 人才招聘信息
     */
	public Employ selectEmployById(Long id);
	
	/**
     * 查询人才招聘列表
     * 
     * @param employ 人才招聘信息
     * @return 人才招聘集合
     */
	public List<Employ> selectEmployList(Employ employ);
	
	/**
     * 新增人才招聘
     * 
     * @param employ 人才招聘信息
     * @return 结果
     */
	public int insertEmploy(Employ employ);
	
	/**
     * 修改人才招聘
     * 
     * @param employ 人才招聘信息
     * @return 结果
     */
	public int updateEmploy(Employ employ);
	
	/**
     * 删除人才招聘
     * 
     * @param id 人才招聘ID
     * @return 结果
     */
	public int deleteEmployById(Long id);
	
	/**
     * 批量删除人才招聘
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteEmployByIds(String[] ids);
	
}