package com.hzit.push.services.impl;

import com.hzit.push.services.FileUploadServices;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wjf13 on 2016/10/30.
 */
@Service
public class FileUploadServicesImpl implements FileUploadServices {
    @Override
    public String provideUploadInfo() {
        return "You can upload a file by posting to this same URL";
    }

    @Override
    public String handleUploadInfo(String name, MultipartFile multipartFile, HttpServletRequest httpServletRequest) {
        try {
            //设置编码格式，解决字符串乱码问题
            httpServletRequest.setCharacterEncoding("utf-8");
            //判断上传文件是否是空的
            if(!multipartFile.isEmpty()){
                //创建字节数组
                byte [] bytes=multipartFile.getBytes();
                //创建File类，参数是文件名
                File file=new File(name);
                //创建文件输出流，参数是File类的对象
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                //创建缓冲输出流，参数是FileOutPutStream的对象
                BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
                //利用缓冲输出流把客户端中的数据写入服务器端
                bufferedOutputStream.write(bytes);
                //关闭缓冲输出流
                bufferedOutputStream.close();
                //文件保存路径，multipartFile.getOriginalFilename()这个方法是获得用户传进来文件的原名
                String filePath="D:\\IDEA\\picture\\src\\main\\webapp\\images\\"+multipartFile.getOriginalFilename();
                /**
                 * httpServletRequest.getSession()获得HttpSession对象
                 * httpSession.getServletContext().getRealPath("/")这个方法是用来获得当前系统的绝对路径
                 * “images”是指定要存入哪个文件夹下面
                 * multipartFile.getOriginalFilename()这个方法有哪个来获得客户端所传进来的文件的原名
                 */
                //String filePath=httpServletRequest.getSession().getServletContext().getRealPath("/")+"images/"+multipartFile.getOriginalFilename();
                System.out.println(filePath);
                //转存文件
                multipartFile.transferTo(new File(filePath));
                return "文件已成功上传至："+filePath;
            }else {
                return "文件上传失败：该文件是空的";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "上传失败："+e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败"+e.getMessage();
        }
    }

    @Override
    public Object handleUploadInfo(HttpServletRequest httpServletRequest) {
        List list=new ArrayList();
        try {
            //设置编码格式，解决字符串乱码问题
            httpServletRequest.setCharacterEncoding("utf-8");
            //将HttpServletRequest转换成MultipartHttpServletRequest，这个类是SpringBoot提供的一个多文件上传的类
            MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest)httpServletRequest;
            //multipartHttpServletRequest.getFiles("file");接收客户端传进来的文件，参数代表以什么名义传入进来，因为文件有多个，所以需要放在一个List集合里面
            List<MultipartFile> multipartFileList=multipartHttpServletRequest.getFiles("file");
            for (int i=0;i<multipartFileList.size();i++){
                MultipartFile multipartFile=multipartFileList.get(i);
                list.add("images/"+multipartFile.getOriginalFilename());
                //循环遍历list集合，得到文件名
                String name=multipartFile.getName();
                //判断上传文件是否是空的
                if(!multipartFile.isEmpty()){
                    //并创建字节数组
                    byte [] bytes=multipartFile.getBytes();
                    //创建File类，参数是文件名
                    File file=new File(name);
                    //创建文件输出流，参数是File类的对象
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    //创建缓冲输出流，参数是FileOutPutStream的对象
                    BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
                    //利用缓冲输出流把客户端中的数据写入服务器端
                    bufferedOutputStream.write(bytes);
                    //关闭缓冲输出流
                    bufferedOutputStream.close();
                    //文件保存路径
                    String filePath="D:\\IDEA\\picture\\src\\main\\webapp\\images\\"+multipartFile.getOriginalFilename();
                    /**
                     * httpServletRequest.getSession()获得HttpSession对象
                     * httpSession.getServletContext().getRealPath("/")这个方法是用来获得当前系统的绝对路径
                     * “images”是指定要存入哪个文件夹下面
                     * multipartFile.getOriginalFilename()这个方法有哪个来获得客户端所传进来的文件的原名
                     */
                    //String filePath=httpServletRequest.getSession().getServletContext().getRealPath("/")+"images/"+multipartFile.getOriginalFilename();
                    System.out.println(filePath);
                    //转存文件
                    multipartFile.transferTo(new File(filePath));
                }else {
                    return "上传失败：因为文件是空的";
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "上传失败："+e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败："+e.getMessage();
        }
         return list;
    }
}
