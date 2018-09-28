<?php

include('connection.php');
header('Content-Type: application/json');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	$idItem = $_POST["id"];
	$namaItem = $_POST["nama"];
	$hargaItem = $_POST["harga"];

	$uItem = "UPDATE items SET nama='$namaItem',harga='$hargaItem' WHERE id='$idItem'";
	$eItem = mysqli_query($konek, $uItem);

	if ($eItem) {
		$result["sukses"] = true;
		$result["pesan"] = "Item berhasil diupdate";
	}else {
		$result["sukses"] = false;
		$result["pesan"] = "Item gagal diupdate";
	}

	echo json_encode($result);
}

?>