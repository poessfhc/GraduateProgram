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
		<script src="libs/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="js/index.js" type="text/javascript"></script>
	</head>
	<body>
		<header class="container">
			<div class="row">
				<div class="col-lg-1 col-lg-offset-1 logo">
					<img src="images/logo.jpg" alt="logo" class="img-responsive img-circle"/>
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
					<a href="introSys.html" target="_blank">查看系统简介</a>
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
								<input type="text" id="account" placeholder="邮箱/手机号" class="form-control">
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
						<form action="${ctx}/user/doRegister.do" method="post">
							<div class="form-group">
								<label for="new-account" class="text-muted">手机号码</label>
								<input type="text" id="new-account" placeholder="填写你常用的手机号码作为登录账号" class="form-control">
							</div>
							<div class="form-group">
								<label for="name" class="text-muted">用户名</label>
								<input type="input" id="name" placeholder="中英文皆可,最长18个英文或9个汉字" class="form-control">
							</div>
							<div class="form-group">
								<label for="new-psd" class="text-muted">密码</label>
								<input type="input" id="new-psd" placeholder="5-20位英文,数字,符号,区分大小写" class="form-control">
							</div>
							<div class="form-group verif clearfix">
								<label for="msg" class="text-muted pull-left">验证码</label>
								<input type="text" id="msg" class="form-control pull-left" placeholder="填写短信验证码"/>
								<button class="btn btn-warning pull-right btn-verif">获取验证码</button>
							</div>
							<div class="form-group">
								<a href="javascript:;" class="btn btn-block logbtn">登录</a>
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
						<h4>修改密码</h4>
					</div>
					<div class="modal-body">
						<form action="">
							<div class="form-group">
								<label for="account" class="text-muted">账号</label>
								<input type="text" id="account" placeholder="邮箱/手机号" class="form-control">
							</div>
							<div class="form-group">
								<label for="old-psd" class="text-muted">旧密码</label>
								<input type="input" id="old-psd" placeholder="请输入旧密码" class="form-control">
							</div>
							<div class="form-group">
								<label for="reset-psd" class="text-muted">新密码</label>
								<input type="input" id="reset-psd" placeholder="请输入新密码" class="form-control">
							</div>
							<div class="form-group">
								<label for="reset-psd-again" class="text-muted">新密码</label>
								<input type="input" id="reset-psd-again" placeholder="请再次输入新密码" class="form-control">
							</div>
							<div class="form-group verif clearfix">
								<label for="verif" class="text-muted pull-left">验证码</label>
								<input type="text" id="verif" class="form-control pull-left" placeholder="填写短信验证码"/>
								<button class="btn btn-warning pull-right btn-verif">获取验证码</button>
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
