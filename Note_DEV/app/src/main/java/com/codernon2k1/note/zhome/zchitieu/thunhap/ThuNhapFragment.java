package com.codernon2k1.note.zhome.zchitieu.thunhap;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codernon2k1.note.databinding.FragmentThuNhapBinding;
import com.codernon2k1.note.zhome.zchitieu.activity.ChiTieuDataBase;
import com.codernon2k1.note.zhome.zchitieu.activity.SupChiTieu;

import java.util.Calendar;


public class ThuNhapFragment extends Fragment {


    public static FragmentThuNhapBinding binding;
    public static ChiTieuDataBase dataBase;
    public static Calendar cal ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThuNhapBinding.inflate(inflater, container, false);
        cal = Calendar.getInstance();
        SupChiTieu.thangct = cal.get(Calendar.MONTH);
        SupChiTieu.namct = cal.get(Calendar.YEAR);
        SupChiTieu.thangtn = cal.get(Calendar.MONTH);
        SupChiTieu.namtn = cal.get(Calendar.YEAR);
        dataBase = new ChiTieuDataBase( binding.getRoot().getContext() , "chitieu.sqlite" , null , 1);
        dataBase.QueryData(" CREATE TABLE IF NOT EXISTS ThuNhap(Id INTEGER PRIMARY KEY AUTOINCREMENT , name NVARCHAR(1000) , ngay INTEGER , thang INTEGER , nam INTEGER  , gio INTEGER , phut INTEGER , tien INTEGER , titile NVARCHAR(1000) ) ");

        binding.left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SupChiTieu.thangtn == 0 ){
                    SupChiTieu.thangtn=11;
                    SupChiTieu.namtn--;
                }
                else
                    SupChiTieu.thangtn--;
                show();
            }
        });
        binding.right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SupChiTieu.thangtn == 11 ){
                    SupChiTieu.thangtn=0;
                    SupChiTieu.namtn++;
                }
                else
                    SupChiTieu.thangtn++;
                show();
            }
        });
        binding.thunhapLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupChiTieu.name_thunhap="luong";
                startActivity(new Intent(v.getContext(), ShowThuNhapActivity.class));
            }
        });
        binding.thunhapKhinhdoanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupChiTieu.name_thunhap="kinhdoanh";
                startActivity(new Intent(v.getContext(), ShowThuNhapActivity.class));
            }
        });
        binding.thunhapKhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupChiTieu.name_chitieu="khac";
                startActivity(new Intent(v.getContext(), ShowThuNhapActivity.class));
            }
        });

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupChiTieu.name_thunhap="luong";
                startActivity(new Intent(v.getContext(), NhapThuNhapActivity.class));
            }
        });

        show();


        return binding.getRoot();
    }

    public static int lay(int thang , int nam , String name){
        Cursor data = dataBase.GetData("SELECT SUM(tien) FROM ThuNhap WHERE ( thang = " + thang +"  AND nam = "+nam +" AND name = '" +  name + "' )" );
        int tien=0;
        while (data.moveToNext()){
            tien= data.getInt(0);
            System.out.println(tien);
        }
        return tien;
    }

    public static void show(){
        int luong=lay(SupChiTieu.thangtn,SupChiTieu.namtn,"luong");
        int kinhdoanh=lay(SupChiTieu.thangtn,SupChiTieu.namtn,"kinhdoanh");
        int khac=lay(SupChiTieu.thangtn,SupChiTieu.namtn,"khac");

        binding.tongLuong.setText("+"+luong);
        binding.tongKinhdoanh.setText("+"+kinhdoanh);
        binding.tongKhac.setText("+"+khac);
        binding.tong.setText("+"+(luong+kinhdoanh+khac));

        binding.ngay.setText((SupChiTieu.thangtn+1)+"/"+SupChiTieu.namtn);

    }



}