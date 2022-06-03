 package com.codernon2k1.note.zhome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.VoiceInteractor;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.codernon2k1.note.R;
import com.codernon2k1.note.chat.chat.SDTActivity;
import com.codernon2k1.note.sup.data.Config;
import com.codernon2k1.note.sup.data.JsonVolley;
import com.codernon2k1.note.sup.network.CheckNetwork;
import com.codernon2k1.note.sup.utl.Monan;
import com.codernon2k1.note.zcongdong.CongDongActivity;
import com.codernon2k1.note.zcongdong.singin.DangNhapActivity;
import com.codernon2k1.note.zcongdong.tienich.monan.TaiMonAnAdapter;
import com.codernon2k1.note.zhome.zchitieu.activity.ChiTieuActivity;
import com.codernon2k1.note.databinding.ActivityMainBinding;
import com.codernon2k1.note.zhome.zchitieu.activity.ChiTieuDataBase;
import com.codernon2k1.note.zhome.zghichu.GhiChuActivity;
import com.codernon2k1.note.zhome.tienich.TienIchActivity;
import com.codernon2k1.note.zhome.zthoikhoabieu.acti.ThoiGianBieuDataBase;
import com.codernon2k1.note.zhome.zthoikhoabieu.acti.ThoiKhoaBieuActivity;
import com.codernon2k1.note.zhome.zthoikhoabieu.sukien.UTLSuKien;
import com.codernon2k1.note.zhome.zthoikhoabieu.thoigianbieu.UTLThoiKhoaBieu;
import com.codernon2k1.note.zzchaoapp.MainActivity2;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


 public class MainActivity extends AppCompatActivity {
    public  static ActivityMainBinding binding;
    public  static SharedPreferences sharedPreferences_home;
    public  static SharedPreferences sharedPreferences;
    public static ChiTieuDataBase dataBase;
     public static ThoiGianBieuDataBase dataBase_tkb;
     public  static SharedPreferences sharedPreferences_user;
    Calendar cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences_home = getSharedPreferences("data_home", MODE_PRIVATE);

        String name = sharedPreferences_home.getString("home_name", "");
        sharedPreferences = getSharedPreferences("matkhau_ungdung",MODE_PRIVATE);
        dataBase = new ChiTieuDataBase( binding.getRoot().getContext() , "chitieu.sqlite" , null , 1);
        dataBase.QueryData(" CREATE TABLE IF NOT EXISTS ChiTieu(Id INTEGER PRIMARY KEY AUTOINCREMENT , name NVARCHAR(1000) , ngay INTEGER , thang INTEGER , nam INTEGER  , gio INTEGER , phut INTEGER , tien INTEGER , titile NVARCHAR(1000) ) ");
        dataBase.QueryData(" CREATE TABLE IF NOT EXISTS ThuNhap(Id INTEGER PRIMARY KEY AUTOINCREMENT , name NVARCHAR(1000) , ngay INTEGER , thang INTEGER , nam INTEGER  , gio INTEGER , phut INTEGER , tien INTEGER , titile NVARCHAR(1000) ) ");

        dataBase_tkb = new ThoiGianBieuDataBase(binding.getRoot().getContext() , "sukien.sqlite" , null , 1);
        dataBase_tkb.QueryData(" CREATE TABLE IF NOT EXISTS SuKien(Id INTEGER PRIMARY KEY AUTOINCREMENT ,name NVARCHAR(1000) ,  day INTEGER ,month INTEGER, year INTEGER , gio INTEGER,  phut INTEGER ,baothuc_gio INTEGER,  baothuc_phut INTEGER , baothuc INTEGER , Ndghichu NVARCHAR(1000) ) ");
        dataBase_tkb.QueryData(" CREATE TABLE IF NOT EXISTS ThoiKhoaBieu(Id INTEGER PRIMARY KEY AUTOINCREMENT ,thu INTEGER ,name NVARCHAR(1000) ,gio INTEGER,  phut INTEGER, Ndghichu NVARCHAR(1000) ) ");


        show_tt();
        show_thoigianbieu();

        sharedPreferences_user = getSharedPreferences("thongtin_user",MODE_PRIVATE);
        show();
        {
            binding.homeNgay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatePickerDialog dialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        }
                    },cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DATE));
                    dialog.show();
                }
            });
            cal = Calendar.getInstance();
            String str_thu;
            String str_ngay =  cal.get(Calendar.DATE) +"";
            String str_thang = (char)('1' + cal.get(Calendar.MONTH) ) +"";
            if (cal.get(Calendar.DAY_OF_WEEK) == 1){
                str_thu = "CN";
            }
            else{
                int x = cal.get(Calendar.DAY_OF_WEEK);
                str_thu= "Th " + (char)('0' + x );
            }
            binding.homeNgay.setText(str_thu + " , " + str_ngay +" thg "+ str_thang);

            binding.homeName.setText(""+name);
            if (name.equals("")) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_home_sua_name);
                EditText textf = dialog.findViewById(R.id.home_ed_dat_name);
                Button dat = dialog.findViewById(R.id.home_bt_dat_name);

                textf.setText(sharedPreferences_home.getString("home_name", ""));

                dat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str = textf.getText().toString();
                        if (str.equals("")) {
                            Toast.makeText(MainActivity.this, "Tên không dc trống", Toast.LENGTH_LONG).show();
                        } else {

                            SharedPreferences.Editor editor = sharedPreferences_home.edit();
                            editor.putString("home_name", str);
                            editor.commit();


                            binding.homeName.setText("@"+str);
                            dialog.dismiss();
                        }
                    }
                });
                dialog.show();
            }
            binding.homeSuaName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.dialog_home_sua_name);
                    EditText textf = dialog.findViewById(R.id.home_ed_dat_name);
                    Button dat = dialog.findViewById(R.id.home_bt_dat_name);
                    textf.setText(sharedPreferences_home.getString("home_name", ""));
                    dat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String str = textf.getText().toString();
                            if (str.equals("")) {
                                Toast.makeText(MainActivity.this, "Tên không dc trống", Toast.LENGTH_LONG).show();
                            } else {
                                SharedPreferences.Editor editor = sharedPreferences_home.edit();
                                editor.putString("home_name", str);
                                editor.commit();
                                binding.homeName.setText("@"+str);
                                dialog.dismiss();
                            }
                        }
                    });
                    dialog.show();
                }
            });

            binding.homeChitieu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(v.getContext(), ChiTieuActivity.class));
                }
            });
            binding.homeTkb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(v.getContext(), ThoiKhoaBieuActivity.class));
                }
            });
            binding.homeTienich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(v.getContext(), TienIchActivity.class));
                }
            });
            binding.homeCongdong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!CheckNetwork.isConnectedInternet(binding.getRoot().getContext())){
                        Toast.makeText(binding.getRoot().getContext(),"Vui lòng kiểm tra kết nối internet" , Toast.LENGTH_LONG).show();
                    }
                    else{
                        startActivity(new Intent(v.getContext(), SDTActivity.class));
                    }

                }
            });
            binding.homeGhichu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(v.getContext(), GhiChuActivity.class));
                }
            });

        }


        binding.homeCaidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_home_cai_dat);
                LinearLayout ngonngu = dialog.findViewById(R.id.home_caidat_ngonngu);
                LinearLayout pass = dialog.findViewById(R.id.home_caidat_khoaapp);
                LinearLayout hotro = dialog.findViewById(R.id.home_caidat_hotro);

                ngonngu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Dialog dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog_home_caidat_ngonngu);
                        LinearLayout tiengviet = dialog.findViewById(R.id.tiengviet);
                        LinearLayout tienganh = dialog.findViewById(R.id.tienganh);

                        tiengviet.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("ngonngu", "vi");
                                editor.commit();
                                ngonngu("vi");
                            }
                        });
                        tienganh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("ngonngu", "en");
                                editor.commit();
                                ngonngu("en");
                            }
                        });

                        dialog.show();
                    }
                });

                pass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog_khoa_app();
                    }
                });
                dialog.show();
            }
        });

    }

     private void show_tt() {
         JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, Config.url_ttdemo, null,
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
                             Picasso.get().load("http://openweathermap.org/img/wn/"+icon+"@2x.png").into(binding.iconTt);

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

     public static void show_thoigianbieu(){
        Calendar cal = Calendar.getInstance();
        int thu = cal.get(Calendar.DAY_OF_WEEK);
         List<UTLThoiKhoaBieu> listtt = new ArrayList<>();
         Cursor data = dataBase_tkb.GetData("SELECT * FROM ThoiKhoaBieu WHERE thu ="+thu+"");
         listtt = new ArrayList<>();
         String str="";
         while (data.moveToNext()){
             int id = data.getInt(0);
             String name = data.getString(2);
             int gio = data.getInt(3);
             int phut = data.getInt(4);
             String ghichu = data.getString(5);
             listtt.add(new UTLThoiKhoaBieu(id,thu,name,gio,phut,ghichu));
         }

         for (int i=0;i<listtt.size()-1;i++)
             for (int j=i+1;j<listtt.size();j++){
                 if (listtt.get(i).getGio() > listtt.get(j).getGio()){
                     UTLThoiKhoaBieu tmp = listtt.get(i);
                     listtt.set(i,listtt.get(j));
                     listtt.set(j,tmp);
                 }
                 else if (listtt.get(i).getGio() == listtt.get(j).getGio() && listtt.get(i).getPhut() > listtt.get(j).getPhut()   ){
                     UTLThoiKhoaBieu tmp = listtt.get(i);
                     listtt.set(i,listtt.get(j));
                     listtt.set(j,tmp);
                 }

             }
         for (UTLThoiKhoaBieu i : listtt){
             str = str + "\n" + i.getGio()+":"+i.getPhut()+" - "+i.getName();
         }
         if (str.equals("")){
             binding.congviec.setText("Không có công việc được thêm");
         }
         else
            binding.congviec.setText(str);

         str="";
         int day=cal.get(Calendar.DATE);int month=cal.get(Calendar.MONTH);int year=cal.get(Calendar.YEAR);
         data = dataBase_tkb.GetData("SELECT * FROM SuKien WHERE day="+day+" AND month="+month+" AND year=" + year);
         List<UTLSuKien> suKiens = new ArrayList<>();
         while (data.moveToNext()) {
             String name = data.getString(1);

             int gio = data.getInt(5);
             int phut = data.getInt(6);

             str=str+"\n"+gio+":"+phut+"-"+name;

         }

         if (str.equals("")){
             binding.sukien.setText("Không có sự kiện nào trong ngày");
         }
         else
             binding.sukien.setText(str);





     }


     private void dialog_khoa_app() {
         Dialog dialog = new Dialog(binding.getRoot().getContext());
         dialog.setContentView(R.layout.khoa_app);
         EditText pass_app_1 = dialog.findViewById(R.id.pass_app_nhap_1);
         EditText pass_app_2 = dialog.findViewById(R.id.pass_app_nhap_2);
         Button huy = dialog.findViewById(R.id.thoat_pass_app);
         Button xoa = dialog.findViewById(R.id.xoa_pass_app);
         Button nhap = dialog.findViewById(R.id.nhap_pass_app);
         nhap.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String ed_pass_1 = pass_app_1.getText().toString();
                 String ed_pass_2 = pass_app_2.getText().toString();
                 if (ed_pass_1.equals(ed_pass_2)){
                     if (ed_pass_1.equals(""))
                     {
                         Toast.makeText(binding.getRoot().getContext(), "Mật khẩu không thể bỏ  trống", Toast.LENGTH_LONG).show();
                     }
                     else{
                         SharedPreferences.Editor  editor = sharedPreferences.edit();
                         editor.putString("noidung", ed_pass_1);
                         editor.commit();
                         Toast.makeText(binding.getRoot().getContext(), "Mật khẩu đã được cài đặt", Toast.LENGTH_LONG).show();
                         dialog.dismiss();
                     }

                 }
                 else {
                     Toast.makeText(binding.getRoot().getContext(), "Mật khẩu xác nhận không giống", Toast.LENGTH_LONG).show();
                 }
             }
         });
         huy.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 dialog.dismiss();
             }
         });
         xoa.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 SharedPreferences.Editor  editor = sharedPreferences.edit();
                 editor.putString("noidung", "");
                 editor.commit();
                 Toast.makeText(binding.getRoot().getContext(), "Mật khẩu đã được xóa", Toast.LENGTH_LONG).show();
             }
         });
         dialog.show();
     }


     public static void show(){
        Calendar calendar = Calendar.getInstance();
         int chi = lay_chi(calendar.get(Calendar.MONTH) , calendar.get(Calendar.YEAR));
         int thu = lay_thu(calendar.get(Calendar.MONTH) , calendar.get(Calendar.YEAR));
         binding.chitieu.setText("-"+chi);
         binding.thunhap.setText("+"+thu);
     }
     public static int lay_chi(int thang , int nam ){
         Cursor data = dataBase.GetData("SELECT SUM(tien) FROM ChiTieu WHERE ( thang = " + thang +"  AND nam = "+nam +" )" );
         int tien=0;
         while (data.moveToNext()){
             tien= data.getInt(0);
             System.out.println(tien);
         }
         return tien;
     }

     public static int lay_thu(int thang , int nam ){
         Cursor data = dataBase.GetData("SELECT SUM(tien) FROM ThuNhap WHERE ( thang = " + thang +"  AND nam = "+nam +" )" );
         int tien=0;
         while (data.moveToNext()){
             tien= data.getInt(0);
             System.out.println(tien);
         }
         return tien;
     }

     public void ngonngu(String str){
         Locale locale = new Locale(str);
         Configuration config = new Configuration();
         config.locale = locale;
         binding.getRoot().getContext().getResources().updateConfiguration(
                 config,
                 binding.getRoot().getContext().getResources().getDisplayMetrics()
         );
         Intent intent = new Intent(binding.getRoot().getContext(), MainActivity2.class);
         startActivity(intent);

     }
     @Override
     public void onBackPressed() {
         AlertDialog alertDialog = new AlertDialog.Builder(binding.getRoot().getContext()).
                 setMessage("").setTitle("Thoát ứng dụng")
                 .setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                         startActivity(intent);
                         Toast.makeText(binding.getRoot().getContext(),"Thoát ",Toast.LENGTH_LONG).show();
                         // Tao su kien ket thuc app
                         Intent startMain = new Intent(Intent.ACTION_MAIN);
                         startMain.addCategory(Intent.CATEGORY_HOME);
                         startActivity(startMain);
                         finish();
                     }
                 })
                 .setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                     }
                 }).show();
     }




 }