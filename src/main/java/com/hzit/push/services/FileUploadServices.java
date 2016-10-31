package com.hzit.push.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wjf13 on 2016/10/30.
 */
public interface FileUploadServices {
    String provideUploadInfo();
    String handleUploadInfo(String name, MultipartFile multipartFile, HttpServletRequest httpServletRequest);
    String handleUploadInfo(HttpServletRequest httpServletRequest);
}
