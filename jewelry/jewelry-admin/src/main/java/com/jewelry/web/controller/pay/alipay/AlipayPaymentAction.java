/*
package com.jewelry.web.controller.pay.alipay;

import java.io.BufferedOutputStream;
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

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.Websocket;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.util.AlipayNotify;
import com.alipay.util.AlipayService;
import com.opensymphony.xwork2.ActionContext;
import com.shove.Convert;
import com.shove.alipay.config.AlipayConfig;
import com.shove.util.Des3;
import com.shove.util.P;
import com.shove.web.util.JSONUtils;
import com.shove.weixin.constant.GlobalConfig;
import com.shove.weixin.service.WechatPayService;
import com.shove.weixin.utils.ResponseHandler;
import com.shove.weixin.utils.TenpayUtil;
import com.ymy.action.front.FrontAction;
import com.ymy.constants.IConstants;
import com.ymy.service.OrderService;

*/
/**
 * 支付宝支付
 * @author Lukas 2015年4月20日10:58:09
 * @email tanbing@eims.com.cn
 *
 *//*

public class AlipayPaymentAction {
	private static final long serialVersionUID = -4116842596566903181L;
	private static Log log = LogFactory.getLog(AlipayPaymentAction.class);
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

	public String createAlipayUrl(String out_trade_no,
			String extraCommonParam, double money, String info)
			throws Exception {
		// 组装接口参数，并进行加密
		Map<String, String> sPara = new HashMap<String, String>();
		// sPara.put("body","body");//订单编号
		sPara.put("_input_charset", AlipayConfig.input_charset); // 编码utf-8
		sPara.put("subject", "东莞易买元城" + info); // 订单信息
		sPara.put("total_fee", money + ""); // 支付金额
		sPara.put("service", "create_direct_pay_by_user"); // 服务
		sPara.put("notify_url", AlipayConfig.notify_url); // 支付宝通知路径
		sPara.put("partner", AlipayConfig.partner); // 支付宝合作商户Id
		sPara.put("seller_email", AlipayConfig.seller_email); // 买家支付宝账户
		sPara.put("out_trade_no", out_trade_no); // 商户系统内部订单号唯一
		sPara.put("payment_type", "1");
		sPara.put("return_url", AlipayConfig.return_url); // 支付宝支付成功返回商户页面回调
		extraCommonParam = com.shove.security.Encrypt.encryptSES(extraCommonParam, AlipayConfig.ses_key);
		extraCommonParam = URLEncoder.encode(extraCommonParam, "utf-8");
		sPara.put("extra_common_param", extraCommonParam); // 自定义字段数据
		String html = AlipayService.create_direct_pay_by_user(sPara);
		return html;
	}
	
	
	public String createAlipayUrl2(String out_trade_no,
			String extraCommonParam, double money, String info)
			throws Exception {
		
		extraCommonParam = com.shove.security.Encrypt.encryptSES(extraCommonParam, AlipayConfig.ses_key);
		extraCommonParam = URLEncoder.encode(extraCommonParam, "utf-8");
		// 组装接口参数，并进行加密
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig2.gatewayUrl,AlipayConfig2.app_id, AlipayConfig2.merchant_private_key, "json", AlipayConfig2.charset, AlipayConfig2.alipay_public_key, AlipayConfig2.sign_type); //获得初始化的AlipayClient
	    AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
	    alipayRequest.setReturnUrl(AlipayConfig2.return_url);
	    alipayRequest.setNotifyUrl(AlipayConfig2.notify_url);//在公共参数中设置回跳和通知地址
	   
	    
	    //只有nitity才传passback_params
	    info="铭普光磁";
	    	//money=0.02;
	  */
/*  String subject = new String(info.getBytes("ISO-8859-1"),"UTF-8");
	    String body =new String(info.getBytes("ISO-8859-1"),"UTF-8");*//*

	    //money=new Double(0.01);
	    alipayRequest.setBizContent("{" +
	            "    \"out_trade_no\":\""+out_trade_no+"\"," +
	            "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
	            "    \"total_amount\":"+money+"," +
	            "    \"subject\":\""+info+"\"," +
	            "    \"passback_params\":\""+extraCommonParam+"\"," +
	            "    \"extend_params\":{" +
	            "    \"sys_service_provider_id\":\"2018122962724346\"" +
	            "    }"+
	            "  }");//填充业务参数
	    
	    */
