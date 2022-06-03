package com.codernon2k1.note.zhome.zghichu;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.ActivityGhiChuBinding;
import com.codernon2k1.note.zhome.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class GhiChuActivity extends AppCompatActivity {

    public static ActivityGhiChuBinding binding;

    public static GhiChuDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGhiChuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataBase = new GhiChuDataBase(this , "ghichu.sqlite" , null , 1);
        dataBase.QueryData(" CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT , Ndghichu NVARCHAR(1000) ) ");

        show();

        binding.thoatGhichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        binding.ghichuThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_ghichu_them);
                EditText textf = dialog.findViewById(R.id.edit_nd_ghi_chu);
                Button add = dialog.findViewById(R.id.add_ghichu);
                Button huy = dialog.findViewById(R.id.scancel_ghichu);
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str = textf.getText().toString();
                        if (str.equals("")){
                            Toast.makeText(dialog.getContext(),"Nội dung không thể trống" , Toast.LENGTH_LONG).show();
                        }
                        else{
                            dataBase.QueryData("INSERT INTO CongViec VALUES ( null ,'"+str+"')" );
                            dialog.dismiss();
                            show();
                        }
                    }
                });
                huy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }

    public static void show(){
        List<UTLGhiChu> list = new ArrayList<>();
        List<UTLGhiChu> list2 = new ArrayList<>();
        Cursor data = dataBase.GetData("SELECT * FROM CongViec");
        while (data.moveToNext()){
            int id = data.getInt(0);
            String noidung = data.getString(1);
            list.add(new UTLGhiChu(id,noidung));
        }

        for (int i = list.size()-1;i >= 0;i--)
            list2.add(list.get(i));

        GhiChuAdapter adapter = new GhiChuAdapter(list2);
        binding.lvShowGhiChu.setAdapter(adapter);

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(binding.getRoot().getContext(), MainActivity.class);
        startActivity(intent);
    }
}