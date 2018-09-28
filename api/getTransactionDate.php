<?php

include('connection.php');
 
 	$query = "SELECT * FROM transaksi";
 	$exeQuery = mysqli_query($konek, $query);

 	$array = array();
	while ($data = mysqli_fetch_assoc($exeQuery)) {
		$array["id"]=$data["id_transaksi"];
		$array["total"]=$data["total"];
		$array["tanggal"]=$data["tanggal"];

		$idUser = $data["id_user"];
		$query = "SELECT * FROM transaksi WHERE id='$idUser'";
 		$exeQuery = mysqli_query($konek, $query);
 		$resultQ = mysqli_fetch_assoc($exeQuery);
 		$array[]["user"]["nama"] = $resultQ["nama"];
	}

 	
	$response["sukses"] = true;
	$response["items"] = $array;
	echo json_encode($response);

?>