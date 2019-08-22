package com.web.gigih.menu_utama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SuratPilihan extends AppCompatActivity {
    private ArrayList<Surat> listsurat;
    private ListSuratAdapter mSuratAdapter;
    private TextView tv_ayat;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat_pilihan);
        tv_ayat = (TextView) findViewById(R.id.tv_ayat);
        setTitle("Doa-Doa Harian");

        recyclerView = (RecyclerView) findViewById(R.id.rcv_ayat_pilihan);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar_ayat);

        loadData();

        listsurat = new ArrayList<Surat>();
        mSuratAdapter = new ListSuratAdapter(this,listsurat);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, mLayoutManager.getOrientation()));
        recyclerView.setAdapter(mSuratAdapter);
    }
    private void loadData (){
        try {
            String url_api= "/surat";
            ClientAsyncTask3 task = new ClientAsyncTask3(this,url_api, new
                    ClientAsyncTask3.OnPostExecuteListener() {
                        @Override
                        public void onPostExecute(String result) {
                            Log.d("SuratData", result);
                            try {
                                JSONObject jsonObj = new JSONObject(result);
                                JSONArray jsonArray = jsonObj.getJSONArray("hasil");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject obj = jsonArray.getJSONObject(i);
                                    Surat surat = new Surat();
                                    surat.nomor = obj.getInt("nomor");
                                    surat.nama = obj.getString("nama");
                                    surat.asma = obj.getString("asma");
                                    surat.ayat = obj.getInt("ayat");
                                    surat.type = obj.getString("type");
                                    surat.arti = obj.getString("arti");
                                    listsurat.add(surat);
                                }
                                mSuratAdapter.notifyDataSetChanged();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
            task.setmProgress(this.progressBar);
            task.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
