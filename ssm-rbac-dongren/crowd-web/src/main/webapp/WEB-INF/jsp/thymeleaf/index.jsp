<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<!--<link rel="stylesheet" type="text/css" href="../css/animate.min.css"/>-->
		
		<link rel="stylesheet" type="text/css" href="${APP_PATH}/css/swiper.min.css"/>
		<link rel="stylesheet" type="text/css" href="${APP_PATH}/css/style.css"/>
	</head>
	<body class="indexPage" style='background: url(../img1/bg.jpg) no-repeat;background-size: cover;' >
		<header>
			<div class="layout">
				<a href="#" class="logo">
					<img src="${APP_PATH}/img1/logo.png"/>
					<span class="italic">侗人网</span>
				</a>
				<img class="erwma" src="${APP_PATH}/img1/logo.png"/>
				<ul class="nav">
					<li class="active"><a href="index">首页</a></li>
					<c:forEach items="${dongColumns }" var="dongColumn">
						<li><a href="${dongColumn.url }">${dongColumn.name}</a></li>
					</c:forEach>
					<li ><a href="http://www.dongzulm.com/forum.php">链接</a></li>
					<!-- <li><a href="flash">侗人快讯</a></li>
					<li><a href="culture">侗人文化</a></li>
					<li><a href="economics">侗人经济</a></li>
					<li><a href="travel">侗人旅游</a></li>
					<li><a href="video">侗人视频</a></li> -->
				</ul>
			</div>
		</header>
		
		<div class="layout">
			<!--侗人快讯-->
			<div class="padding30 over_hidden trkx fl">
				<div class="swiper-container swiper-container1 fl">
				    <div class="swiper-wrapper">
					    <div class="swiper-slide">
					    	<a href="#">
					    		<img src="${APP_PATH}/img1/img_kuaixun.png"/>
					    	</a>
					    </div>
					    <div class="swiper-slide">
					    	<a href="#">
					    		<img src="${APP_PATH}/img1/img_kuaixun.png"/>
					    	</a>
					    </div>
					    <div class="swiper-slide">
					    	<a href="#">
					    		<img src="${APP_PATH}/img1/img_kuaixun.png"/>
					    	</a>
					    </div>
				    </div>
				    <!-- Add Pagination -->
				    <div class="swiper-pagination"></div>
				    
			  	</div>
			  	<div class="fl trkx_con">
			  		<div class="title over_hidden">
			  			<div class="fl">
			  				<span class="line"></span>
				  			<p class="size20 bold">侗人快讯</p>
				  			<p class="english">News</p>
			  			</div>
			  			<a class="fr" href="flash">
			  				更多&gt;&gt;
			  			</a>
			  		</div>
			  		<ul class="trkx_item">
			  			<c:forEach varStatus="status" begin="0" end="4" items="${dongNewss1 }" var="dongNews1">
			  				<c:if test="${status.index eq 0 }">
			  					<li class="important"><span class="cricle6"></span><a href="flash_detail?newsid=${dongNews1.id}">${dongNews1.title}</a></li>
			  				</c:if>
			  				<c:if test="${status.index gt 0 }">
			  					<li><span class="cricle6"></span><a href="flash_detail?newsid=${dongNews1.id}">${dongNews1.title}</a></li>
			  				</c:if>
			  			</c:forEach>
			  			<!-- <li><span class="cricle6"></span><a href="#">这次“点穴式”访问，很是不一般！</a></li>
			  			<li><span class="cricle6"></span><a href="#">这次“点穴式”访问，很是不一般！</a></li>
			  			<li><span class="cricle6"></span><a href="#">这次“点穴式”访问，很是不一般！</a></li>
			  			<li><span class="cricle6"></span><a href="#">这次“点穴式”访问，很是不一般！</a></li>
			  			<li><span class="cricle6"></span><a href="#">这次“点穴式”访问，很是不一般！</a></li>
			  			<li><span class="cricle6"></span><a href="#">这次“点穴式”访问，很是不一般！</a></li> -->
			  		</ul>
			  	</div>
			</div>
			<!--热点新闻-->
			<div class="fr rdxw">
				<div class="rdxw_title">
					<p class="size18 fl bold">热点新闻</p>
					<!-- <a class="fr" href="#">
			  			更多&gt;&gt;
			  		</a> -->
				</div>
				<c:forEach items="${dongNewss6 }" varStatus="status" var="dongNews6" begin="0" end="4">
					<c:if test="${status.index eq 0 }">
						<p class="clear"></p>
						<div class="rdxw_con over_hidden">
							<a href="flash_detail?newsid=${dongNews6.id}" class="bold color666 size14 fl">${dongNews6.title }</a>
							<a href="flash_detail?newsid=${dongNews6.id}" class="rdxw_con_item fr size12">${dongNews6.columnName }</a>
						</div>
						<div class="rdxw_con_pic_text over_hidden">
							<a  href="flash_detail?newsid=${dongNews6.id}" class="img-responsive fl">
								<img src="${ dongNews6.picture}"/>
							</a>
							<a href="flash_detail?newsid=${dongNews6.id}"  class="color666 size14 block text-hidden-six">
								${ dongNews6.contentText}
								<span class="color333 size14">详情</span>
							</a>
						</div>
					</c:if>
					<c:if test="${status.index gt 0 }">
						<div class="rdxw_con over_hidden ">
							<span class="cricle4"></span>
							<a href="flash_detail?newsid=${dongNews6.id}" class="color666 size14 marginleft8">${dongNews6.title }</a>
							<a href="flash_detail?newsid=${dongNews6.id}" class="rdxw_con_item fr size12">${dongNews6.columnName }</a>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<div class="banner width100 img-responsive clear">
				<img src="${APP_PATH}/img1/mg_cunzhai.png"/>
			</div>
			<div class="fl">
				<!--侗人文化-->
				<div class="trwh padding30 over_hidden">
					<div class="title over_hidden">
			  			<div class="fl">
			  				<span class="line"></span>
				  			<p class="size20 bold">侗人文化</p>
				  			<p class="english">Culture</p>
			  			</div>
			  			<a class="fr" href="culture">
			  				更多&gt;&gt;
			  			</a>
			  		</div>
			  		  <c:forEach items="${dongNewss2 }" varStatus="status" var="dongNews2" begin="0" end="4">
			  		  		<c:if test="${status.index eq 0 }">
			  		  			<div class="trwh_con">
				  		  			<a class="img-responsive fl big_img" href="flash_detail?newsid=${dongNews2.id}">
						  				<img src="${ dongNews2.picture}"/>
						  				<span class="colorfff text-center">
						  					${ dongNews2.title}
						  				</span>
						  			</a>
					  			</div>
			  		  		</c:if>
			  		  		<c:if test="${status.index gt 0 }">
			  				<a class="small_img" href="flash_detail?newsid=${dongNews2.id}">
				  				 <div class="img-responsive"> 
				  					<img src="${ dongNews2.picture}"/>
				  					<span class="colorfff text-center">
					  					共1张
					  				</span>
				  				 </div> 
				  				 <div class="">
				  					${ dongNews2.title}
				  				</div>
			  				</a>
			  				</c:if>
			  		</c:forEach> 
		  			 <%-- 
		  			 <div class="trwh_con">
		  			 <a class="img-responsive fl big_img" href="#">
		  				<img src="${APP_PATH}/img1/img_cuture1.png"/>
		  				<span class="colorfff text-center">
		  					不要看天晴！四川全省平均气温下降4℃左右
		  				</span>
		  			</a>
			  		</div>
		  			<a class="small_img" href="#">
		  				<div class="img-responsive">
		  					<img src="${APP_PATH}/img1/img_cuture2.png"/>
		  					<span class="colorfff text-center">
			  					共1张
			  				</span>
		  				</div>
		  				
		  				<div class="">
		  					这次“点穴式”访问， 很是不一般！
		  				</div>
		  			</a>    --%>
		  			
				</div>
				<!--侗人经济-->
				<div class="trjj padding30 over_hidden">
					<div class="title over_hidden">
			  			<div class="fl">
			  				<span class="line"></span>
				  			<p class="size20 bold">侗人经济</p>
				  			<p class="english colorfff">Economics</p>
			  			</div>
			  			<a class="fr" href="economics">
			  				更多&gt;&gt;
			  			</a>
			  		</div>
			  		<c:forEach items="${dongNewss3 }"  var="dongNews3" begin="0" end="3">
			  			<div class="trjj_con fl">
			  			<a href="flash_detail?newsid=${dongNews3.id}" class="img-responsive fl">
			  				<img src="${dongNews3.picture}"/>
			  			</a>
			  			<a href="flash_detail?newsid=${dongNews3.id}" class="trjj_con_text fl">
			  				<p>${dongNews3.title}</p>
			  				<p class="size14 color666 text-hidden-three">${dongNews3.contentText}</p>
			  				<p class="size14">[详细]</p>
			  			</a>
			  		</div>
			  		</c:forEach>
			  		
			  		
			  		<%-- <div class="trjj_con fl">
			  			<a href="#" class="img-responsive fl">
			  				<img src="${APP_PATH}/img1/img_jingji4.png"/>
			  			</a>
			  			<a href="#" class="trjj_con_text fl">
			  				<p>不要看天晴！四川全省 平均气温下降4℃左右</p>
			  				<p class="size14 color666 text-hidden-three">毕竟再过7天，就是中秋节了。 本周的气温也是相当配合地跳 着小步舞...</p>
			  				<p class="size14">[详细]</p>
			  			</a>
			  		</div> --%>
				</div>
			</div>
			<!--侗人旅游-->
			<div class="fr trly padding30 over_hidden">
				<div class="title over_hidden">
		  			<div class="fl">
		  				<span class="line"></span>
			  			<p class="size20 bold">侗人旅游</p>
			  			<p class="english">Travel</p>
		  			</div>
		  			<a class="fr" href="travel">
		  				更多&gt;&gt;
		  			</a>
		  		</div>
		  		<div class="trly_con">
		  			<c:forEach items="${dongNewss4 }" varStatus="status" var="dongNews4" begin="0" end="6">
		  				<c:if test="${status.index eq 0 }">
				  			<a class="img-responsive big_img" href="flash_detail?newsid=${dongNews4.id}" >
				  				<img src="${dongNews4.picture}"/>
				  				<span class="colorfff text-center">
				  					${dongNews4.title}
				  				</span>
				  			</a>
				  		</c:if>
		  			<c:if test="${status.index gt 0 }">
			  			<div class="trly_sm_pic">
			  				<a class="img-responsive" href="flash_detail?newsid=${dongNews4.id}">
				  				<img src="${dongNews4.picture}"/>
				  				<span class="colorfff text-center">
				  					${dongNews4.title}
				  				</span>
				  			</a>
				  			
			  			</div>
		  			</c:if>
		  			</c:forEach>
		  		</div>
			</div>
			<%-- <div class="banner width100 img-responsive clear">
				<img src="${APP_PATH}/img1/mg_cunzhai.png"/>
			</div> --%>
			<!--侗人视频-->
		<div class="layout trsp">
			<div class="bgfff padding30 over_hidden" id="userData">
				<div class="title over_hidden">
		  			<div class="fl">
		  				<span class="line"></span>
			  			<p class="size20 bold">侗人视频</p>
			  			<p class="english">Video</p>
		  			</div>
		  			<a class="fr" href="video">
		  				更多&gt;&gt;
		  			</a>
		  		</div>
		  		
		  			
				  		  <c:forEach items="${dongNewss5 }" varStatus="status" var="dongNews5" begin="0" end="4">
				  		  	
					  			<c:if test="${status.index eq 0 }">	
					  						<div class="fl">
								  			<a href="javascript:(0);" class="img-responsive big_img">
								  				<img src="${APP_PATH}/img1/bofang.png" class="bofang"/>
								  				
								  				<video preload="meta" style="width:100%">
								  					<source src="${dongNews5.video }" type="video/mp4"/>
								  				</video>
								  				<span class="colorfff text-center">${dongNews5.title }</span>
								  			</a>
						  		</c:if>
					  		
						  		<c:if test="${status.index eq  1 }">	
						  					<div class="small_img">
							  				<a href="javascript:(0);" class="">
							  					<div class="img-responsive">
							  						<img src="${APP_PATH}/img1/bofang.png" class="bofang"/>
							  						<video preload="meta" style="width:100%">
								  							<source src="${dongNews5.video }" type="video/mp4"/>
								  						</video>
							  					</div>
								  				<span class="small_img_ms">${dongNews5.title }</span>
								  			</a>
							  			
						  		</c:if>
						  		<c:if test="${status.index eq  2 }">	
							  				<a href="javascript:(0);" class="">
							  					<div class="img-responsive">
							  						<img src="${APP_PATH}/img1/bofang.png" class="bofang"/>
							  						<video preload="meta" style="width:100%">
								  							<source src="${dongNews5.video }" type="video/mp4"/>
								  						</video>
							  					</div>
								  				<span class="small_img_ms">${dongNews5.title }</span>
								  			</a>
							  			</div>
							  			</div>
						  		</c:if>
						  		
						  		<c:if test="${status.index eq 3 }">	
				  					<div class="fr small_img">
						  			<a href="javascript:(0);" class="">
					  					<div class="img-responsive">
					  						<img src="${APP_PATH}/img1/bofang.png" class="bofang"/>
					  						<video preload="meta" style="width:100%">
					  							<source src="${dongNews5.video }" type="video/mp4"/>
					  						</video>
					  					</div>
						  				<span class="small_img_ms">${dongNews5.title}</span>
						  			</a>
						  		
					  		</c:if>
					  		
					  		<c:if test="${status.index eq 4 }">	
				  		
						  			<a href="javascript:(0);" class="">
					  					<div class="img-responsive">
					  						<img src="${APP_PATH}/img1/bofang.png" class="bofang"/>
					  						<video preload="meta" style="width:100%">
					  							<source src="${dongNews5.video }" type="video/mp4"/>
					  						</video>
					  					</div>
						  				<span class="small_img_ms">${dongNews5.title}</span>
						  			</a>
						  		</div>
					  		</c:if>
						  		
				  		</c:forEach> 
		  		
		  		<%-- <c:forEach items="${dongNewss5 }" varStatus="status" var="dongNews5" begin="0" end="2">
		  			<div class="fr small_img">
			  		<c:if test="${status.index gt 2 }">	
				  		
				  			<a href="#" class="">
			  					<div class="img-responsive">
			  						<img src="${APP_PATH}/img1/bofang.png" class="bofang"/>
			  						<video preload="meta" style="width:100%">
			  							<source src="${dongNews5.video }" type="video/mp4"/>
			  						</video>
			  					</div>
				  				<span class="small_img_ms">${dongNews5.title}</span>
				  			</a>
				  		
			  		</c:if>
			  		</div>
		  		</c:forEach> --%>
		  		 
		  		
		  		
		  		  <%-- <div class="fl">
		  			<a href="#" class="img-responsive big_img">
		  				<img src="${APP_PATH}/img1/bofang.png" class="bofang"/>
		  				
		  				<video preload="meta" style="width:100%">
		  					<source src="${dongNews5.video }" type="video/mp4"/>
		  				</video>
		  				<span class="colorfff text-center">这次“点穴式”访问，很是不一般！</span>
		  			</a>
		  			<div class="small_img">
		  				<a href="#" class="">
		  					<div class="img-responsive">
		  						<img src="${APP_PATH}/img1/bofang.png" class="bofang"/>
		  						<video preload="meta" style="width:100%">
		  					<source src="${dongNews5.video }" type="video/mp4"/>
		  				</video>
		  					</div>
			  				<span class="small_img_ms">这次“点穴式”访问，很是不一般！</span>
			  			</a>
			  			<a href="#" class="">
		  					<div class="img-responsive">
		  						<img src="${APP_PATH}/img1/bofang.png" class="bofang"/>
		  						<video preload="meta" style="width:100%">
				  					<source src="${dongNews5.video }" type="video/mp4"/>
				  				</video>
		  					</div>
			  				<span class="small_img_ms">这次“点穴式”访问，很是不一般！</span>
			  			</a>
		  			</div>
		  		</div>
		  		
		  		<div class="fr small_img">
		  			<a href="#" class="">
	  					<div class="img-responsive">
	  						<img src="${APP_PATH}/img1/bofang.png" class="bofang"/>
	  						<img src="${APP_PATH}/img1/img_shipin2.png"/>
	  					</div>
		  				<span class="small_img_ms">这次“点穴式”访问，很是不一般！</span>
		  			</a>
		  			<a href="#" class="">
	  					<div class="img-responsive">
	  						<img src="${APP_PATH}/img1/bofang.png" class="bofang"/>
	  						<img src="${APP_PATH}/img1/img_shipin3.png"/>
	  					</div>
		  				<span class="small_img_ms">这次“点穴式”访问，很是不一般！</span>
		  			</a>
	  			</div>    --%>
	  			
			</div>
		</div>
		<!--合作伙伴-->
		<div class="hzhb">
			<div class="title over_hidden mar_auto">
  				<span class="line"></span>
	  			<p class="size20 bold">合作伙伴</p>
	  			<p class="english">Partner</p>
	  		</div>
	  		<div class="relative">
		  		<div class="swiper-container swiper-container2">
				    <div class="swiper-wrapper">
				      <div class="swiper-slide">
				      	<a href="#" class="img-responsive">
				      		<img src="${APP_PATH}/img1/img_lvyou6.png"/>
				      	</a>
				      </div>
				      <div class="swiper-slide">
				      	<a href="#" class="img-responsive">
				      		<img src="${APP_PATH}/img1/img_lvyou6.png"/>
				      	</a>
				      </div>
				      <div class="swiper-slide">
				      	<a href="#" class="img-responsive">
				      		<img src="${APP_PATH}/img1/img_lvyou6.png"/>
				      	</a>
				      </div>
				      <div class="swiper-slide">
				      	<a href="#" class="img-responsive">
				      		<img src="${APP_PATH}/img1/img_lvyou6.png"/>
				      	</a>
				      </div>
				      <div class="swiper-slide">
				      	<a href="#" class="img-responsive">
				      		<img src="${APP_PATH}/img1/img_lvyou6.png"/>
				      	</a>
				      </div>
				      <div class="swiper-slide">
				      	<a href="#" class="img-responsive">
				      		<img src="${APP_PATH}/img1/img_lvyou6.png"/>
				      	</a>
				      </div>
				      <div class="swiper-slide">
				      	<a href="#" class="img-responsive">
				      		<img src="${APP_PATH}/img1/img_lvyou6.png"/>
				      	</a>
				      </div>
				    </div>
				    <!-- Add Pagination -->
				    <!--<div class="swiper-button-next"></div>
	    			<div class="swiper-button-prev"></div>-->
				</div>
				<div class="swiper-button-prev"></div>
				<div class="swiper-button-next"></div>
			</div>
		</div>
		
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
	           	<div class="layout" style="text-align: center;">&copy;万宝源</div>
        	</div>
        </div>
		</footer>
		<div id="modal-overlay" style="display: none;">
		    <div class="modal-data">
		        <a onclick="overlay('')" href="javascript:;" class="close">
		        	<i class="iconfont icon-cuo size30"></i>
		        </a>
		        <video id="videoTarget" name="media" controls="" autoplay="" preload="" src="">
		
		        </video>
		    </div>
		</div>
		<script src="${APP_PATH}/script/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="${APP_PATH}/script/swiper.min.js" type="text/javascript" charset="utf-8"></script>
		<!--<script src="${APP_PATH}/script/wow.js" type="text/javascript" charset="utf-8"></script>-->
		<script>
		 $("#userData").on("click",".img-responsive",function(){
			 $("#modal-overlay").toggle();
			 console.log(1)
			 var src = $(this).find("source").attr("src")
			 console.log(src)
				
		        if(src){
					console.log(src)
					$('#videoTarget').attr('src', src)
		        }else {
					$('#videoTarget').attr('src', '')
		        }
		 });
			function overlay(src){
				console.log(src)
				
				$("#modal-overlay").toggle();
				if(src){
					console.log(src)
					$('#videoTarget').attr('src', src)
		        }else {
					$('#videoTarget').attr('src', '')
		        }
		    };
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
		    var swiper = new Swiper('.swiper-container2', {
		      slidesPerView: 4,
		      spaceBetween: 20,
		      
		      navigation: {
		        nextEl: '.swiper-button-next',
		        prevEl: '.swiper-button-prev',
		      },
		    });
		    var wow = new WOW({
		        boxClass: 'wow',
		        animateClass: 'animated',
		        offset: 0,
		        mobile: true,
		        live: true
		    });
		    wow.init();
		</script>
	</body>
</html>
