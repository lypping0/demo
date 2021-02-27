<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  
</head>
<body>
   <div style="padding-top:50px;padding-left:20px;">
          <div style="width:80%"> 
               <form action="topic/addTopic" method="post">
                                                          标题:<input type="text" name="title"/><br/>
                                                           内容:<textarea name="content"></textarea><br/>
                       <input type="submit" value="提交">                                                                       
               </form>
          </div>
      </div>
</body>
</html>