package com.jewelry.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jewelry.common.base.BaseEntity;

/**
 * 站点配置管理表 sys_site_config
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public class SiteConfig extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 站点标题 */
	private String title;
	/** 站点关键字 */
	private String key;
	/** 站点简介 */
	private String summary;
	/** 版权申明 */
	private String declare;
	/** 备案号1 */
	private String recordNumber1;
	/** 备案号2 */
	private String recordNumber2;
	/** 联系邮箱 */
	private String email;
	/** 站点logo */
	private String logo;
	/** 修改人 */
	private String updateBy;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setKey(String key) 
	{
		this.key = key;
	}

	public String getKey() 
	{
		return key;
	}
	public void setSummary(String summary) 
	{
		this.summary = summary;
	}

	public String getSummary() 
	{
		return summary;
	}
	public void setDeclare(String declare) 
	{
		this.declare = declare;
	}

	public String getDeclare() 
	{
		return declare;
	}
	public void setRecordNumber1(String recordNumber1) 
	{
		this.recordNumber1 = recordNumber1;
	}

	public String getRecordNumber1() 
	{
		return recordNumber1;
	}
	public void setRecordNumber2(String recordNumber2) 
	{
		this.recordNumber2 = recordNumber2;
	}

	public String getRecordNumber2() 
	{
		return recordNumber2;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setLogo(String logo) 
	{
		this.logo = logo;
	}

	public String getLogo() 
	{
		return logo;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("key", getKey())
            .append("summary", getSummary())
            .append("declare", getDeclare())
            .append("recordNumber1", getRecordNumber1())
            .append("recordNumber2", getRecordNumber2())
            .append("email", getEmail())
            .append("logo", getLogo())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
