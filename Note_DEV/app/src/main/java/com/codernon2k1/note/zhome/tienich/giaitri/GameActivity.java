package com.codernon2k1.note.zhome.tienich.giaitri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.codernon2k1.note.databinding.ActivityGameBinding;
import com.codernon2k1.note.zhome.tienich.giaitri.sudoku.SudokuActivity;

public class GameActivity extends AppCompatActivity {

    public static ActivityGameBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.gameSudoku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SudokuActivity.class));
            }
        });

        binding.thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}