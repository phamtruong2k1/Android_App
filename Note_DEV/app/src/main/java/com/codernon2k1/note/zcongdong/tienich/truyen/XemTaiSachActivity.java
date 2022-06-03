package com.codernon2k1.note.zcongdong.tienich.truyen;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.codernon2k1.note.databinding.ActivityXemSachBinding;
import com.codernon2k1.note.sup.truyen.TruyenData;
import com.codernon2k1.note.zhome.tienich.sach.SachDataBase;
import com.squareup.picasso.Picasso;

public class XemTaiSachActivity extends AppCompatActivity {

    ActivityXemSachBinding binding;
    public static SachDataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityXemSachBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBase = new SachDataBase(binding.getRoot().getContext() , "sach.sqlite" , null , 1);
        binding.thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.noidung.setText(TruyenSach.truyen.getNoidung());
        binding.ten.setText(TruyenSach.truyen.getName());
        binding.tacgia.setText(TruyenSach.truyen.getTagia());
        binding.theloai.setText(TruyenSach.truyen.getTheloai());


        binding.tai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.get().load(TruyenData.monan.getAvt()).fetch();
                dataBase.QueryData("INSERT INTO Sach VALUES ( null , "+TruyenSach.truyen.getTruyenId()+" , '"+TruyenSach.truyen.getName()+"' , '"+TruyenSach.truyen.getTheloai()+"' , '"+TruyenSach.truyen.getTagia()+"' , '"+TruyenSach.truyen.getNoidung()+"' )" );
                Toast.makeText(binding.getRoot().getContext(),"Dã lưu về máy",Toast.LENGTH_LONG).show();
            }
        });

    }
}