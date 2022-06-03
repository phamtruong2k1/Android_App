package com.codernon2k1.note.zhome.zthoikhoabieu.thoigianbieu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.codernon2k1.note.R;
import com.codernon2k1.note.zhome.zthoikhoabieu.acti.ThoiGianBieuDataBase;

import java.util.ArrayList;
import java.util.List;

public class ThoiGianBieuAdapter extends BaseAdapter {
    List<UTLThoiKhoaBieu> list = new ArrayList<>();

    public ThoiGianBieuAdapter(List<UTLThoiKhoaBieu> list) {
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

    public static ThoiGianBieuDataBase dataBase;
    View view;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.item_show_thoikhoabieu_thumay,parent,false);

        UTLThoiKhoaBieu tkb = list.get(position);

        TextView name = view.findViewById(R.id.name);
        TextView ghichu = view.findViewById(R.id.ghichu);
        TextView gio = view.findViewById(R.id.gio);
        ImageButton xoa = view.findViewById(R.id.xoa);
        ImageButton sua = view.findViewById(R.id.sua);

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(view.getContext());
                dialog.setContentView(R.layout.dialog_sua_thoikhoabieu);
                EditText name = dialog.findViewById(R.id.name);
                EditText ghichu = dialog.findViewById(R.id.ghichu);
                TextView gio = dialog.findViewById(R.id.gio);
                TextView thumay = dialog.findViewById(R.id.thumay);
                ImageView right = dialog.findViewById(R.id.right);
                gio.setText(tkb.getGio()+":"+tkb.getPhut());

                ghichu.setText(tkb.getNdghichu());
                name.setText(tkb.getName());
                gio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(v.getContext(),
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                    }
                                },tkb.getGio(),tkb.getPhut(),true);
                        timePickerDialog.show();            }
                });


                Button add = dialog.findViewById(R.id.add);
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(view.getContext(),"Sửa thành công",Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });







        name.setText(tkb.getName());
        ghichu.setText(tkb.getNdghichu());
        gio.setText(tkb.getGio()+":"+tkb.getPhut());
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("Xóa sự kiện")
                        .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataBase = new ThoiGianBieuDataBase(view.getContext() , "sukien.sqlite" , null , 1);
                                dataBase.QueryData("DELETE FROM ThoiKhoaBieu WHERE Id =" + tkb.getId() +"" );
                                ThoiGianBieuFragment.dialog_show.dismiss();
                                ThoiGianBieuFragment.show_thoigianbieu();
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
}

