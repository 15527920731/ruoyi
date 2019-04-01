package com.jewelry.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jewelry.common.base.BaseEntity;
import java.util.Date;

/**
 * 用户管理表 sys_member
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public class Member extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 用户姓名 */
	private String name;
	/** 用户等级 */
	private String level;
	/** 角色等级 */
	private String roleLevel;
	/** 会员号 */
	private String vipNo;
	/** 手机号 */
	private String phone;
	/** 密码 */
	private String password;
	/** 邮箱 */
	private String email;
	/** 收货电话 */
	private String receivePhone;
	/** 收货地址 */
	private String receiveAddress;
	/** 登录时间 */
	private Date loginTime;
	/** 权限到期时间 */
	private Date endTime;
	/** 创建时间 */
	private Date createTime;
	/** 是否启动 */
	private Integer isEnable;
	/**  1 正常 0 虚拟删除 */
	private Integer del;
	/** 备用1 */
	private String pre1;
	/** 备用2 */
	private Integer pre2;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setLevel(String level) 
	{
		this.level = level;
	}

	public String getLevel() 
	{
		return level;
	}
	public void setRoleLevel(String roleLevel) 
	{
		this.roleLevel = roleLevel;
	}

	public String getRoleLevel() 
	{
		return roleLevel;
	}
	public void setVipNo(String vipNo) 
	{
		this.vipNo = vipNo;
	}

	public String getVipNo() 
	{
		return vipNo;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setReceivePhone(String receivePhone) 
	{
		this.receivePhone = receivePhone;
	}

	public String getReceivePhone() 
	{
		return receivePhone;
	}
	public void setReceiveAddress(String receiveAddress) 
	{
		this.receiveAddress = receiveAddress;
	}

	public String getReceiveAddress() 
	{
		return receiveAddress;
	}
	public void setLoginTime(Date loginTime) 
	{
		this.loginTime = loginTime;
	}

	public Date getLoginTime() 
	{
		return loginTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setIsEnable(Integer isEnable) 
	{
		this.isEnable = isEnable;
	}

	public Integer getIsEnable() 
	{
		return isEnable;
	}
	public void setDel(Integer del) 
	{
		this.del = del;
	}

	public Integer getDel() 
	{
		return del;
	}
	public void setPre1(String pre1) 
	{
		this.pre1 = pre1;
	}

	public String getPre1() 
	{
		return pre1;
	}
	public void setPre2(Integer pre2) 
	{
		this.pre2 = pre2;
	}

	public Integer getPre2() 
	{
		return pre2;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("level", getLevel())
            .append("roleLevel", getRoleLevel())
            .append("vipNo", getVipNo())
            .append("phone", getPhone())
            .append("password", getPassword())
            .append("email", getEmail())
            .append("receivePhone", getReceivePhone())
            .append("receiveAddress", getReceiveAddress())
            .append("loginTime", getLoginTime())
            .append("endTime", getEndTime())
            .append("createTime", getCreateTime())
            .append("isEnable", getIsEnable())
            .append("del", getDel())
            .append("pre1", getPre1())
            .append("pre2", getPre2())
            .toString();
    }
}
