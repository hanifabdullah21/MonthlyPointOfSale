<?php

include('connection.php');
 
 	$query = "SELECT * FROM items";
 	$exeQuery = mysqli_query($konek, $query);

 	$array = array();
	while ($data = mysqli_fetch_assoc($exeQuery)) {
				$array[]=$data;
	}

 	
	$response["error"] = false;
	$response["items"] = $array;
	echo json_encode($response);

?>