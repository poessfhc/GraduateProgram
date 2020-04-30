<?php
	$email = $_POST["user"];
	$psd = $_POST["psd"];
	// $email = '18215224219';
	// $psd = '123456';
	$link = mysqli_connect('localhost','root','1227315182lyf','pms',3306);
	if(!$link){
		echo "{\"status\":\"-1\"}";
	}else{
		mysqli_set_charset($link,'utf8');
		$sql = "select name,cover,host from userInfo where email='".$email."' and password='".$psd."';";
		$re = mysqli_query($link, $sql);
		$re1 = mysqli_query($link, $sql);
		$row = mysqli_fetch_array($re);
		if($row){
			while ($row1 = mysqli_fetch_assoc($re1)) {
				$results[] = $row1;
			}
			$userData = json_encode($results);
			echo "{\"status\": \"1\", \"userData\": $userData}";
		}else{
			echo "{\"status\":\"0\"}";
		}
		mysqli_close($link);
	}