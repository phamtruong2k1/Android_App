package com.codernon2k1.note.zhome.tienich.sach;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.ActivityXemMonAnBinding;
import com.codernon2k1.note.databinding.ActivityXemSachBinding;
import com.codernon2k1.note.sup.truyen.TruyenData;

public class XemSachActivity extends AppCompatActivity {

    ActivityXemSachBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityXemSachBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.noidung.setText(TruyenData.truyen.getNoidung());
        binding.ten.setText(TruyenData.truyen.getName());
        binding.tacgia.setText(TruyenData.truyen.getTagia());
        binding.theloai.setText(TruyenData.truyen.getTheloai());

    }
}