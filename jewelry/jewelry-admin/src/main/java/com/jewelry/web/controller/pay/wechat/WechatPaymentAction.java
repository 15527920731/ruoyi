/*
package com.jewelry.web.controller.pay.wechat;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


*/
/**
 * 微信支付
 * @author Lukas 2015年4月20日10:58:09
 * @email tanbing@eims.com.cn
 *
 *//*

public class WechatPaymentAction {
	private static final long serialVersionUID = -4116842596566903181L;
	private static Log log = LogFactory.getLog(WechatPaymentAction.class);
	private String urlParam = "";// 接口拼接的参数
	private OrderService orderService;
	
	*/
/**
	 * 创建支付
	 * @param out_trade_no 合并付款单号
	 * @param extraCommonParam 自定义参数内容参数组成：合并付款单号_会员加密标识_支付方式_支付订单数量类型payType 例如：M201503314865273_3_1_1
	 * @param money   付款金额
	 * @param info  订单描述信息
	 * @return
	 * @throws Exception
	 *//*

	public void createImage(String out_trade_no,
			BigDecimal money)
			throws Exception {
		String currTime = TenpayUtil.getCurrTime();
		String strTime = currTime.substring(8, currTime.length());
		String strRandom = TenpayUtil.buildRandom(4) + "";
		String nonce_str = strTime + strRandom;
		

		BigDecimal total_fee =money.multiply(new BigDecimal(100));
		
		String body = "铭普光磁";
		//String order_price = "2";
		//String spbill_create_ip = this.request().getRemoteAddr();
		String ip = this.request().getHeader("X-real-ip");
			
		
	        
		String notify_url = GlobalConfig.URL + "wechatNotify.do";

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", GlobalConfig.APPID);
		packageParams.put("mch_id", GlobalConfig.MCH_ID);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("out_trade_no", out_trade_no);
		packageParams.put("total_fee", total_fee.toBigInteger().toString());
		packageParams.put("spbill_create_ip",ip);
		packageParams.put("notify_url", notify_url);
		packageParams.put("trade_type", GlobalConfig.TRADE_TYPE);

		WechatPayService wechatPayService = new WechatPayService();
		String code_url = wechatPayService.getUrlCode(packageParams);

		if (code_url.equals(""))
			return;
		
		ServletOutputStream sos = this.response().getOutputStream();
		QRCodeUtil.encode(code_url, sos);
	}
	
	
	
	 
	
	


	public String getUrlParam() {
		return urlParam;
	}

	public void setUrlParam(String urlParam) {
		this.urlParam = urlParam;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}


}
*/
