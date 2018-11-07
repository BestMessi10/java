<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet"
	href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
<link href="${APP_PATH}/bootstrap/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen">
<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
<link rel="stylesheet" href="${APP_PATH}/css/main.css">
<link rel="stylesheet" href="${APP_PATH}/css/doc.min.css">

<script type="text/javascript" charset="utf-8"
	src="${APP_PATH}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${APP_PATH}/ueditor/ueditor.all.min.js">
	
</script>


<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="${APP_PATH}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
	var ue = UE.getEditor('editor');
	
	  ue.addListener("ready", function () {
        　　ue.setContent('${dongNews.content}');
   });

	
    //判断ueditor 编辑器是否创建成功
	function getContent() {
		/* var arr = [];
		    arr.push("使用editor.getContent()方法可以获得编辑器的内容");
		   arr.push("内容为：");
		   arr.push(UE.getEditor('editor').getContent()); */

	}
</script>
<style>
.tree li {
	list-style-type: none;
	cursor: pointer;
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
					<li style="padding-top: 8px;">
						<div class="btn-group">
							<button type="button"
								class="btn btn-default btn-success dropdown-toggle"
								data-toggle="dropdown">
								<i class="glyphicon glyphicon-user"></i> ${loginUser.username} <span
									class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><i class="glyphicon glyphicon-cog"></i>
										个人设置</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-comment"></i>
										消息</a></li>
								<li class="divider"></li>
								<li><a href="${APP_PATH}/logout"><i
										class="glyphicon glyphicon-off"></i> 退出系统</a></li>
							</ul>
						</div>
					</li>
					<li style="margin-left: 10px; padding-top: 8px;">
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
					<div class="panel-heading">
						表单数据
						<div style="float: right; cursor: pointer;" data-toggle="modal"
							data-target="#myModal">
							<i class="glyphicon glyphicon-question-sign"></i>
						</div>
					</div>
					<div class="panel-body">
						<form role="form" id="newsForm" action="${APP_PATH}/news/insert"
							medthod="post">
							<input type="hidden" name="content" id="content">
							<div class="row">
								<div class="col-lg-3">
									<div class="input-group">
										<span class="input-group-addon"> 新闻标题 </span> <input
											type="text" value="${dongNews.title}" name="title" id="title" class="form-control"
											aria-label="...">
									</div>
									<!-- /input-group -->
								</div>
								<!-- /.col-lg-6 -->
								<div class="col-lg-3">
									<div class="input-group">
										<span class="input-group-addon"> 发布人 </span> <input
											type="text" value="${dongNews.user}" name="user" id="user" class="form-control"
											aria-label="...">
									</div>
									<!-- /input-group -->
								</div>
								<!-- /.col-lg-6 -->
								<div class="col-lg-3">
									<div class="input-group">
										<span class="input-group-addon"> 所属栏目 </span> <select
											id="columnId" class="form-control">
											<c:forEach items="${dongColumns}" var="dongColumn">
												<c:if test="${dongNews.columnId == dongColumn.id}">
													<option selected value="${dongColumn.id}">${dongColumn.name}</option>
												</c:if>
												<c:if test="${dongNews.columnId != dongColumn.id}">
													<option  value="${dongColumn.id}">${dongColumn.name}</option>
												</c:if>
												
												
											</c:forEach>
										</select>
									</div>
									<!-- /input-group -->
								</div>
								<!-- /.col-lg-6 -->
								<div class="col-lg-3">


									<!-- <div class="form-group" style="width: 700px;">
										<div class="input-group date form_date col-md-5" data-date=""
											data-date-format="yyyy-MM-dd HH:ii:mm"
											data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
											<input class="form-control" size="16" type="text" value=""
												readonly> <span class="input-group-addon"><span
												class="glyphicon glyphicon-remove"></span></span> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span></span>
										</div>
										<input type="hidden" id="dtp_input2" value="" /><br />
									</div> -->
									<div class="input-group">
									<span class="input-group-addon"> 发布日期</span> 
									<input type="text" value="${dongNews.publishTime}" name="publishTime" id="publishTime" class="form-control ui_timepicker" value="">
										</div>
								</div>

							</div>
							<!-- /.row -->

							<!--  <div class="form-group">
					<label for="exampleInputPassword1">登陆账号</label>
					<input type="text" class="form-control" id="loginacct" placeholder="请输入登陆账号">
				  </div>
				  <div class="form-group">
					<label for="exampleInputPassword1">用户名称</label>
					<input type="text" class="form-control" id="username" placeholder="请输入用户名称">
				  </div>
				  <div class="form-group">
					<label for="exampleInputEmail1">邮箱地址</label>
					<input type="email" class="form-control" id="email" placeholder="请输入邮箱地址">
					<p class="help-block label label-warning">请输入合法的邮箱地址, 格式为： xxxx@xxxx.com</p>
				  </div> -->
							<div>
								<script id="editor" type="text/plain"
									style="width: 1024px; height: 500px;"></script>
							</div>

							<button id="insertBtn" type="button" class="btn btn-success">
								<i class="glyphicon glyphicon-plus"></i> 更新
							</button>
							<button id="returnBtn" type="button" class="btn btn-danger">
								<i class="glyphicon glyphicon-refresh"></i> 返回
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
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

	<script type="text/javascript"
		src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${APP_PATH}/bootstrap/js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="${APP_PATH}/bootstrap/js/bootstrap-datetimepicker.fr.js"
		charset="UTF-8"></script>

	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/layer/layer.js"></script>
	
	<script type="text/javascript">
		$(function() {
			

		
			 
			
			$(".list-group-item").click(function(){
                // jquery对象的回调方法中的this关键字为DOM对象
                // $(DOM) ==> JQuery
			    if ( $(this).find("ul") ) { // 3 li
					$(this).toggleClass("tree-closed");
					if ( $(this).hasClass("tree-closed") ) {
						$("ul", this).hide("fast");
					} else {
						$("ul", this).show("fast");
					}
				}
			});
			
			// 日期插件
		    $(".ui_timepicker").datetimepicker({
		        language: 'CN',
		        defaultDate: $('.ui_timepicker').val(),
		        dateFormat: "yy-mm-dd",
		        showSecond: true,
		        timeFormat: 'hh:mm:ss',
		        stepHour: 1,
		        stepMinute: 1,
		        stepSecond: 1
		    });
		    
			//querycolumn();

			$("#returnBtn").click(function(){
				
				window.location.href="${APP_PATH}/news/index";
			})
			$("#insertBtn")
					.click(
							function() {
								//getContent();
								var columnId = $("#columnId option:selected").val();
								if (ue.getContent() == null
										|| ue.getContent() == "") {
									layer.msg("新闻内容不能为空", {
										time : 2000,
										icon : 2,
										shift : 6
									}, function() {
									});
									return;
								} else {
									$("#content").val(ue.getContent());
								}

								var user = $("#user").val();
								var title = $("#title").val();
								if (user == "") {
									layer.msg("发布人不能为空，请输入", {
										time : 2000,
										icon : 5,
										shift : 6
									}, function() {

									});
									return;
								}
								if (title == "") {
									layer.msg("新闻标题不能为空，请输入", {
										time : 2000,
										icon : 5,
										shift : 6
									}, function() {

									});
									return;
								}

								var loadingIndex = null;
								//$("#newsForm").submit();
								$
										.ajax({
											type : "POST",
											url : "${APP_PATH}/news/update",
											data : {
												"user" : $("#user").val(),
												"title" : title,
												"columnId" : columnId,
												"content" : $("#content").val(),
												"publishTime":$("#publishTime").val(),
												"id":"${dongNews.id}"
											},
											beforeSend : function() {
												loadingIndex = layer.msg('处理中',
														{
															icon : 16
														});
											},
											success : function(result) {
												layer.close(loadingIndex);
												if (result.success) {
													layer.msg(
																"用户信息保存成功",
																{
																	time : 1000,
																	icon : 6
																},
																function() {
																	window.location.href = "${APP_PATH}/news/index";
																});
												} else {
													layer.msg("用户信息保存失败，请重新操作",
															{
																time : 2000,
																icon : 5,
																shift : 6
															}, function() {

															});
												}
											}
										});
							});
		});
	
	</script>
</body>
</html>
