package com.web.gigih.menu_utama;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListSuratAdapter extends RecyclerView.Adapter<ListSuratAdapter.SuratHolder> {private ArrayList<Surat> listSurat;
    private Context context;

    public ListSuratAdapter(Context context, ArrayList<Surat> listSurat) {
        this.context = context;
        this.listSurat = listSurat;
    }

    @NonNull
    @Override
    public SuratHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater =
                LayoutInflater.from(parent.getContext());
        return new SuratHolder(inflater.inflate(R.layout.item_ayat_pilihan, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ListSuratAdapter.SuratHolder suratHolder, int position) {
        Surat surat = listSurat.get(position);

        String ayat;
        suratHolder.tvnama.setText(surat.getNama());
        suratHolder.tvasma.setText(surat.getAsma());
        ayat = Integer.toString(surat.getAyat());
        suratHolder.tvayat.setText(ayat);
        suratHolder.tvtype.setText(surat.getType());
        suratHolder.tvarti.setText(surat.getArti());
    }

    @Override
    public int getItemCount() {
        return listSurat.size();
    }

    public class SuratHolder extends RecyclerView.ViewHolder {
        TextView tvnama,tvasma,tvayat,tvtype,tvarti;


        public SuratHolder(@NonNull View itemView) {
            super(itemView);

            tvnama = itemView.findViewById(R.id.tv_nama_surat);
            tvasma = itemView.findViewById(R.id.tv_asma);
            tvtype = itemView.findViewById(R.id.tv_type);
            tvayat = itemView.findViewById(R.id.tv_ayat);
            tvarti = itemView.findViewById(R.id.tv_arti);
        }
    }
}

