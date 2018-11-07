<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/main.css">
	<link rel="stylesheet" href="${APP_PATH}/css/doc.min.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	</style>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;">侗人网新闻管理系统</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li style="padding-top:8px;">
				<div class="btn-group">
				  <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i> ${loginUser.username} <span class="caret"></span>
				  </button>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
						<li class="divider"></li>
						<li><a href="${APP_PATH}/logout"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
					  </ul>
			    </div>
			</li>
            <li style="margin-left:10px;padding-top:8px;">
				<button type="button" class="btn btn-default btn-danger">
				  <span class="glyphicon glyphicon-question-sign"></span> 帮助
				</button>
			</li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
			<div class="tree">
				<%@include file="/WEB-INF/jsp/common/menu.jsp"%>
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				
			<div class="panel panel-default">
              <div class="panel-heading">表单数据<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
			  <div class="panel-body">
				<form role="form">
					<div class="form-group">
					<label for="exampleInputPassword1">用户昵称</label>
					<input type="text" class="form-control" id="username" placeholder="请输入用户昵称">
				  </div>
				  <div class="form-group">
					<label for="exampleInputPassword1">登陆账号</label>
					<input type="text" class="form-control" id="loginacct" placeholder="请输入登陆账号">
				  </div>
				  <div class="form-group has-feedback">
				  	<label for="exampleInputPassword1">请输入登录密码</label>
					<input type="password" class="form-control" id="userpswd" placeholder="请输入登录密码" style="margin-top:10px;">
				  </div>
				  <div class="form-group has-feedback">
				  	<label for="exampleInputPassword1">请再次输入登录密码</label>
					<input type="password" class="form-control" id="userpswd1" placeholder="请再次输入登录密码" style="margin-top:10px;">
				  </div>
				  <div class="form-group">
					<label for="exampleInputEmail1">邮箱地址</label>
					<input type="email" class="form-control" id="email" placeholder="请输入邮箱地址">
					<!-- <p class="help-block label label-warning">请输入合法的邮箱地址, 格式为： xxxx@xxxx.com</p> -->
				  </div>
				  <button id="insertBtn" type="button" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i> 新增</button>
				  <button type="button" class="btn btn-danger"><i class="glyphicon glyphicon-refresh"></i> 重置</button>
				</form>
			  </div>
			</div>
        </div>
      </div>
    </div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			<h4 class="modal-title" id="myModalLabel">帮助</h4>
		  </div>
		  <div class="modal-body">
			<div class="bs-callout bs-callout-info">
				<h4>测试标题1</h4>
				<p>测试内容1，测试内容1，测试内容1，测试内容1，测试内容1，测试内容1</p>
			  </div>
			<div class="bs-callout bs-callout-info">
				<h4>测试标题2</h4>
				<p>测试内容2，测试内容2，测试内容2，测试内容2，测试内容2，测试内容2</p>
			  </div>
		  </div>
		  <!--
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="button" class="btn btn-primary">Save changes</button>
		  </div>
		  -->
		</div>
	  </div>
	</div>
    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/layer/layer.js"></script>
        <script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
			    
			    $("#insertBtn").click(function(){
			    	var username = $("#username").val();
	    			var userpswd = $("#userpswd").val();
	    			var loginacct = $("#loginacct").val();
	    			var userpswd1 = $("#userpswd1").val();
	    			var loginacct = $("#loginacct").val();
	    			var email = $("#email").val();
	    			if (username == "" || loginacct == ""){
	    				layer.msg("昵称和登陆账号不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
			            	
			            });
			        	return;
	    				
	    				}
	    			if (userpswd1 == "" || email == ""){
	    				layer.msg("密码和邮箱不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
			            	
			            });
			        	return;
	    				
	    				}
	    			if(!(/^1[34578]\d{9}$/.test(loginacct))){ 
	    				 layer.msg("登陆账号格式有误，请重新输入", {time:2000, icon:5, shift:6}, function(){
	    		            	
	    		            });
	    		        	return;
	    		    } 
	    			if (userpswd1 != userpswd){
	    				layer.msg("两次密码不一致，请重新输入", {time:2000, icon:5, shift:6}, function(){
			            	
			            });
			        	return;
	    				
	    				}
	    			 $.ajax({
	    		        	type : "POST",
	    		        	url  : "${APP_PATH}/doAJAXRegist",
	    		        	data : {
	    		        		"loginacct" : loginacct,
	    		        		"userpswd"  : userpswd,
	    		        		"username" : username,
	    		        		"email"  : email
	    		        	},
	    		        	beforeSend : function(){
	    		        		loadingIndex = layer.msg('处理中', {icon: 16});
	    		        	},
	    		        	success : function(result) {
	    		        		layer.close(loadingIndex);
	    		        		if (result.success) {
									layer.msg("用户添加成功", {time:2000, icon:3, shift:6}, function(){
										window.location.href = "${APP_PATH}/user/index";
	    		                    });
									
	    		                   
	    		        			
	    		        		} else {
	    		                    layer.msg("用户已经存在，请重新输入登陆账号", {time:2000, icon:5, shift:6}, function(){
	    		                    	
	    		                    });
	    		        		}
	    		        	}
	    		        });
			    });
            });
        </script>
  </body>
</html>
