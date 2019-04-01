package com.jewelry.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jewelry.common.base.BaseEntity;
import java.util.Date;

/**
 * 图片管理表 sys_image
 * 
 * @author ruoyi
 * @date 2019-03-27
 */
public class Image extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 货号 */
	private String huoHao;
	/** 路径 */
	private String url;
	/** 创建时间 */
	private Date createTime;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setHuoHao(String huoHao) 
	{
		this.huoHao = huoHao;
	}

	public String getHuoHao() 
	{
		return huoHao;
	}
	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("huoHao", getHuoHao())
            .append("url", getUrl())
            .append("createTime", getCreateTime())
            .toString();
    }
}
