package com.rifai.kasirapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListPenjualan {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("harga")
    @Expose
    private Integer harga;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("created_by")
    @Expose
    private Integer createdBy;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("updated_by")
    @Expose
    private Object updatedBy;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("deleted_by")
    @Expose
    private Object deletedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Object getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Object deletedBy) {
        this.deletedBy = deletedBy;
    }
}
