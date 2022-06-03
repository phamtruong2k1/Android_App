package com.codernon2k1.note.zhome.tienich.sach;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.codernon2k1.note.databinding.ActivitySachBinding;

import java.util.ArrayList;
import java.util.List;


public class SachActivity extends AppCompatActivity {

    public static ActivitySachBinding binding;

    public static SachDataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySachBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataBase = new SachDataBase(this , "sach.sqlite" , null , 1);
        dataBase.QueryData(" CREATE TABLE IF NOT EXISTS Sach(Id INTEGER PRIMARY KEY AUTOINCREMENT , idsach INTEGER , name NVARCHAR(1000) , theloai name NVARCHAR(1000) , tacgia name NVARCHAR(1000) , noidung  name NVARCHAR(50000)  ) ");

        show();

        binding.thoatSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    public static void show(){
        List<UTLSach> list = new ArrayList<>();
        List<UTLSach> list2 = new ArrayList<>();
        Cursor data = dataBase.GetData("SELECT * FROM Sach");
        while (data.moveToNext()){
            int id = data.getInt(0);
            int sachid = data.getInt(1);
            String name = data.getString(2);
            String theloai = data.getString(3);
            String tacgia = data.getString(4);

            String noidung = data.getString(5);
            list.add(new UTLSach(id,sachid,name,theloai,tacgia,noidung) );
        }

        for (int i = list.size()-1;i >= 0;i--)
            list2.add(list.get(i));

        SachAdapter adapter = new SachAdapter(list2);
        binding.lvShowTruyen.setAdapter(adapter);

    }
}