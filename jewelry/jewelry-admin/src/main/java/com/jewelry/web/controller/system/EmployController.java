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
import com.jewelry.system.domain.Employ;
import com.jewelry.system.service.IEmployService;
import com.jewelry.framework.web.base.BaseController;
import com.jewelry.common.page.TableDataInfo;
import com.jewelry.common.base.AjaxResult;
import com.jewelry.common.utils.poi.ExcelUtil;

/**
 * 人才招聘 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
@Controller
@RequestMapping("/system/employ")
public class EmployController extends BaseController
{
    private String prefix = "system/employ";
	
	@Autowired
	private IEmployService employService;
	
	@RequiresPermissions("system:employ:view")
	@GetMapping()
	public String employ()
	{
	    return prefix + "/employ";
	}
	
	/**
	 * 查询人才招聘列表
	 */
	@RequiresPermissions("system:employ:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Employ employ)
	{
		startPage();
        List<Employ> list = employService.selectEmployList(employ);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出人才招聘列表
	 */
	@RequiresPermissions("system:employ:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Employ employ)
    {
    	List<Employ> list = employService.selectEmployList(employ);
        ExcelUtil<Employ> util = new ExcelUtil<Employ>(Employ.class);
        return util.exportExcel(list, "employ");
    }
	
	/**
	 * 新增人才招聘
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存人才招聘
	 */
	@RequiresPermissions("system:employ:add")
	@Log(title = "人才招聘", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Employ employ)
	{		
		return toAjax(employService.insertEmploy(employ));
	}

	/**
	 * 修改人才招聘
	 */
	@GetMapping("/edit")
	public String edit(ModelMap mmap)
	{
		Employ employ = employService.selectEmployById(1L);
		mmap.put("employ", employ);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存人才招聘
	 */
	@RequiresPermissions("system:employ:edit")
	@Log(title = "人才招聘", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Employ employ)
	{		
		return toAjax(employService.updateEmploy(employ));
	}
	
	/**
	 * 删除人才招聘
	 */
	@RequiresPermissions("system:employ:remove")
	@Log(title = "人才招聘", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(employService.deleteEmployByIds(ids));
	}
	
}
