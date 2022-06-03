package com.codernon2k1.note.zcongdong.tienich.truyen;

import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codernon2k1.note.R;
import com.codernon2k1.note.sup.truyen.TruyenData;
import com.codernon2k1.note.zhome.tienich.sach.SachActivity;
import com.codernon2k1.note.zhome.tienich.sach.SachDataBase;
import com.codernon2k1.note.sup.utl.Truyen;
import com.codernon2k1.note.zhome.tienich.sach.XemSachActivity;

import java.util.ArrayList;
import java.util.List;

public class TaiTruyenAdapter extends BaseAdapter {
    List<Truyen> list = new ArrayList<>();

    public TaiTruyenAdapter(List<Truyen> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static SachDataBase dataBase;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_show_truyen,parent,false);
        dataBase = new SachDataBase(view.getContext() , "sach.sqlite" , null , 1);
        LinearLayout layout = view.findViewById(R.id.show_truyen);
        Truyen truyen = list.get(position);
        TextView name,tacgia,theloai,id;
        name = view.findViewById(R.id.name_truyen);
        theloai = view.findViewById(R.id.theloai_truyen);
        tacgia = view.findViewById(R.id.tacgia_truyen);
        name.setText(truyen.getName());
        theloai.setText(truyen.getTheloai());
        tacgia.setText(truyen.getTagia());

        Button tai = view.findViewById(R.id.dowload_truyen);
        tai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBase.QueryData("INSERT INTO Sach VALUES ( null , "+truyen.getTruyenId()+" , '"+truyen.getName()+"' , '"+truyen.getTheloai()+"' , '"+truyen.getTagia()+"' , '"+truyen.getNoidung()+"' )" );
                Toast.makeText(view.getContext(),"Dã lưu về máy",Toast.LENGTH_LONG).show();
            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TruyenSach.truyen=truyen;
                startActivity(new Intent(v.getContext(), XemTaiSachActivity.class));
            }
        });


        return view;
    }
    private void startActivity(Intent intent1) {
        TaiTruyenActivity.binding.getRoot().getContext().startActivity(intent1);
    }

}

