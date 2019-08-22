package com.web.gigih.menu_utama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CardView cvjadwalsholat;
    private CardView cvprodukhalal;
    private CardView cvsurat;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("JADWAL SHOLAT DAERAH");
        {
            cvjadwalsholat = findViewById(R.id.jadwal_sholat);
            cvjadwalsholat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent ijadwalsholat = new Intent(MainActivity.this, AppSholat.class);
                    startActivity(ijadwalsholat);
                }
            });
            cvprodukhalal = findViewById(R.id.produk_halal);
            cvprodukhalal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent iproduk_halal = new Intent(MainActivity.this, HalalApp.class);
                    startActivity(iproduk_halal);
                }
            });
            cvsurat = findViewById(R.id.doa_doa);
            cvsurat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent iSuratPilihan = new Intent(MainActivity.this, SuratPilihan.class);
                    startActivity(iSuratPilihan);
                }
            });
        }
    }
}