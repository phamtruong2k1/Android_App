package com.codernon2k1.note.zcongdong.banbe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import com.codernon2k1.note.sup.data.Config;
import com.codernon2k1.note.sup.data.JsonVolley;
import com.codernon2k1.note.databinding.FragmentFriendBinding;

import com.codernon2k1.note.sup.utl.User;
import com.codernon2k1.note.zcongdong.support.Data_User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FriendFragment extends Fragment {

    public static FragmentFriendBinding binding;
    public static ArrayList<User> list ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFriendBinding.inflate(inflater, container, false);


        show();

        binding.tailai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        return binding.getRoot();
    }

    public static void show(){
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Config.url_acc, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            list = new ArrayList<>();
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject1 = response.getJSONObject(i);
                                int accId = jsonObject1.getInt("accId");
                                String account = jsonObject1.getString("account");
                                String name_in_app = jsonObject1.getString("name_in_app");
                                String avt = jsonObject1.getString("avt");
                                String gmail = jsonObject1.getString("gmail");
                                String isAct = jsonObject1.getString("isAct");
                                String sex = jsonObject1.getString("sex");
                                String quenquan = jsonObject1.getString("quenquan");
                                String honnhan = jsonObject1.getString("honnhan");
                                String sdt = jsonObject1.getString("sdt");
                                String status = jsonObject1.getString("status");
                                if (accId != Data_User.user.getId())
                                    list.add(new User(accId, account, "*****", name_in_app, avt, gmail, isAct, "", "", sex, quenquan, honnhan, sdt, status));

                            }

                            FriendAdapter adapter = new FriendAdapter(list);
                            binding.lv.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        JsonVolley.getInstance(binding.getRoot().getContext()).getRequestQueue().add(request);

    }


}