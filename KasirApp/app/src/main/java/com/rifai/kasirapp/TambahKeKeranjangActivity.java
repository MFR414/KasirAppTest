package com.rifai.kasirapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rifai.kasirapp.KeranjangSQLITE.KeranjangBelanja;
//import com.rifai.kasirapp.KeranjangSQLITE.KeranjangDBHelper;

import java.util.ArrayList;
import java.util.List;

public class TambahKeKeranjangActivity extends AppCompatActivity {
    TextView tv_namaBrg,tv_hargaBrg,edt_jmlhBarang;
    int id_produk,harga_produk,inputJmlhProduk;
    String nama_produk;
//    private KeranjangDBHelper db;
    List<KeranjangBelanja> keranjangList = new ArrayList<KeranjangBelanja>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //make activity fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        //Hide the action bar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_tambah_ke_keranjang);
        tv_namaBrg = findViewById(R.id.tv_namabrgAddCart);
        tv_hargaBrg = findViewById(R.id.tv_hargabrgAddCart);
        edt_jmlhBarang = findViewById(R.id.tv_jumlahbrgAddCart);

        id_produk = Integer.parseInt(getIntent().getStringExtra("idProduk"));
        harga_produk = Integer.parseInt(getIntent().getStringExtra("hargaProduk"));
        nama_produk = getIntent().getStringExtra("namaProduk");

        tv_namaBrg.setText(nama_produk);
        tv_hargaBrg.setText(String.valueOf(harga_produk));
        //set DBHelper
//        db = new KeranjangDBHelper(this);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
    public void tambahBelanjaan(View view) {
        if(String.valueOf(inputJmlhProduk).isEmpty()){
            Toast.makeText(this, "Jumlah barang tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else if(!validateNumber(String.valueOf(edt_jmlhBarang.getText()))){
            Toast.makeText(this, "Jumlah barang harus berupa angka", Toast.LENGTH_SHORT).show();
        }else{
            inputJmlhProduk = Integer.parseInt(String.valueOf(edt_jmlhBarang.getText()));
//            db.insertKeranjangBelanja(nama_produk,inputJmlhProduk,harga_produk,id_produk);
//            Toast.makeText(this, "Barang berhasil ditambahkan ke keranjang", Toast.LENGTH_SHORT).show();
        }

        KeranjangBelanja keranjangBelanja = new KeranjangBelanja(nama_produk,id_produk,harga_produk,inputJmlhProduk);
        keranjangList.add(keranjangBelanja);
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(keranjangList);
        editor.putString("tambahKeranjang", json);
        editor.commit();
        Toast.makeText(this, "Produk telah dimasukkan kedalam keranjang", Toast.LENGTH_SHORT).show();
    }

    private boolean validateNumber(String valueOf) {
        try {
            Double.parseDouble(valueOf);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public void keKeranjang(View view) {
        Intent keranjang = new Intent(this, KeranjangActivity.class);
        this.startActivity(keranjang);
    }
}