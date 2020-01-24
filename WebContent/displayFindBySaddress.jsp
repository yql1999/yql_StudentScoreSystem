<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.demo.Student"%>
<html>
<head>
<title>根据生源地查询成绩</title>
</head>
<style type="text/css">
body {
	background-color: #E8E8FF;
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
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.nav {
	width: 900px;
	height: 30px;
	margin: 30px auto 0;
	border-bottom: 8px solid #de4b15;
	padding-left: 20px;
}

.nav li {
	float: left;
	list-style: none;
	margin-right: 4px;
}

.nav li a {
	display: block;
	text-decoration: none;
	width: 180px;
	height: 28px;
	text-align: center;
	line-height: 20px;
	background: #dfdfdf;
	color: black;
	font-size: 20px;
}

.nav li a:hover {
	background: #DE4B15;
	color: white;
}
/*隐藏设置*/
.nav li a b {
	display: none;
}
/*鼠标移入*/
.nav li a:hover span {
	display: none;
}

.nav li a:hover b {
	display: block;
}
</style>
</head>
<body>
	<table class="hovertable">
		<tr>
			<th colspan="8"
				style="text-align: center; font-size: 20px; color: blue;">根据生源地查询成绩结果表</th>
		</tr>
		<tr>
			<th>生源地</th>
			<th>学生平均成绩</th>
		</tr>
		
		<%ArrayList<Student> custList =(ArrayList<Student>)session.getAttribute("student");
   for(Student student:custList){
   %>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td><%=student.getYql_Saddress14() %></td>
			<td><%=student.getYql_ResouceGradeAVG14() %></td>
		</tr>
		<%
 }
 %>
	</table>
</body>
</html>
