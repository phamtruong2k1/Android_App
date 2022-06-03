package com.codernon2k1.note.zhome.tienich;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.codernon2k1.note.zhome.MainActivity;
import com.codernon2k1.note.zhome.tienich.anuong.AnUongActivity;
import com.codernon2k1.note.databinding.ActivityTienIchBinding;
import com.codernon2k1.note.zhome.tienich.sach.SachActivity;
import com.codernon2k1.note.zhome.tienich.giaitri.GameActivity;


public class TienIchActivity extends AppCompatActivity {

    public static ActivityTienIchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTienIchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        startActivity(new Intent(getBaseContext(), GiaiTriActivity.class));
//
        binding.tienichGiaitri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), GameActivity.class));
            }
        });
        binding.tienichTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SachActivity.class));
            }
        });
        binding.tienichMonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), AnUongActivity.class));
            }
        });
        binding.thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(binding.getRoot().getContext(), MainActivity.class);
        startActivity(intent);
    }
}