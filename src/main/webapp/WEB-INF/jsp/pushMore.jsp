<%--
  Created by IntelliJ IDEA.
  User: wjf13
  Date: 2016/10/30
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SpringBoot上传文件</title>
  </head>
  <body>
 <form method="post" enctype="multipart/form-data" action="/batch/upload">
   选择要上传的第一个文件：<input type="file" name="file"><br/>
   选择要上传的第二个文件：<input type="file" name="file"><br/>
   <input type="submit" value="上传">
 </form>
  </body>
</html>
