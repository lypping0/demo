<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<script type="text/javascript">
			function delTopic(topicId){
				if(window.confirm("是否确认删除?")){
					window.location.href="topic/delTopic.do?topicId="+topicId;
				}
			}
		</script>
	</head>
	
	<body>
		<div style="padding-top:50px;padding-left:20px;">
			<div style="width:80%;margin-bottom:10px">
			    <div style="text-align:right;padding-right=20px">
			    <c:choose>
			         <c:when test="${fid==currUser.id}">
			           <span><a href="${pageContext.request.contextPath}/addTopic.jsp">添加新日志</a></span>
			         </c:when>
			         <c:otherwise>
			         <span><a href="${pageContext.request.contextPath}/topic/topicList?fid=${currUser.id}">返回自己的空间</a></span>
			         </c:otherwise>
			    </c:choose>
			       
			         
			    </div>
			</div>
			<div style="width:80%">
				<table width="100%" border="1" cellspacing="0" cellpadding="2">
					<tr>
						<th>序号</th>
						<th>标题</th>
						<th>日期</th>
						<th>操作</th>
					</tr>
					<c:choose>
						<c:when test="${not empty topicList}">
							<c:forEach items="${topicList }" var="topic">
								<tr align="center">
									<td>${topic.id}</td>
									<td><a href="${pageContext.request.contextPath}/topic/topicDetail?topicId=${topic.id}">${topic.title}</a></td>
									<td><fmt:formatDate value="${topic.topicDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
									<td>
										<img src="${pageContext.request.contextPath}/imgs/del.png" width="16" height="16" onclick="delTopic(${topic.id })"/>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<th colspan="4">对不起，没有任何记录！</th>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</div>
	</body>
</html>