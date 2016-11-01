package com.hzit.push.controller;

import com.hzit.push.services.FileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by wjf13 on 2016/10/30.
 */
@Controller
public class FileUploadController {
    @Autowired
    private FileUploadServices fileUploadServices;
 /*   @RequestMapping("upload")
    @ResponseBody
    public String privadeUpload(){
        return fileUploadServices.provideUploadInfo();
    }*/
    @RequestMapping("upload")
    @ResponseBody
    public String HandUpload(@RequestParam("name") String name, @RequestParam("file")MultipartFile file, HttpServletRequest httpServletRequest){
        return fileUploadServices.handleUploadInfo(name,file,httpServletRequest);
    }
    @RequestMapping("pushOneFile")
    public String pushOneFile(){
        return "pushOne";
    }
    @RequestMapping("pushMoreFile")
    public String pushMoreFile(){
        return "pushMore";
    }
    @RequestMapping("/batch/upload")
    @ResponseBody
    public Object HandUpload(HttpServletRequest httpServletRequest){
        return fileUploadServices.handleUploadInfo(httpServletRequest);
    }

}
