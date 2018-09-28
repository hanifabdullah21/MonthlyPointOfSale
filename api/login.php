<?php

include('connection.php');

if ($_GET) {
 	$username = $_GET['username'];
 	$password = $_GET['password'];
 
 	$query = "SELECT * FROM users WHERE username='$username' AND password='$password'";
 	$exeQuery = mysqli_query($konek, $query);

 	$array_json = array();
	while ($data = mysqli_fetch_assoc($exeQuery)) {
				$array_json[]=$data;
	}

	$jumlah_data = count($array_json);
	// $response["count"] = count($array_json);
	if ($jumlah_data==0) {
		$response["error"] = true;
		$response["users"] = null;
 		echo json_encode($response);
	}else{
		$response["error"] = false;
		$response["users"]["id"] = $array_json[0]["id"];
		$response["users"]["nama"] = $array_json[0]["nama"];
		$response["users"]["username"] = $array_json[0]["username"];
 		echo json_encode($response);
	}
}

?>