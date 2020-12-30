package com.rifai.kasirapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rifai.kasirapp.API.APIClient;
import com.rifai.kasirapp.API.APIInterfaces;
//import com.rifai.kasirapp.KeranjangSQLITE.KeranjangDBHelper;
import com.rifai.kasirapp.adapter.KeranjangAdapter;
import com.rifai.kasirapp.KeranjangSQLITE.KeranjangBelanja;
import com.rifai.kasirapp.models.SimpanDataPembelian;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class KeranjangActivity extends AppCompatActivity {
    private static String xKey = "bd0b3ae6651538fac2515baafc9326c5";
    TextView tv_totalBelanja;
    RecyclerView recyclerKeranjang;
    int totalBelanja;
//    private KeranjangDBHelper db;
    List<KeranjangBelanja> keranjangList = new ArrayList<KeranjangBelanja>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);

        recyclerKeranjang = findViewById(R.id.rv_keranjangBelanja);
        KeranjangAdapter adapter = new KeranjangAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerKeranjang.setLayoutManager(layoutManager);
        recyclerKeranjang.setAdapter(adapter);
        tv_totalBelanja = findViewById(R.id.totalBelanja);

        totalBelanja=0;

//        db = new KeranjangDBHelper(this);
//        keranjangList.addAll(db.getAllKeranjangBelanja());
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = sharedPrefs.getString("tambahKeranjang", "");
        Type type = new TypeToken<List<KeranjangBelanja>>() {}.getType();
        List<KeranjangBelanja> keranjangListFromTambahKeranjang = gson.fromJson(json, type);
        keranjangList.addAll(keranjangListFromTambahKeranjang);

        if (keranjangList != null){
            for(int i=0;i<keranjangList.size();i++){
                totalBelanja = totalBelanja+(keranjangList.get(i).getHarga()*keranjangList.get(i).getJumlah());
            }
        }else{
            Toast.makeText(this, "Keranjang Belanjaan Kosong", Toast.LENGTH_SHORT).show();
        }
        adapter.setKeranjangBelanjas(keranjangList);
        tv_totalBelanja.setText(String.valueOf(totalBelanja));

    }

    public void simpanPembelian(View view) {
        for(int i=0;i<keranjangList.size();i++){
            SimpanDataPembelian simpanDataPembelian = new SimpanDataPembelian(keranjangList.get(i).getId_produk(),keranjangList.get(i).getJumlah());
            APIInterfaces apiInterfaces = APIClient.getClient().create(APIInterfaces.class);
            Call<Integer> call = apiInterfaces.sendDataPembelian(xKey,simpanDataPembelian);
            call.enqueue(new Callback<Integer>() {
                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    Toast.makeText(KeranjangActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Integer> call, Throwable t) {
                    Toast.makeText(KeranjangActivity.this, "Data Gagal Disimpan ", Toast.LENGTH_SHORT).show();
                }
            });
        }
//        APIInterfaces apiInterfaces = APIClient.getClient().create(APIInterfaces.class);
//        Call<Integer> call = apiInterfaces.sendDataPembelian(xKey,);
//        call.enqueue(new Callback<Integer>() {
//            @Override
//            public void onResponse(Call<Integer> call, Response<Integer> response) {
//                Toast.makeText(KeranjangActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<Integer> call, Throwable t) {
//                Toast.makeText(KeranjangActivity.this, "Data Gagal Disimpan ", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}