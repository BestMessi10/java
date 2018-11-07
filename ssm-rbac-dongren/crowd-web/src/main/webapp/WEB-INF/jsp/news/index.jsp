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
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
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
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 新闻数据列表</h3>
			  </div>
			  <div class="panel-body">
<form class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">标题</div>
      <input id="queryText" class="form-control has-success" type="text" placeholder="请输入标题查询">
    </div>
  </div>
  <button id="queryBtn" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
</form>
<button type="button" class="btn btn-danger" onclick="deleteDongNewss()" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
<button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='${APP_PATH}/news/add'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
<br>
 <hr style="clear:both;">
          <div class="table-responsive">
            <form id="dongNewsForm">
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input type="checkbox" id="allSelBox"></th>
				  <th>审核状态</th>
                  <th>标题</th>
                  <th>发布者</th>
                  <th>时间</th>
                  <th>所属栏目</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              
              <tbody id="dongNewsData">
                  
              </tbody>
              
			  <tfoot>
			     <tr >
				     <td colspan="6" align="center">
						<ul class="pagination">

							 </ul>
					 </td>
				 </tr>

			  </tfoot>
            </table>
            </form>
          </div>
			  </div>
			</div>
        </div>
      </div>
    </div>

    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/layer/layer.js"></script>
        <script type="text/javascript">
            var likeflg = false;
            $(function () {
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
			    
			    pageQuery(1);
			    
			    $("#queryBtn").click(function(){
			    	var queryText = $("#queryText").val();
			    	if ( queryText == "" ) {
			    		likeflg = false;
			    	} else {
			    		likeflg = true;
			    	}
			    	
			    	pageQuery(1);
			    });
			    
			    $("#allSelBox").click(function(){
			    	var flg = this.checked;
			    	
			    	$("#dongNewsData :checkbox").each(function(){
			    		this.checked = flg;
			    	});
			    });
            });
            $("tbody .btn-success").click(function(){
                window.location.href = "assignRole.html";
            });
            $("tbody .btn-primary").click(function(){
                window.location.href = "edit.html";
            });
            
            // 分页查询
            function pageQuery( pageno ) {
            	var loadingIndex = null;
            	
            	var jsonData = {"pageno" : pageno, "pagesize" : 6};
            	if ( likeflg == true ) {
            		jsonData.queryText = $("#queryText").val();
            	}
            	
            	$.ajax({
            		type : "POST",
            		url  : "${APP_PATH}/news/pageQuery",
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
            	                tableContent += '<tr>';
	          	                tableContent += '  <td>'+(i+1)+'</td>';
	          					tableContent += '  <td><input type="checkbox" name="dongNewsid" value="'+dongNews.id+'"></td>';
	          					tableContent += '  <td>'+(dongNews.status == 0 ? "待审核" : "审核通过")+'</td>';
	          	                tableContent += '  <td>'+dongNews.title+'</td>';
	          	                tableContent += '  <td>'+dongNews.user+'</td>';
	          	                tableContent += '  <td>'+dongNews.publishTime+'</td>';
	          	             	 tableContent += '  <td>'+dongNews.columnName+'</td>';
	          	                tableContent += '  <td width="140px">';
	          					tableContent += '      <button type="button" onclick="goAssignPage('+dongNews.id+', \''+dongNews.title+'\')" class="btn btn-default btn-xs"><i class=" glyphicon glyphicon-ok-sign"></i></button>';
	          					tableContent += '      <button type="button" onclick="goNotAssignPage('+dongNews.id+', \''+dongNews.title+'\')" class="btn btn-default btn-xs"><i class=" glyphicon glyphicon-remove-sign"></i></button>';
	          					tableContent += '      <button type="button" onclick="goUpdatePage('+dongNews.id+')" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>';
	          					tableContent += '	  <button type="button" onclick="deleteDongNews('+dongNews.id+', \''+dongNews.title+'\')" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
	          					tableContent += '  </td>';
	          	                tableContent += '</tr>';
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

            				$("#dongNewsData").html(tableContent);
            				$(".pagination").html(pageContent);
            			} else {
                            layer.msg("用户信息分页查询失败", {time:2000, icon:5, shift:6}, function(){
                            	
                            });
            			}
            		}
            	});
            }
            
            function goUpdatePage(id) {
            	window.location.href = "${APP_PATH}/news/edit?id="+id;
            }
            function goNotAssignPage( id, title) {
            	var flag= "0";
            	//window.location.href = "${APP_PATH}/news/assign?dongNews="+dongNews;
				layer.confirm("确认取消审核新闻【"+title+"】通过, 是否继续",  {icon: 3, title:'提示'}, function(cindex){
    			    
    				$.ajax({
    					type : "POST",
    					url  : "${APP_PATH}/news/assign",
    					data : { id : id ,
    							flag: flag	
    					},
    					success : function(result) {
    						if ( result.success ) {
    							pageQuery(1);
    						} else {
                                layer.msg("取消新闻信息审核失败", {time:2000, icon:5, shift:6}, function(){
                                	
                                });
    						}
    					}
    				});
    				
    				layer.close(cindex);
    			}, function(cindex){
    			    layer.close(cindex);
    			});
            }
            function goAssignPage( id, title) {
            	//window.location.href = "${APP_PATH}/news/assign?dongNews="+dongNews;
            	var flag= "1";
				layer.confirm("确认审核新闻【"+title+"】通过, 是否继续",  {icon: 3, title:'提示'}, function(cindex){
    			    
    				$.ajax({
    					type : "POST",
    					url  : "${APP_PATH}/news/assign",
    					data : { id : id ,
    						flag: flag	},
    					success : function(result) {
    						if ( result.success ) {
    							pageQuery(1);
    						} else {
                                layer.msg("新闻信息审核失败", {time:2000, icon:5, shift:6}, function(){
                                	
                                });
    						}
    					}
    				});
    				
    				layer.close(cindex);
    			}, function(cindex){
    			    layer.close(cindex);
    			});
            }
            

            function deleteDongNewss() {
            	var boxes = $("#dongNewsData :checkbox");
            	if ( boxes.length == 0 ) {
                    layer.msg("请选择需要删除的用户信息", {time:2000, icon:5, shift:6}, function(){
                    	
                    });
            	} else {
        			layer.confirm("删除选择的用户信息, 是否继续",  {icon: 3, title:'提示'}, function(cindex){
        				// 删除选择的用户信息
        				 /* alert($("#dongNewsForm").serialize());
        				return;  */
        				$.ajax({
        					type : "POST",
        					url  : "${APP_PATH}/news/deletes",
        					data : $("#dongNewsForm").serialize(),
        					success : function(result) {
        						if ( result.success ) {
        							pageQuery(1);
        						} else {
                                    layer.msg("用户信息删除失败", {time:2000, icon:5, shift:6}, function(){
                                    	
                                    });
        						}
        					}
        				});
        				
        				layer.close(cindex);
        			}, function(cindex){
        			    layer.close(cindex);
        			});
            	}
            }
            
            function deleteDongNews( id, title ) {
    			layer.confirm("删除新闻信息【"+title+"】, 是否继续",  {icon: 3, title:'提示'}, function(cindex){
    			    
    				// 删除用户信息
    				$.ajax({
    					type : "POST",
    					url  : "${APP_PATH}/news/delete",
    					data : { id : id },
    					success : function(result) {
    						if ( result.success ) {
    							pageQuery(1);
    						} else {
                                layer.msg("用户信息删除失败", {time:2000, icon:5, shift:6}, function(){
                                	
                                });
    						}
    					}
    				});
    				
    				layer.close(cindex);
    			}, function(cindex){
    			    layer.close(cindex);
    			});
            }
        </script>
  </body>
</html>
