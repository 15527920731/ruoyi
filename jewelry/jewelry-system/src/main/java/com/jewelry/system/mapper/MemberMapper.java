package com.jewelry.system.mapper;

import com.jewelry.system.domain.Member;
import java.util.List;	

/**
 * 用户管理 数据层
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public interface MemberMapper 
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
     * 删除用户管理
     * 
     * @param id 用户管理ID
     * @return 结果
     */
	public int deleteMemberById(Long id);
	
	/**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberByIds(String[] ids);


	public Member selectMemberByPhone(String phone);
}