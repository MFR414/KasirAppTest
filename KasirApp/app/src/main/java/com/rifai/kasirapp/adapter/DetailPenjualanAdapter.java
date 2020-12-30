package com.rifai.kasirapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rifai.kasirapp.R;
import com.rifai.kasirapp.models.DetailPenjualan;
import com.rifai.kasirapp.models.ListPenjualan;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DetailPenjualanAdapter extends RecyclerView.Adapter<DetailPenjualanAdapter.detailPenjualanViewholder> {
    private Context context;
    private List<DetailPenjualan> detailPenjualans;

    public DetailPenjualanAdapter(Context context) {
        this.context = context;
    }

    public void setDetailPenjualans(List<DetailPenjualan> detailPenjualans){
        this.detailPenjualans = detailPenjualans;
        this.notifyDataSetChanged();
    }

    @Override
    public detailPenjualanViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_detailpenjualan,viewGroup,false);
        detailPenjualanViewholder vh = new detailPenjualanViewholder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull detailPenjualanViewholder holder, int position) {
        DetailPenjualan detailPenjualan = detailPenjualans.get(position);
        holder.tv_namabrg.setText(detailPenjualan.getNama());
        holder.tv_jumlahbrg.setText(detailPenjualan.getQty().toString());
        holder.tv_totalHarga.setText(detailPenjualan.getHarga().toString());
    }

    @Override
    public int getItemCount() { return (detailPenjualans != null ) ? detailPenjualans.size() : 0; }

    public class detailPenjualanViewholder extends RecyclerView.ViewHolder {
        TextView tv_namabrg,tv_jumlahbrg,tv_totalHarga;
        public detailPenjualanViewholder(@NonNull View itemView) {
            super(itemView);
            tv_namabrg = itemView.findViewById(R.id.tv_namabrgdetail);
            tv_jumlahbrg = itemView.findViewById(R.id.tv_jmlhbrgdetail);
            tv_totalHarga = itemView.findViewById(R.id.tv_totalhargadetail);
        }
    }
}
