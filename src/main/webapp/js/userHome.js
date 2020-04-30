$(function(){
	$("section .left .header").click(function(){		//	点击左侧按钮，显示具体选项
		$(this).parent().find("ul").toggle(300);
	});
	$("section .left li a").click(function(){
		$("section .right .tip").hide();
	});
	// $("section .left li a").delegate("body", "click", function(){
	// 	console.log(1);
	// });
});