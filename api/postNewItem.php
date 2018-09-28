<?php

include('connection.php');
header('Content-Type: application/json');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	$id = $_POST["id"];
	$nama = $_POST["nama"];
	$harga = $_POST["harga"];
	$stok = $_POST["stok"];

	
	$qCekId = "SELECT id FROM items WHERE id = '$id'";
	$exeQuery = mysqli_query($konek, $qCekId);
	$idIsEmpty = mysqli_fetch_assoc($exeQuery);

	//jika belum masukkan data baru, ambil id nya
	if ($idIsEmpty!=null) {
		$response["sukses"] = FALSE;
		$response["pesan"] = "Id Sudah Ada";
		echo json_encode($response);
	}else{
		$insertItem = "INSERT INTO items (id,nama,harga,stok) VALUES ('$id','$nama','$harga','$stok')";
		$exeQuery = mysqli_query($konek, $insertItem);

		if ($exeQuery==0) {
			$response["sukses"] = FALSE;
			$response["pesan"] = "Item baru gagal ditambahkan";
			echo json_encode($response);
		}else{
			$response["sukses"] = TRUE;
			$response["pesan"] = "Item baru berhasil ditambahkan";
			echo json_encode($response);
		}
	}
}

?>