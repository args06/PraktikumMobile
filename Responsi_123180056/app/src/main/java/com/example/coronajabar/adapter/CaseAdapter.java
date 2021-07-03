package com.example.coronajabar.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronajabar.R;
import com.example.coronajabar.model.kasus.ContentItem;

import java.util.List;

public class CaseAdapter extends RecyclerView.Adapter<CaseAdapter.ViewHolder>{

    List<ContentItem> item;

    public CaseAdapter(List<ContentItem> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_case, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CaseAdapter.ViewHolder holder, int position) {
        holder.bind(item.get(position));
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggal, tvSembuh, tvMeninggal, tvTerkonfirmasi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvSembuh = itemView.findViewById(R.id.tv_sembuh);
            tvMeninggal = itemView.findViewById(R.id.tv_meninggal);
            tvTerkonfirmasi = itemView.findViewById(R.id.tv_terkonfirmasi);
        }

        @SuppressLint("SetTextI18n")
        void bind(ContentItem item){
            tvTanggal.setText(item.getTanggal());
            tvSembuh.setText(item.getConfirmationSelesai() + " Kasus");
            tvMeninggal.setText(item.getConfirmationMeninggal() + " Kasus");
            tvTerkonfirmasi.setText(item.getConfirmationDiisolasi() + " Kasus");
        }
    }
}
