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

import com.rifai.kasirapp.adapter.ListProdukAdapter;
import com.rifai.kasirapp.API.APIClient;
import com.rifai.kasirapp.models.ListProduk;
import com.rifai.kasirapp.API.APIInterfaces;

import java.util.List;

public class ListProdukActivity extends AppCompatActivity {

    private RecyclerView RecylerListProduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //make activity fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        //Hide the action bar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_list_produk);

        RecylerListProduk = findViewById(R.id.rv_listProduk);
        ListProdukAdapter listProdukAdapter = new ListProdukAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecylerListProduk.setLayoutManager(layoutManager);
        RecylerListProduk.setAdapter(listProdukAdapter);

        APIInterfaces apiService = APIClient.getClient().create(APIInterfaces.class);
        Call<List<ListProduk>> call = apiService.getListProduk();
        call.enqueue(new Callback<List<ListProduk>>() {
            @Override
            public void onResponse(Call<List<ListProduk>> call, Response<List<ListProduk>> response) {
                List<ListProduk> listProduks = response.body();
                listProdukAdapter.setListProduks(listProduks);
            }

            @Override
            public void onFailure(Call<List<ListProduk>> call, Throwable t) {
                Log.e("error",t.getMessage());
                Toast.makeText(ListProdukActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}