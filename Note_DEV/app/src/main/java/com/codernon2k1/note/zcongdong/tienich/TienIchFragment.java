package com.codernon2k1.note.zcongdong.tienich;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codernon2k1.note.zcongdong.tienich.monan.TaiMonAnActivity;
import com.codernon2k1.note.zcongdong.tienich.truyen.TaiTruyenActivity;
import com.codernon2k1.note.databinding.FragmentTienIchBinding;


public class TienIchFragment extends Fragment {

    public  static FragmentTienIchBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTienIchBinding.inflate(inflater, container, false);

        binding.tienichMonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(binding.getRoot().getContext(), TaiMonAnActivity.class);
                startActivity(intent);
            }
        });
        binding.tienichTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(binding.getRoot().getContext(), TaiTruyenActivity.class);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}