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
import com.jewelry.system.domain.Charges;
import com.jewelry.system.service.IChargesService;
import com.jewelry.framework.web.base.BaseController;
import com.jewelry.common.page.TableDataInfo;
import com.jewelry.common.base.AjaxResult;
import com.jewelry.common.utils.poi.ExcelUtil;

/**
 * 佣金管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
@Controller
@RequestMapping("/system/charges")
public class ChargesController extends BaseController
{
    private String prefix = "system/charges";
	
	@Autowired
	private IChargesService chargesService;
	
	@RequiresPermissions("system:charges:view")
	@GetMapping()
	public String charges()
	{
	    return prefix + "/charges";
	}
	
	/**
	 * 查询佣金管理列表
	 */
	@RequiresPermissions("system:charges:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Charges charges)
	{
		startPage();
        List<Charges> list = chargesService.selectChargesList(charges);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出佣金管理列表
	 */
	@RequiresPermissions("system:charges:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Charges charges)
    {
    	List<Charges> list = chargesService.selectChargesList(charges);
        ExcelUtil<Charges> util = new ExcelUtil<Charges>(Charges.class);
        return util.exportExcel(list, "charges");
    }
	
	/**
	 * 新增佣金管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存佣金管理
	 */
	@RequiresPermissions("system:charges:add")
	@Log(title = "佣金管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Charges charges)
	{		
		return toAjax(chargesService.insertCharges(charges));
	}

	/**
	 * 修改佣金管理
	 */
	@GetMapping("/edit")
	public String edit( ModelMap mmap)
	{
		Charges charges = chargesService.selectChargesById(1L);
		mmap.put("charges", charges);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存佣金管理
	 */
	@RequiresPermissions("system:charges:edit")
	@Log(title = "佣金管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Charges charges)
	{		
		return toAjax(chargesService.updateCharges(charges));
	}
	
	/**
	 * 删除佣金管理
	 */
	@RequiresPermissions("system:charges:remove")
	@Log(title = "佣金管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(chargesService.deleteChargesByIds(ids));
	}
	
}
