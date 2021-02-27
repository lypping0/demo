<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		
		<style type="text/css">
			div , span {
				position: relative ;
				float:left;
			}
			div{
				width:100%;
			}
			*{
				font-size:14px;
			}
		</style>
		<script type="text/javascript">
			function showAddHostReply(hostReplyDivId){
				var div = document.getElementById(hostReplyDivId);
				div.style.display = 'inline' ;
			}
			function delReply(replyId){
				if(window.confirm("是否确认删除?")){
					window.location.href="${pageContext.request.contextPath}/reply/delReply.do?replyId="+replyId;
				}
			}
			function delHostReply(hostReplyId){
				if(window.confirm("是否确认删除?")){
					window.location.href="${pageContext.request.contextPath}/hostReply/delHostReply.do?hostReplyId="+hostReplyId;
				}
			}
		</script>
	</head>
	<body>
		<div style="padding-top:50px;padding-left:20px;">
			<div style="width:80%;">
				<!-- topic -->
				<div style="width:100%;border:1px solid blue ;margin-bottom:5px;">
					<div style="font-weight:bolder;padding:2px 5px;">
						<span style="float:left;">${topic.title }</span>
						<span style="float:right;margin-right:10px;"><fmt:formatDate value="${topic.topicDate }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
					</div>
					<div style="padding-left:20px;">
						${topic.content}
					</div>
					<div>
						<span style="float:right;margin-right:10px;">回复数量：${topic.replyCount }</span>
					</div>
				</div>
				
				<!-- reply list -->
				<c:forEach items="${topic.replyList}" var="reply">
					<div style="width:100%;border:1px solid blue ;margin-top:5px;padding-right:5px;">
						<div style="margin-left:20px;margin-top:2px;margin-right:2px;">
							<span style="float:left;">${reply.content }</span>
							<span style="float:right;margin-right:50px;"><img src="imgs/del.png" onclick="delReply(${reply.id})" width="16" height="16"/></span>
						</div>
						<div>
							<span style="float:right;margin-right:2px;"><fmt:formatDate value="${reply.replyDate}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
							<span style="float:right;margin-right:2px;">${reply.author.nickName }</span>
						</div>
						<div style="text-align:right;margin-right:2px;margin-bottom:5px;">
							<c:choose>
								<c:when test="${empty reply.hostReply}">
									<div id="addHostReplyDiv">
										<span style="display:${currUser.id==fid ? 'inline' : 'none' };"><a href="javascript:showAddHostReply('addHostReplyDiv${reply.id}')">主人回复</a></span>
										<div id="addHostReplyDiv${reply.id}" style="display:none;">
											<form action="${pageContext.request.contextPath}/hostReply/addHostReply" method="post">
												<input type="hidden" name="replyId" value="${reply.id}"/>
												内容:<textarea name="content"></textarea><br/>
												<input type="submit" value="提交"/>
											</form>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div id="hostReplyDiv" style="background-color:#FBEFCF; width:50%;float:right;margin-right:40px;border:1px solid red ;">
										<div>
											<span style="float:left;margin-right:2px;"><fmt:formatDate value="${reply.hostReply.hostReplyDate}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
											<span style="float:right;margin-right:2px;"><img src="imgs/del.png"  width="16" height="16" onclick="delHostReply(${reply.hostReply.id})"/></span>
										</div>
										<div>${reply.hostReply.content}</div>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:forEach>
				<!-- add Reply -->
				<form action="${pageContext.request.contextPath}/reply/addReply.do" method="post">
					<input type="hidden" name="topicId" value="${topic.id}"/>
					内容：<textarea name="content"></textarea><br/>
					<input type="submit" value="提交"/>
				</form>
			</div>
		</div>
	</body>
</html>