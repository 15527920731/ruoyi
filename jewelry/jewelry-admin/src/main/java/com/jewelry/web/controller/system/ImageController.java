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
import com.jewelry.system.domain.Image;
import com.jewelry.system.service.IImageService;
import com.jewelry.framework.web.base.BaseController;
import com.jewelry.common.page.TableDataInfo;
import com.jewelry.common.base.AjaxResult;
import com.jewelry.common.utils.poi.ExcelUtil;

/**
 * 图片管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-27
 */
@Controller
@RequestMapping("/system/image")
public class ImageController extends BaseController
{
    private String prefix = "system/image";
	
	@Autowired
	private IImageService imageService;
	
	@RequiresPermissions("system:image:view")
	@GetMapping()
	public String image()
	{
	    return prefix + "/image";
	}
	
	/**
	 * 查询图片管理列表
	 */
	@RequiresPermissions("system:image:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Image image)
	{
		startPage();
        List<Image> list = imageService.selectImageList(image);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出图片管理列表
	 */
	@RequiresPermissions("system:image:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Image image)
    {
    	List<Image> list = imageService.selectImageList(image);
        ExcelUtil<Image> util = new ExcelUtil<Image>(Image.class);
        return util.exportExcel(list, "image");
    }
	
	/**
	 * 新增图片管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存图片管理
	 */
	@RequiresPermissions("system:image:add")
	@Log(title = "图片管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Image image)
	{		
		return toAjax(imageService.insertImage(image));
	}

	/**
	 * 修改图片管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Image image = imageService.selectImageById(id);
		mmap.put("image", image);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存图片管理
	 */
	@RequiresPermissions("system:image:edit")
	@Log(title = "图片管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Image image)
	{		
		return toAjax(imageService.updateImage(image));
	}
	
	/**
	 * 删除图片管理
	 */
	@RequiresPermissions("system:image:remove")
	@Log(title = "图片管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(imageService.deleteImageByIds(ids));
	}
	
}
