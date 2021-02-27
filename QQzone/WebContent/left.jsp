<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		
	</head>
	<body>
		<ul>
			<c:forEach items="${currUser.friends}" var="friend">
				<li><a href="${pageContext.request.contextPath}/topic/topicList?fid=${friend.id}" target="main">${friend.nickName}</a></li>
			</c:forEach>
		</ul>
	</body>
</html>