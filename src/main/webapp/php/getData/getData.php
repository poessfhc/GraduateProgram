<?php
	$server = $_POST["server"];
	$userEmail = $_POST["userEmail"];
	// $server = 0;
	if($server == 0){
		echo "{
			\"水壶\":[\"正常\",\"1\",\"2\",\"3\"],
			\"电饭煲\":[\"异常\",\"5\",\"2\",\"3\"],
			\"监控\":[\"异常\",\"1\",\"0\",\"4\"],
			\"手电筒\":[\"正常\",\"1\",\"3\",\"8\"]
		}";
	}else if($server == 1){
		echo "{
			\"18215224219\":[\"是\",\"2016-02-04\"],
			\"18215224220\":[\"否\",\"2016-02-05\"],
			\"18215224221\":[\"否\",\"2016-02-06\"]
		}";
	}else if($server >= 20 && $server < 30){
		echo "{
			\"水壶\":[\"修改异常数据\",\"2018-02-03\"]
		}";
	}else{
		echo "{
			\"水壶\":[\"电压异常\", \"2030-12-21\"]
		}";
	}