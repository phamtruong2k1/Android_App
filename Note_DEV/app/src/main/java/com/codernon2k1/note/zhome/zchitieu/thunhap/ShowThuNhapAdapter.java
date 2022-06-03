package com.codernon2k1.note.zhome.zchitieu.thunhap;

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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.codernon2k1.note.R;
import com.codernon2k1.note.zhome.zchitieu.activity.ChiTieuDataBase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ShowThuNhapAdapter extends BaseAdapter {
    List<UTLThuNhap> chiTieus = new ArrayList<>();

    public ShowThuNhapAdapter(List<UTLThuNhap> ghichus) {
        this.chiTieus = ghichus;
    }

    @Override
    public int getCount() {
        return chiTieus.size();
    }

    @Override
    public Object getItem(int position) {
        return chiTieus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static ChiTieuDataBase dataBase;
    public static SimpleDateFormat simpleDateFormat_gio = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat simpleDateFormat_day = new SimpleDateFormat("dd/MM/yyyy");
    public  static  int houer1 , mini1 , day1 , month1 , year1;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_show_chitieu_chitiet,parent,false);
        dataBase = new ChiTieuDataBase( view.getContext() , "chitieu.sqlite" , null , 1);
        UTLThuNhap thuNhap = chiTieus.get(position);
        TextView ngay = view.findViewById(R.id.ngay);
        TextView gio = view.findViewById(R.id.gio);
        TextView titile = view.findViewById(R.id.title);
        TextView tien = view.findViewById(R.id.tien);
        ImageButton delte = view.findViewById(R.id.xoa);
        ImageButton sua = view.findViewById(R.id.sua);
        ngay.setText( thuNhap.getNgay() +"/"+ (thuNhap.getThang() +1 )+"/"+thuNhap.getNam() );
        gio.setText(thuNhap.getGio()+":"+thuNhap.getPhut());
        titile.setText(thuNhap.getTitle());
        tien.setText("+"+thuNhap.getTien());

        delte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("Xóa ? ")
                        .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataBase.QueryData(" DELETE FROM ThuNhap WHERE Id = " + thuNhap.getId() +"" );
                                ShowThuNhapActivity.show();
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
                Calendar cal = Calendar.getInstance();
                cal.set(thuNhap.getNam(),thuNhap.getThang(),thuNhap.getNgay(),thuNhap.getGio(),thuNhap.getPhut());
                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_chitieu_sua);
                EditText tien1 = dialog.findViewById(R.id.tien);
                TextView ngay1 = dialog.findViewById(R.id.ngay);
                TextView gio1 = dialog.findViewById(R.id.gio);
                EditText ghichu1 = dialog.findViewById(R.id.ghichu);
                Button huy = dialog.findViewById(R.id.huy);
                Button sua1 = dialog.findViewById(R.id.sua1);
                houer1 =thuNhap.getGio();
                mini1 =thuNhap.getPhut();
                day1=thuNhap.getNgay() ;
                month1 = thuNhap.getThang() ;
                year1=thuNhap.getNam();
                tien1.setText(""+thuNhap.getTien());
                ngay1.setText(simpleDateFormat_day.format(cal.getTime()));
                gio1.setText(simpleDateFormat_gio.format(cal.getTime()));
                ghichu1.setText(thuNhap.getTitle());

                gio1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(v.getContext(),
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                        cal.set(year1,month1,day1,hourOfDay,minute);
                                        houer1 = cal.get(Calendar.HOUR);
                                        mini1 = cal.get(Calendar.MINUTE);
                                        day1 = cal.get(Calendar.DATE);
                                        month1 = cal.get(Calendar.MONTH);
                                        year1 = cal.get(Calendar.YEAR);
                                        ngay1.setText(simpleDateFormat_day.format(cal.getTime()));
                                        gio1.setText(simpleDateFormat_gio.format(cal.getTime()));
                                    }
                                },houer1,mini1,true);
                        timePickerDialog.show();
                    }
                });
                ngay1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog timePickerDialog = new DatePickerDialog(v.getContext(),
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                        cal.set(year,month,dayOfMonth,houer1,mini1);
                                        houer1 = cal.get(Calendar.HOUR);
                                        mini1 = cal.get(Calendar.MINUTE);
                                        day1 = cal.get(Calendar.DATE);
                                        month1 = cal.get(Calendar.MONTH);
                                        year1 = cal.get(Calendar.YEAR);
                                        ngay1.setText(simpleDateFormat_day.format(cal.getTime()));
                                        gio1.setText(simpleDateFormat_gio.format(cal.getTime()));
                                    }
                                },year1,month1,day1);
                        timePickerDialog.show();
                    }
                });

                sua1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String tiens = tien1.getText().toString();
                        if (tiens.equals("")){
                            Toast.makeText(v.getContext(),"Tiền không thể trống",Toast.LENGTH_LONG).show();
                        }
                        else {
                            String title = ghichu1.getText().toString();
                            int tien3 = chuyenchu(tiens);
                            System.out.println(tien);

                            dataBase.QueryData("UPDATE ThuNhap SET ngay ="+day1 + ", thang="+month1+", nam="+year1+", gio="+houer1+",phut="+mini1+", tien="+tien3+", titile='"+title+"' WHERE Id="+thuNhap.getId()+";");

                            Toast.makeText(v.getContext(),"Sửa thành công",Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                            ShowThuNhapActivity.show();

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


    public static int chuyenchu(String str){
        int cnt=0;
        for (int i=0;i<str.length();i++)
            cnt=cnt*10+(str.charAt(i)-'0');
        return  cnt;
    }








}


