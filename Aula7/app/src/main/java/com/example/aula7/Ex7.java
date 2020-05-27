package com.example.aula7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class Ex7 extends AppCompatActivity {

    private TextView txtTemperatura;
    private TextView txtUmidade;
    private TextView txtPressao;
    private TextView txtOrvalho;
    private ListView listView;
    String de []={"Temp","Umid","Orv","Press"};
    int para [] ={R.id.txtTemp,R.id.txtUmid,R.id.txtOrv,R.id.txtPress};
    List<Map<String,String>> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex7);

        txtTemperatura = (TextView) findViewById(R.id.txtTemperatura);
        txtUmidade = (TextView) findViewById(R.id.txtUmidade);
        txtOrvalho = (TextView) findViewById(R.id.txtOrvalho);
        txtPressao= (TextView) findViewById(R.id.txtPressao);
        listView = findViewById(R.id.listView);

    }

    public void onClickBuscar(View view) {
        lista = new ArrayList<>();
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://ghelfer.net/la/weather.json", new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
            String data = new String(response);
            //Toast.makeText(getApplicationContext(),data,Toast.LENGTH_SHORT).show();
                try {
                    loadData(data);
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void loadData(String data) throws JSONException {
        double SumTemp =0;
        double SumUmid =0;
        double SumOrv=0;
        double SumPress =0;

        JSONObject res = new JSONObject(data);
        JSONArray array = res.getJSONArray("weather");



        for (int i = 0; i < array.length(); i++) {
            JSONObject json = array.getJSONObject(i);
            String temp = json.get("temperature").toString();
            SumTemp += Double.parseDouble(temp);
            String umid = json.get("humidity").toString();
            SumUmid += Double.parseDouble(umid);
            String po = json.get("dewpoint").toString();
            SumOrv += Double.parseDouble(po);
            String press = json.get("pressure").toString();
            SumPress += Double.parseDouble(press);

            Map<String,String> mapa = new HashMap<>();
            mapa.put("Temp", temp);
            mapa.put("Umid", umid);
            mapa.put("Orv", po);
            mapa.put("Press",press);
            lista.add(mapa);

        }
        txtTemperatura.setText(String.valueOf(SumTemp/array.length()));
        txtUmidade.setText(String.valueOf(SumUmid/array.length()));
        txtPressao.setText(String.valueOf(SumPress/array.length()));
        txtOrvalho.setText(String.valueOf(SumOrv/array.length()));

        SimpleAdapter adapter = new SimpleAdapter(this,lista,R.layout.linha_tempo,de,para);
        listView.setAdapter(adapter);


    }
}
