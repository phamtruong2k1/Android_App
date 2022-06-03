package com.codernon2k1.note.zhome.tienich.anuong.monan;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codernon2k1.note.R;
import com.codernon2k1.note.sup.truyen.TruyenData;
import com.codernon2k1.note.sup.utl.Monan;
import com.codernon2k1.note.zhome.zchitieu.activity.ChiTieuActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MonAnAdapter extends BaseAdapter {
    List<Monan> list = new ArrayList<>();

    public MonAnAdapter(List<Monan> list) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_show_mon_an_may,parent,false);
        LinearLayout layout = view.findViewById(R.id.show_monan);
        Monan monan = list.get(position);
        TextView name,tien,id;
        ImageView imageView;
        imageView=view.findViewById(R.id.avt_monan);
        name = view.findViewById(R.id.name_monan);
        tien = view.findViewById(R.id.tien_monan);
        ImageButton xoa = view.findViewById(R.id.xoa);
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("Xóa sách")
                        .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MonAnDataBase dataBase;
                                dataBase = new MonAnDataBase(v.getContext() , "monan.sqlite" , null , 1);
                                dataBase.QueryData(" DELETE FROM MonAn1 WHERE Id = " + monan.getMonanId() +"" );
                                MonAnFragment.show_monan();
                            }
                        })
                        .setNeutralButton("Huỷ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });

        name.setText(monan.getUsername());
        tien.setText(monan.getTien());
        Picasso.get().load(monan.getAvt()).into(imageView);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TruyenData.monan=monan;
                startActivity(new Intent(v.getContext(), XemMonAnActivity.class));
            }

        });
        return view;
    }

    private void startActivity(Intent intent1) {
        MonAnFragment.binding.getRoot().getContext().startActivity(intent1);
    }



}
