<?php
	$oldEmail = $_POST["oldEmail"];
	$newEmail = $_POST["newEmail"];
	$link = mysqli_connect('localhost','root','1227315182lyf','pms',3306);
	if(!$link){
		echo "{\"status\":\"-1\"}";
	}else{
		mysqli_set_charset($link,'utf8');
		$sql = "update userInfo set email='".$newEmail."' where email='".$oldEmail."';";
		if(mysqli_query($link, $sql)){
			echo "{\"status\":\"1\"}";
		}else{
			echo "{\"status\":\"0\"}";
		}
		mysqli_close($link);
	}