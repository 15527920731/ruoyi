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
import com.jewelry.system.domain.About;
import com.jewelry.system.service.IAboutService;
import com.jewelry.framework.web.base.BaseController;
import com.jewelry.common.page.TableDataInfo;
import com.jewelry.common.base.AjaxResult;
import com.jewelry.common.utils.poi.ExcelUtil;

/**
 * 关于我们 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
@Controller
@RequestMapping("/system/about")
public class AboutController extends BaseController
{
    private String prefix = "system/about";
	
	@Autowired
	private IAboutService aboutService;
	
	@RequiresPermissions("system:about:view")
	@GetMapping()
	public String about()
	{
	    return prefix + "/about";
	}
	
	/**
	 * 查询关于我们列表
	 */
	@RequiresPermissions("system:about:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(About about)
	{
		startPage();
        List<About> list = aboutService.selectAboutList(about);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出关于我们列表
	 */
	@RequiresPermissions("system:about:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(About about)
    {
    	List<About> list = aboutService.selectAboutList(about);
        ExcelUtil<About> util = new ExcelUtil<About>(About.class);
        return util.exportExcel(list, "about");
    }
	
	/**
	 * 新增关于我们
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存关于我们
	 */
	@RequiresPermissions("system:about:add")
	@Log(title = "关于我们", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(About about)
	{		
		return toAjax(aboutService.insertAbout(about));
	}

	/**
	 * 修改关于我们
	 */
	@GetMapping("/edit")
	public String edit( ModelMap mmap)
	{
		About about = aboutService.selectAboutById(1L);
		mmap.put("about", about);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存关于我们
	 */
	@RequiresPermissions("system:about:edit")
	@Log(title = "关于我们", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(About about)
	{		
		return toAjax(aboutService.updateAbout(about));
	}
	
	/**
	 * 删除关于我们
	 */
	@RequiresPermissions("system:about:remove")
	@Log(title = "关于我们", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(aboutService.deleteAboutByIds(ids));
	}
	
}
