package com.jewelry.system.mapper;

import com.jewelry.system.domain.About;
import java.util.List;	

/**
 * 关于我们 数据层
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public interface AboutMapper 
{
	/**
     * 查询关于我们信息
     * 
     * @param id 关于我们ID
     * @return 关于我们信息
     */
	public About selectAboutById(Long id);
	
	/**
     * 查询关于我们列表
     * 
     * @param about 关于我们信息
     * @return 关于我们集合
     */
	public List<About> selectAboutList(About about);
	
	/**
     * 新增关于我们
     * 
     * @param about 关于我们信息
     * @return 结果
     */
	public int insertAbout(About about);
	
	/**
     * 修改关于我们
     * 
     * @param about 关于我们信息
     * @return 结果
     */
	public int updateAbout(About about);
	
	/**
     * 删除关于我们
     * 
     * @param id 关于我们ID
     * @return 结果
     */
	public int deleteAboutById(Long id);
	
	/**
     * 批量删除关于我们
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAboutByIds(String[] ids);
	
}