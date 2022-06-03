package com.codernon2k1.note.zhome.tienich.anuong.monan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.codernon2k1.note.databinding.ActivityXemMonAnBinding;
import com.codernon2k1.note.sup.truyen.TruyenData;

import com.squareup.picasso.Picasso;

public class XemMonAnActivity extends AppCompatActivity {

    ActivityXemMonAnBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityXemMonAnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

    }
}