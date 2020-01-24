<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>插入教师信息记录</title>
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
		<p id="image_logo">教师信息插入</p>
		<%-- <font color=red>${message}</font> --%>

		<form action="adminAddTeacher.do" method="post">

			<p>
				<label class="label_input">教师工号</label><input type="text"
					name="yql_Tno14" id="yql_Tno14" class="text_field" />
			</p>
			<p>
				<label class="label_input">姓  名</label><input type="text"
					name="yql_Tname14" id="yql_Tname14" class="text_field" />
			</p>
			<p>
				<label class="label_input">性  别</label><input type="text"
					name="yql_Tsex14" id="yql_Tsex14" class="text_field" />
			</p>
			<p>
				<label class="label_input">年  龄</label><input type="text"
					name="yql_Tage14" id="yql_Tage14" class="text_field" />
			</p>
			<p>
				<label class="label_input">职  称</label><input type="text"
					name="yql_Trank14" id="yql_Trank14" class="text_field" />
			</p>
			<p>
				<label class="label_input">联系电话</label><input type="text"
					name="yql_Tphone14" id="yql_Tphone14" class="text_field" />
			</p>

			<div id="login_control">
				<input type="submit" id="btn_login" value="确定" style="margin-left:35px;"/> <input
					style="margin-left: 95px;" type="reset" id="btn_login" value="重置" />
			</div>

			<br>
			<p>
				<a href="adminDisplayAddTeacher.do">查看教师信息插入情况>>></a>
			</p>

		</form>

	</div>

</body>
</html>
