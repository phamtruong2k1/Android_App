package com.codernon2k1.note.zhome.zthoikhoabieu.sukien;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.codernon2k1.note.R;
import com.codernon2k1.note.zhome.zthoikhoabieu.acti.ThoiGianBieuDataBase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ShowSuKienAdapter extends BaseAdapter {
    List<UTLSuKien> list = new ArrayList<>();

    public ShowSuKienAdapter(List<UTLSuKien> list) {
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
        view = layoutInflater.inflate(R.layout.item_show_sukien_ngay,parent,false);
        UTLSuKien suKien = list.get(position);
        TextView name = view.findViewById(R.id.name);
        TextView ghichu = view.findViewById(R.id.ghichu);
        TextView ngay = view.findViewById(R.id.ngay);
        TextView gio = view.findViewById(R.id.gio);
        TextView baothuc = view.findViewById(R.id.baothuc);
        ImageButton xoa = view.findViewById(R.id.xoa);
        ImageButton sua = view.findViewById(R.id.sua);

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(view.getContext());
                dialog.setContentView(R.layout.dialog_sua_sukien);
                Calendar cal_add = Calendar.getInstance();
                EditText name = dialog.findViewById(R.id.name);
                EditText ghichu = dialog.findViewById(R.id.ghichu);
                Button add = dialog.findViewById(R.id.them);
                Button huy = dialog.findViewById(R.id.huy);
                TextView ngay = dialog.findViewById(R.id.ngay);
                TextView gio = dialog.findViewById(R.id.gio);
                TextView gio_baothuc = dialog.findViewById(R.id.baothuc);
                CheckBox isBaothuc = dialog.findViewById(R.id.baothuc_khong);
                name.setText(suKien.getName());
                ghichu.setText(suKien.getNdghichu());
                ngay.setText(suKien.getDay()+"/"+suKien.getMonth()+"/"+suKien.getYear());
                gio.setText(suKien.getGio()+":"+suKien.getPhut());
                gio_baothuc.setText(suKien.getBaothuc_gio()+":"+suKien.getBaothuc_phut());
                gio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(v.getContext(),
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                    }
                                },0,0,true);
                        timePickerDialog.show();
                    }
                });
                ngay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog timePickerDialog = new DatePickerDialog(v.getContext(),
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                    }
                                },2021,7,31);
                        timePickerDialog.show();
                    }
                });

                gio_baothuc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(v.getContext(),
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                    }
                                },0,0,true);
                        timePickerDialog.show();
                    }
                });


                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(view.getContext(),"Sửa thành công",Toast.LENGTH_LONG).show();
                        dialog.dismiss();
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




        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("Xóa sự kiện")
                        .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataBase = new ThoiGianBieuDataBase(view.getContext() , "sukien.sqlite" , null , 1);
                                dataBase.QueryData("DELETE FROM SuKien WHERE Id =" + suKien.getId() +"" );
                                SuKienFragment.dialog_okok.dismiss();
                                SuKienFragment.show_sukien(Sup_SuKien.utlLich);
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

        name.setText(suKien.getName());
        ngay.setText(suKien.getDay()+"/"+suKien.getMonth()+"/"+suKien.getYear());
        gio.setText(suKien.getGio()+":"+suKien.getPhut());
        if (suKien.getBaothuc()==0){
            baothuc.setText("Không");
        }
        else {
            baothuc.setText(suKien.getBaothuc_gio()+"/"+suKien.getBaothuc_phut());
        }
        ghichu.setText(suKien.getNdghichu());

        return view;
    }
}
