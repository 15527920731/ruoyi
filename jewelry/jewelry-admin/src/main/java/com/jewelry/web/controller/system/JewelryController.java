package com.jewelry.web.controller.system;

import java.util.ArrayList;
import java.util.List;

import com.jewelry.common.utils.StringUtils;
import com.jewelry.system.domain.SysUser;
import com.jewelry.system.service.ISysUserService;
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
import com.jewelry.system.domain.Jewelry;
import com.jewelry.system.service.IJewelryService;
import com.jewelry.framework.web.base.BaseController;
import com.jewelry.common.page.TableDataInfo;
import com.jewelry.common.base.AjaxResult;
import com.jewelry.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商品管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-27
 */
@Controller
@RequestMapping("/system/jewelry")
public class JewelryController extends BaseController
{
    private String prefix = "system/jewelry";
	
	@Autowired
	private IJewelryService jewelryService;
	@Autowired
	private ISysUserService iSysUserService;
	
	@RequiresPermissions("system:jewelry:view")
	@GetMapping("/{id}")
	public String jewelry(@PathVariable String id)
	{
	    return prefix + "/jewelry"+id;
	}
	
	/**
	 * 查询商品管理列表
	 */
	@RequiresPermissions("system:jewelry:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Jewelry jewelry)
	{
		startPage();
        List<Jewelry> list = jewelryService.selectJewelryList(jewelry);
		return getDataTable(list);
	}

	@RequiresPermissions("system:jewelry:list")
	@PostMapping("/nameList")
	@ResponseBody
	public AjaxResult nameList(){
		return AjaxResult.success().put("nameList",iSysUserService.queryLoginName());
	}


	
	
	/**
	 * 导出商品管理列表
	 */
	@RequiresPermissions("system:jewelry:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Jewelry jewelry)
    {
    	List<Jewelry> list = jewelryService.selectJewelryList(jewelry);
        ExcelUtil<Jewelry> util = new ExcelUtil<Jewelry>(Jewelry.class);
        return util.exportExcel(list, "jewelry");
    }
	
	/**
	 * 新增商品管理
	 */
	@GetMapping("/add/{jId}")
	public String add(@PathVariable String jId)
	{
	    return prefix + "/add"+jId;
	}
	
	/**
	 * 新增保存商品管理
	 */
	@RequiresPermissions("system:jewelry:add")
	@Log(title = "商品管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Jewelry jewelry)
	{		
		return toAjax(jewelryService.insertJewelry(jewelry));
	}

	/**
	 * 修改商品管理
	 */
	@GetMapping("/edit/{jId}/{id}")
	public String edit(@PathVariable("jId") String jId,@PathVariable("id") Long id, ModelMap mmap)
	{
		Jewelry jewelry = jewelryService.selectJewelryById(id);
		mmap.put("jewelry", jewelry);
		String img=jewelry.getImages();
		if(StringUtils.isEmpty(img)){
			mmap.put("images", new String[]{});
		}else{
			mmap.put("images", jewelry.getImages().split(","));
		}
	    return prefix + "/edit"+jId;
	}
	
	/**
	 * 修改保存商品管理
	 */
	@RequiresPermissions("system:jewelry:edit")
	@Log(title = "商品管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Jewelry jewelry)
	{
		String operName = getSysUser().getLoginName();
		jewelry.setApproveBy(operName);
		return toAjax(jewelryService.updateJewelry(jewelry));
	}
	
	/**
	 * 删除商品管理
	 */
	@RequiresPermissions("system:jewelry:remove")
	@Log(title = "商品管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(jewelryService.deleteJewelryByIds(ids));
	}

	/**
	 * 审核商品管理-----状态待审核的变为上架
	 */
	@RequiresPermissions("system:jewelry:approvel")
	@Log(title = "商品管理", businessType = BusinessType.OTHER)
	@PostMapping( "/approvel")
	@ResponseBody
	public AjaxResult approvel(String ids)
	{
		return toAjax(jewelryService.approvelJewelryByIds(ids));
	}

	/**
	 * 审核商品管理-----状态待审核的变为上架
	 */
	@RequiresPermissions("system:jewelry:up")
	@Log(title = "商品管理", businessType = BusinessType.OTHER)
	@PostMapping( "/up")
	@ResponseBody
	public AjaxResult up(String ids)
	{
		return toAjax(jewelryService.upJewelryByIds(ids));
	}

	/**
	 * 审核商品管理-----状态待审核的变为上架
	 */
	@RequiresPermissions("system:jewelry:down")
	@Log(title = "商品管理", businessType = BusinessType.OTHER)
	@PostMapping( "/down")
	@ResponseBody
	public AjaxResult down(String ids)
	{
		return toAjax(jewelryService.downJewelryByIds(ids));
	}




	@Log(title = "商品管理", businessType = BusinessType.IMPORT)
	@RequiresPermissions("system:jewelry:import")
	@PostMapping("/importData")
	@ResponseBody
	public AjaxResult importData(MultipartFile file,String productType,boolean updateSupport) throws Exception
	{
		ExcelUtil<Jewelry> util = new ExcelUtil<Jewelry>(Jewelry.class);
		List<Jewelry> jewelryList = util.importExcel(file.getInputStream());
		String operName = getSysUser().getLoginName();
		String message = jewelryService.importJewelry(jewelryList,productType, updateSupport,operName);
		return AjaxResult.success(message);
	}

	@RequiresPermissions("system:user:view")
	@GetMapping("/importTemplate")
	@ResponseBody
	public AjaxResult importTemplate()
	{
		ExcelUtil<Jewelry> util = new ExcelUtil<Jewelry>(Jewelry.class);
		return util.importTemplateExcel("商品数据");
	}




}
