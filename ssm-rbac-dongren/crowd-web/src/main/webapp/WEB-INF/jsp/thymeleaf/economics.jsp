<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${APP_PATH}/css/imagehover.css"/>
		<link rel="stylesheet" type="text/css" href="${APP_PATH}/css/swiper.min.css"/>
		<link rel="stylesheet" type="text/css" href="${APP_PATH}/css/style.css"/>
	</head>
	<body class="drjj"  style='background: url(../img1/bg_con.jpg) no-repeat;background-size: cover;'>
		<header>
			<div class="layout">
				<a href="index.html" class="logo">
					<img src="${APP_PATH}/img1/logo.png"/>
					<span class="italic">侗人网</span>
				</a>
				<ul class="nav">
					<li><a href="index">首页</a></li>
					<c:forEach items="${dongColumns }" var="dongColumn">
						<c:if test="${dongColumn.url == 'economics' }">
							<li class="active"><a href="${dongColumn.url }">${dongColumn.name}</a></li>
						</c:if>
						<c:if test="${dongColumn.url != 'economics' }">
							<li><a href="${dongColumn.url }">${dongColumn.name}</a></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</header>
		<div class="layout bgfff">
			<div class="swiper-container swiper-container1">
			    <div class="swiper-wrapper">
				    <div class="swiper-slide">
				    	<a href="">
				    		<img src="${APP_PATH}/img1/e_img1.jpg"/>
				    	</a>
				    </div>
				    <div class="swiper-slide">
				    	<a href="">
				    		<img src="${APP_PATH}/img1/e_img1.jpg"/>
				    	</a>
				    </div>
				    <div class="swiper-slide">
				    	<a href="">
				    		<img src="${APP_PATH}/img1/e_img1.jpg"/>
				    	</a>
				    </div>
			    </div>
			    <!-- Add Pagination -->
			    <div class="swiper-pagination"></div>
		  	</div>
		  	<div class="over_hidden">
		  		<div action="" method="post" class="search_item fl">
		  			<i class="iconfont icon-chazhao"></i>
		  			<input type="text" name="search" id="search" value="" />
		  			<button id="searchBtn" class="hand">搜索</button>
		  		</div>
		  		<div class="fl hot_search">
		  			<span class="size20 color666 bold">热搜:</span>
			  		<c:forEach items="${dongSearchs }" var="dongSearch">
		  				<a href="" class="bold size18 color666">${dongSearch.name}</a>
		  			</c:forEach>
		  		</div>
		  	</div>
		  	
		  	
		  	<div id="userData">
               
		  	
             </div>
		  	
		  	<!--分页  -->
		  		<nav aria-label="Page navigation" class="navigation">
				  <ul class="pagination">
				   
				  </ul>
				</nav>
		  	
		  	
		  	
		  	<%-- <a href="flash_detail.html" class="drjj_item over_hidden">
		  		<div href="" class="fl">
		  			<figure class="imghvr-slide-right img-responsive">
			  			<img src="${APP_PATH}/img1/e_img2.jpg" alt="">
				        <div></div>
				    </figure>
		  		</div>
		  		<div class="text fr">
		  			<p href="" class="size20 color333 block">习近平主席赴俄罗斯出席第四届东方经济论坛</p>
		  			<p href="" class="color666 block text-hidden-two">历时5年出台的这部电商法，明确了电子商务经营者特别是平台经营者 在产...</p>
		  			<span class="fl size14 color666">澎湃新闻</span>
			  		<span class="fr size14 color666">今天08:21</span>	
		  		</div>
		  	</a> --%>
		  	
		  	
		  	
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
		<script src="${APP_PATH}/script/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
		<%-- <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script> --%>
   		 <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
		<script src="${APP_PATH}/script/swiper.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${APP_PATH}/script/wow.js" type="text/javascript" charset="utf-8"></script>
			<script src="${APP_PATH}/layer/layer.js"></script>
		<script type="text/javascript">
		var likeflg = false;
			var swiper = new Swiper('.swiper-container1', {
				autoplay: {
			        delay: 3000,
			        disableOnInteraction: false,
			    },
			    pagination: {
			        el: '.swiper-pagination',
			        clickable: true,
			        renderBullet: function (index, className) {
			          return '<span class="' + className + '"></span>';
			        },
			    },
		    });
		    $(function(){
				pageQuery(1);
			    
			    $("#searchBtn").click(function(){
			    	var queryText = $("#search").val();
			    	if ( queryText == "" ) {
			    		likeflg = false;
			    	} else {
			    		likeflg = true;
			    	}
			    	
			    	pageQuery(1);
			    });
				
			});
		    function pageQuery( pageno ) {
            	var loadingIndex = null;
            	
            	var jsonData = {"pageno" : pageno, "pagesize" : 8, "column" : 3};
            	if ( likeflg == true ) {
            		jsonData.queryText = $("#search").val();
            	}
            	
            	$.ajax({
            		type : "POST",
            		url  : "${APP_PATH}/html/pageQuery",
            		data : jsonData,
            		beforeSend : function(){
            			loadingIndex = layer.msg('处理中', {icon: 16});
            		},
            		success : function(result) {
            			layer.close(loadingIndex);
            			if ( result.success ) {
            				// 局部刷新页面数据
            				var tableContent = "";
            				var pageContent = "";
            				
            				var dongNewsPage = result.data;
            				var dongNews = dongNewsPage.datas;
            				
            				
            				$.each(dongNews, function(i, dongNews){
            					
				            		tableContent+='<a href=flash_detail?newsid='+dongNews.id+' class="drjj_item over_hidden">';
				            		tableContent+='<div href="" class="fl">';
				            		tableContent+='<figure class="imghvr-slide-right img-responsive">';
				            		tableContent+='<img src="'+dongNews.picture+'" alt="">';
				            		tableContent+='<div></div>';
				            		tableContent+='</figure>';
				            		tableContent+='</div>';
				            		tableContent+='<div class="text fr">';
				            		tableContent+='<p href="" class="size20 color333 block">'+dongNews.title+'</p>';
				            		tableContent+='<p href="" class="color666 block text-hidden-two">'+dongNews.contentText+'</p>';
				            		tableContent+='<span class="fl size14 color666">'+dongNews.user+'</span>';
				            		tableContent+='<span class="fr size14 color666">'+dongNews.publishTime+'</span>';	
				            		tableContent+='</div>';
				            		tableContent+='</a>';
				            	/* tableContent +='<a href=flash_detail?newsid='+dongNews.id+' class="drkx_item">';
					            tableContent +='<p href=flash_detail?newsid='+dongNews.id+' class="img-responsive">';
					            tableContent +='<img src="'+1+'"/>';
					            tableContent +='</p>';
					            tableContent +='<div class="text">';
					            tableContent +='<p href="" class="size20 bold color333">'+dongNews.title+'</p>';
					            tableContent +='<p  class="color666">';
					            tableContent +='<span class="bold">'+dongNews.user+'</span>';
					            tableContent +=dongNews.publishTime
					            tableContent +='</p>';	
					            tableContent +='</div>';	
					            tableContent +='</a>'; */			
            	                
            				});
            				
            				if ( pageno > 1 ) {
            					pageContent += '<li><a href="#" onclick="pageQuery('+(pageno-1)+')">上一页</a></li>';
            				}
            				
            				for ( var i = 1; i <= dongNewsPage.totalno; i++ ) {
            					if ( i == pageno ) {
            						pageContent += '<li class="active"><a  href="#">'+i+'</a></li>';
            					} else {
            						pageContent += '<li ><a href="#" onclick="pageQuery('+i+')">'+i+'</a></li>';
            					}
            				}
            				
            				if ( pageno < dongNewsPage.totalno ) {
            					pageContent += '<li><a href="#" onclick="pageQuery('+(pageno+1)+')">下一页</a></li>';
            				}

            				$("#userData").html(tableContent);
            				$(".pagination").html(pageContent);
            			} else {
                            layer.msg("用户信息分页查询失败", {time:2000, icon:5, shift:6}, function(){
                            	
                            });
            			}
            		}
            	});
            }
		</script>
	</body>
</html>

