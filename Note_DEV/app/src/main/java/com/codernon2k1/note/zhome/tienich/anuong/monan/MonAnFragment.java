package com.codernon2k1.note.zhome.tienich.anuong.monan;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codernon2k1.note.databinding.FragmentMonAnBinding;
import com.codernon2k1.note.sup.utl.Monan;

import java.util.ArrayList;
import java.util.List;

public class MonAnFragment extends Fragment {

    public static FragmentMonAnBinding binding;
    public static MonAnDataBase dataBase;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMonAnBinding.inflate(inflater, container, false);
        dataBase = new MonAnDataBase(binding.getRoot().getContext() , "monan.sqlite" , null , 1);
        dataBase.QueryData(" CREATE TABLE IF NOT EXISTS MonAn1(Id INTEGER PRIMARY KEY AUTOINCREMENT , name NVARCHAR(1000) , avt NVARCHAR(1000) , nguyenlieu NVARCHAR(50000) , congthuc NVARCHAR(50000) ,tien NVARCHAR(1000) ) ");

        show_monan();

        return binding.getRoot();
    }

    public static void show_monan(){
        List<Monan> list = new ArrayList<>();
        List<Monan> list2 = new ArrayList<>();
        Cursor data = dataBase.GetData("SELECT * FROM MonAn1");
        while (data.moveToNext()){
            int id = data.getInt(0);
            String name = data.getString(1);
            String avt = data.getString(2);
            String nguyenlieu = data.getString(3);
            String congthuc = data.getString(4);
            String tien = data.getString(5);
            list.add(new Monan(id,name,avt,nguyenlieu,congthuc,tien) );
        }

        for (int i = list.size()-1;i >= 0;i--)
            list2.add(list.get(i));

        MonAnAdapter adapter = new MonAnAdapter(list2);
        binding.lvShow.setAdapter(adapter);

    }



}