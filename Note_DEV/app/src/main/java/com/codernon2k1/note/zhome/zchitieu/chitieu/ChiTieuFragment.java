package com.codernon2k1.note.zhome.zchitieu.chitieu;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codernon2k1.note.databinding.FragmentChiTieuBinding;
import com.codernon2k1.note.zhome.zchitieu.activity.ChiTieuDataBase;
import com.codernon2k1.note.zhome.zchitieu.activity.SupChiTieu;

import java.util.Calendar;


public class ChiTieuFragment extends Fragment {


    public static FragmentChiTieuBinding binding;
    public static ChiTieuDataBase dataBase;
    public static Calendar cal ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChiTieuBinding.inflate(inflater, container, false);
        cal = Calendar.getInstance();
        SupChiTieu.thangct = cal.get(Calendar.MONTH);
        SupChiTieu.namct = cal.get(Calendar.YEAR);
        dataBase = new ChiTieuDataBase( binding.getRoot().getContext() , "chitieu.sqlite" , null , 1);
        dataBase.QueryData(" CREATE TABLE IF NOT EXISTS ChiTieu(Id INTEGER PRIMARY KEY AUTOINCREMENT , name NVARCHAR(1000) , ngay INTEGER , thang INTEGER , nam INTEGER  , gio INTEGER , phut INTEGER , tien INTEGER , titile NVARCHAR(1000) ) ");



        binding.left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SupChiTieu.thangct == 0 ){
                    SupChiTieu.thangct=11;
                    SupChiTieu.namct--;
                }
                else
                    SupChiTieu.thangct--;
                show();
            }
        });
        binding.right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SupChiTieu.thangct == 11 ){
                    SupChiTieu.thangct=0;
                    SupChiTieu.namct++;
                }
                else
                    SupChiTieu.thangct++;
                show();
            }
        });

        binding.chitieuAnuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupChiTieu.name_chitieu="anuong";
                startActivity(new Intent(v.getContext(), ShowChiTieuActivity.class));
            }
        });
        binding.chitieuNhaO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupChiTieu.name_chitieu="nhao";
                startActivity(new Intent(v.getContext(), ShowChiTieuActivity.class));
            }
        });
        binding.chitieuMuasam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupChiTieu.name_chitieu="muasam";
                startActivity(new Intent(v.getContext(), ShowChiTieuActivity.class));
            }
        });
        binding.chitieuGiaitri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupChiTieu.name_chitieu="giaitri";
                startActivity(new Intent(v.getContext(), ShowChiTieuActivity.class));
            }
        });
        binding.chitieuKhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupChiTieu.name_chitieu="khac";
                startActivity(new Intent(v.getContext(), ShowChiTieuActivity.class));
            }
        });

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupChiTieu.name_chitieu="anuong";
                startActivity(new Intent(v.getContext(), NhapChiTieuActivity.class));
            }
        });

        show();
        return binding.getRoot();
    }


    public static int lay(int thang , int nam , String name){
        Cursor data = dataBase.GetData("SELECT SUM(tien) FROM ChiTieu WHERE ( thang = " + thang +"  AND nam = "+nam +" AND name = '" +  name + "' )" );
        int tien=0;
        while (data.moveToNext()){
           tien= data.getInt(0);
            System.out.println(tien);
        }
        return tien;
    }

    public static void show(){
        int anuong=lay(SupChiTieu.thangct,SupChiTieu.namct,"anuong");
        int muasam=lay(SupChiTieu.thangct,SupChiTieu.namct,"muasam");
        int nhao=lay(SupChiTieu.thangct,SupChiTieu.namct,"nhao");
        int giaitri=lay(SupChiTieu.thangct,SupChiTieu.namct,"giaitri");
        int khac=lay(SupChiTieu.thangct,SupChiTieu.namct,"khac");
        binding.tongAnuong.setText("-"+anuong);
        binding.tongNhao.setText("-"+nhao);
        binding.tongMuasam.setText("-"+muasam);
        binding.tongGiaitri.setText("-"+giaitri);
        binding.tongKhac.setText("-"+khac);
        binding.tongTong.setText("-"+(anuong+nhao+muasam+giaitri+khac));
        binding.thang.setText((SupChiTieu.thangct+1)+"/"+SupChiTieu.namct);
    }




}