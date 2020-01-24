<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<style type="text/css">
body {
	background-image: url("background01.jpg");
	background-size: 100%;
	background-repeat: no-repeat;
}

h3 {
	font-size: 25px;
	font-family: cursive;
	text-shadow: 1px 2px 2px #333;
	color: deeppink;
}

#login_frame {
	width: 400px;
	height: 260px;
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
	width: 278px;
	height: 28px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
	border: 0;
}

#btn_login {
	font-size: 14px;
	font-family: 宋体;
	width: 120px;
	height: 28px;
	line-height: 28px;
	text-align: center;
	color: white;
	background-color: #3BD9FF;
	border-radius: 6px;
	border: 0;
	float: left;
}

#forget_pwd {
	font-size: 12px;
	color: white;
	text-decoration: none;
	position: relative;
	float: right;
	top: 5px;
}

#forget_pwd:hover {
	color: blue;
	text-decoration: underline; /* 去链接底下的下划线 */
}

#login_control {
	padding: 0 28px;
}
</style>
</head>

<body>

	<div id="login_frame">
		<h3 class="biaoti">学生成绩管理系统</h3>
		<form method="post" action="login.do" id="form_login">
			<p>
				<label class="label_input">用户名:</label><input type="text"
					name="userid" id="userid" placeholder="请输入账号" class="text_field"
					onBlur="f0()" />
			</p>
			<p>
				<label class="label_input">密 码:</label><input type="text"
					name="password" id="password" placeholder="请输入密码"
					class="text_field" onBlur="f1()" />
			</p>
			<p style="font-size: 20;">
				<input name="user" type="radio" value="student" checked>学生 <input
					name="user" type="radio" value="teacher" style="margin-left: 20px;">教师
				<input name="user" type="radio" value="admin"
					style="margin-left: 20px;">管理员<br>
			</p>
			<div id="login_control">
				<input type="submit" id="btn_login" value="登录" " /> <a
					href="register.jsp">没有账号？点击注册吧</a>
			</div>
		</form>
	</div>
</body>
</html>

