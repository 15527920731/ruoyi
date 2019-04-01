package com.jewelry.system.service.impl;

import java.util.Date;
import java.util.List;

import com.jewelry.common.exception.BusinessException;
import com.jewelry.common.utils.StringUtils;
import com.jewelry.system.utils.JwtUtils;
import com.jewelry.system.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jewelry.system.mapper.MemberMapper;
import com.jewelry.system.domain.Member;
import com.jewelry.system.service.IMemberService;
import com.jewelry.common.support.Convert;

import javax.servlet.http.Cookie;

/**
 * 用户管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
@Service
public class MemberServiceImpl implements IMemberService 
{
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private JwtUtils jwtUtils;

	/**
     * 查询用户管理信息
     * 
     * @param id 用户管理ID
     * @return 用户管理信息
     */
    @Override
	public Member selectMemberById(Long id)
	{
	    return memberMapper.selectMemberById(id);
	}
	
	/**
     * 查询用户管理列表
     * 
     * @param member 用户管理信息
     * @return 用户管理集合
     */
	@Override
	public List<Member> selectMemberList(Member member)
	{
	    return memberMapper.selectMemberList(member);
	}

	@Override
	public Member selectMemberByPhone(String phone) {
		return memberMapper.selectMemberByPhone(phone);
	}


	public void login(String phone,String password){

	}
	/**
     * 新增用户管理
     * 
     * @param member 用户管理信息
     * @return 结果
     */
	@Override
	public int insertMember(Member member)
	{
	    return memberMapper.insertMember(member);
	}
	
	/**
     * 修改用户管理
     * 
     * @param member 用户管理信息
     * @return 结果
     */
	@Override
	public int updateMember(Member member)
	{
	    return memberMapper.updateMember(member);
	}

	/**
     * 删除用户管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMemberByIds(String ids)
	{
		return memberMapper.deleteMemberByIds(Convert.toStrArray(ids));
	}

	@Override
	public Cookie codeLogin(String phone, String code) {
		Member member=memberMapper.selectMemberByPhone(phone);
		if(member==null){
			throw new BusinessException("手机号不存在！");
		}
		String cc=redisUtil.get(phone+"D");
		if(StringUtils.isEmpty(cc)){
			throw new BusinessException("验证码已过期！");
		}
		if(!code.equals(cc)){
			throw new BusinessException("验证码错误！");
		}
		//判断用户级别，是否能登录还是已经过期
		//体验用户，登陆过就不能登录了
		Date loginTime=member.getLoginTime();
		if(loginTime!=null){
			if("C2T".equals(member.getLevel())
			|| "B1T".equals(member.getLevel())
			|| "B2T".equals(member.getLevel())
			){
				throw new BusinessException("体验账号已过期！");
			}
		}
		//登录成功--写入登录时间
		member.setLoginTime(new Date());
		updateMember(member);
		//信息保存到cookie
		return getCookie(member.getId());
	}





	@Override
	public Cookie passwordLogin(String phone, String password) {
		Member member=memberMapper.selectMemberByPhone(phone);
		if(member==null){
			throw new BusinessException("手机号不存在！");
		}




		if(!password.equals(member.getPassword())){
			throw new BusinessException("密码错误！");
		}
		return getCookie(member.getId());
	}







	private Cookie getCookie(long memberId) {
		String token = jwtUtils.generateToken(memberId);
		return new Cookie(jwtUtils.getHeader(), token);
	}


}
