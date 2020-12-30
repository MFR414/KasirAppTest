package com.rifai.kasirapp.API;

import com.rifai.kasirapp.models.DetailPenjualan;
import com.rifai.kasirapp.models.ListPenjualan;
import com.rifai.kasirapp.models.ListProduk;
import com.rifai.kasirapp.models.SimpanDataPembelian;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterfaces {
    @GET("api/produk")
    Call<List<ListProduk>> getListProduk() ;
    @GET("api/penjualan")
    Call<List<ListPenjualan>> getListPenjualan(@Header("x-key") String xKey);
    @GET("api/penjualan/detail")
    Call<List<DetailPenjualan>> getDetailPenjualan(@Header("x-key") String xKey, @Query("id") int id);
    @POST("api/penjualan/save")
    Call<Integer> sendDataPembelian(@Header("x-key") String xKey,@Body SimpanDataPembelian simpanDataPembelian);
 }
