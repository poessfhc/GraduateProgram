<?php
	$server = $_POST["server"];
	$home = $_POST["home"];
	if($server == 1){
		echo "{
			\"嘚嘚\":[\"18215224219\",\"是\",\"2020-09-09\"],
			\"哒哒\":[\"18215224220\",\"否\",\"2020-09-09\"],
			\"滴滴\":[\"18215224221\",\"否\",\"2020-09-09\"],
			\"比u比u\":[\"18215224222\",\"否\",\"2020-09-09\"],
			\"小明\":[\"18215224223\",\"否\",\"2020-09-09\"]
		}";
	}else if($server == 2){
		echo "{
			\"水壶\":[\"正常\",\"1\",\"2\",\"3\"],
			\"电饭煲\":[\"异常\",\"5\",\"2\",\"3\"],
			\"监控\":[\"异常\",\"1\",\"0\",\"4\"],
			\"手电筒\":[\"正常\",\"1\",\"3\",\"8\"]
		}";
	}else if($server == 3){
		echo "{
			\"18215224219\":[\"dede\",\"水壶\",\"修改异常数据\",\"2018-02-03\"],
			\"18215224220\":[\"夫人\",\"手电筒\",\"修改异常数据\",\"2018-02-06\"],
			\"18215224215\":[\"士大夫\",\"手机\",\"修改异常数据\",\"2018-02-08\"],
			\"18215224214\":[\"句\",\"插线板\",\"修改异常数据\",\"2018-02-22\"]
		}";
	}else{
		echo "{
			\"水壶\":[\"电压异常\",\"2020-03-03\"],
			\"电饭煲\":[\"电流异常\",\"2020-03-03\"],
			\"监控\":[\"电流异常\",\"2020-03-03\"],
			\"手电筒\":[\"地线异常\",\"2020-03-03\"]
		}";
	}