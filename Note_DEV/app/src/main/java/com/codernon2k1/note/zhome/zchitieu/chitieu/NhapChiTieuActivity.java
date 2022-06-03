package com.codernon2k1.note.zhome.zchitieu.chitieu;

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
import com.codernon2k1.note.databinding.ActivityNhapChiTieuBinding;
import com.codernon2k1.note.zhome.MainActivity;
import com.codernon2k1.note.zhome.zchitieu.activity.ChiTieuDataBase;
import com.codernon2k1.note.zhome.zchitieu.activity.SupChiTieu;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NhapChiTieuActivity extends AppCompatActivity {
    public  static  ActivityNhapChiTieuBinding binding;
    public static ChiTieuDataBase dataBase;
    public static Calendar cal ;
    public static int gio, phut,ngay,thang,nam;
    public static SimpleDateFormat simpleDateFormat_gio = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat simpleDateFormat_day = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNhapChiTieuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBase = new ChiTieuDataBase( binding.getRoot().getContext() , "chitieu.sqlite" , null , 1);


        binding.chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(binding.getRoot().getContext());
                dialog.setContentView(R.layout.dialog_chitieu_chon_chiteu);
                LinearLayout anuong = dialog.findViewById(R.id.anuong);
                LinearLayout nhao = dialog.findViewById(R.id.nhao);
                LinearLayout muasam = dialog.findViewById(R.id.muasam);
                LinearLayout giaitri = dialog.findViewById(R.id.giaitri);
                LinearLayout khac = dialog.findViewById(R.id.khac);
                anuong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_chitieu="anuong";
                        dialog.dismiss();
                        show_chon();
                    }
                });
                nhao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_chitieu="nhao";
                        dialog.dismiss();
                        show_chon();
                    }
                });
                muasam.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_chitieu="muasam";
                        dialog.dismiss();
                        show_chon();
                    }
                });
                giaitri.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_chitieu="giaitri";
                        dialog.dismiss();
                        show_chon();
                    }
                });
                khac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_chitieu="khac";
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
                    dataBase.QueryData("INSERT INTO ChiTieu VALUES ( null ,'"+SupChiTieu.name_chitieu+"' , "+ ngay +" , " + thang + "," + nam +","+gio+","+phut+","+ tien+ ",'"+title+"')" );
                    binding.nhapTien.setText("");
                    binding.ghichu.setText("");
                    MainActivity.show();
                    Toast.makeText(binding.getRoot().getContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
                }

            }
        });
        binding.thoatThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChiTieuFragment.show();
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

        if (SupChiTieu.name_chitieu=="anuong"){
            binding.imgNhap.setImageResource(R.mipmap.icons8_dining_room_96);
            binding.textNhap.setText("Ăn uống");
        }
        if (SupChiTieu.name_chitieu=="nhao"){
            binding.imgNhap.setImageResource(R.mipmap.icons8_home_160);
            binding.textNhap.setText("Nhà ở");
        }
        if (SupChiTieu.name_chitieu=="muasam"){
            binding.imgNhap.setImageResource(R.mipmap.icons8_buying_80);
            binding.textNhap.setText("Ăn uống");
        }
        if (SupChiTieu.name_chitieu=="giaitri"){
            binding.imgNhap.setImageResource(R.mipmap.icons8_beach_80);
            binding.textNhap.setText("Ăn uống");
        }
        if (SupChiTieu.name_chitieu=="khac"){
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