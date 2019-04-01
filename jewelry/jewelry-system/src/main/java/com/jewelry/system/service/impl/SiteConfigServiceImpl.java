package com.jewelry.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jewelry.system.mapper.SiteConfigMapper;
import com.jewelry.system.domain.SiteConfig;
import com.jewelry.system.service.ISiteConfigService;
import com.jewelry.common.support.Convert;

/**
 * 站点配置管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
@Service
public class SiteConfigServiceImpl implements ISiteConfigService 
{
	@Autowired
	private SiteConfigMapper siteConfigMapper;

	/**
     * 查询站点配置管理信息
     * 
     * @param id 站点配置管理ID
     * @return 站点配置管理信息
     */
    @Override
	public SiteConfig selectSiteConfigById(Long id)
	{
	    return siteConfigMapper.selectSiteConfigById(id);
	}
	
	/**
     * 查询站点配置管理列表
     * 
     * @param siteConfig 站点配置管理信息
     * @return 站点配置管理集合
     */
	@Override
	public List<SiteConfig> selectSiteConfigList(SiteConfig siteConfig)
	{
	    return siteConfigMapper.selectSiteConfigList(siteConfig);
	}
	
    /**
     * 新增站点配置管理
     * 
     * @param siteConfig 站点配置管理信息
     * @return 结果
     */
	@Override
	public int insertSiteConfig(SiteConfig siteConfig)
	{
	    return siteConfigMapper.insertSiteConfig(siteConfig);
	}
	
	/**
     * 修改站点配置管理
     * 
     * @param siteConfig 站点配置管理信息
     * @return 结果
     */
	@Override
	public int updateSiteConfig(SiteConfig siteConfig)
	{
	    return siteConfigMapper.updateSiteConfig(siteConfig);
	}

	/**
     * 删除站点配置管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSiteConfigByIds(String ids)
	{
		return siteConfigMapper.deleteSiteConfigByIds(Convert.toStrArray(ids));
	}
	
}
