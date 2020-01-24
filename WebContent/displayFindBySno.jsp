<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.demo.Student"%>
<html>
<head>
<title>学生成绩查询</title>
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
	<div class="nav">
		<ul>
			<!--span和b 两个只显示一个-->
			<li><a href="findBySno.jsp"> <span>Home</span> <b>首页</b>
			</a></li>
			<li><a href="findAll.do"> <span>班级课程开设查询</span> <b>班级课程开设查询</b>
			</a></li>
			<li><a href="findTeachCno.do"> <span>教师授课信息查询</span> <b>教师授课信息查询</b>
			</a></li>
			<li><a href="findBySno.jsp"> <span>根据学号查成绩</span> <b>根据学号查成绩</b>
			</a></li>
		</ul>
	</div>
	&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;
	<table class="hovertable">
		<tr>
			<th colspan="8"
				style="text-align: center; font-size: 20px; color: blue;">学生成绩查询结果表</th>
		</tr>
		<tr>
			<th>学生学号</th>
			<th>学生姓名</th>
			<th>课程名称</th>
			<th>班级名称</th>
			<th>任课老师姓名</th>
			<th>课程学分</th>
			<th>开课学期</th>
			<th>课程成绩</th>
		</tr>
		
		<%ArrayList<Student> custList =(ArrayList<Student>)session.getAttribute("student");
   for(Student student:custList){
   %>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td><%=student.getYql_Sno14() %></td>
			<td><%=student.getYql_Sname14()%></td>
			<td><%=student.getYql_Cname14()%></td>
			<td><%=student.getYql_CSname14()%></td>
			<td><%=student.getYql_Tname14()%></td>
			<td><%=student.getYql_Credit14()%></td>
			<td><%=student.getYql_Startterm14()%></td>
			<td><%=student.getYql_Score14()%></td>
		</tr>
		<%
 }
 %>
	</table>
</body>
</html>
