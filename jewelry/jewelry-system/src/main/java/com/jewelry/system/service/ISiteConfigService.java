package com.jewelry.system.service;

import com.jewelry.system.domain.SiteConfig;
import java.util.List;

/**
 * 站点配置管理 服务层
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public interface ISiteConfigService 
{
	/**
     * 查询站点配置管理信息
     * 
     * @param id 站点配置管理ID
     * @return 站点配置管理信息
     */
	public SiteConfig selectSiteConfigById(Long id);
	
	/**
     * 查询站点配置管理列表
     * 
     * @param siteConfig 站点配置管理信息
     * @return 站点配置管理集合
     */
	public List<SiteConfig> selectSiteConfigList(SiteConfig siteConfig);
	
	/**
     * 新增站点配置管理
     * 
     * @param siteConfig 站点配置管理信息
     * @return 结果
     */
	public int insertSiteConfig(SiteConfig siteConfig);
	
	/**
     * 修改站点配置管理
     * 
     * @param siteConfig 站点配置管理信息
     * @return 结果
     */
	public int updateSiteConfig(SiteConfig siteConfig);
		
	/**
     * 删除站点配置管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSiteConfigByIds(String ids);
	
}
