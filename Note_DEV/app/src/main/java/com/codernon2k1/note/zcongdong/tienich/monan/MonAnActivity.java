package com.codernon2k1.note.zcongdong.tienich.monan;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.codernon2k1.note.databinding.ActivityMonAnBinding;
import com.codernon2k1.note.sup.truyen.TruyenData;
import com.codernon2k1.note.zhome.tienich.anuong.monan.MonAnDataBase;
import com.squareup.picasso.Picasso;

public class MonAnActivity extends AppCompatActivity {

    ActivityMonAnBinding binding;
    public static MonAnDataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMonAnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBase = new MonAnDataBase(binding.getRoot().getContext() , "monan.sqlite" , null , 1);
        binding.ten.setText(TruyenData.monan.getUsername());
        binding.congthuc.setText(TruyenData.monan.getCongthuc());
        binding.gia.setText(TruyenData.monan.getTien());
        binding.nguyenlieu.setText(TruyenData.monan.getNguyenlieu());
        Picasso.get().load(TruyenData.monan.getAvt()).into(binding.avt);
        binding.thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.tai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.get().load(TruyenData.monan.getAvt()).fetch();
                dataBase.QueryData("INSERT INTO MonAn1 VALUES ( null , '"+TruyenData.monan.getUsername()+"' , '"+TruyenData.monan.getAvt()+"' , '"+TruyenData.monan.getNguyenlieu()+"' , '"+TruyenData.monan.getCongthuc()+"','"+TruyenData.monan.getTien()+"' )" );
                Toast.makeText(binding.getRoot().getContext(),"Dã lưu về máy",Toast.LENGTH_LONG).show();
            }
        });

    }
}