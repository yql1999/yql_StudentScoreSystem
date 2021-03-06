<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>插入学生成绩记录</title>
</head>
<style type="text/css">
body {
	background-image: url(2.jpg);
	background-size: 100% 100%;
	text-align: center;
	font-size: 20px;
}

#login_frame {
	width: 420px;
	height: 430px;
	padding: 13px;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -200px;
	margin-top: -200px;
	background-color: rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	text-align: center;
}

form p>* {
	display: inline-block;
	vertical-align: middle;
}

#image_logo {
	margin-top: 5px;
}

.label_input {
	font-size: 14px;
	font-family: 宋体;
	width: 65px;
	height: 28px;
	line-height: 28px;
	text-align: center;
	color: white;
	background-color: #3CD8FF;
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
}

.text_field {
	width: 228px;
	height: 28px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
	border: 0;
}

#btn_login {
	font-size: 14px;
	font-family: 宋体;
	width: 100px;
	height: 28px;
	line-height: 28px;
	text-align: center;
	color: white;
	background-color: #3BD9FF;
	border-radius: 6px;
	border: 0;
	float: left;
}

#login_control {
	padding: 0 28px;
}
</style>
<body>
	<div id="login_frame">
		<br>
		<p id="image_logo">学生成绩插入</p>
		<font color=red>${message}</font>

		<form action="addStudentReport.do" method="post">

			<p>
				<label class="label_input">学 号</label><input type="text"
					name="yql_Sno14" id="yql_Sno14" class="text_field" />
			</p>
			<p>
				<label class="label_input">课程编号</label><input type="text"
					name="yql_Cno14" id="yql_Cno14" class="text_field" />
			</p>
			<p>
				<label class="label_input">学 年</label><input type="text"
					name="yql_Startterm14" id="yql_Startterm14" class="text_field" />
			</p>
			<p>
				<label class="label_input">课程成绩</label><input type="text"
					name="yql_Score14" id="yql_Score14" class="text_field" />
			</p>
			<p>
				<label class="label_input">任课老师</label><input type="text"
					name="yql_Tname14" id="yql_Tname14" class="text_field" />
			</p>

			<div id="login_control">
				<input type="submit" id="btn_login" value="确定" style="margin-left:35px;"/> <input
					style="margin-left: 95px;" type="reset" id="btn_login" value="重置" />
			</div>

			<br>
			<p>
				<a href="addStudentTeacher.do">查看学生课程成绩插入情况>>></a>
			</p>

		</form>

	</div>

</body>
</html>
