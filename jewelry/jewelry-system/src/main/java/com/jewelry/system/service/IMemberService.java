package com.jewelry.system.service;

import com.jewelry.system.domain.Member;
import com.jewelry.system.domain.SysUser;

import javax.servlet.http.Cookie;
import java.util.List;

/**
 * 用户管理 服务层
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public interface IMemberService 
{
	/**
     * 查询用户管理信息
     * 
     * @param id 用户管理ID
     * @return 用户管理信息
     */
	public Member selectMemberById(Long id);
	
	/**
     * 查询用户管理列表
     * 
     * @param member 用户管理信息
     * @return 用户管理集合
     */
	public List<Member> selectMemberList(Member member);


	public Member selectMemberByPhone(String phone);

	public void login(String phone,String pwd);
	
	/**
     * 新增用户管理
     * 
     * @param member 用户管理信息
     * @return 结果
     */
	public int insertMember(Member member);
	
	/**
     * 修改用户管理
     * 
     * @param member 用户管理信息
     * @return 结果
     */
	public int updateMember(Member member);
		
	/**
     * 删除用户管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberByIds(String ids);

	public Cookie codeLogin(String phone, String code);

	public Cookie passwordLogin(String phone, String password);
}
