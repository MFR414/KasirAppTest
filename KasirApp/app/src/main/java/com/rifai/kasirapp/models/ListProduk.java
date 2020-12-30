package com.rifai.kasirapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListProduk {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("harga")
    @Expose
    private Integer harga;
    private List<ListProduk> listProduk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public List<ListProduk> getListProduk() {return listProduk;}
}