/* alipayRequest.setBizContent("{" +
	        "    \"out_trade_no\":\""+out_trade_no+"\"," +
	        "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
	        "    \"total_amount\":1.01," +
	        "    \"subject\":\""+ info+"\"," +
	        "    \"body\":\""+"铭普光磁" + info+"\"," +
	        "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
	        "    \"extend_params\":{" +
	        "    \"sys_service_provider_id\":\"2018122962724346\"" +
	        "    }"+
	        "  }");//填充业务参数
*//*

	    String form="";
	    try {
	        form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
	    } catch (AlipayApiException e) {
	        e.printStackTrace();
	    }
		return form;
	}

	*/
/**
	 * 支付宝回调方法：明
	 * @return
	 * @throws Exception
	 *//*

	public String alipayReceive() throws Exception {
		log.info("alipayReceive");
		Map<String, String> params = new HashMap<String, String>();// trade_no订单流水号
		// notify_time支付回调时间
		Map requestParams = request().getParameterMap(); // 支付宝返回的支付结果
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]: valueStr + values[i] + ",";
			}
			log.info("支付宝明调：明调参数name:"+name+"-----valueStr:"+valueStr+"");
			params.put(name, valueStr);
		}
		boolean verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig2.alipay_public_key, AlipayConfig2.charset, AlipayConfig2.sign_type); //调用SDK验证签名
		//boolean verify_result = AlipayNotify.verify(params);// 验证参数是否是支付宝那边返回过来的。
		if (!verify_result) {
			log.info("支付宝明调：验证消息是否是支付宝发出的合法消息verify_result=="+verify_result);
			return INPUT;
		}
	
		String out_buyer_out = request("out_trade_no"); // 商户内部订单号
		if (StringUtils.isBlank(out_buyer_out)) { // 订单号为空支付失败返回首页
			log.info("支付宝明调参数异常：合并付款订单号为空，out_trade_no="+out_buyer_out);
			return INPUT;
		}
		long member_Id=queryMemberId();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		int payType=1;
		String index=out_buyer_out.substring(0, 1);
		if("A".equals(index)){
			payType=2;
		}
		String  total_amount = request(" total_amount");
		try {
			//TODO 逻辑处理操作
			//1.判断订单是否支付
			list =orderService.queryOrderByAllOrderNumber(member_Id,out_buyer_out,payType);
			if(!P.ListIsEmpty(list)){
				log.info("支付宝明调参数异常,订单支付数量类型payType："+payType+",订单："+out_buyer_out+",已经支付或者订单不存在");
				return null;
			}
			//2.修改订单状态，支付方式，支付时间
			long result= orderService.updatePayOrder_Status(member_Id, out_buyer_out, 2,1, payType, "");
			if(result<0){
				log.info("支付宝明调参数异常,订单支付数量类型payType："+payType+",订单："+out_buyer_out+",支付失败，修改数据库订单状态时，result="+result);
				return null;
			}
			//TODO 逻辑处理操作
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			return null;
		}
		
		
		
		out_buyer_out = URLDecoder.decode(out_buyer_out, "utf-8"); // 编码格式转换
	
		String tradeNo = URLDecoder.decode(request("trade_no"), "utf-8");// 支付宝流水号
		//String notify_time = URLDecoder.decode(request("notify_time"), "utf-8");// 支付宝时间
		String paybank ="";
		if(StringUtils.isBlank(request("paybank"))){
			paybank = "支付宝支付:";
			log.info("支付银行：支付银行卡号，支付银行="+paybank);
		}else{
			paybank = URLDecoder.decode(request("paybank"), "utf-8");//支付银行
			log.info("支付银行：支付银行卡号，支付银行="+paybank);
		}
		
		String money_ = P.strTodouble(Convert.strToDouble(request("total_fee"), 0))+"";// 总金额
		log.info("买家支付金额:money_="+money_);
		
		
		
		// 备注 订单号加支付方式加支付金额
		String remark = paybank + "订单号" + out_buyer_out + "支付金额为"+ new BigDecimal(money_) + "元";
		String remark1 = paybank;
		String remark2 = "订单号：" + out_buyer_out;
		String remark3 = new BigDecimal(money_) + "元";
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("extraCommonParam", extraCommonParam);
		map.put("total_fee", new BigDecimal(money_));
		map.put("out_buyer_out", out_buyer_out);
		map.put("tradeNo", tradeNo);
		// map.put("paybank", paybank);
		map.put("buyer_email", "buyer_email");
		map.put("buyer_id", "buyer_id");
		//map.put("notify_time", notify_time);
		map.put("remark", remark);
		map.put("remark1", remark1);
		map.put("remark2", remark2);
		map.put("remark3", remark3);
		map.put("type", IConstants.ONLINE_TYPE); // 支付方式 支付宝支付
		request().setAttribute("map", map);
		log.error("参数信息========================================");
		for (String key : map.keySet()) {
			log.info("====="+key+":"+map.get(key));
		}
		log.error("参数信息========================================");
		//List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		long result = -1L;
		
		
		
		ActionContext.getContext().put("allNum", out_buyer_out);
		ActionContext.getContext().put("payType", payType);
		
		
		
		
		
		return SUCCESS;
	}

	*/
