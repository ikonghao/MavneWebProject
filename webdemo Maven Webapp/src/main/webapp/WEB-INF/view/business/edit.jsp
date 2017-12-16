<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>

    <form name="mainForm" action="<%=request.getContextPath()%>/business/save" method="post">
    	<div><span>Name:</span><input type="text" id="name" name="name"/></div>
    	<div><span>Age:</span><input type="text" id="name" name="age"/></div>
    	<div><span>Desc:</span><input type="text" id="name" name="desc"/></div>
    	<input value="提交"  type="submit">
    </form>
     <br>
  </body>
</html>
