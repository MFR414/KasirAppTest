//package com.rifai.kasirapp.KeranjangSQLITE;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import androidx.annotation.Nullable;
//
//public class KeranjangDBHelper extends SQLiteOpenHelper {
//    //init static variable for DB_NAME AND DB_VER
//    public static final String DB_NAME = "KeranjangBelanjaDB";
//    private static final int DB_VER = 1;
//
//    public KeranjangDBHelper(Context context) {
//        super(context, DB_NAME, null, DB_VER);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(KeranjangBelanja.CREATE_TABLE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        //drop older Table
//        db.execSQL("DROP TABLE IF EXISTS " + KeranjangBelanja.TABLE_NAME);
//        //create table again
//        onCreate(db);
//    }
//
//    //Inserting Produk to Database
//    public void insertKeranjangBelanja(String insertNamaProduk,int insertJmlhBrg,int insertHarga, int insertIDProduk){
//        // get writable database as we want to write data
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        // `id` will be inserted automatically.
//        // no need to add them
//        values.put(KeranjangBelanja.COLUMN_NAMAPRODUK, insertNamaProduk);
//        values.put(KeranjangBelanja.COLUMN_IDPRODUK, insertIDProduk);
//        values.put(KeranjangBelanja.COLUMN_HARGA, insertHarga);
//        values.put(KeranjangBelanja.COLUMN_JUMLAH, insertJmlhBrg);
//
//        // insert row
//        db.insert(KeranjangBelanja.TABLE_NAME, null, values);
//
//        // close db connection
//        db.close();
//
//    }
//
//    //Get All Task from database
//    public List<KeranjangBelanja> getAllKeranjangBelanja() {
//        List<KeranjangBelanja> allKeranjangBelanja = new ArrayList<>();
//
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + KeranjangBelanja.TABLE_NAME;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                KeranjangBelanja produkKeranjang = new KeranjangBelanja();
//                produkKeranjang.setId(cursor.getInt(cursor.getColumnIndex(KeranjangBelanja.COLUMN_ID)));
//                produkKeranjang.setId_produk(cursor.getInt(cursor.getColumnIndex(KeranjangBelanja.COLUMN_IDPRODUK)));
//                produkKeranjang.setNama(cursor.getString(cursor.getColumnIndex(KeranjangBelanja.COLUMN_NAMAPRODUK)));
//                produkKeranjang.setJumlah(cursor.getInt(cursor.getColumnIndex(KeranjangBelanja.COLUMN_JUMLAH)));
//                produkKeranjang.setHarga(cursor.getInt(cursor.getColumnIndex(KeranjangBelanja.COLUMN_HARGA)));
//                allKeranjangBelanja.add(produkKeranjang);
//            } while (cursor.moveToNext());
//        }
//
//        // close db connection
//        db.close();
//
//        // return notes list
//        return allKeranjangBelanja;
//    }
//
//    //Delete task from database
//    public void deleteKeranjangBelanja(int id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(KeranjangBelanja.TABLE_NAME, KeranjangBelanja.COLUMN_ID + " = ?",
//                new String[]{String.valueOf(id)});
//        db.close();
//    }
//}