/**
	 * 支付宝回调方法：暗
	 * @return
	 * @throws Exception
	 *//*

	public String alipayNotify() throws Exception {
		log.info("进入暗调处理页面alipayNotify");
		HttpServletResponse httpServletResponse = ServletActionContext
				.getResponse();
		httpServletResponse.setCharacterEncoding("utf-8");
		PrintWriter pw = httpServletResponse.getWriter();
		Map<String, String> params = new HashMap<String, String>();// trade_no订单流水号
		// notify_time支付回调时间
		Map requestParams = request().getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			*/
/*if("subject".equals(name)){
				continue;
			}*//*

			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]: valueStr + values[i] + ",";
			}
			params.put(name, valueStr);//new String (valueStr.getBytes("ISO-8859-1"),"utf-8"));
		}
		log.info("参数验证======================================");
		for (String key : params.keySet()) {
			log.info("====="+key+":"+params.get(key));
		}
		log.info("参数验证======================================");
		//boolean verify_result = AlipayNotify.verify(params);// 验证参数是否是支付宝那边返回过来的。
		String extra_common_param2 = request("passback_params");// 获得参数信息
		boolean verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig2.alipay_public_key, AlipayConfig2.charset, AlipayConfig2.sign_type); //调用SDK验证签名
		
		if (!verify_result) {
			log.info("支付宝暗调：验证消息是否是支付宝发出的合法消息verify_result=="+verify_result);
			//return null;
		}
		String extra_common_param = request("passback_params");// 获得参数信息
		log.info("extra_common_param："+extra_common_param);
		 // 支付类型_订单编号/金钱_用户编号
		if (StringUtils.isBlank(extra_common_param)) {
			log.info("支付宝暗调参数异常：extra_common_param="+extra_common_param);
			return null;
		}
		extra_common_param = URLDecoder.decode(extra_common_param, "utf-8");
		log.info("返回的extra_common_param(decode)参数:"+extra_common_param);
		extra_common_param = com.shove.security.Encrypt.decryptSES(extra_common_param, AlipayConfig.ses_key);
		log.info("返回的extra_common_param(decryptSES)参数:"+extra_common_param);
		String[] extraCommonParam = extra_common_param.split("_");
		if (extraCommonParam == null || extraCommonParam.length != 4) {// 通过"_"进行截取，判断是否符合规范
			log.info("支付宝暗调参数异常：参数不符合规范，extra_common_param");
			return null;
		}
		long member_Id = Convert.strToLong(extraCommonParam[1].toString(), -1L);// 会员标识
		if(member_Id==-1L){
			log.info("支付宝暗调参数异常：会员标识为-1，member_Id="+member_Id);
			return null;
		}
		Integer type = Convert.strToInt(extraCommonParam[2], 0);// 支付方式
		if (type != IConstants.ONLINE_TYPE) {
			log.info("支付宝暗调参数异常：参数不符合规范,支付方式异常，type="+type);
			return null;
		}
		int payType=Convert.strToInt(extraCommonParam[3].toString(), -1);//支付几个订单  payType=1 一个订单， payType=2 多个订单
		if (payType ==-1) {
			log.info("支付宝暗调参数异常：参数不符合规范,支付几个订单，payType="+payType);
			return null;
		}
		String out_buyer_out = request("out_trade_no"); // 商户内部订单号
		if (StringUtils.isBlank(out_buyer_out)) { // 订单号为空支付失败返回首页
			log.info("支付宝暗调参数异常：合并付款订单号为空，out_trade_no="+out_buyer_out);
			return INPUT;
		}
		out_buyer_out = URLDecoder.decode(out_buyer_out, "utf-8"); // 编码格式转换
		*/
