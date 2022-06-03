package com.codernon2k1.note.zhome.tienich.sach;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.codernon2k1.note.R;
import com.codernon2k1.note.sup.truyen.TruyenData;
import com.codernon2k1.note.zhome.tienich.anuong.monan.MonAnFragment;
import com.codernon2k1.note.zhome.tienich.anuong.monan.XemMonAnActivity;


import java.util.ArrayList;
import java.util.List;

public class SachAdapter extends BaseAdapter {
    List<UTLSach> saches = new ArrayList<>();

    public SachAdapter(List<UTLSach> saches) {
        this.saches = saches;
    }

    @Override
    public int getCount() {
        return saches.size();
    }

    @Override
    public Object getItem(int position) {
        return saches.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_tienich_show_sach,parent,false);
        UTLSach sach = saches.get(position);
        LinearLayout layout = view.findViewById(R.id.show_truyen);
        ImageButton delete;
        TextView name = view.findViewById(R.id.name_truyen);
        TextView tacgia = view.findViewById(R.id.tacgia_truyen);
        TextView theloai = view.findViewById(R.id.theloai_truyen);
        delete=view.findViewById(R.id.xoa_sach);
        
        name.setText(sach.getName());
        tacgia.setText(sach.getTagia());
        theloai.setText(sach.getTheloai());
        
        
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TruyenData.truyen=sach;
                startActivity(new Intent(v.getContext(), XemSachActivity.class));
            }
        });
        
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("Xóa sách")
                        .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SachDataBase dataBase;
                                dataBase = new SachDataBase(v.getContext() , "sach.sqlite" , null , 1);
                                dataBase.QueryData(" DELETE FROM Sach WHERE Id = " + sach.getId() +"" );
                                SachActivity.show();
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
        return view;

    }
    private void startActivity(Intent intent1) {
        SachActivity.binding.getRoot().getContext().startActivity(intent1);
    }
}
