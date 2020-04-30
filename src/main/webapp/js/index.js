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
				url: '',
				data: {
					user: account,
					name: name,
					psd: password
				},
				dataType: 'json',		//	服务器返回json格式数据
				type: 'post',			//	HTTP请求类型
				success: function(userData){
					if(userData.status > 0){
						$.cookie("userEmail", email, {expires:7,path: '/'});
						$.cookie("userIshost", hoster, {expires:7,path: '/'});
						$.cookie("userCover", cover, {expires:7,path: '/'});
						$.cookie("userName", name, {expires:7,path: '/'});
						window.location.href = "userHome.html";
					}else if(user.status < 0){
						alert("用户不存在，请先注册！");
					}else{
						alert("密码错误，请重新登录！");
					}
				},
				error: function(e){
					console.log(e);
				}
			});
		}
	});
	// $("#rege .modal-content .modal-body .logbtn").click(function(){	//	注册账号
	// 	var groups = $(this).parent().siblings();
	// 	var account = $(groups[0]).find('input').val();				//	获取注册电话
	// 	var name = $(groups[1]).find('input').val();				//	获取用户名
	// 	var password = $(groups[2]).find('input').val();			//	获取输入密码
	// 	var verif = $(groups[3]).find('input').val();				//	获取输入的验证码
	// 	if(!account){
	// 		alert("请输入邮箱！");
	// 	}else if(!name){
	// 		alert("请输入用户名！");
	// 	}else if(!password){
	// 		alert("请输入密码！");
	// 	}else if(!verif){
	// 		alert("请输入验证码！");
	// 	}else{
	// 		$("#rege").modal('hide');
	// 		$.ajax({
	// 			url: "${ctx}/doRegister.do",
	// 			data: {
	// 				user: account,
	// 				name: name,
	// 				psd: password
	// 			},
	// 			dataType: 'json',		//	服务器返回json格式数据
	// 			type: 'post',			//	HTTP请求类型
	// 			success: function(data){
	// 				if(data > 0){
	// 					alert("注册成功！您现在可以登录管理设备了。");
	// 					$("#rege").modal('hide');
	// 				}else if(data < 0){
	// 					alert("注册失败，请稍后重试！");
	// 				}else{
	// 					alert("用户已存在，请直接登录！");
	// 				}
	// 			},
	// 			error: function(){
	// 				console.log("error");
	// 			}
	// 		});
	// 	}
	// });
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
				url: '',
				data: {
					user: account,
					psd: newPsd
				},
				dataType: 'json',		//	服务器返回json格式数据
				type: 'post',			//	HTTP请求类型
				success: function(data){
					if(data > 0){
						alert("修改成功！您现在可以登录管理设备了。");
						$("#rege").modal('hide');
					}else if(data < 0){
						alert("修改失败，请稍后重试！");
					}
				},
				error: function(){
					console.log("error!");
				}
			});
			// $("#reset").modal('hide');
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
		if($.cookie("user"))	window.location.href = "userHome.html";
		// if(true)	window.location.href = "userHome.html";
	}
});