/*String sellerEmail = request("seller_email");// 商户邮箱
		if (!sellerEmail.equals(AlipayConfig.seller_email)) {// 比较商户邮箱看是否符合
			log.info("支付宝暗调参数异常：商户邮箱不正确，实际的sellerEmail="+AlipayConfig.seller_email+"，返回的sellerEmail="+sellerEmail);
			return null;
		}*//*

		String tradeNo = URLDecoder.decode(request("trade_no"), "utf-8");// 支付宝编号
		String notify_time = URLDecoder.decode(request("notify_time"), "utf-8");// 支付宝编号
		String paybank ="";
		if(StringUtils.isBlank(request("paybank"))){
			paybank = "支付宝支付:";
			log.info("支付银行：支付银行卡号，支付银行="+paybank);
		}else{
			paybank = URLDecoder.decode(request("paybank"), "utf-8");//支付银行
			log.info("支付银行：支付银行卡号，支付银行="+paybank);
		}
		out_buyer_out = URLDecoder.decode(out_buyer_out, "utf-8"); // 编码格式转换
		//String buyer_email = URLDecoder.decode(request("buyer_email"), "utf-8");// 支付银行
		String buyer_id = URLDecoder.decode(request("buyer_id"), "utf-8");// 支付银行
		String money_ = P.strTodouble(Convert.strToDouble(request("total_fee"), 0))+"";// 总金额
		// 备注 订单号加支付方式加支付金额
		String remark = paybank + "订单号" + out_buyer_out + "支付金额为"+ new BigDecimal(money_) + "元";
		String remark1 = paybank;
		String remark2 = "订单号：" + out_buyer_out;
		String remark3 = "支付金额：" + new BigDecimal(money_) + "元";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("extraCommonParam", extraCommonParam);
		map.put("total_fee", new BigDecimal(money_));
		map.put("tradeNo", tradeNo);
		map.put("paybank", paybank);
		map.put("buyer_email", "buyer_email");
		map.put("buyer_id", buyer_id);
		map.put("notify_time", notify_time);
		map.put("out_buyer_out", out_buyer_out);
		map.put("remark", remark);
		map.put("remark1", remark1);
		map.put("remark2", remark2);
		map.put("remark3", remark3);
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		long result = -1L;
		Integer orderId = Convert.strToInt(extraCommonParam[0], 0);
		try {
			//TODO 逻辑处理操作
			//1.判断订单是否支付
			list =orderService.queryOrderByAllOrderNumber(member_Id,out_buyer_out,payType);
			if(!P.ListIsEmpty(list)){
				log.info("支付宝暗调参数异常,订单支付数量类型payType："+payType+",订单："+out_buyer_out+",已经支付或者订单不存在");
				return null;
			}
			//2.修改订单状态，支付方式，支付时间
			result= orderService.updatePayOrder_Status(member_Id, out_buyer_out, 2,1, payType, "");
			if(result<0){
				log.info("支付宝暗调参数异常,订单支付数量类型payType："+payType+",订单："+out_buyer_out+",支付失败，修改数据库订单状态时，result="+result);
				return null;
			}
			//TODO 逻辑处理操作
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			return null;
		}
		if (result <= 0) {
			return null;
		}
		return null;

	}
	
	
	
	
	*/
