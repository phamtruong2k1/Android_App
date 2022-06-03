package com.codernon2k1.note.zhome.zchitieu.thunhap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.ActivityShowThuNhapBinding;
import com.codernon2k1.note.zhome.zchitieu.activity.ChiTieuDataBase;
import com.codernon2k1.note.zhome.zchitieu.activity.SupChiTieu;

import java.util.ArrayList;
import java.util.List;

public class ShowThuNhapActivity extends AppCompatActivity {

    public static ActivityShowThuNhapBinding binding;
    public static ChiTieuDataBase dataBase;
    public static List<UTLThuNhap> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowThuNhapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataBase = new ChiTieuDataBase( binding.getRoot().getContext() , "chitieu.sqlite" , null , 1);
        show();
        binding.thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThuNhapFragment.show();
                finish();
            }
        });

        binding.chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(binding.getRoot().getContext());
                dialog.setContentView(R.layout.dialog_chiteu_chon_thunhap);
                LinearLayout luong = dialog.findViewById(R.id.luong);
                LinearLayout kinhdoanh = dialog.findViewById(R.id.kinhdoanh);
                LinearLayout khac = dialog.findViewById(R.id.khac);
                luong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_thunhap="luong";
                        dialog.dismiss();
                        show();
                    }
                });
                kinhdoanh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_thunhap="kinhdoanh";
                        dialog.dismiss();
                        show();
                    }
                });
                khac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_thunhap="khac";
                        dialog.dismiss();
                        show();
                    }
                });
                dialog.show();
            }
        });

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



    }

    public static void showchon(){

        if (SupChiTieu.name_thunhap=="luong"){
            binding.imgNhap.setImageResource(R.mipmap.icons8_cash_80);
            binding.textNhap.setText("Lương");
        }
        if (SupChiTieu.name_thunhap=="kinhdoanh"){
            binding.imgNhap.setImageResource(R.mipmap.icons8_rent_80);
            binding.textNhap.setText("Kinh doanh");
        }

        if (SupChiTieu.name_thunhap=="khac"){
            binding.imgNhap.setImageResource(R.mipmap.icons8_deviation_80);
            binding.textNhap.setText("Khác");
        }
    }


    public static void show(){
        showchon();
        binding.thang.setText((SupChiTieu.thangtn+1)+"/"+SupChiTieu.namtn);
        list=new ArrayList<>();
        Cursor data = dataBase.GetData("SELECT * FROM ThuNhap WHERE ( thang = " + SupChiTieu.thangtn +"  AND nam = "+ SupChiTieu.namtn +" AND name = '" + SupChiTieu.name_thunhap + "' )" );
        while (data.moveToNext()){
            list.add(new UTLThuNhap(data.getInt(0),data.getString(1),data.getInt(2),data.getInt(3),data.getInt(4),data.getInt(5),data.getInt(6),data.getInt(7),data.getString(8)));
        }

        Cursor data1 = dataBase.GetData("SELECT SUM(tien) FROM ThuNhap WHERE ( thang = " + SupChiTieu.thangtn +"  AND nam = "+ SupChiTieu.namtn +" AND name = '" + SupChiTieu.name_thunhap + "' )" );
        int tien=0;
        while (data1.moveToNext()){
            tien= data1.getInt(0);
            System.out.println(tien);
        }

        for (int i=0;i<list.size()-1;i++){
            for (int j=i+1 ; j<list.size();j++){
                if (list.get(i).getNgay() < list.get(j).getNgay()){
                    UTLThuNhap tmp = list.get(i);
                    list.set(i , list.get(j));
                    list.set(j , tmp);
                }
            }
        }

        binding.tong.setText("+"+tien);
        ShowThuNhapAdapter adapter  = new ShowThuNhapAdapter(list);
        binding.lvShow.setAdapter(adapter);

    }}