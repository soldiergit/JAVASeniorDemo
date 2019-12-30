<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		<%--获取用户数据--%>
		$("#but").click(function(){
			$.get("/user/findUser",function(data){
				alert(data);
				var str = "";
				for(i=0;i<data.length;i++){
					str+= data[i].userid+" "+data[i].username+" "+data[i].userage+"---;";
				}
				$("#show").html(str);
			});
		});
	});
</script>
</head>
<body>
	<span id="show"></span>
	<input type="button" value="OK" id="but"/>
</body>
</html>