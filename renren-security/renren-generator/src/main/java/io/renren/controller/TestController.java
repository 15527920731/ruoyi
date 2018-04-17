package io.renren.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2018/4/14.
 */
//@Api(tags ="口语测试接口")
@RestController
@RequestMapping("/test")
public class TestController {

   // private final static Logger LOGGER = LoggerFactory.getLogger(WechatController.class);

    @Value("${web.upload.path}")
    private String uploadPath;

    //@ApiOperation(value="上传文件(小程序)")
    @PostMapping("/test")
    public String upload(HttpServletRequest request, @RequestParam("file")MultipartFile[] files){
        //LOGGER.info("上传测试");
        //多文件上传
        String logoPicPath =  null;
        String logoLocPath =  null;
        String path = request.getSession().getServletContext().getRealPath("statics"+java.io.File.separator+"uploadfiles"+java.io.File.separator);
        if(files!=null && files.length>=1) {

            BufferedOutputStream bw = null;
            try {
                String fileName = files[0].getOriginalFilename();
                //判断是否有文件(实际生产中要判断是否是音频文件)
                if(StringUtils.isNoneBlank(fileName)) {
                    //创建输出文件对象
                    File outFile = new File(path +UUID.randomUUID().toString()+ ".jpg");
                    System.out.println("+++++++"+outFile.getAbsolutePath());
                    //拷贝文件到输出文件对象
                    FileUtils.copyInputStreamToFile(files[0].getInputStream(), outFile);
                    logoPicPath = request.getContextPath()+"/statics/uploadfiles/"+fileName;
                    logoLocPath = path+File.separator+fileName;
                    System.out.println("logoPicPath"+logoPicPath);
                    System.out.println("logoLocPath"+logoLocPath);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(bw!=null) {bw.close();}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "success";
    }
}