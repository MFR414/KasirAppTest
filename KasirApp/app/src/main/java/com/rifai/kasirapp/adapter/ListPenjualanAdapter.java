package com.rifai.kasirapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rifai.kasirapp.DetailPenjualanActivity;
import com.rifai.kasirapp.R;
import com.rifai.kasirapp.models.ListPenjualan;
import com.rifai.kasirapp.models.ListProduk;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListPenjualanAdapter extends RecyclerView.Adapter<ListPenjualanAdapter.listPenjualanViewholder> {

    private Context context;
    private List<ListPenjualan> listPenjualans;

    public ListPenjualanAdapter(Context context) {
        this.context = context;
    }

    public void setListPenjualans(List<ListPenjualan> listPenjualans){
        this.listPenjualans = listPenjualans;
        this.notifyDataSetChanged();
    }

    @Override
    public listPenjualanViewholder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_listpenjualan,viewGroup,false);
        listPenjualanViewholder vh = new ListPenjualanAdapter.listPenjualanViewholder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder( listPenjualanViewholder holder, int position) {
        ListPenjualan listPenjualan = listPenjualans.get(position);
        holder.tv_tgl.setText(listPenjualan.getTanggal());
        holder.tv_total.setText(listPenjualan.getHarga().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(v.getContext(), DetailPenjualanActivity.class);
                detail.putExtra("idListPenjualan",String.valueOf(listPenjualan.getId()));
                v.getContext().startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() { return (listPenjualans != null ) ? listPenjualans.size() : 0; }

    public class listPenjualanViewholder extends RecyclerView.ViewHolder {
        TextView tv_tgl,tv_total;
        public listPenjualanViewholder(@NonNull View itemView) {
            super(itemView);
            tv_tgl = itemView.findViewById(R.id.tv_tglPenjualan);
            tv_total = itemView.findViewById(R.id.tv_hargaPenjualan);
        }
    }
}
