<?php
	$email = $_POST["user"];
	$name = $_POST["name"];
	$psd = $_POST["psd"];
	$link = mysqli_connect('localhost','root','1227315182lyf','pms',3306);
	if(!$link){
		echo "{\"status\":\"-1\"}";
	}else{
		mysqli_set_charset($link,'utf8');
		$sql = "insert into userInfo values('".$email."','".$psd."','".$name."','covers/default.jpg','N');";
		if(mysqli_query($link, $sql)){
			echo "{\"status\":\"1\"}";
		}else{
			echo "{\"status\":\"0\"}";
		}
		mysqli_close($link);
	}