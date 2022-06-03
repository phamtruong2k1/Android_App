package com.codernon2k1.note.zhome.zchitieu.thongke;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.FragmentThongKeBinding;
import com.codernon2k1.note.zhome.zchitieu.activity.ChiTieuDataBase;
import com.codernon2k1.note.zhome.zchitieu.activity.SupChiTieu;

import java.util.Calendar;


public class ThongKeFragment extends Fragment {


    public static FragmentThongKeBinding binding;
    public static ChiTieuDataBase dataBase;
    public static Calendar cal ;
    public  static  int nam_tc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentThongKeBinding.inflate(inflater, container, false);
        cal = Calendar.getInstance();
        SupChiTieu.thangct = cal.get(Calendar.MONTH);
        SupChiTieu.namct = cal.get(Calendar.YEAR);
        SupChiTieu.thangtn = cal.get(Calendar.MONTH);
        SupChiTieu.namtn = cal.get(Calendar.YEAR);
        dataBase = new ChiTieuDataBase( binding.getRoot().getContext() , "chitieu.sqlite" , null , 1);

        binding.left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SupChiTieu.thangct == 0 ){
                    SupChiTieu.thangct=11;
                    SupChiTieu.namct--;
                    SupChiTieu.thangtn=11;
                    SupChiTieu.namtn--;
                }
                else
                {
                    SupChiTieu.thangct--;
                    SupChiTieu.thangtn--;
                }

                show();
            }
        });
        binding.right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SupChiTieu.thangct == 11 ){
                    SupChiTieu.thangct=0;
                    SupChiTieu.namct++;
                    SupChiTieu.thangtn=0;
                    SupChiTieu.namtn++;
                }
                else
                {
                    SupChiTieu.thangct++;
                    SupChiTieu.thangtn++;
                }

                show();
            }
        });

        binding.tatca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_tatca();
            }
        });



        show();

        return binding.getRoot();
    }

    public static void show_tatca(){
        Calendar cal_t = Calendar.getInstance();
        nam_tc = cal_t.get(Calendar.YEAR);
        Dialog dialog = new Dialog(binding.getRoot().getContext());
        dialog.setContentView(R.layout.dialog_show_tatca_thongke);
        ImageView thoat = dialog.findViewById(R.id.thoat);
        TextView year = dialog.findViewById(R.id.nam);
        year.setText(nam_tc+"");

        {
            TextView ct_t1 = dialog.findViewById(R.id.ct_t1);
            TextView ct_t2 = dialog.findViewById(R.id.ct_t2);
            TextView ct_t3 = dialog.findViewById(R.id.ct_t3);
            TextView ct_t4 = dialog.findViewById(R.id.ct_t4);
            TextView ct_t5 = dialog.findViewById(R.id.ct_t5);
            TextView ct_t6 = dialog.findViewById(R.id.ct_t6);
            TextView ct_t7 = dialog.findViewById(R.id.ct_t7);
            TextView ct_t8 = dialog.findViewById(R.id.ct_t8);
            TextView ct_t9 = dialog.findViewById(R.id.ct_t9);
            TextView ct_t10 = dialog.findViewById(R.id.ct_t10);
            TextView ct_t11 = dialog.findViewById(R.id.ct_t11);
            TextView ct_t12 = dialog.findViewById(R.id.ct_t12);
            TextView ct_tt = dialog.findViewById(R.id.ct_tt);

            TextView tn_t1 = dialog.findViewById(R.id.tn_t1);
            TextView tn_t2 = dialog.findViewById(R.id.tn_t2);
            TextView tn_t3 = dialog.findViewById(R.id.tn_t3);
            TextView tn_t4 = dialog.findViewById(R.id.tn_t4);
            TextView tn_t5 = dialog.findViewById(R.id.tn_t5);
            TextView tn_t6 = dialog.findViewById(R.id.tn_t6);
            TextView tn_t7 = dialog.findViewById(R.id.tn_t7);
            TextView tn_t8 = dialog.findViewById(R.id.tn_t8);
            TextView tn_t9 = dialog.findViewById(R.id.tn_t9);
            TextView tn_t10 = dialog.findViewById(R.id.tn_t10);
            TextView tn_t11 = dialog.findViewById(R.id.tn_t11);
            TextView tn_t12 = dialog.findViewById(R.id.tn_t12);
            TextView tn_tt = dialog.findViewById(R.id.tn_tt);

            TextView tong_t1 = dialog.findViewById(R.id.tong_t1);
            TextView tong_t2 = dialog.findViewById(R.id.tong_t2);
            TextView tong_t3 = dialog.findViewById(R.id.tong_t3);
            TextView tong_t4 = dialog.findViewById(R.id.tong_t4);
            TextView tong_t5 = dialog.findViewById(R.id.tong_t5);
            TextView tong_t6 = dialog.findViewById(R.id.tong_t6);
            TextView tong_t7 = dialog.findViewById(R.id.tong_t7);
            TextView tong_t8 = dialog.findViewById(R.id.tong_t8);
            TextView tong_t9 = dialog.findViewById(R.id.tong_t9);
            TextView tong_t10 = dialog.findViewById(R.id.tong_t10);
            TextView tong_t11 = dialog.findViewById(R.id.tong_t11);
            TextView tong_t12 = dialog.findViewById(R.id.tong_t12);
            TextView tong_tt = dialog.findViewById(R.id.tong_tt);


            lay_dulieu_thang(ct_t1, tn_t1, tong_t1, 0 , nam_tc);
            lay_dulieu_thang(ct_t2, tn_t2, tong_t2, 1, nam_tc);
            lay_dulieu_thang(ct_t3, tn_t3, tong_t3, 2, nam_tc);
            lay_dulieu_thang(ct_t4, tn_t4, tong_t4, 3, nam_tc);
            lay_dulieu_thang(ct_t5, tn_t5, tong_t5, 4, nam_tc);
            lay_dulieu_thang(ct_t6, tn_t6, tong_t6, 5, nam_tc);
            lay_dulieu_thang(ct_t7, tn_t7, tong_t7, 6, nam_tc);
            lay_dulieu_thang(ct_t8, tn_t8, tong_t8, 7, nam_tc);
            lay_dulieu_thang(ct_t9, tn_t9, tong_t9, 8, nam_tc);
            lay_dulieu_thang(ct_t10, tn_t10, tong_t10, 9, nam_tc);
            lay_dulieu_thang(ct_t12, tn_t12, tong_t12, 11, nam_tc);
            lay_dulieu_thang(ct_t11, tn_t11, tong_t11, 10, nam_tc);
            lay_dulieu_nam(ct_tt, tn_tt, tong_tt, nam_tc);





            ImageView left = dialog.findViewById(R.id.left);
            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nam_tc--;
                    year.setText(nam_tc + "");
                    lay_dulieu_thang(ct_t1, tn_t1, tong_t1, 0 , nam_tc);
                    lay_dulieu_thang(ct_t2, tn_t2, tong_t2, 1, nam_tc);
                    lay_dulieu_thang(ct_t3, tn_t3, tong_t3, 2, nam_tc);
                    lay_dulieu_thang(ct_t4, tn_t4, tong_t4, 3, nam_tc);
                    lay_dulieu_thang(ct_t5, tn_t5, tong_t5, 4, nam_tc);
                    lay_dulieu_thang(ct_t6, tn_t6, tong_t6, 5, nam_tc);
                    lay_dulieu_thang(ct_t7, tn_t7, tong_t7, 6, nam_tc);
                    lay_dulieu_thang(ct_t8, tn_t8, tong_t8, 7, nam_tc);
                    lay_dulieu_thang(ct_t9, tn_t9, tong_t9, 8, nam_tc);
                    lay_dulieu_thang(ct_t10, tn_t10, tong_t10, 9, nam_tc);
                    lay_dulieu_thang(ct_t12, tn_t12, tong_t12, 11, nam_tc);
                    lay_dulieu_thang(ct_t11, tn_t11, tong_t11, 10, nam_tc);
                    lay_dulieu_nam(ct_tt, tn_tt, tong_tt, nam_tc);


                }
            });
            ImageView right = dialog.findViewById(R.id.right);
            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nam_tc++;
                    year.setText(nam_tc + "");
                    lay_dulieu_thang(ct_t1, tn_t1, tong_t1, 0 , nam_tc);
                    lay_dulieu_thang(ct_t2, tn_t2, tong_t2, 1, nam_tc);
                    lay_dulieu_thang(ct_t3, tn_t3, tong_t3, 2, nam_tc);
                    lay_dulieu_thang(ct_t4, tn_t4, tong_t4, 3, nam_tc);
                    lay_dulieu_thang(ct_t5, tn_t5, tong_t5, 4, nam_tc);
                    lay_dulieu_thang(ct_t6, tn_t6, tong_t6, 5, nam_tc);
                    lay_dulieu_thang(ct_t7, tn_t7, tong_t7, 6, nam_tc);
                    lay_dulieu_thang(ct_t8, tn_t8, tong_t8, 7, nam_tc);
                    lay_dulieu_thang(ct_t9, tn_t9, tong_t9, 8, nam_tc);
                    lay_dulieu_thang(ct_t10, tn_t10, tong_t10, 9, nam_tc);
                    lay_dulieu_thang(ct_t12, tn_t12, tong_t12, 11, nam_tc);
                    lay_dulieu_thang(ct_t11, tn_t11, tong_t11, 10, nam_tc);
                    lay_dulieu_nam(ct_tt, tn_tt, tong_tt, nam_tc);
                }
            });
            thoat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

        }
        dialog.show();



    }

    @SuppressLint("ResourceAsColor")
    public static void lay_dulieu_thang(TextView ct , TextView tn , TextView tong , int thang, int nam){
        Cursor data_c = dataBase.GetData("SELECT SUM(tien) FROM ChiTieu WHERE ( thang = " + thang +" AND nam = "+nam +" )");
        int tien_ct=0;
        while (data_c.moveToNext()){
            tien_ct= data_c.getInt(0);
        }
        Cursor data_t = dataBase.GetData("SELECT SUM(tien) FROM ThuNhap WHERE ( thang = " + thang +" AND nam = "+nam +" )");
        int tien_tn=0;
        while (data_t.moveToNext()){
            tien_tn= data_t.getInt(0);
        }
        ct.setText("-"+tien_ct+"");
        tn.setText("+"+tien_tn+"");
        if ((tien_tn-tien_ct) >= 0){
            tong.setText("+"+(tien_tn-tien_ct)+"");
            tong.setTextColor(R.color.tieu_xanh);
        }
        else{
            tong.setText("-"+(tien_tn-tien_ct)+"");
            tong.setTextColor(R.color.tieu_red);
        }

    }
    @SuppressLint("ResourceAsColor")
    public static void lay_dulieu_nam(TextView ct , TextView tn , TextView tong , int nam){
        Cursor data_c = dataBase.GetData("SELECT SUM(tien) FROM ChiTieu WHERE ( nam = " + nam +")" );
        int tien_ct=0;
        while (data_c.moveToNext()){
            tien_ct= data_c.getInt(0);
        }
        Cursor data_t = dataBase.GetData("SELECT SUM(tien) FROM ThuNhap WHERE ( nam = " + nam +" )" );
        int tien_tn=0;
        while (data_t.moveToNext()){
            tien_tn= data_t.getInt(0);
        }
        ct.setText("-"+tien_ct+"");
        tn.setText("+"+tien_tn+"");
        if ((tien_tn-tien_ct) >= 0){
            tong.setText("+"+(tien_tn-tien_ct)+"");
            tong.setTextColor(R.color.tieu_xanh);
        }
        else{
            tong.setText("-"+(tien_tn-tien_ct)+"");
            tong.setTextColor(R.color.tieu_red);
        }

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

    @SuppressLint("ResourceAsColor")
    public static void show(){
        int chi = lay_chi(SupChiTieu.thangct, SupChiTieu.namct);
        int thu = lay_thu(SupChiTieu.thangct, SupChiTieu.namct);
        binding.chitieu.setText("-"+chi);
        binding.thunhap.setText("+"+thu);
        binding.tong.setText(""+(thu-chi));
        if (thu-chi >= 0){
            binding.tong.setTextColor(R.color.tieu_xanh);
        }
        else
            binding.tong.setTextColor(R.color.tieu_red);
        binding.thang.setText((SupChiTieu.thangct+1)+"/"+SupChiTieu.namct);
    }
}