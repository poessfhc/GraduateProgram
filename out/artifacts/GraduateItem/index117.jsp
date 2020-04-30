<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>电力系统首页</title>
		<link rel="stylesheet" type="text/css" href="libs/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/pub.css">
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<script src="libs/jQuery/jquery-1.12.4.js" type="text/javascript"></script>
		<script src="libs/jQuery/jquery.cookie.js" type="text/javascript"></script>
		<script src="libs/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
		<script>
			$(function(){
				autoSign();
				var timer = 0;
				$("#sign .modal-content .modal-body .logbtn").click(function(){	//	登录账号
					var groups = $(this).parent().siblings();					
					var account = $(groups[0]).find('input').val();				//	获取登录账号
					var password = $(groups[1]).find('input').val();			//	获取输入密码
					var isRemember = $(groups[2]).find('input').is(":checked");	//	获取是否记住密码
					if(!account){
						alert("请输入邮箱！");
					}else if(!password){
						alert("请输入密码！");
					}else{
						$.ajax({
							url: '${ctx}/doLogin.do',
							data: {
								"user": account,
								"psd": password
							},
							dataType: 'json',		//	服务器返回json格式数据
							type: 'post',			//	HTTP请求类型
							success: function(data){
								if(!data){
									alert("账户或密码错误！");
								}else{
									$.cookie("userEmail", account, {expires:7,path: '/'});
									$.cookie("userIshost", data[0], {expires:7,path: '/'});
									$.cookie("userCover", data[2], {expires:7,path: '/'});
									$.cookie("userName", data[1], {expires:7,path: '/'});
									window.location.replace("userHome.html");
								}
							},
							error: function(){
								console.log("error!");
							}
						});
					}
				});
				$("#rege .modal-content .modal-body .logbtn").click(function(){	//	注册账号	
					var groups = $(this).parent().siblings();					
					var account = $(groups[0]).find('input').val();				//	获取注册电话
					var name = $(groups[1]).find('input').val();				//	获取用户名
					var password = $(groups[2]).find('input').val();			//	获取输入密码
					var verif = $(groups[3]).find('input').val();				//	获取输入的验证码
					if(!account){
						alert("请输入邮箱！");
					}else if(!name){
						alert("请输入用户名！");
					}else if(!password){
						alert("请输入密码！");
					}else if(!verif){
						alert("请输入验证码！");
					}else{
						// $("#rege").modal('hide');
						$.ajax({
							url: '${ctx}/doRegister.do',
							data: {
								"user": account,
								"name": name,
								"psd": password
							},
							dataType: 'json',		//	服务器返回json格式数据
							type: 'post',			//	HTTP请求类型
							success: function(data){
								if(data > 0){
									alert("注册成功！您现在可以登录管理设备了。");
								}else if(data < 0){
									alert("注册失败，请稍后重试！");
								}else{
									alert("用户已存在，请直接登录！");
								}
								$("#rege").modal('hide');
							},
							error: function(){
								console.log("error!");
							}
						});
					}
				});
				$("#reset .modal-content .modal-body .logbtn").click(function(){	//	找回密码
					clearInterval(timer);
					$(".btn-verif").html("获取验证码");
					$(".btn-verif").removeAttr("disabled"); 	//	恢复点击事件
					var groups = $(this).parent().siblings();					
					var account = $(groups[0]).find('input').val();				//	获取账号
					var newPsd = $(groups[1]).find('input').val();				//	获取新密码
					var newPsdAg = $(groups[2]).find('input').val();				//	再次获取新密码
					var verif = $(groups[3]).find('input').val();			//	获取输入的验证码
					if(!account){
						alert("请输入邮箱！");
					}else if(!newPsd){
						alert("请输入新密码！");
					}else if(!newPsdAg){
						alert("请再次输入新密码！");
					}else if(newPsd != newPsdAg){
						alert("两次输入的密码不一致！");
					}else if(!verif){
						alert("请输入验证码！");
					}else{
						$.ajax({
							<%--url: '${ctx}/doRevise.do',--%>
							data: {
								"user": account,
								"psd": newPsd
							},
							dataType: 'json',		//	服务器返回json格式数据
							type: 'post',			//	HTTP请求类型
							success: function(data){
								if(data > 0){  //去掉status
									alert("修改成功！您现在可以登录管理设备了。");
									$("#rege").modal('hide');
								}else{
									alert("修改失败，账号不存在！");
								}
							},
							error: function(){
								console.log("error!");
							}
						});
						$("#reset").modal('hide');
					}
				});
				$(".btn-verif").click(function(){	//	获取验证码
					var tarUrl = $(this).parents("form").find(".verif-account").val();
					if(!tarUrl){
						alert("请输入邮箱！");
					}else{
						var btn = $(this);
						btn.attr("disabled","true"); 		//	设置变灰按钮
						var time = 60;
						timer = setInterval(function(){
							time--;
							if(time > 0) btn.html(time + " s 后重新获取");
							else{
								clearInterval(timer);
								btn.html("获取验证码");
								btn.removeAttr("disabled"); 	//	恢复点击事件
							}
						},1000);
					}
				});
				$("header .Sig_Reg a").click(function(){		//	点击登录或注册，重置验证码
					clearInterval(timer);
					$(".btn-verif").html("获取验证码");
					$(".btn-verif").removeAttr("disabled");
					$("#sign input").val('');
					$("#rege input").val('');
					$("#reset input").val('');
					$("#sign input[type='checkbox']").prop("checked", "ckecked");
				});
				function autoSign(){
					if($.cookie("userEmail"))	window.location.href = "userHome.html";
				}
			});
		</script>
	</head>
	<body>
		<header class="container">
			<div class="row">
				<div class="col-lg-1 col-lg-offset-1 logo">
					<img src="imgs/logo.jpg" alt="logo" class="img-responsive img-circle"/>
				</div>
				<div class="col-lg-4 navWord">
					<p>欢迎来到安全用电系统</p>
				</div>
				<div class="col-lg-2 col-lg-offset-4 Sig_Reg">
					<a href="javascript:;" class="pull-left"><span data-toggle="modal" data-target="#sign">登&nbsp;录</span></a>
					<a href="javascript:;" class="pull-left"><span data-toggle="modal" data-target="#rege">注&nbsp;册</span></a>
				</div>
			</div>
		</header>
		<section class="container">
			<div class="row">
				<div class="col-lg-6 col-lg-offset-1">
					<p>Safety of electricity, be weightier than Mount Tai</p>
				</div>
			</div>
			<div class="row sys_intro">
				<div class="col-lg-2 col-lg-offset-1">
					<a href="systemIntro.html" target="_blank">查看系统简介</a>
				</div>
			</div>
		</section>
		<footer class="container">
			<ul class="list-unstyled row">
				<li class="col-lg-10 col-lg-offset-1">
					<span>作者：刘富川（前台）、李浩奇（后台）</span>
				</li>
				<li class="col-lg-10 col-lg-offset-1">
					<span>邮箱1：</span><a href="mailto: 18894221537@163.com">18894221537@163.com</a>
				</li>
				<li class="col-lg-10 col-lg-offset-1">
					<span>邮箱2：</span><a href="mailto: 869156715@qq.com">869156715@qq.com</a>
				</li>
			</ul>
		</footer>
		<div id="sign" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<div class="close" data-dismiss="modal">&times;</div>
						<h4>登录</h4>
					</div>
					<div class="modal-body">
						<form action="">
							<div class="form-group">
								<label for="account" class="text-muted">账号</label>
								<input type="text" id="account" placeholder="邮箱" class="form-control">
							</div>
							<div class="form-group">
								<label for="psd" class="text-muted">密码</label>
								<input type="password" id="psd" placeholder="密码" class="form-control">
							</div>
							<div class="form-group check_box clearfix">
								<input type="checkbox" id="remeb_psd" class="pull-left" checked="checked">
								<label for="remeb_psd" class="text-muted pull-left noselect">记住密码</label>
								<a href="javascript:;" class=" pull-right" data-dismiss="modal" data-toggle="modal" data-target="#reset">忘记密码?</a>
							</div>
							<div class="form-group">
								<a href="javascript:;" class="btn btn-block logbtn">登录</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div id="rege" class="modal fade">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<div class="close" data-dismiss="modal">&times;</div>
						<h4>注册</h4>
					</div>
					<div class="modal-body">
						<form action="">
							<div class="form-group">
								<label for="new-account" class="text-muted">邮箱号</label>
								<input type="text" id="new-account" placeholder="填写你常用的邮箱号作为登录账号" class="form-control verif-account">
							</div>
							<div class="form-group">
								<label for="name" class="text-muted">用户名</label>
								<input type="input" id="name" placeholder="中英文皆可,最长18个英文或9个汉字" class="form-control">
							</div>
							<div class="form-group">
								<label for="new-psd" class="text-muted">密码</label>
								<input type="password" id="new-psd" placeholder="5-20位英文,数字,符号,区分大小写" class="form-control">
							</div>
							<div class="form-group verif clearfix">
								<label for="msg" class="text-muted pull-left">验证码</label>
								<input type="text" id="msg" class="form-control pull-left" placeholder="填写邮箱验证码"/>
								<button type="button" class="btn btn-warning pull-right btn-verif">获取验证码</button>
							</div>
							<div class="form-group">
								<a href="javascript:;" class="btn btn-block logbtn">注册</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div id="reset" class="modal fade">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<div class="close" data-dismiss="modal">&times;</div>
						<h4>找回密码</h4>
					</div>
					<div class="modal-body">
						<form action="">
							<div class="form-group">
								<label for="find-account" class="text-muted">账号</label>
								<input type="text" id="find-account" placeholder="邮箱" class="form-control verif-account">
							</div>
							<div class="form-group">
								<label for="reset-psd" class="text-muted">新密码</label>
								<input type="password" id="reset-psd" placeholder="请输入新密码" class="form-control">
							</div>
							<div class="form-group">
								<label for="reset-psd-again" class="text-muted">新密码</label>
								<input type="password" id="reset-psd-again" placeholder="请再次输入新密码" class="form-control">
							</div>
							<div class="form-group verif clearfix">
								<label for="verif" class="text-muted pull-left">验证码</label>
								<input type="text" id="verif" class="form-control pull-left" placeholder="填写邮箱验证码"/>
								<button type="button" class="btn btn-warning pull-right btn-verif">获取验证码</button>
							</div>
							<div class="form-group">
								<a href="javascript:;" class="btn btn-block logbtn">确定</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
