<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.demo.Admin"%>
<html>
<head>
<title>所有课程信息查询</title>
</head>
<style type="text/css">
body {
	background-color:#E8E8FF; 
	background-size: 100% 100%;
	text-align: center;
	font-size: 20px;
}

table {
	margin: 0 auto;
	text-align: center;
	width: 60%;
	height: 85%;
}

table.hovertable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}

table.hovertable th {
	background-color: #c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

table.hovertable tr {
	background-color: #d4e3e5;
}

table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
</style>
<body>
	<table class="hovertable">
		<tr>
			<th colspan="7"
				style="text-align: center; font-size: 20px; color: blue;">所有课程信息查询结果表</th>
		</tr>
		<tr>
			<th>课程编号</th>
			<th>课程名称</th>
			<th>授课教师</th>
			<th>开课学期</th>
			<th>学时</th>
			<th>考查方式</th>
			<th>学分</th>
		</tr>
		<%
			ArrayList<Admin> custList = (ArrayList<Admin>) session.getAttribute("admin");
			for (Admin admin : custList) {
		%>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td><%=admin.getYql_Cno14()%></td>
			<td><%=admin.getYql_Cname14()%></td>
			<td><%=admin.getYql_Tname14()%></td>
			<td><%=admin.getYql_Startterm14()%></td>
			<td><%=admin.getYql_Classhour14()%></td>
			<td><%=admin.getYql_Testway14()%></td>
			<td><%=admin.getYql_Credit14()%></td>
			
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>