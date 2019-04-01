package com.jewelry.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jewelry.common.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 套餐管理表 sys_packages
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public class Packages extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 套餐名称 */
	private String packageName;
	/** 用户类型 */
	private String roleName;
	/** 套餐类型 */
	private Integer packageType;
	/** 套餐天数 */
	private Integer packageDay;
	/** 套餐费用（元） */
	private BigDecimal packageFee;
	/** 是否优惠 */
	private Integer isDiscount;
	/** 限时优惠价（元） */
	private BigDecimal discountFee;
	/** 限时优惠开始时间 */
	private Date discountStart;
	/** 限时优惠结束时间 */
	private Date discountEnd;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setPackageName(String packageName) 
	{
		this.packageName = packageName;
	}

	public String getPackageName() 
	{
		return packageName;
	}
	public void setRoleName(String roleName) 
	{
		this.roleName = roleName;
	}

	public String getRoleName() 
	{
		return roleName;
	}
	public void setPackageType(Integer packageType) 
	{
		this.packageType = packageType;
	}

	public Integer getPackageType() 
	{
		return packageType;
	}
	public void setPackageDay(Integer packageDay) 
	{
		this.packageDay = packageDay;
	}

	public Integer getPackageDay() 
	{
		return packageDay;
	}
	public void setPackageFee(BigDecimal packageFee) 
	{
		this.packageFee = packageFee;
	}

	public BigDecimal getPackageFee() 
	{
		return packageFee;
	}
	public void setIsDiscount(Integer isDiscount) 
	{
		this.isDiscount = isDiscount;
	}

	public Integer getIsDiscount() 
	{
		return isDiscount;
	}
	public void setDiscountFee(BigDecimal discountFee) 
	{
		this.discountFee = discountFee;
	}

	public BigDecimal getDiscountFee() 
	{
		return discountFee;
	}
	public void setDiscountStart(Date discountStart) 
	{
		this.discountStart = discountStart;
	}

	@JsonFormat(pattern="yyyy-MM-dd")
	public Date getDiscountStart() 
	{
		return discountStart;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
	public void setDiscountEnd(Date discountEnd) 
	{
		this.discountEnd = discountEnd;
	}

	public Date getDiscountEnd() 
	{
		return discountEnd;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("packageName", getPackageName())
            .append("roleName", getRoleName())
            .append("packageType", getPackageType())
            .append("packageDay", getPackageDay())
            .append("packageFee", getPackageFee())
            .append("isDiscount", getIsDiscount())
            .append("discountFee", getDiscountFee())
            .append("discountStart", getDiscountStart())
            .append("discountEnd", getDiscountEnd())
            .toString();
    }
}
