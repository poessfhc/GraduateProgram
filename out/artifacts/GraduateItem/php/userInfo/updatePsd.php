<?php
	$email = $_POST["user"];
	$psd = $_POST["psd"];
	// $email = "18215224218";
	// $psd = "123";
	$link = mysqli_connect('localhost','root','1227315182lyf','pms',3306);
	if(!$link){
		echo "{\"status\":\"-1\"}";
	}else{
		mysqli_set_charset($link,'utf8');
		$sql = "select * from userInfo where email='".$email."';";
		$re = mysqli_query($link, $sql);
		$row = mysqli_fetch_array($re);
		if($row){
			$sql1 = "update userInfo set password='".$psd."' where email='".$email."';";
			// echo $sql1;
			mysqli_query($link, $sql1);
			echo "{\"status\": \"1\"}";
		}else{
			echo "{\"status\":\"0\"}";
		}
		mysqli_close($link);
	}