<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点击接收到JSON数据</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css">
<script src="resources/js/jquery-1.11.3.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

</head>
<body class="center">

<h1 id="receive_JSON" class="btn btn-info">点击接收到JSON数据</h1>
<h1 id="JSONToJava" class="btn btn-info">点击发送JSON数据并接收JSON数据</h1>
<h1 id="JSONListToJava" class="btn btn-info">接收List类型JSON数据</h1>
<h1 id="sendJSONListToJava" class="btn btn-info">发送List类型JSON数据</h1>
<img alt="" src="./test001.png" onclick="javaScript:alert('的水电费水电费');">
</body>
<script type="text/javascript">
$('#receive_JSON').click(function(){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"${pageContext.request.contextPath }/mySpringmvcreultJSON",
		contentType:"application/json",
		data:'{"name":"yangsheng","age":23,"addre":"长岭南路"}',
		success:function(data){
			alert(data.name);
		}
	});
});
$('#JSONToJava').click(function(){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"${pageContext.request.contextPath }/mySpringmvcreultToJSON",
		contentType:"application/json",
		data:'{"name":"yangsheng","age":23,"addre":"长岭南路"}',
		success:function(data){

			alert(data.name);
		},
		error:function(data){
		alert("收到的结果："+data);
		}
	});
});
$('#JSONListToJava').click(function(){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"${pageContext.request.contextPath }/mySpringmvcListJSON",
		contentType:"application/json",
		data:'{"name":"yangsheng","age":23,"addre":"长岭南路"}',
		success:function(data){
		    alert(data.length);
            for(i = 0;i<data.length;i++){
			alert(data[i].name);
            }

           var json1={"abc":[{"name":"txt1"},{"name":"txt2"}]};
           //json1 = eval(json1); 因为json1本身接收一个json数组，所以这一句可有可无
           //得到abc这个对象，而这个对象时一个数组，则jsons["abc"].length应该是2
           //而我们使用一个变量来接收abc的index的对象 obj =jsons["abc"][0]
           alert(json1["abc"].length);
           alert(json1["abc"][0].name);
		},
		error:function(data){
		alert("收到的结果："+data);
		}
	});

});
	$('#sendJSONListToJava').click(function(){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"${pageContext.request.contextPath }/mySpringmvcListToListJSON",
		contentType:"application/json",
		data: JSON.stringify([{"id":0,"name":"杨胜","addre":"观山湖区长岭南路","age":23},{"id":0,"name":"杨胜","addre":"观山湖区长岭南路","age":23},{"id":0,"name":"杨胜","addre":"观山湖区长岭南路","age":23},{"id":0,"name":"杨胜","addre":"观山湖区长岭南路","age":23}]),
		success:function(data){
		    alert(data.length);
            for(i = 0;i<data.length;i++){
			alert(data[i].name);
            }
		},
		error:function(data){
		alert("收到的结果："+data);
		}
	});
});

</script>
</html>