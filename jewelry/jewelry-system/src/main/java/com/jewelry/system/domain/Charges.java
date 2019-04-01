package com.jewelry.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jewelry.common.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 佣金管理表 sys_charges
 * 
 * @author ruoyi
 * @date 2019-03-29
 */
public class Charges extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 无色钻石 */
	private BigDecimal wuSe;
	/** 彩色钻石 */
	private BigDecimal caiSe;
	/** 红宝石 */
	private BigDecimal hongBaoShi;
	/** 蓝宝石 */
	private BigDecimal lanBaoShi;
	/** 祖母绿 */
	private BigDecimal zuMu;
	/** 首饰款式 */
	private BigDecimal shouShi;
	/** 其它稀有 */
	private BigDecimal qiTa;
	/** 品牌荟萃 */
	private BigDecimal pinPai;
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
	public void setWuSe(BigDecimal wuSe) 
	{
		this.wuSe = wuSe;
	}

	public BigDecimal getWuSe() 
	{
		return wuSe;
	}
	public void setCaiSe(BigDecimal caiSe) 
	{
		this.caiSe = caiSe;
	}

	public BigDecimal getCaiSe() 
	{
		return caiSe;
	}
	public void setHongBaoShi(BigDecimal hongBaoShi) 
	{
		this.hongBaoShi = hongBaoShi;
	}

	public BigDecimal getHongBaoShi() 
	{
		return hongBaoShi;
	}
	public void setLanBaoShi(BigDecimal lanBaoShi) 
	{
		this.lanBaoShi = lanBaoShi;
	}

	public BigDecimal getLanBaoShi() 
	{
		return lanBaoShi;
	}
	public void setZuMu(BigDecimal zuMu) 
	{
		this.zuMu = zuMu;
	}

	public BigDecimal getZuMu() 
	{
		return zuMu;
	}
	public void setShouShi(BigDecimal shouShi) 
	{
		this.shouShi = shouShi;
	}

	public BigDecimal getShouShi() 
	{
		return shouShi;
	}
	public void setQiTa(BigDecimal qiTa) 
	{
		this.qiTa = qiTa;
	}

	public BigDecimal getQiTa() 
	{
		return qiTa;
	}
	public void setPinPai(BigDecimal pinPai) 
	{
		this.pinPai = pinPai;
	}

	public BigDecimal getPinPai() 
	{
		return pinPai;
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
            .append("wuSe", getWuSe())
            .append("caiSe", getCaiSe())
            .append("hongBaoShi", getHongBaoShi())
            .append("lanBaoShi", getLanBaoShi())
            .append("zuMu", getZuMu())
            .append("shouShi", getShouShi())
            .append("qiTa", getQiTa())
            .append("pinPai", getPinPai())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
