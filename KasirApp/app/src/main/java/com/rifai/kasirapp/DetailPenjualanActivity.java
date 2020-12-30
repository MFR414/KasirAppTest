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
import android.widget.TextView;
import android.widget.Toast;

import com.rifai.kasirapp.API.APIClient;
import com.rifai.kasirapp.API.APIInterfaces;
import com.rifai.kasirapp.adapter.DetailPenjualanAdapter;
import com.rifai.kasirapp.adapter.ListPenjualanAdapter;
import com.rifai.kasirapp.models.DetailPenjualan;
import com.rifai.kasirapp.models.ListPenjualan;

import java.util.List;

public class DetailPenjualanActivity extends AppCompatActivity {
    private static String xKey = "bd0b3ae6651538fac2515baafc9326c5";
    RecyclerView RecyclerDetailPenjualan;
    int id;
    int totalPenjualan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //make activity fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        //Hide the action bar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_detail_penjualan);

        RecyclerDetailPenjualan = findViewById(R.id.rv_detailPenjualan);
        DetailPenjualanAdapter adapter = new DetailPenjualanAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerDetailPenjualan.setLayoutManager(layoutManager);
        RecyclerDetailPenjualan.setAdapter(adapter);
        TextView tv_totalPenjualan = findViewById(R.id.tv_totalpenjualan);

        id = Integer.parseInt(getIntent().getStringExtra("idListPenjualan"));;
        APIInterfaces apiService = APIClient.getClient().create(APIInterfaces.class);
        Call<List<DetailPenjualan>> call = apiService.getDetailPenjualan(xKey,id);
        call.enqueue(new Callback<List<DetailPenjualan>>() {
            @Override
            public void onResponse(Call<List<DetailPenjualan>> call, Response<List<DetailPenjualan>> response) {
                List<DetailPenjualan> detailPenjualans = response.body();
                adapter.setDetailPenjualans(detailPenjualans);
                for(int i=0;i<detailPenjualans.size();i++){
                    totalPenjualan = totalPenjualan + (detailPenjualans.get(i).getHarga()*detailPenjualans.get(i).getQty());
                }
                tv_totalPenjualan.setText(String.valueOf(totalPenjualan));
            }

            @Override
            public void onFailure(Call<List<DetailPenjualan>> call, Throwable t) {
                Log.e("error",t.getMessage());
                Toast.makeText(DetailPenjualanActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}