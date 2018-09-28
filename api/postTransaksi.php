<?php

include('connection.php');
header('Content-Type: application/json');

function randomId()
{
	$random = rand(pow(10, 4), pow(10, 6)-1);
	return $random;
}

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	// $jsonArray = 
	// '[{"harga_jual":"1000","harga_kulak":"500","id_agent":"3","id":"5","id_merk":"2","id_supplier":"1","isi":"10","jumlah":"50","kuantitas":5,"nama":"Nuget","subtotal":6500,"update_at":"2018-09-04 01:06:50"}]';
	// $jsonArray = '[{"id":"899","nama":"Teh Kotak Jasmine","harga":"3600","jumlah":"5"}]';
	$jsonArray = $_POST["array"];
	$idUser = $_POST["idUser"];
	$total = $_POST["total"];
	$created_at = $_POST["tanggal"];

	$hasil = randomId();
	$idTransaksi = "T-$hasil";
	$qInsertT = "INSERT INTO transaksi (id_transaksi, id_user, total, tanggal) VALUES ('$idTransaksi','$idUser','$total','$created_at')";
	$eQInsertT = mysqli_query($konek, $qInsertT);

	$array = json_decode($jsonArray,true);
	foreach ($array as $key => $value) {
		$idItem = $value["id"];
		$harga = $value["harga"];
		$nama = $value["nama"];
		$kuantitas = $value["jumlah"];

		$qInsert = "INSERT INTO d_transaksi (id_transaksi, id_item, nama, harga, jumlah) VALUES ('$idTransaksi','$idItem','$harga','$nama','$kuantitas')";
		$eQInsert = mysqli_query($konek, $qInsert);

		$qSelectStock = "SELECT stok FROM items WHERE id='$idItem'";
		$eQSelectStock = mysqli_query($konek, $qSelectStock);
		$jumlah = mysqli_fetch_assoc($eQSelectStock)["stok"];;

		$stok = $jumlah - $kuantitas;
		$qUpdateStock = "UPDATE items SET stok='$stok' WHERE id='$idItem'";
		$eQUpdate = mysqli_query($konek, $qUpdateStock);
	}

	$result["sukses"]=true;
	$result["pesan"]="Pesanan Berhasil";
	echo json_encode($result);
}

?>