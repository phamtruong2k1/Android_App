package com.codernon2k1.note.zcongdong.tienich.monan;

import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codernon2k1.note.R;
import com.codernon2k1.note.sup.truyen.TruyenData;
import com.codernon2k1.note.zhome.tienich.anuong.monan.MonAnDataBase;
import com.codernon2k1.note.sup.utl.Monan;
import com.codernon2k1.note.zhome.tienich.anuong.monan.MonAnFragment;
import com.codernon2k1.note.zhome.tienich.anuong.monan.XemMonAnActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TaiMonAnAdapter extends BaseAdapter {
    List<Monan> list = new ArrayList<>();

    public TaiMonAnAdapter(List<Monan> list) {
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

    public static MonAnDataBase dataBase;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_show_monan,parent,false);
        dataBase = new MonAnDataBase(view.getContext() , "monan.sqlite" , null , 1);
        LinearLayout layout = view.findViewById(R.id.show_monan);
        Monan monan = list.get(position);
        TextView name,tien,id;
        ImageView imageView;
        imageView=view.findViewById(R.id.avt_monan);
        name = view.findViewById(R.id.name_monan);
        tien = view.findViewById(R.id.tien_monan);
        name.setText(monan.getUsername());
        tien.setText(monan.getTien());
        Picasso.get().load(monan.getAvt()).into(imageView);

        Button tai = view.findViewById(R.id.dowload_monan);
        tai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Picasso.get().load(monan.getAvt()).fetch();

                dataBase.QueryData("INSERT INTO MonAn1 VALUES ( null , '"+monan.getUsername()+"' , '"+monan.getAvt()+"' , '"+monan.getNguyenlieu()+"' , '"+monan.getCongthuc()+"','"+monan.getTien()+"' )" );
                Toast.makeText(view.getContext(),"Dã lưu về máy",Toast.LENGTH_LONG).show();
            }
        });


        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TruyenData.monan=monan;
                startActivity(new Intent(v.getContext(),MonAnActivity.class));
            }

        });
        return view;
    }
    private void startActivity(Intent intent1) {
        TaiMonAnActivity.binding.getRoot().getContext().startActivity(intent1);
    }

}
