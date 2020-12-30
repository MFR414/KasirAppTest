package com.rifai.kasirapp.KeranjangSQLITE;

public class KeranjangBelanja {
//    public static final String TABLE_NAME = "keranjangBelanja";
//    public static final String COLUMN_ID = "id";
//    public static final String COLUMN_IDPRODUK = "id_produk";
//    public static final String COLUMN_NAMAPRODUK = "nama_produk";
//    public static final String COLUMN_HARGA = "harga";
//    public static final String COLUMN_JUMLAH = "jumlah";
//
//    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
//            + COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
//            + COLUMN_NAMAPRODUK + " TEXT,"
//            + COLUMN_HARGA + " INTEGER,"
//            + COLUMN_JUMLAH +" INTEGER"
//            + ")";


    String nama;
    int id_produk,harga,jumlah;

    public KeranjangBelanja() {
    }

    public KeranjangBelanja(String nama, int id_produk, int harga, int jumlah) {
//        this.id = id;
        this.nama = nama;
        this.id_produk = id_produk;
        this.harga = harga;
        this.jumlah = jumlah;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
