<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="GB18030">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/login.css">
	<style>

	</style>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <div><a class="navbar-brand" style="font-size:32px;">侗人网新闻管理系统</a></div>
        </div>
      </div>
    </nav>

    <div class="container">

      <form class="form-signin" id="regist_form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户注册</h2>
	        <div class="form-group has-success has-feedback">
				<input type="text" class="form-control" id="username" placeholder="请输入昵称(不可作为登陆账号)" autofocus>
				<span class="glyphicon glyphicon-user form-control-feedback"></span>
		   </div>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="loginacct" placeholder="请输入手机号码作为登录账号" autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="password" class="form-control" id="userpswd" placeholder="请输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="password" class="form-control" id="userpswd1" placeholder="请再次输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="email" placeholder="请输入邮箱地址" style="margin-top:10px;">
			<span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
		  </div>
		  
		  <!-- <div class="form-group has-success has-feedback">
			<select class="form-control" >
                <option>会员</option>
                <option>管理</option>
            </select>
		  </div> -->
        <!-- <div class="checkbox">
          <label>
            忘记密码
          </label>
          <label style="float:right">
            <a href="login.html">我有账号</a>
          </label>
        </div> -->
        <a class="btn btn-lg btn-success btn-block" id="RegistBtn" > 注册</a>
      </form>
    </div>
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="layer/layer.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#RegistBtn").click(function(){
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
    		        	url  : "doAJAXRegist",
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
								layer.msg("注册成功，请登录", {time:2000, icon:3, shift:6}, function(){
									window.location.href = "login";
    		                    });
								
    		                   
    		        			
    		        		} else {
    		                    layer.msg("用户登录账号或密码不正确，请重新输入", {time:2000, icon:5, shift:6}, function(){
    		                    	
    		                    });
    		        		}
    		        	}
    		        });
    		})
    		
    	})
    </script>
  </body>
</html>