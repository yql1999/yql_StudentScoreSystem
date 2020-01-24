<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.demo.Teacher"%>
<html>
<head>
<title>学生成绩按学年统计查询</title>
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
	<div class="nav">
		<ul>
			<!--span和b 两个只显示一个-->
			<li><a href="findAvg.jsp"> <span>Home</span> <b>首页</b>
			</a></li>
			<li><a href="findAvg.do"> <span>每门课平均成绩</span> <b>每门课平均成绩</b>
			</a></li>
			<li><a href="findOrderCreditSum.do"> <span>学生成绩学年统计</span>
					<b>学生成绩每学年统计</b>
			</a></li>
			<li><a href="findCredit.do"> <span>所学课程及学分统计</span> <b>所学课程及学分统计</b>
			</a></li>
		</ul>
	</div>
	<div class="nav">
		<ul>
			<li><a href="addStudentReport.jsp"> <span>插入学生成绩</span> <b>插入学生成绩</b>
			</a></li>
			<li><a href="findOrderYear.do"> <span>学生名次排定</span> <b>学生名次排定</b>
			</a></li>
			<li><a href="addStudentTeacher.do"> <span>查看全部信息</span> <b>查看全部信息</b>
			</a></li>
		</ul>
	</div>
	<br>
	<br>
	<table class="hovertable">
		<tr>
			<th colspan="4"
				style="text-align: center; font-size: 20px; color: blue;">学生成绩按学年统计查询结果表</th>
		</tr>
		<tr>
			<th>总学分</th>
			<th>学生姓名</th>
			<th>学生性别</th>
			<th>班级编号</th>
		</tr>
		<%ArrayList<Teacher> custList =(ArrayList<Teacher>)session.getAttribute("teacher");
   for(Teacher teacher:custList){
   %>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td><%=teacher.getYql_Credit14()%></td>
			<td><%=teacher.getYql_Sname14()%></td>
			<td><%=teacher.getYql_Tsex14()%></td>
			<td><%=teacher.getYql_CSno14()%></td>
		</tr>
		<%
 }
 %>
	</table>
</body>
</html>