/*public String refund() throws AlipayApiException, IOException{
		JSONObject json=new JSONObject();
		//AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",AlipayConfig2.app_id,AlipayConfig2.merchant_private_key,"json",AlipayConfig2.charset,AlipayConfig2.alipay_public_key,AlipayConfig2.sign_type);
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
		
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig2.gatewayUrl, AlipayConfig2.app_id, AlipayConfig2.merchant_private_key, "json", AlipayConfig2.charset, AlipayConfig2.alipay_public_key, AlipayConfig2.sign_type);
		
		
		String order_number = request("order_number");
		request.setBizContent("{" +
		"    \"out_trade_no\":\""+order_number+"\"," +
		"    \"refund_amount\":0.01," +
		"    \"refund_reason\":\"正常退款\"" +
		"  }");
		AlipayTradeRefundResponse response = alipayClient.execute(request);
		if(response.isSuccess()){
			System.out.println("调用成功");
			json.put("type", 1);
		} else {
			System.out.println("调用失败");
			json.put("type", -1);
		}
		JSONUtils.printObject(json);
		return null;
		
	}*//*

	
	
	

	*/
/**
	 * 微信回调
	 * @return
	 * @throws Exception
	 *//*

	public String wechatNotify() throws Exception {
		 ResponseHandler resHandler = new ResponseHandler(this.request(), this.response());
	     resHandler.setKey(GlobalConfig.KEY);
	     boolean suscess=true;
		log.info("alipayReceive");
	
		String resXml = "";
		resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
		
		
		boolean verify_result = resHandler.isTenpaySign();
		//boolean verify_result = AlipayNotify.verify(params);// 验证参数是否是支付宝那边返回过来的。
		if (!verify_result) {
			log.info("微信验签verify_result=="+verify_result);
			 resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
	                 + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
			 suscess=false;
		}
		String out_buyer_out =resHandler.getParameter("out_trade_no"); // 商户内部订单号
		if (StringUtils.isBlank(out_buyer_out)) { // 订单号为空支付失败返回首页
			log.info("支付宝明调参数异常：合并付款订单号为空，out_trade_no="+out_buyer_out);
			 
			resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
	                 + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
			suscess=false;
		}
		 String money_=resHandler.getParameter("total_fee");
		 if (StringUtils.isBlank(money_)) { // 订单号为空支付失败返回首页
				log.info("金额money="+money_);
				 resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
		                 + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
				 suscess=false;
		}
		
		
	
		//String money_ = P.strTodouble(Convert.strToDouble(request("total_fee"), 0))+"";// 总金额
		log.info("买家支付金额:money_="+money_);
		// 备注 订单号加支付方式加支付金额
		String remark = "微信" + "订单号" + out_buyer_out + "支付金额为"+ new BigDecimal(money_) + "元";
		String remark1 = "微信";
		String remark2 = "订单号：" + out_buyer_out;
		String remark3 = new BigDecimal(money_) + "元";
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("extraCommonParam", extraCommonParam);
		map.put("total_fee", new BigDecimal(money_));
		map.put("out_buyer_out", out_buyer_out);
		map.put("tradeNo", out_buyer_out);
		// map.put("paybank", paybank);
		map.put("buyer_email", "buyer_email");
		map.put("buyer_id", "buyer_id");
		//map.put("notify_time", notify_time);
		map.put("remark", remark);
		map.put("remark1", remark1);
		map.put("remark2", remark2);
		map.put("remark3", remark3);
		map.put("type", IConstants.ONLINE_TYPE); // 支付方式 支付宝支付
		request().setAttribute("map", map);
		log.error("参数信息========================================");
		for (String key : map.keySet()) {
			log.info("====="+key+":"+map.get(key));
		}
		log.error("参数信息========================================");
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		long result = -1L;
		
		int payType=1;
		String index=out_buyer_out.substring(0, 1);
		if("A".equals(index)){
			payType=2;
		}
		
		ActionContext.getContext().put("allNum", out_buyer_out);
		ActionContext.getContext().put("payType", payType+"");
		String member_id="";
		Long member_Id=queryMemberId();
		List<Map<String, Object>> listOrder=orderService.queryOrderByAllOrderNumber2(out_buyer_out,payType);
		if(P.ListIsEmpty(listOrder)){
			log.info("支付宝明调,订单支付数量类型payType："+payType+",订单："+out_buyer_out+",已经支付，已经支付或者订单不存在");
			 resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
	                 + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
			 suscess=false;
		}else{
			//判断支付价格是否是订单折扣价
			Map<String, Object> orderDetail=listOrder.get(0);
			BigDecimal discount_rate=new BigDecimal(orderDetail.get("discount_rate").toString());
				
			
			log.error("AA========================================");
			member_id=orderDetail.get("member_id").toString();
			log.error("BB========================================"+member_id);
			
			
			//;
			
			//如果订单已支付，直接结束
			String order_status=orderDetail.get("order_status").toString();
			if(!"1".equals(order_status)){
				 resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
		                 + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
				 suscess=false;
			}
			
			
			//金额判断先注销
			BigDecimal  b100=discount_rate.multiply(new BigDecimal(100));
			
			if(!b100.toBigInteger().toString().equals(money_)) {
				log.info("支付金额不对"+payType+",订单："+out_buyer_out+",已经支付，已经支付或者订单不存在");
				return INPUT;
			}
		
			//2.修改订单状态，支付方式，支付时间
			result= orderService.updatePayOrder_Status(member_Id, out_buyer_out, 2,7, payType, "");
			if(result<0){
				log.info("支付宝暗调参数异常,订单支付数量类型payType："+payType+",订单："+out_buyer_out+",支付失败，修改数据库订单状态时，result="+result);
				 resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
		                 + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
				 suscess=false;
			}
			
			
		
			
		}
		
		
		
		
		BufferedOutputStream out = new BufferedOutputStream(this.response().getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
        
        
        
        	//websocket通知结果
      		Websocket w=new Websocket();
      		Map<String,String> json=new HashMap<String,String>();
      		json.put("allNum", out_buyer_out);
      		if(suscess){
      			json.put("result", "success");
      		}else{
      			json.put("result", "failure");
      		}
      		json.put("payType", payType+"");
      		w.sendMessage(json,member_id);
      		
      		
		return null;
	}

	
	
	 public String alipayRefund(String order_number,String all_order_number,String after_order_number,String discount_rate) throws AlipayApiException{
		 AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
			
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig2.gatewayUrl, AlipayConfig2.app_id, AlipayConfig2.merchant_private_key, "json", AlipayConfig2.charset, AlipayConfig2.alipay_public_key, AlipayConfig2.sign_type);
			
			//lump_sum="0.01";
			//discount_rate="0.02";

			request.setBizContent("{" +
			"    \"out_trade_no\":\""+all_order_number+"\"," +
			"    \"out_request_no\":\""+after_order_number+"\"," +

			"    \"refund_amount\":"+discount_rate+"," +
			"    \"refund_reason\":\"正常退款\"" +
			"  }");
			AlipayTradeRefundResponse response = alipayClient.execute(request);
			request.setBizContent("{" +
					"    \"out_trade_no\":\""+order_number+"\"," +
					"    \"out_request_no\":\""+after_order_number+"\"," +
					"    \"refund_amount\":"+discount_rate+"," +
					"    \"refund_reason\":\"正常退款\"" +
					"  }");
			AlipayTradeRefundResponse response2 = alipayClient.execute(request);
			
			
			
			if(response.isSuccess()){
				System.out.println("调用成功");
				//json.put("type", 1);
				return "1";
			} else {
				System.out.println("调用失败");
				return "0";
			}
			
		
	 }
	
	 
	 public String alipayRefundt() throws AlipayApiException{
		 AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
			
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig2.gatewayUrl, AlipayConfig2.app_id, AlipayConfig2.merchant_private_key, "json", AlipayConfig2.charset, AlipayConfig2.alipay_public_key, AlipayConfig2.sign_type);
			
			String orderNumber=request("orderNumber");
			String discount_rate="0.02";

			request.setBizContent("{" +
			"    \"out_trade_no\":\""+orderNumber+"\"," +
			"    \"refund_amount\":"+discount_rate+"," +
			"    \"refund_reason\":\"正常退款\"" +
			"  }");
			AlipayTradeRefundResponse response = alipayClient.execute(request);
		
			if(response.isSuccess()){
				System.out.println("调用成功");
				//json.put("type", 1);
			} else {
				System.out.println("调用失败");
				//json.put("type", -1);
			}
			
		return urlParam;
	 }
	
	 
	
	
	    public String wechatRefund(String orderNumber,String total_fee,String refund_fee,String out_refund_no)
	            throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException,
	            IOException, CertificateException {

	    	log.info("wechatRefund1==================");
	    	WechatPayService wechatPayService=new WechatPayService();
	        String currTime = TenpayUtil.getCurrTime();
	        String strTime = currTime.substring(8, currTime.length());
	        String strRandom = TenpayUtil.buildRandom(4) + "";
	        String nonce_str = strTime + strRandom;

	        log.info("total_fee=================="+total_fee);
	        log.info("refund_fee=================="+refund_fee);
	        
	        log.info("total_fee2=================="+new BigDecimal(total_fee).multiply(new BigDecimal(100)).toBigInteger().toString());
	        log.info("refund_fee2=================="+new BigDecimal(refund_fee).multiply(new BigDecimal(100)).toBigInteger().toString());
	        
	        SortedMap<String, String> parameters = new TreeMap<String, String>();
	        parameters.put("appid", GlobalConfig.APPID);
	        parameters.put("mch_id", GlobalConfig.MCH_ID);
	        parameters.put("nonce_str", nonce_str);
	        parameters.put("out_trade_no", orderNumber);
	        parameters.put("out_refund_no",out_refund_no);
	        parameters.put("total_fee", new BigDecimal(total_fee).multiply(new BigDecimal(100)).toBigInteger().toString());
	        parameters.put("refund_fee", new BigDecimal(refund_fee).multiply(new BigDecimal(100)).toBigInteger().toString());
	        parameters.put("op_user_id", GlobalConfig.MCH_ID);

	        log.info("wechatRefund2==================");
	        Map map = wechatPayService.forRefund(parameters);
	        if (map != null) {
	            String return_code = (String) map.get("return_code");
	            String result_code = (String) map.get("result_code");
	            if (return_code.equals("SUCCESS") && result_code.equals("SUCCESS")) {
	                return "1";
	            } else {
	                return  (String) map.get("err_code_des");
	            }
	        } else {
	            return "未知的错误";
	        }
	    }


	    public String wechatRefundt()
	            throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException,
	            IOException, CertificateException {

	    	WechatPayService wechatPayService=new WechatPayService();
	    	
	    	String orderNumber=request("orderNumber");
	    	
	    	*/
