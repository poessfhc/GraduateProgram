<?php
	$faceInfo = $_FILES["newCover"];
	$email = $_POST["email"];
	$coverPath = $_POST["coverPath"];
	if(isset($faceInfo)){
		$lastName = explode('.', $faceInfo["name"])[1];
		move_uploaded_file($_FILES["newCover"]["tmp_name"],"../../covers/".$email.".".$lastName);
		$link = mysqli_connect('localhost','root','1227315182lyf','pms',3306);
		$sql = "update userInfo set cover='".$coverPath."' where email='".$email."';";
		mysqli_query($link, $sql);
		echo "{\"status\": \"1\"}";
		mysqli_close($link);
	}else{
		echo "{\"status\": \"0\"}";
	}