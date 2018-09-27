<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>在线科目分数</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href=javascript:void(0); onclick="showGrade()">分数列表</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<form action="indexAjax.ajax" method="POST" class="navbar-form navbar-left">
						<div class="form-group">
							<input type="text" name="isubject" id="isubject"
								class="form-control" placeholder="请输科目"> <input
								type="number" name="iscore" id="iscore" class="form-control"
								placeholder="请输入分数">
						</div>
						<button type="button" class="btn btn-default" onclick="tianjia()">新增</button>
					</form>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>科目</th>
							<th>分数</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="gradeBox">
					
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
	showGrade();//初始化界面之后立即显示帖子列表
	});
	
	//使用Ajax添加分数
	function tianjia() {
		var isubject = $("#isubject").val();
		var iscore = $("#iscore").val();
		$.ajax({
			url : 'indexAjax.ajax',
			type : 'POST',
			data : {
				isubject : isubject,
				iscore : iscore
			},
			dataType : 'text',
			success : function(res) {
				if (res == "SUCCESS") {
					showGrade();
				}
			},
			error : function() {
				alert("添加失败。");
			}
		});
	}
	//删除分数
	function shanchu(id) {
		var id = id;
		
		$.ajax({
			url : 'removeIndexByAjax.ajax',
			type : 'POST',
			data : {
				id : id
				
			},
			dataType : 'text',
			success : function(re) {
				if (re == "SUCCESS") {
					showGrade();
				}
			},
			error : function() {
				alert("删除失败。");
			}
		});
	}
	
	//显示分数列表
	function showGrade() {
		$.ajax({
			url : 'showGradeByAjax.ajax',
			type : 'POST',
			data : {

			},
			dataType : 'text',
			success : function(res) {
				$("#gradeBox").html("");//清空div内容
				var json = eval("(" + res + ")");//执行输入的代码并返回执行结果，把返回的Json字符串转化为货真价实的Json对象
				for (var i = 0; i < json.length; i++) {//对于Json数组遍历并在页面上添加元素
					$("#gradeBox").append("<tr><td>"+json[i].id+"</td>"+
							"<td>"+json[i].subject+"</td>"+
							"<td>"+json[i].score+"</td>"+
							"<td><a href='javascript:void(0);' onclick='shanchu("+json[i].id+")'><span class='glyphicon glyphicon-remove'></span>删除</a></td></tr>"
							);
				}
			},
			error : function() {

			}
		});
	}
	
	
</script>
</html>