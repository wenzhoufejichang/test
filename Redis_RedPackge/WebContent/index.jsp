<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		for (var i = 0; i < 15000; i++) {

			$.get("${pageContext.request.contextPath}/main/get.action?id=" + i);

		}

	});
</script>

</head>
<body>

</body>
</html>