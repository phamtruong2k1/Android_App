package com.codernon2k1.note.zcongdong.tienich.truyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.ActivitySachBinding;
import com.codernon2k1.note.databinding.ActivityTaiMonAnBinding;
import com.codernon2k1.note.databinding.ActivityTaiTruyenBinding;
import com.codernon2k1.note.sup.data.Config;
import com.codernon2k1.note.sup.data.JsonVolley;
import com.codernon2k1.note.sup.utl.Truyen;
import com.codernon2k1.note.zcongdong.tienich.monan.TaiMonAnActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TaiTruyenActivity extends AppCompatActivity {

    List<Truyen> list = new ArrayList<>();
    public static ActivityTaiTruyenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTaiTruyenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RequestQueue requestQueue = Volley.newRequestQueue(TaiTruyenActivity.this);
        list = new ArrayList<>();
        GET_API();
    }

    private void GET_API() {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Config.url_tai_truyen, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = response.length() -1; i >=0 ; i--) {
                                JSONObject jsonObject1 = response.getJSONObject(i);
                                Integer truyenId = jsonObject1.getInt("truyenId");
                                String username = jsonObject1.getString("truyenname");
                                String nguyenlieu = jsonObject1.getString("theloai");
                                String conthuc = jsonObject1.getString("tacgia");
                                String tien = jsonObject1.getString("noidung");
                                list.add(new Truyen(truyenId,username,nguyenlieu,conthuc,tien));
                            }
                            TaiTruyenAdapter adapter = new TaiTruyenAdapter(list);
                            binding.lvTaiTruyen.setAdapter(adapter);
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