package com.codernon2k1.note.zhome.zchitieu.thunhap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.ActivityNhapThuNhapBinding;
import com.codernon2k1.note.zhome.zchitieu.activity.ChiTieuDataBase;
import com.codernon2k1.note.zhome.zchitieu.activity.SupChiTieu;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NhapThuNhapActivity extends AppCompatActivity {
    public  static ActivityNhapThuNhapBinding binding;
    public static ChiTieuDataBase dataBase;
    public static Calendar cal ;
    public static int gio, phut,ngay,thang,nam;
    public static SimpleDateFormat simpleDateFormat_gio = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat simpleDateFormat_day = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNhapThuNhapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBase = new ChiTieuDataBase( binding.getRoot().getContext() , "chitieu.sqlite" , null , 1);


        binding.thoatThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThuNhapFragment.show();
                finish();
            }
        });

        binding.chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(binding.getRoot().getContext());
                dialog.setContentView(R.layout.dialog_chiteu_chon_thunhap);
                LinearLayout luong = dialog.findViewById(R.id.luong);
                LinearLayout kinhdoanh = dialog.findViewById(R.id.kinhdoanh);
                LinearLayout khac = dialog.findViewById(R.id.khac);
                luong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_thunhap="luong";
                        dialog.dismiss();
                        show_chon();
                    }
                });
                kinhdoanh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_thunhap="kinhdoanh";
                        dialog.dismiss();
                        show_chon();
                    }
                });
                khac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_thunhap="khac";
                        dialog.dismiss();
                        show_chon();
                    }
                });
                dialog.show();
            }
        });

        cal = Calendar.getInstance();
        gio = cal.get(Calendar.HOUR);
        phut = cal.get(Calendar.MINUTE);
        ngay= cal.get(Calendar.DATE);
        thang= cal.get(Calendar.MONTH);
        nam= cal.get(Calendar.YEAR);
        show_chon();

        binding.textGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chong_gio();
            }
        });
        binding.textNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chong_ngay();
            }
        });

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = binding.nhapTien.getText().toString();
                if (str.equals("")){
                    Toast.makeText(binding.getRoot().getContext(),"Tiền không thể bỏ trống",Toast.LENGTH_LONG).show();
                }
                else {
                    String title = binding.ghichu.getText().toString();
                    int tien = chuyenchu(str);
                    System.out.println(tien);
                    System.out.println(thang+","+nam);
                    dataBase.QueryData("INSERT INTO ThuNhap VALUES ( null ,'"+SupChiTieu.name_thunhap+"' , "+ ngay +" , " + thang + "," + nam +","+gio+","+phut+","+ tien+ ",'"+title+"')" );
                    binding.nhapTien.setText("");
                    binding.ghichu.setText("");
                    Toast.makeText(binding.getRoot().getContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
                }

            }
        });
        binding.thoatThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ThuNhapFragment.show();
                finish();
            }
        });

    }

    public static int chuyenchu(String str){
        int cnt=0;
        for (int i=0;i<str.length();i++)
            cnt=cnt*10+(str.charAt(i)-'0');
        return  cnt;
    }

    public static void show_chon( ){

        if (SupChiTieu.name_thunhap=="luong"){
            binding.imgNhap.setImageResource(R.mipmap.icons8_cash_80);
            binding.textNhap.setText("Lương");
        }
        if (SupChiTieu.name_thunhap=="kinhdoanh"){
            binding.imgNhap.setImageResource(R.mipmap.icons8_rent_80);
            binding.textNhap.setText("Kinh doanh");
        }

        if (SupChiTieu.name_thunhap=="khac"){
            binding.imgNhap.setImageResource(R.mipmap.icons8_deviation_80);
            binding.textNhap.setText("Khác");
        }
        binding.textNgay.setText(simpleDateFormat_day.format(cal.getTime()));
        binding.textGio.setText(simpleDateFormat_gio.format(cal.getTime()));

    }

    public static void chong_gio(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(binding.getRoot().getContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        cal.set(nam,thang,ngay,hourOfDay,minute);
                        gio = cal.get(Calendar.HOUR);
                        phut = cal.get(Calendar.MINUTE);
                        ngay= cal.get(Calendar.DATE);
                        thang= cal.get(Calendar.MONTH);
                        nam= cal.get(Calendar.YEAR);
                        show_chon();
                    }
                },gio,phut,true);
        timePickerDialog.show();
    }

    public static void chong_ngay(){
        DatePickerDialog timePickerDialog = new DatePickerDialog(binding.getRoot().getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        cal.set(year,month,dayOfMonth,gio,phut);
                        gio = cal.get(Calendar.HOUR);
                        phut = cal.get(Calendar.MINUTE);
                        ngay= cal.get(Calendar.DATE);
                        thang= cal.get(Calendar.MONTH);
                        nam= cal.get(Calendar.YEAR);
                        show_chon();
                        show_chon();
                    }
                },nam,thang,ngay);
        timePickerDialog.show();
    }

}