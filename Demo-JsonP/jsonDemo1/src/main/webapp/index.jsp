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
	$("#but").click(function(){
		//	跨域请求 $.get("http://localhost:9090/user/findUser",function(data){
		/**
		 * 使用jsonP跨域请求时:
		 * 	1、type:必须是get方式
		 * 	2、jsonp:必须与方法的参数一致
 		 */
		$.ajax({
			type:"get",
			// url:"http://localhost:9090/user/jsonpFindUser",
			url:"http://localhost:9090/user/jsonpFindUser2",
			dataType:"jsonp",
			jsonp:"callback",
			success:function(data){
				alert(data);
				var str = "";
				for(i=0;i<data.length;i++){
					str+= data[i].userid+" "+data[i].username+" "+data[i].userage+" ";
				}
				$("#show").html(str);
			}
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