package com.example.phamtruong.haui.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.phamtruong.haui.weather.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    static ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Data.Create_provinces();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Data.provinces);

        binding.sql.setAdapter(adapter);

        binding.sql.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CallAPI(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void CallAPI(int pos){
        String tinh = StringUtils.Convert_String( Data.provinces.get(pos)) ;
        binding.name.setText(Data.provinces.get(pos));

        String url = Config.url_tt1+tinh+Config.url_tt2;
        RequestQueue requestQueue = Volley.newRequestQueue(binding.getRoot().getContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url , null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject main = response.getJSONObject("main");
                            Double nhietdo= main.getDouble("temp");
                            binding.nhietdo.setText(String.format("%.1f",nhietdo-273.0) +"\u00B0C");
                            JSONArray weather = response.getJSONArray("weather");
                            JSONObject okla = weather.getJSONObject(0);
                            String icon = okla.getString("icon");
                            Picasso.get().load("http://openweathermap.org/img/wn/"+icon+"@2x.png").into(binding.img);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }
}