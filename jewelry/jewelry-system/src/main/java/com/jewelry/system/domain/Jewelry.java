package com.jewelry.system.domain;

import com.jewelry.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jewelry.common.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品管理表 sys_jewelry
 *
 * @author ruoyi
 * @date 2019-03-27
 */
public class Jewelry extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** ID主键 */
	private Long id;

	/** 货号 */
	@Excel(name = "货号(必填)")
	private String huoHao;

	/** 宝石品种 */
	@Excel(name = "宝石品种",
			combo = "彩色蓝宝,海蓝宝,摩根石,坦桑石,尖晶石,沙弗莱")
	private String jewelryType;
	/** 首饰类型 */
	@Excel(name = "首饰类型",
			combo = "不限,首饰,项饰,腕饰,胸饰")
	private String shouShiType;
	/** 品牌 */
	@Excel(name = "品牌")
	private Long pinPai;
	/** 版型 */
	@Excel(name = "版型"
	)
	private String banXing;
	/** 库存地 */
	@Excel(name = "库存地",
			combo = "境内,境外,现存")
	private String kuCunDi;
	/** 宝石琢形 */
	@Excel(name = "宝石琢形",
			combo = "圆形刻面,椭圆刻面,祖母绿刻面," +
					"水滴刻面,阿斯切形,马眼刻面," +
					"心形刻面,公主方形,垫形刻面,雷迪恩刻面,三角刻面,异形刻面")
	private String baoShiZhuoXing;

	/** 抛光 */
	@Excel(name = "抛光", combo = "EX,VG,G,Fiar,Poor")
	private String paoGuang;
	/** 对称性 */
	@Excel(name = "对称性", combo = "EX,VG,G,Fiar,Poor")
	private String duiChengXing;
	/** 状态 */
	@Excel(name = "状态")
	private String zhuangTai;
	/** 色调 */
	@Excel(name = "色调", combo = "Blue,Yellow,Pink,Green,pR,R,oR,B,gB,pB,G,yG,bG,Red,Orange,Cyan,Purple")
	private String seDiao;
	/** 颜色 */
	@Excel(name = "颜色",combo ="D,E,F,G,H,I,J,K,M")
	private String yanSe;
	/** 净度 */
	@Excel(name = "净度",combo="FL/IF,VVS1,VVS2,VS1,VS2,SI1,SI2,SI3,P1,P2,P3")
	private String jingDu;
	/** 尺寸规格 */
	@Excel(name = "尺寸规格")
	private String chiCunGuiGe;
	/** 色级 */
	@Excel(name = "色级",combo="Faint,Very Light,Light,Fancy Light,Fancy,Fancy Intense,Fancy Vivid,Fancy Deep,Fancy Dark")
	private String seJi;
	/** 荧光 */
	@Excel(name = "荧光",combo="无,微,中,强")
	private String yingGuang;
	/** 彩度 */
	@Excel(name = "彩度",combo="Deep Red,Vivid Red,Intense Red,Red,Deep Blue,Vivid Blue,Intense Blue,Medium Blue,Light Blue,Deep Green,Vivid Green,Intense Green,Medium Green,Light Green")
	private String caiDu;
	/** 优化 */
	@Excel(name = "优化",combo="N,H,H1,H2,H3")
	private String youHua;
	/** 火彩 */
	@Excel(name = "火彩",combo="B1,B2,B3,B4")
	private String huoCai;
	/** 奶咖 */
	@Excel(name = "奶咖",combo="无,浅奶,奶,浅咖,咖")
	private String naiKa;
	/** 货期 */
	@Excel(name = "货期")
	private String huoQi;
	/** 切工 */
	@Excel(name = "切工",combo = "EX,VG,G,Fiar,Poor")
	private String qieGong;
	/** 鉴定机构 */
	@Excel(name = "鉴定机构", combo = "GIA,IGI,HRD,NGTC")
	private String jianDingJiGou;
	/** 证书号 */
	@Excel(name = "证书号")
	private String zhengShuHao;
	/** 库存 */
	@Excel(name = "库存")
	private Integer kuCun;
	/** 重量 */
	@Excel(name = "重量")
	private String zhongLiang;
	/** 主石重 */
	@Excel(name = "主石重")
	private String zhuShiZhong;
	/** 配石重 */
	@Excel(name = "配石重")
	private String peiShiZhong;
	/** 金重 */
	@Excel(name = "金重")
	private String jinZhong;
	/** 贵金属 */
	@Excel(name = "贵金属",combo="不限,普通,精工")
	private String guiJinShu;
	/** 工艺 */
	@Excel(name = "工艺",combo="精工,1:1,代购")
	private String gongYi;

	/** 进货价 */
	@Excel(name = "进货价")
	private BigDecimal jinHuoJia;



	@Excel(name = "B3价格")
	private BigDecimal b3DuanJia;

	/** B端价格 */
	@Excel(name = "B端价格")
	private BigDecimal bDuanJia;
	/** C端价格 */
	@Excel(name = "C端价格")
	private BigDecimal cDuanJia;

	@Excel(name = "官方价格")
	private BigDecimal officeJia;


	/** 审核时间 */
	private Date approveTime;
	/** 审核人 */
	private String approveBy;



	/** 上架状态 */
	@Excel(name = "上架状态",type =  Excel.Type.EXPORT)
	private Integer status;


	/** 商品类型 */
	@Excel(name = "商品类型",
			type = Excel.Type.EXPORT,
			combo = "无色钻石,彩色钻石,红宝石,蓝宝石,祖母绿,其它稀有,首饰款式,品牌荟萃")
	private String productType;


	/** 创建时间 */
	//@Excel(name = "创建时间",width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
	private Date createTime;





	/** 图片 */
	@Excel(name = "图片",isImage = "1",type =  Excel.Type.EXPORT,height = 50)
	private String images;
	/** 视频 */
	private String videos;


	public BigDecimal getB3DuanJia() {
		return b3DuanJia;
	}

	public void setB3DuanJia(BigDecimal b3DuanJia) {
		this.b3DuanJia = b3DuanJia;
	}

	public BigDecimal getbDuanJia() {
		return bDuanJia;
	}

	public void setbDuanJia(BigDecimal bDuanJia) {
		this.bDuanJia = bDuanJia;
	}

	public BigDecimal getcDuanJia() {
		return cDuanJia;
	}

	public void setcDuanJia(BigDecimal cDuanJia) {
		this.cDuanJia = cDuanJia;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return id;
	}
	public void setProductType(String productType)
	{
		this.productType = productType;
	}

	public String getProductType()
	{
		return productType;
	}
	public void setJewelryType(String jewelryType)
	{
		this.jewelryType = jewelryType;
	}

	public String getJewelryType()
	{
		return jewelryType;
	}
	public void setShouShiType(String shouShiType)
	{
		this.shouShiType = shouShiType;
	}

	public String getShouShiType()
	{
		return shouShiType;
	}
	public void setPinPai(Long pinPai)
	{
		this.pinPai = pinPai;
	}

	public Long getPinPai()
	{
		return pinPai;
	}
	public void setBanXing(String banXing)
	{
		this.banXing = banXing;
	}

	public String getBanXing()
	{
		return banXing;
	}
	public void setKuCunDi(String kuCunDi)
	{
		this.kuCunDi = kuCunDi;
	}

	public String getKuCunDi()
	{
		return kuCunDi;
	}
	public void setBaoShiZhuoXing(String baoShiZhuoXing)
	{
		this.baoShiZhuoXing = baoShiZhuoXing;
	}

	public String getBaoShiZhuoXing()
	{
		return baoShiZhuoXing;
	}
	public void setHuoHao(String huoHao)
	{
		this.huoHao = huoHao;
	}

	public String getHuoHao()
	{
		return huoHao;
	}
	public void setPaoGuang(String paoGuang)
	{
		this.paoGuang = paoGuang;
	}

	public String getPaoGuang()
	{
		return paoGuang;
	}
	public void setDuiChengXing(String duiChengXing)
	{
		this.duiChengXing = duiChengXing;
	}

	public String getDuiChengXing()
	{
		return duiChengXing;
	}
	public void setZhuangTai(String zhuangTai)
	{
		this.zhuangTai = zhuangTai;
	}

	public String getZhuangTai()
	{
		return zhuangTai;
	}
	public void setSeDiao(String seDiao)
	{
		this.seDiao = seDiao;
	}

	public String getSeDiao()
	{
		return seDiao;
	}
	public void setYanSe(String yanSe)
	{
		this.yanSe = yanSe;
	}

	public String getYanSe()
	{
		return yanSe;
	}
	public void setJingDu(String jingDu)
	{
		this.jingDu = jingDu;
	}

	public String getJingDu()
	{
		return jingDu;
	}
	public void setChiCunGuiGe(String chiCunGuiGe)
	{
		this.chiCunGuiGe = chiCunGuiGe;
	}

	public String getChiCunGuiGe()
	{
		return chiCunGuiGe;
	}
	public void setSeJi(String seJi)
	{
		this.seJi = seJi;
	}

	public String getSeJi()
	{
		return seJi;
	}
	public void setYingGuang(String yingGuang)
	{
		this.yingGuang = yingGuang;
	}

	public String getYingGuang()
	{
		return yingGuang;
	}
	public void setCaiDu(String caiDu)
	{
		this.caiDu = caiDu;
	}

	public String getCaiDu()
	{
		return caiDu;
	}
	public void setYouHua(String youHua)
	{
		this.youHua = youHua;
	}

	public String getYouHua()
	{
		return youHua;
	}
	public void setHuoCai(String huoCai)
	{
		this.huoCai = huoCai;
	}

	public String getHuoCai()
	{
		return huoCai;
	}
	public void setNaiKa(String naiKa)
	{
		this.naiKa = naiKa;
	}

	public String getNaiKa()
	{
		return naiKa;
	}
	public void setHuoQi(String huoQi)
	{
		this.huoQi = huoQi;
	}

	public String getHuoQi()
	{
		return huoQi;
	}
	public void setQieGong(String qieGong)
	{
		this.qieGong = qieGong;
	}

	public String getQieGong()
	{
		return qieGong;
	}
	public void setJianDingJiGou(String jianDingJiGou)
	{
		this.jianDingJiGou = jianDingJiGou;
	}

	public String getJianDingJiGou()
	{
		return jianDingJiGou;
	}
	public void setZhengShuHao(String zhengShuHao)
	{
		this.zhengShuHao = zhengShuHao;
	}

	public String getZhengShuHao()
	{
		return zhengShuHao;
	}
	public void setKuCun(Integer kuCun)
	{
		this.kuCun = kuCun;
	}

	public Integer getKuCun()
	{
		return kuCun;
	}
	public void setZhongLiang(String zhongLiang)
	{
		this.zhongLiang = zhongLiang;
	}

	public String getZhongLiang()
	{
		return zhongLiang;
	}
	public void setZhuShiZhong(String zhuShiZhong)
	{
		this.zhuShiZhong = zhuShiZhong;
	}

	public String getZhuShiZhong()
	{
		return zhuShiZhong;
	}
	public void setPeiShiZhong(String peiShiZhong)
	{
		this.peiShiZhong = peiShiZhong;
	}

	public String getPeiShiZhong()
	{
		return peiShiZhong;
	}
	public void setJinZhong(String jinZhong)
	{
		this.jinZhong = jinZhong;
	}

	public String getJinZhong()
	{
		return jinZhong;
	}
	public void setGuiJinShu(String guiJinShu)
	{
		this.guiJinShu = guiJinShu;
	}

	public String getGuiJinShu()
	{
		return guiJinShu;
	}
	public void setGongYi(String gongYi)
	{
		this.gongYi = gongYi;
	}

	public String getGongYi()
	{
		return gongYi;
	}
	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Integer getStatus()
	{
		return status;
	}
	public void setJinHuoJia(BigDecimal jinHuoJia)
	{
		this.jinHuoJia = jinHuoJia;
	}

	public BigDecimal getJinHuoJia()
	{
		return jinHuoJia;
	}
	public void setBDuanJia(BigDecimal bDuanJia)
	{
		this.bDuanJia = bDuanJia;
	}

	public BigDecimal getBDuanJia()
	{
		return bDuanJia;
	}
	public void setCDuanJia(BigDecimal cDuanJia)
	{
		this.cDuanJia = cDuanJia;
	}

	public BigDecimal getCDuanJia()
	{
		return cDuanJia;
	}
	public void setImages(String images)
	{
		this.images = images;
	}

	public String getImages()
	{
		return images;
	}
	public void setVideos(String videos)
	{
		this.videos = videos;
	}

	public String getVideos()
	{
		return videos;
	}
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getCreateTime()
	{
		return createTime;
	}
	public void setApproveTime(Date approveTime)
	{
		this.approveTime = approveTime;
	}

	public Date getApproveTime()
	{
		return approveTime;
	}
	public void setApproveBy(String approveBy)
	{
		this.approveBy = approveBy;
	}

	public String getApproveBy()
	{
		return approveBy;
	}


	public BigDecimal getOfficeJia() {
		return officeJia;
	}

	public void setOfficeJia(BigDecimal officeJia) {
		this.officeJia = officeJia;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id", getId())
				.append("productType", getProductType())
				.append("jewelryType", getJewelryType())
				.append("shouShiType", getShouShiType())
				.append("pinPai", getPinPai())
				.append("banXing", getBanXing())
				.append("kuCunDi", getKuCunDi())
				.append("baoShiZhuoXing", getBaoShiZhuoXing())
				.append("huoHao", getHuoHao())
				.append("paoGuang", getPaoGuang())
				.append("duiChengXing", getDuiChengXing())
				.append("zhuangTai", getZhuangTai())
				.append("seDiao", getSeDiao())
				.append("yanSe", getYanSe())
				.append("jingDu", getJingDu())
				.append("chiCunGuiGe", getChiCunGuiGe())
				.append("seJi", getSeJi())
				.append("yingGuang", getYingGuang())
				.append("caiDu", getCaiDu())
				.append("youHua", getYouHua())
				.append("huoCai", getHuoCai())
				.append("naiKa", getNaiKa())
				.append("huoQi", getHuoQi())
				.append("qieGong", getQieGong())
				.append("jianDingJiGou", getJianDingJiGou())
				.append("zhengShuHao", getZhengShuHao())
				.append("kuCun", getKuCun())
				.append("zhongLiang", getZhongLiang())
				.append("zhuShiZhong", getZhuShiZhong())
				.append("peiShiZhong", getPeiShiZhong())
				.append("jinZhong", getJinZhong())
				.append("guiJinShu", getGuiJinShu())
				.append("gongYi", getGongYi())
				.append("status", getStatus())
				.append("jinHuoJia", getJinHuoJia())
				.append("bDuanJia", getBDuanJia())
				.append("cDuanJia", getCDuanJia())
				.append("images", getImages())
				.append("videos", getVideos())
				.append("createTime", getCreateTime())
				.append("approveTime", getApproveTime())
				.append("approveBy", getApproveBy())
				.toString();
	}
}
