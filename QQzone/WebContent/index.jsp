<%@ page contentType="text/html;charset=utf-8"%>

<html>
	<head>
		
		<style type="text/css">
			body{
				background-color: gray;
			}
			
			div{
				position:relative;
				float: left;
			}
			
			#div_content{
				width:80%;
				margin-left: 10%;
				height:100%;
			}
			
			#div_top{
				width:100%;
				height:20%;
				background-color: orange;
			}
			#div_left{
				width:15%;
				height:80%;
				background-color: green;
			}
			#div_main{
				width:85%;
				height:70%;
				background-color: #FEFEFE;
			}
			#div_bottom{
				width:85%;
				height:10%;
				background-color: #CEFABC;
			}
		</style>
	</head>
	<body>
		<div id="div_content">
			<div id="div_top">&nbsp;</div>
			<div id="div_left">
				<iframe src="${pageContext.request.contextPath}/left.jsp" name="left" width="100%" height="100%"></iframe>
			</div>
			<div id="div_main">
				<iframe src="${pageContext.request.contextPath}/main.jsp" name="main" width="100%" height="100%"></iframe>
			</div>
			<div id="div_bottom">&nbsp;</div>
		</div>
	</body>
</html>