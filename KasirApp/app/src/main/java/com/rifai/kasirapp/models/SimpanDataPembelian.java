package com.rifai.kasirapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimpanDataPembelian {
    @SerializedName("id_produk")
    @Expose
    private Integer id_produk;
    @SerializedName("qty")
    @Expose
    private Integer qty;

    public SimpanDataPembelian() {
    }

    public SimpanDataPembelian(Integer id_produk, Integer qty) {
        this.id_produk = id_produk;
        this.qty = qty;
    }

    public Integer getId_produk() {
        return id_produk;
    }

    public void setId_produk(Integer id_produk) {
        this.id_produk = id_produk;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
