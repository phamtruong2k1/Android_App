package com.codernon2k1.note.zcongdong.tienich.monan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.ActivityMonAnBinding;
import com.codernon2k1.note.databinding.ActivityTaiMonAnBinding;
import com.codernon2k1.note.sup.data.Config;
import com.codernon2k1.note.sup.data.JsonVolley;
import com.codernon2k1.note.sup.utl.Monan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TaiMonAnActivity extends AppCompatActivity {

    ListView lv_show;
    List<Monan> list = new ArrayList<>();
    public static ActivityTaiMonAnBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTaiMonAnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RequestQueue requestQueue = Volley.newRequestQueue(TaiMonAnActivity.this);
        list = new ArrayList<>();
        GET_API();
    }

    private void GET_API() {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Config.url_tai_monan, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject1 = response.getJSONObject(i);
                                Integer monanId = jsonObject1.getInt("monanId");
                                String username = jsonObject1.getString("moanname");
                                String avt = jsonObject1.getString("avt");
                                String nguyenlieu = jsonObject1.getString("nguyenlieu");
                                String conthuc = jsonObject1.getString("congthuc");
                                String tien = jsonObject1.getString("tien");
                                list.add(new Monan(monanId,username,avt,nguyenlieu,conthuc,tien));
                            }
                            TaiMonAnAdapter adapter = new TaiMonAnAdapter(list);
                            binding.lvTaiMonan.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        JsonVolley.getInstance(getApplicationContext()).getRequestQueue().add(request);
    }


}