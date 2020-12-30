package com.rifai.kasirapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.rifai.kasirapp.API.APIClient;
import com.rifai.kasirapp.API.APIInterfaces;
import com.rifai.kasirapp.adapter.ListPenjualanAdapter;
import com.rifai.kasirapp.adapter.ListProdukAdapter;
import com.rifai.kasirapp.models.ListPenjualan;
import com.rifai.kasirapp.models.ListProduk;

import java.util.List;

public class ListPenjualanActivity extends AppCompatActivity {
    private static String xKey = "bd0b3ae6651538fac2515baafc9326c5";
    private RecyclerView RecylerListProduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //make activity fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        //Hide the action bar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_list_penjualan);

        RecylerListProduk = findViewById(R.id.rv_listPenjualan);
        ListPenjualanAdapter adapter = new ListPenjualanAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecylerListProduk.setLayoutManager(layoutManager);
        RecylerListProduk.setAdapter(adapter);

        APIInterfaces apiService = APIClient.getClient().create(APIInterfaces.class);
        Call<List<ListPenjualan>> call = apiService.getListPenjualan(xKey);
        call.enqueue(new Callback<List<ListPenjualan>>() {
            @Override
            public void onResponse(Call<List<ListPenjualan>> call, Response<List<ListPenjualan>> response) {
                List<ListPenjualan> listPenjualans = response.body();
                adapter.setListPenjualans(listPenjualans);
            }

            @Override
            public void onFailure(Call<List<ListPenjualan>> call, Throwable t) {
                Log.e("error",t.getMessage());
                Toast.makeText(ListPenjualanActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}