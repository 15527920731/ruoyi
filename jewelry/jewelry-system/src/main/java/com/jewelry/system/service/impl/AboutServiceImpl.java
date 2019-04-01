package com.jewelry.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jewelry.system.mapper.AboutMapper;
import com.jewelry.system.domain.About;
import com.jewelry.system.service.IAboutService;
import com.jewelry.common.support.Convert;

/**
 * 关于我们 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
@Service
public class AboutServiceImpl implements IAboutService 
{
	@Autowired
	private AboutMapper aboutMapper;

	/**
     * 查询关于我们信息
     * 
     * @param id 关于我们ID
     * @return 关于我们信息
     */
    @Override
	public About selectAboutById(Long id)
	{
	    return aboutMapper.selectAboutById(id);
	}
	
	/**
     * 查询关于我们列表
     * 
     * @param about 关于我们信息
     * @return 关于我们集合
     */
	@Override
	public List<About> selectAboutList(About about)
	{
	    return aboutMapper.selectAboutList(about);
	}
	
    /**
     * 新增关于我们
     * 
     * @param about 关于我们信息
     * @return 结果
     */
	@Override
	public int insertAbout(About about)
	{
	    return aboutMapper.insertAbout(about);
	}
	
	/**
     * 修改关于我们
     * 
     * @param about 关于我们信息
     * @return 结果
     */
	@Override
	public int updateAbout(About about)
	{
	    return aboutMapper.updateAbout(about);
	}

	/**
     * 删除关于我们对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAboutByIds(String ids)
	{
		return aboutMapper.deleteAboutByIds(Convert.toStrArray(ids));
	}
	
}
