<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>教师查询</title>
</head>
<style type="text/css">
body {
	background-color: #E8E8FF;
	background-size: 100% 100%;
	text-align: center;
	font-size: 20px;
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
					<b>学生成绩学年统计</b>
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
	<form action="findBySnoServlet.do" method="post">
		<table>
			<tr>
				<td><font color="blue" size="5" style="margin-left: 350px;"><strong>
							<p3>请输入学生学号查询成绩：</p3>
					</strong></font></td>

				<td><input type="text" name="yql_Sno14">&nbsp;<input
					type="submit" value="确定"></td> &nbsp;&nbsp;&nbsp;
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
	
	
	<form action="findOrderYear.do" method="post">
		<table>
			<tr>
				<td><font color="blue" size="5" style="margin-left: 350px;"><strong>
							<p3>按学期查询学生成绩，请输入学期（如19/20（1））：</p3>
					</strong></font></td>

				<td><input type="text" name="yql_Startterm14">&nbsp;<input
					type="submit" value="确定"></td> &nbsp;&nbsp;&nbsp;
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
	
	<form action="findBySaddress.do" method="post">
		<table>
			<tr>
				<td><font color="blue" size="5" style="margin-left: 350px;"><strong>
							<p3>根据生源地查询平均成绩，请输入要查询的生源地：</p3>
					</strong></font></td>

				<td><input type="text" name="yql_Saddress14">&nbsp;<input
					type="submit" value="确定"></td> &nbsp;&nbsp;&nbsp;
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>
