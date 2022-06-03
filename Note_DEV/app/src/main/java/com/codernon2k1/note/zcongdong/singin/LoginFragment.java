package com.codernon2k1.note.zcongdong.singin;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.codernon2k1.note.R;
import com.codernon2k1.note.sup.data.Config;
import com.codernon2k1.note.sup.data.Data_Off;
import com.codernon2k1.note.sup.data.JsonVolley;
import com.codernon2k1.note.databinding.FragmentLoginBinding;

import com.codernon2k1.note.sup.utl.User;
import com.codernon2k1.note.zcongdong.CongDongActivity;
import com.codernon2k1.note.zcongdong.support.Data_User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

public class LoginFragment extends Fragment {

    public static FragmentLoginBinding binding;
    public  static SharedPreferences sharedPreferences_user;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        sharedPreferences_user = binding.getRoot().getContext().getApplicationContext().getSharedPreferences("thongtin_user",MODE_PRIVATE);

        dangnhap_cont();

        binding.dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk= binding.taikhoan.getText().toString();
                String mk = binding.matkhau.getText().toString();
                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Config.url_acc, null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                try {
                                    for (int i = 0; i < response.length(); i++) {
                                        JSONObject jsonObject1 = response.getJSONObject(i);

                                        String account = jsonObject1.getString("account");
                                        String password = jsonObject1.getString("password");
                                        System.out.println(i + " " + account + " " + password);
                                        if ( tk.equals(account)  )
                                            if (mk.equals(password))
                                            {
                                                int accId = jsonObject1.getInt("accId");
                                                String name_in_app = jsonObject1.getString("name_in_app");
                                                String avt = jsonObject1.getString("avt");
                                                String gmail = jsonObject1.getString("gmail");
                                                String isAct = jsonObject1.getString("isAct");
                                                String friend = jsonObject1.getString("friend");
                                                String add_friend = jsonObject1.getString("add_friend");
                                                String sex = jsonObject1.getString("sex");
                                                String quenquan = jsonObject1.getString("quenquan");
                                                String honnhan = jsonObject1.getString("honnhan");
                                                String sdt = jsonObject1.getString("sdt");
                                                String status = jsonObject1.getString("status");
                                                Data_User.user = new User(accId,account,password,name_in_app,avt,gmail,isAct,friend,add_friend,sex,quenquan,honnhan,sdt,status);
                                                SharedPreferences.Editor  editor = sharedPreferences_user.edit();
                                                editor.putString("taikhoan", account);
                                                editor.putString("matkhau",password);
                                                editor.putString("name_in_app",name_in_app);
                                                editor.putString("avt",avt);
                                                editor.commit();
                                                Data_Off.dangnhapchua=1;
                                                Toast.makeText(binding.getRoot().getContext(),"Đăng nhập thành công",Toast.LENGTH_LONG).show();
                                                Intent intent=new Intent(binding.getRoot().getContext(), CongDongActivity.class);
                                                startActivity(intent);
                                            }
                                    }

                                    if (Data_Off.dangnhapchua==0)
                                        Toast.makeText(binding.getRoot().getContext(),"Thông tin đăng nhập không chính xác",Toast.LENGTH_LONG).show();

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
        });
        
        return binding.getRoot();
    }

    private Context getApplicationContext() {
        return binding.getRoot().getContext();
    }
    public void dangnhap_cont(){
        String taikhoan_ed = sharedPreferences_user.getString("taikhoan","");
        String matkhau_ed = sharedPreferences_user.getString("matkhau","");

        if (!taikhoan_ed.equals("")){
            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Config.url_acc, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject jsonObject1 = response.getJSONObject(i);

                                    String account = jsonObject1.getString("account");
                                    String password = jsonObject1.getString("password");
                                    System.out.println(i + " " + account + " " + password);
                                    if ( taikhoan_ed.equals(account)  )
                                        if (matkhau_ed.equals(password))
                                        {
                                            int accId = jsonObject1.getInt("accId");
                                            String name_in_app = jsonObject1.getString("name_in_app");
                                            String avt = jsonObject1.getString("avt");
                                            String gmail = jsonObject1.getString("gmail");
                                            String isAct = jsonObject1.getString("isAct");
                                            String friend = jsonObject1.getString("friend");
                                            String add_friend = jsonObject1.getString("add_friend");
                                            String sex = jsonObject1.getString("sex");
                                            String quenquan = jsonObject1.getString("quenquan");
                                            String honnhan = jsonObject1.getString("honnhan");
                                            String sdt = jsonObject1.getString("sdt");
                                            String status = jsonObject1.getString("status");
                                            Data_User.user = new User(accId,account,password,name_in_app,avt,gmail,isAct,friend,add_friend,sex,quenquan,honnhan,sdt,status);
                                            SharedPreferences.Editor  editor = sharedPreferences_user.edit();
                                            editor.putString("taikhoan", account);
                                            editor.putString("matkhau",password);
                                            editor.putString("name_in_app",name_in_app);
                                            editor.putString("avt",avt);
                                            editor.commit();
                                            Data_Off.dangnhapchua=1;
                                            Dialog dialog = new Dialog(binding.getRoot().getContext());
                                            dialog.setContentView(R.layout.dialog_login_tieptuc_taikhoan);
                                            TextView name = dialog.findViewById(R.id.tucach_name);
                                            Button huy = dialog.findViewById(R.id.huy);
                                            Button xacnhan = dialog.findViewById(R.id.xacnhan);
                                            name.setText(name_in_app);
                                            xacnhan.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Toast.makeText(binding.getRoot().getContext(),"Kết thành công",Toast.LENGTH_LONG).show();
                                                    Intent intent=new Intent(binding.getRoot().getContext(), CongDongActivity.class);
                                                    startActivity(intent);
                                                }
                                            });
                                            huy.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Data_Off.dangnhapchua=0;
                                                    SharedPreferences.Editor  editor = sharedPreferences_user.edit();
                                                    editor.putString("taikhoan", "");
                                                    editor.putString("matkhau","");
                                                    editor.putString("name_in_app","");
                                                    editor.putString("avt","");
                                                    editor.commit();
                                                    dialog.dismiss();
                                                }
                                            });
                                            dialog.show();

                                        }
                                }

                            } catch (JSONException e) {
                                Data_Off.dangnhapchua=0;
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

}