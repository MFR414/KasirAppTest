package com.rifai.kasirapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rifai.kasirapp.DetailPenjualanActivity;
import com.rifai.kasirapp.ListProdukActivity;
import com.rifai.kasirapp.R;
import com.rifai.kasirapp.TambahKeKeranjangActivity;
import com.rifai.kasirapp.models.ListProduk;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListProdukAdapter extends RecyclerView.Adapter<ListProdukAdapter.ViewHolder> {

    private Context context;
    private List<ListProduk> listProduks;

    public ListProdukAdapter(Context context) {
        this.context = context;
    }

    public void setListProduks(List<ListProduk> listProduks) {
        this.listProduks = listProduks;
        this.notifyDataSetChanged();
    }

    @Override
    public ListProdukAdapter.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_listproduk,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListProdukAdapter.ViewHolder holder, int position) {
        ListProduk listProduk = listProduks.get(position);
        holder.tv_nama.setText(listProduk.getNama());
        holder.tv_harga.setText(listProduk.getHarga().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tmbhKeKeranjang = new Intent(v.getContext(), TambahKeKeranjangActivity.class);
                tmbhKeKeranjang.putExtra("idProduk",String.valueOf(listProduk.getId()));
                tmbhKeKeranjang.putExtra("namaProduk",String.valueOf(listProduk.getNama()));
                tmbhKeKeranjang.putExtra("hargaProduk",String.valueOf(listProduk.getHarga()));
                v.getContext().startActivity(tmbhKeKeranjang);
            }
        });
    }

    @Override
    public int getItemCount() { return ( listProduks != null)? listProduks.size() : 0; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama,tv_harga;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_namaProduk);
            tv_harga = itemView.findViewById(R.id.tv_hargaProduk);
        }
    }
}
