<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.demo.Student" %>
<html>
<head> 
<title>班级信息 </title>
</head>
<style type="text/css">    
     body{    
        background-color: #E8E8FF;   
        background-size:100% 100% ; 
        text-align: center; 
     }    
 </style>
<body><br><br><br><br><br><br><br>
&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;
<table border="1">
<tr><td>学号：</td><td>姓名：</td><td>课程名称：</td><td>班级名称：</td><td>任课老师姓名：</td><td>课程学分：</td><td>学年：</td><td>课程成绩：</td></tr>
   <%ArrayList<Student> custList =(ArrayList<Student>)session.getAttribute("student");
   for(Student student:custList){
   %>
   <tr><td><%=student.getYql_Sno14() %></td>
       <td><%=student.getYql_Sname14()%></td>
       <td><%=student.getYql_Cname14()%></td>
       <td><%=student.getYql_CSname14()%></td>
       <td><%=student.getYql_Tname14()%></td>
       <td><%=student.getYql_Credit14()%></td>
       <td><%=student.getYql_Startterm14()%></td>
       <td><%=student.getYql_Score14()%></td></tr> 
 <%
 }
 %>       
</table>
</body>
</html> 