package com.jewelry.system.service;

import com.jewelry.system.domain.Employ;
import java.util.List;

/**
 * 人才招聘 服务层
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public interface IEmployService 
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
     * 删除人才招聘信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteEmployByIds(String ids);
	
}
