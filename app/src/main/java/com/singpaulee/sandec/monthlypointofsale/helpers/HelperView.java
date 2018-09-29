package com.singpaulee.sandec.monthlypointofsale.helpers;

public interface HelperView {
    interface View{
        int ADDITEM = 1;

        //TODO Tambahkan kode view untuk alur tambah item
        int SCANADDITEM = 41;
        int FORMADDITEM = 42;
    }

    interface Gift{
        String VIEW = "VIEW";
        String IDITEM = "IDITEM";
    }
}
