package com.jewelry.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jewelry.common.annotation.Log;
import com.jewelry.common.enums.BusinessType;
import com.jewelry.system.domain.SiteConfig;
import com.jewelry.system.service.ISiteConfigService;
import com.jewelry.framework.web.base.BaseController;
import com.jewelry.common.page.TableDataInfo;
import com.jewelry.common.base.AjaxResult;
import com.jewelry.common.utils.poi.ExcelUtil;

/**
 * 站点配置管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
@Controller
@RequestMapping("/system/siteConfig")
public class SiteConfigController extends BaseController
{
    private String prefix = "system/siteConfig";
	
	@Autowired
	private ISiteConfigService siteConfigService;
	
	@RequiresPermissions("system:siteConfig:view")
	@GetMapping()
	public String siteConfig()
	{
	    return prefix + "/siteConfig";
	}
	
	/**
	 * 查询站点配置管理列表
	 */
	@RequiresPermissions("system:siteConfig:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SiteConfig siteConfig)
	{
		startPage();
        List<SiteConfig> list = siteConfigService.selectSiteConfigList(siteConfig);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出站点配置管理列表
	 */
	@RequiresPermissions("system:siteConfig:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SiteConfig siteConfig)
    {
    	List<SiteConfig> list = siteConfigService.selectSiteConfigList(siteConfig);
        ExcelUtil<SiteConfig> util = new ExcelUtil<SiteConfig>(SiteConfig.class);
        return util.exportExcel(list, "siteConfig");
    }
	
	/**
	 * 新增站点配置管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存站点配置管理
	 */
	@RequiresPermissions("system:siteConfig:add")
	@Log(title = "站点配置管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SiteConfig siteConfig)
	{		
		return toAjax(siteConfigService.insertSiteConfig(siteConfig));
	}

	/**
	 * 修改站点配置管理
	 */
	@GetMapping("/edit")
	public String edit(ModelMap mmap)
	{
		SiteConfig siteConfig = siteConfigService.selectSiteConfigById(1L);
		mmap.put("siteConfig", siteConfig);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存站点配置管理
	 */
	@RequiresPermissions("system:siteConfig:edit")
	@Log(title = "站点配置管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SiteConfig siteConfig)
	{		
		return toAjax(siteConfigService.updateSiteConfig(siteConfig));
	}
	
	/**
	 * 删除站点配置管理
	 */
	@RequiresPermissions("system:siteConfig:remove")
	@Log(title = "站点配置管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(siteConfigService.deleteSiteConfigByIds(ids));
	}
	
}