/*int payType=1;
			String index=out_buyer_out.substring(0, 1);
			if("A".equals(index)){
				payType=2;
			}*//*

			
	    	
	        //Order order=orderService.queryByOrderNumber(orderNumber);

	        String currTime = TenpayUtil.getCurrTime();
	        String strTime = currTime.substring(8, currTime.length());
	        String strRandom = TenpayUtil.buildRandom(4) + "";
	        String nonce_str = strTime + strRandom;
	        //String order_price = order.getAmount().multiply(new BigDecimal(100)).toBigInteger().toString();
	        String order_price ="2";
	        String refund_fee="2";
	        SortedMap<String, String> parameters = new TreeMap<String, String>();
	        parameters.put("appid", GlobalConfig.APPID);
	        parameters.put("mch_id", GlobalConfig.MCH_ID);
	        parameters.put("nonce_str", nonce_str);
	        parameters.put("out_trade_no", orderNumber);
	        parameters.put("out_refund_no", "A00" + strTime);
	        parameters.put("total_fee", order_price);
	        parameters.put("refund_fee", order_price);
	        parameters.put("op_user_id", GlobalConfig.MCH_ID);


	        Map map = wechatPayService.forRefund(parameters);
	        if (map != null) {
	            String return_code = (String) map.get("return_code");
	            String result_code = (String) map.get("result_code");
	            if (return_code.equals("SUCCESS") && result_code.equals("SUCCESS")) {
	                // 退款成功
	                //orderService.refundSuccess(map,(String) map.get("out_trade_no"));

	                return "退款成功";
	            } else {
	                return  (String) map.get("err_code_des");
	            }
	        } else {
	            return "未知的错误";
	        }
	    }
	    
	    
	    
	    public void sendSocket(){
	    	
	    	Websocket w=new Websocket();
	    	boolean suscess=true;
	    	Map<String,String> json=new HashMap<String,String>();
			json.put("allNum", "M2019011628444549");
			if(suscess){
				json.put("result", "success");
			}else{
				json.put("result", "failure");
			}
			json.put("payType", 1+"");
			w.sendMessage(json,"725");
	    }
	    
	    
	    private Websocket websocket;
	    
	    

	public Websocket getWebsocket() {
			return websocket;
		}


		public void setWebsocket(Websocket websocket) {
			this.websocket = websocket;
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
