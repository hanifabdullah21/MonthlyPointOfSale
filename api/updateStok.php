<?php

include('connection.php');
header('Content-Type: application/json');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	$idItem = $_POST["id"];
	// $namaItem = $_POST["nama"];
	// $hargaItem = $_POST["harga"];
	$stokBaru = $_POST["stok"];

	$query = "SELECT stok FROM items WHERE id='$idItem'";
 	$exeQuery = mysqli_query($konek, $query);
	$qResult = mysqli_fetch_assoc($exeQuery);
	$stokItem = $qResult["stok"];

	$stokTotal = $stokBaru + $stokItem;
	$uItem = "UPDATE items SET stok='$stokTotal' WHERE id='$idItem'";
	$eItem = mysqli_query($konek, $uItem);

	if ($eItem) {
		$result["sukses"] = true;
		$result["pesan"] = "Stok Item berhasil diupdate";
	}else {
		$result["sukses"] = false;
		$result["pesan"] = "Stok Item gagal diupdate";
	}

	echo json_encode($result);
}

?>