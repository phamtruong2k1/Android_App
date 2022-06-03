package com.codernon2k1.note.zhome.zghichu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.codernon2k1.note.R;

import java.util.ArrayList;
import java.util.List;


public class GhiChuAdapter extends BaseAdapter {
    List<UTLGhiChu> ghichus = new ArrayList<>();

    public GhiChuAdapter(List<UTLGhiChu> ghichus) {
        this.ghichus = ghichus;
    }

    @Override
    public int getCount() {
        return ghichus.size();
    }

    @Override
    public Object getItem(int position) {
        return ghichus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_show_ghi_chu,parent,false);
        UTLGhiChu ghichu = ghichus.get(position);
        TextView noidung;
        ImageButton delete,sua;
        noidung=view.findViewById(R.id.tv_show_ghi_chu);
        delete=view.findViewById(R.id.xoa_ghi_chu);
        sua=view.findViewById(R.id.sua_ghi_chu);
        noidung.setText(ghichu.getNoidungghichu());
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("Xóa ghi chú")
                        .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                GhiChuDataBase dataBase;
                                dataBase = new GhiChuDataBase(v.getContext() , "ghichu.sqlite" , null , 1);
                                dataBase.QueryData(" DELETE FROM CongViec WHERE Id = " + ghichu.getIdghichu() +"" );
                                GhiChuActivity.show();
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
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_ghichu_sua);
                EditText textf = dialog.findViewById(R.id.edit_nd_ghi_chu);
                Button sua = dialog.findViewById(R.id.sua_ghichu);
                Button huy = dialog.findViewById(R.id.scancel_ghichu);
                textf.setText(ghichu.getNoidungghichu());
                sua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GhiChuDataBase dataBase;
                        String str = textf.getText().toString();
                        if (str.equals("")){
                            Toast.makeText(dialog.getContext(),"Nội dung không thể trống" , Toast.LENGTH_LONG).show();
                        }
                        else{
                            dataBase = new GhiChuDataBase(v.getContext() , "ghichu.sqlite" , null , 1);
                            dataBase.QueryData(" UPDATE CongViec SET Ndghichu = '"+str+"' WHERE Id = "+ghichu.getIdghichu() );
                            dialog.dismiss();
                            GhiChuActivity.show();
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
        return view;
    }
}
