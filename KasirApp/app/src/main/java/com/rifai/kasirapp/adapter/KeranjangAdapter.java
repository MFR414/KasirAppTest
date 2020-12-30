package com.rifai.kasirapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rifai.kasirapp.R;
import com.rifai.kasirapp.KeranjangSQLITE.KeranjangBelanja;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class KeranjangAdapter extends RecyclerView.Adapter<KeranjangAdapter.keranjangViewholder>{

    private Context context;
    private List<KeranjangBelanja> keranjangBelanjas;

    public KeranjangAdapter(Context context) {
        this.context = context;
    }

    public void setKeranjangBelanjas(List<KeranjangBelanja> keranjangBelanjas){
        this.keranjangBelanjas = keranjangBelanjas;
        this.notifyDataSetChanged();
    }

    @Override
    public keranjangViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_keranjang,viewGroup,false);
        keranjangViewholder vh = new keranjangViewholder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull keranjangViewholder holder, int position) {
        KeranjangBelanja keranjangBelanja = keranjangBelanjas.get(position);
        holder.tv_namaBarang.setText(keranjangBelanja.getNama());
        holder.tv_hargaBarang.setText(String.valueOf(keranjangBelanja.getHarga()));
        holder.tv_jumlahBarang.setText(String.valueOf(keranjangBelanja.getJumlah()));
    }

    @Override
    public int getItemCount() { return (keranjangBelanjas != null ) ? keranjangBelanjas.size() : 0; }

    public class keranjangViewholder extends RecyclerView.ViewHolder {
        TextView tv_namaBarang,tv_hargaBarang,tv_jumlahBarang;
        public keranjangViewholder(@NonNull View itemView) {
            super(itemView);
            tv_namaBarang=itemView.findViewById(R.id.tv_namaProdukKeranjang);
            tv_hargaBarang=itemView.findViewById(R.id.tv_hargaProdukKeranjang);
            tv_jumlahBarang=itemView.findViewById(R.id.tv_jumlahProdukKeranjang);
        }
    }
}
