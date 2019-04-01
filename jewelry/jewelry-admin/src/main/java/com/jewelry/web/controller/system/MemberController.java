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
import com.jewelry.system.domain.Member;
import com.jewelry.system.service.IMemberService;
import com.jewelry.framework.web.base.BaseController;
import com.jewelry.common.page.TableDataInfo;
import com.jewelry.common.base.AjaxResult;
import com.jewelry.common.utils.poi.ExcelUtil;

/**
 * 用户管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
@Controller
@RequestMapping("/system/member")
public class MemberController extends BaseController
{
    private String prefix = "system/member";
	
	@Autowired
	private IMemberService memberService;
	
	@RequiresPermissions("system:member:view")
	@GetMapping()
	public String member()
	{
	    return prefix + "/member";
	}
	
	/**
	 * 查询用户管理列表
	 */
	@RequiresPermissions("system:member:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Member member)
	{
		startPage();
        List<Member> list = memberService.selectMemberList(member);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户管理列表
	 */
	@RequiresPermissions("system:member:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Member member)
    {
    	List<Member> list = memberService.selectMemberList(member);
        ExcelUtil<Member> util = new ExcelUtil<Member>(Member.class);
        return util.exportExcel(list, "member");
    }
	
	/**
	 * 新增用户管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户管理
	 */
	@RequiresPermissions("system:member:add")
	@Log(title = "用户管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Member member)
	{		
		return toAjax(memberService.insertMember(member));
	}

	/**
	 * 修改用户管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Member member = memberService.selectMemberById(id);
		mmap.put("member", member);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户管理
	 */
	@RequiresPermissions("system:member:edit")
	@Log(title = "用户管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Member member)
	{		
		return toAjax(memberService.updateMember(member));
	}
	
	/**
	 * 删除用户管理
	 */
	@RequiresPermissions("system:member:remove")
	@Log(title = "用户管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(memberService.deleteMemberByIds(ids));
	}
	
}
