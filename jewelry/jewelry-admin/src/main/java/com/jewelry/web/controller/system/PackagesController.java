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
import com.jewelry.system.domain.Packages;
import com.jewelry.system.service.IPackagesService;
import com.jewelry.framework.web.base.BaseController;
import com.jewelry.common.page.TableDataInfo;
import com.jewelry.common.base.AjaxResult;
import com.jewelry.common.utils.poi.ExcelUtil;

/**
 * 套餐管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
@Controller
@RequestMapping("/system/packages")
public class PackagesController extends BaseController
{
    private String prefix = "system/packages";
	
	@Autowired
	private IPackagesService packagesService;
	
	@RequiresPermissions("system:packages:view")
	@GetMapping()
	public String packages()
	{
	    return prefix + "/packages";
	}
	
	/**
	 * 查询套餐管理列表
	 */
	@RequiresPermissions("system:packages:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Packages packages)
	{
		startPage();
        List<Packages> list = packagesService.selectPackagesList(packages);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出套餐管理列表
	 */
	@RequiresPermissions("system:packages:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Packages packages)
    {
    	List<Packages> list = packagesService.selectPackagesList(packages);
        ExcelUtil<Packages> util = new ExcelUtil<Packages>(Packages.class);
        return util.exportExcel(list, "packages");
    }
	
	/**
	 * 新增套餐管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存套餐管理
	 */
	@RequiresPermissions("system:packages:add")
	@Log(title = "套餐管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Packages packages)
	{		
		return toAjax(packagesService.insertPackages(packages));
	}

	/**
	 * 修改套餐管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Packages packages = packagesService.selectPackagesById(id);
		mmap.put("packages", packages);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存套餐管理
	 */
	@RequiresPermissions("system:packages:edit")
	@Log(title = "套餐管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Packages packages)
	{		
		return toAjax(packagesService.updatePackages(packages));
	}
	
	/**
	 * 删除套餐管理
	 */
	@RequiresPermissions("system:packages:remove")
	@Log(title = "套餐管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(packagesService.deletePackagesByIds(ids));
	}
	
}
