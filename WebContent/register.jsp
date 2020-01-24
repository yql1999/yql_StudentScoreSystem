
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	background-image: url("background02.gif");
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
	height: 350px;
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
	margin-top: 22px;
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
	<script type="text/javascript">
    var emt = document.getElementsByTagName("em");
    var t=1;
     function  f0(){
     if(register.userid.value.length<6||register.userid.value.length>12){
                emt[0].innerHTML="账号长度6-12位!";
                t=0;
            }
      else{
           emt[0].innerHTML="";
           t=1;
      }
    } 
    function  f1(){
     if(register.username.value.length<1||register.username.value.length>4){
                emt[1].innerHTML="用户名长度1-4位!";
                t=0;
            }
      else{
           emt[1].innerHTML="";
           t=1;
      }
    } 
    function  f2(){
        var mm=/^[0-9a-zA-Z]{6,12}$/;
     var flag=mm.test(register.password1.value);
     if(!flag){
                emt[2].innerHTML="密码要求长度6-12位；字母数字的组合，不能有其他字符!";
                t=0;
            }
      else{
           emt[2].innerHTML="";
           t=1;
      }
    } 
    function  f3(){
       if(register.password1.value != register.password2.value){
            emt[3].innerHTML="密码两次应一致！";
                t=0;
       }else{
           emt[3].innerHTML="";
           t=1;
      }
    }
</script>

	<div id="login_frame">

		<h3>学生成绩管理系统注册页面</h3>

		<form name="register" action="servlet\register" method="post">
			<p>
				<label class="label_input">用户名</label><input type="text" name=userid
				  	id="userid" class="text_field" onBlur="f0()" />
			</p>
			<p>
				<label class="label_input">姓 名</label><input type="text"
					name="username" id="username" class="text_field" onBlur="f1()" />
			</p>
			<p>
				<label class="label_input">密 码</label><input type="text"
					name="password1" id="password1" class="text_field" onBlur="f2()" />
			</p>
			<p>
				<label class="label_input">确认密码</label><input type="text"
					name="password2" id="password1" class="text_field" onBlur="f3()" />
			</p>
			<p>
				<a href="login.jsp">返回登录界面</a>
			</p>
			<div id="login_control">
				<input type="submit" id="btn_login" value="提交" /> <input
					style="margin-left: 95px;" type="reset" id="btn_login" value="重置" />
			</div>
		</form>

	</div>

</body>
</html>
