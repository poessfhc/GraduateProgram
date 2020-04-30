<?php
	$email = $_POST["user"];
	$link = mysqli_connect('localhost','root','1227315182lyf','pms',3306);
	if(!$link){
		echo "{\"status\":\"0\"}";
	}else{
		mysqli_set_charset($link,'utf8');
		$sql = "delete from userInfo where email='".$email."';";
		mysqli_query($link, $sql);
		echo "{\"status\":\"1\"}";
		mysqli_close($link);
	}