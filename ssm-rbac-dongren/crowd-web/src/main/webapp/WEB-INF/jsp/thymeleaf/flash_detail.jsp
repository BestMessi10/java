<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/style.css"/>
	</head>
	<body class="drly_detail"  style='background: url(../img1/bg_con.jpg) no-repeat;background-size: cover;'>
		<header>
			<div class="layout">
				<a href="index.html" class="logo">
					<img src="${APP_PATH}/img1/logo.png"/>
					<span class="italic">侗人网</span>
				</a>
				<ul class="nav">
					<li><a href="index">首页</a></li>
					<c:forEach items="${dongColumns }" var="dongColumn">
						<li><a href="${dongColumn.url }">${dongColumn.name}</a></li>
					</c:forEach>
				</ul>
			</div>
		</header>
		<div class="layout bgfff">
			<a href="" class="bold">侗人旅游</a><!--<span>&gt;</span>--><i class="iconfont icon-jiantouyou"></i><a href="/">正文</a>
			<div class="detail_title">
				<p class="text-center size34 bold">${dongNews.title}</p>
				<span class="color666 newsname">${dongNews.user}</span>
				<span class="color666">${dongNews.publishTime}</span>
			</div>
			<p class="detail_con_text">${dongNews.content}
		</div>
		<footer>
			<div class="fd-con">
	            <div class="layout">
	                <a href="index.html" class="fd-logo">
	                	<img src="${APP_PATH}/img1/logo.png">
	                	<span class="bold size18 italic color666">侗人网</span>
	                </a>
	                <div class="fd-nv">
	                     <a href="index">首页</a>
					<c:forEach items="${dongColumns }" var="dongColumn">
						<a href="${dongColumn.url }">${dongColumn.name}</a>
					</c:forEach>    
	                </div>
	                <div class="qr">
	                	<img src="http://www.i-vista.org/filespath/images/20170814170010.jpg" data-original="/filespath/images/20170814170010.jpg" style="transition: all 1s ease 0s; opacity: 1;">
	                </div>
	            </div>
            </div>
            <div class="fd-copy">
	           	<div class="layout">&copy;万宝源</div>
        	</div>
        </div>
		</footer>
		<script src="../js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
		
	</body>
</html>
