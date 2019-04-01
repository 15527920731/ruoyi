package com.jewelry.system.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.jewelry.common.base.AjaxResult;
import com.jewelry.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Component
public class SmSMessageUtils {
    private final  static String ACCESS_KEY_ID="LTAIta6K9O4b2ItN";
    private final  static String ACCESSS_ECRET="pScDOi90PLABquec6yNLq1USYMR7U8";

    private final  static String SIGN_NAME="珠宝检索";
    private final  static String REGION_ID="cn-hangzhou";

    public final  static String REGISTER_CODE="SMS_162111005";
    public final  static String FIND_PASSWORD_CODE="SMS_162111003";
    public final  static String LOGIN_CODE="SMS_162221476";


    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private MathRandomUtils mathRandomUtils;
    @Value("${sms.expire}")
    private int smsExpire;


    @Transactional
    public void sendSmsMessage(String type,String phone){
        String phoneKey=null;
        String templateId=null;
        String code=mathRandomUtils.mathRandom(6);
        // 1 注册 2 登录 3 找回密码
        if("1".equals(type)){
            phoneKey=phone+"R";
            templateId=REGISTER_CODE;
        }else if("2".equals(type)){
            phoneKey=phone+"D";
            templateId=LOGIN_CODE;
        }else if("3".equals(type)){
            phoneKey=phone+"Z";
            templateId=FIND_PASSWORD_CODE;
        }else {
            throw new BusinessException("网络异常，请稍后再试！");
        }

        //验证码默认180m有效
        redisUtil.set(phoneKey,code,smsExpire,null);

        DefaultProfile profile = DefaultProfile.getProfile(REGION_ID, ACCESS_KEY_ID, ACCESSS_ECRET);
        IAcsClient client = new DefaultAcsClient(profile);
        sendSms(client, phone,code,templateId);
    }



    private void sendSms(IAcsClient client,String phone,String code,String teplateId) {
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", REGION_ID);
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", SIGN_NAME);
        request.putQueryParameter("TemplateCode", teplateId);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
