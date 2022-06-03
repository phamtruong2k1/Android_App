package com.codernon2k1.note.zhome.zthoikhoabieu.thoigianbieu;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.FragmentThoiGianBieuBinding;
import com.codernon2k1.note.zhome.zthoikhoabieu.acti.ThoiGianBieuDataBase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ThoiGianBieuFragment extends Fragment {

    private static FragmentThoiGianBieuBinding binding;
    public static ThoiGianBieuDataBase dataBase;
    public  static  int thu_add,thu , hour , min;
    public static List<UTLThoiKhoaBieu> list ;
    public static Dialog dialog_show;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThoiGianBieuBinding.inflate(inflater, container, false);
        dataBase = new ThoiGianBieuDataBase(binding.getRoot().getContext() , "sukien.sqlite" , null , 1);
        dataBase.QueryData(" CREATE TABLE IF NOT EXISTS ThoiKhoaBieu(Id INTEGER PRIMARY KEY AUTOINCREMENT ,thu INTEGER ,name NVARCHAR(1000) ,gio INTEGER,  phut INTEGER, Ndghichu NVARCHAR(1000) ) ");


        show_thu();


        binding.thu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu=2;
                show_thoigianbieu();
            }
        });
        binding.thu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu=3;
                show_thoigianbieu();
            }
        });
        binding.thu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu=4;
                show_thoigianbieu();
            }
        });
        binding.thu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu=5;
                show_thoigianbieu();
            }
        });
        binding.thu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu=6;
                show_thoigianbieu();
            }
        });
        binding.thu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu=7;
                show_thoigianbieu();
            }
        });
        binding.thu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu=8;
                show_thoigianbieu();
            }
        });
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu_add=2;
                add_thoiganbieu_acti();
            }
        });
        show_all();
        return binding.getRoot();
    }

    @SuppressLint("ResourceAsColor")
    private void show_thu() {
        Calendar cal = Calendar.getInstance();
        int thu = cal.get(Calendar.DAY_OF_WEEK);
        if (thu==1) {
            binding.thunay1.setBackgroundResource(R.color.thu_nay);
        }
        if (thu==2)
            binding.thunay2.setBackgroundResource(R.color.thu_nay);
        if (thu==3)
            binding.thunay3.setBackgroundResource(R.color.thu_nay);
        if (thu==4)
            binding.thunay4.setBackgroundResource(R.color.thu_nay);
        if (thu==5)
            binding.thunay5.setBackgroundResource(R.color.thu_nay);
        if (thu==6)
            binding.thunay6.setBackgroundResource(R.color.thu_nay);
        if (thu==7)
            binding.thunay7.setBackgroundResource(R.color.thu_nay);





    }

    public static void show_thoigianbieu(){
        dialog_show = new Dialog(binding.getRoot().getContext());
        dialog_show.setContentView(R.layout.dialog_show_thoikhoabieu_thumay);
        lay_dulieu();
        ListView lv = dialog_show.findViewById(R.id.lv);
        ThoiGianBieuAdapter adapter = new ThoiGianBieuAdapter(list);
        lv.setAdapter(adapter);
        TextView thumay = dialog_show.findViewById(R.id.thumay);
        if (thu==8){
            thumay.setText("Chủ nhật");
        }
        else
            thumay.setText("Thứ "+thu);
        ImageView left = dialog_show.findViewById(R.id.left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu--;
                if (thu==1)
                    thu=8;
                if (thu==8){
                    thumay.setText("Chủ nhật");
                }
                else
                    thumay.setText("Thứ "+thu);
                lay_dulieu();
                ThoiGianBieuAdapter adapter = new ThoiGianBieuAdapter(list);
                lv.setAdapter(adapter);
            }
        });

        ImageView right = dialog_show.findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu++;
                if (thu==9)
                    thu=2;
                if (thu==8){
                    thumay.setText("Chủ nhật");
                }
                else
                    thumay.setText("Thứ "+thu);
                lay_dulieu();
                ThoiGianBieuAdapter adapter = new ThoiGianBieuAdapter(list);
                lv.setAdapter(adapter);
            }
        });
        ImageView thoat = dialog_show.findViewById(R.id.thoat);
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_show.dismiss();
            }
        });
        ImageView add = dialog_show.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu_add=thu;
                dialog_show.dismiss();
                add_thoiganbieu();
            }
        });
        dialog_show.show();
    }

    public static void add_thoiganbieu(){
        Dialog dialog = new Dialog(binding.getRoot().getContext());
        dialog.setContentView(R.layout.dialog_add_thoikhoabieu);
        EditText name = dialog.findViewById(R.id.name);
        EditText ghichu = dialog.findViewById(R.id.ghichu);
        TextView gio = dialog.findViewById(R.id.gio);
        TextView thumay = dialog.findViewById(R.id.thumay);
        ImageView right = dialog.findViewById(R.id.right);
        hour=0 ;min=0;
        gio.setText(hour+":"+min);
        if (thu_add==8){
            thumay.setText("Chủ nhật");
        }
        else
            thumay.setText("Thứ "+thu_add);
        gio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(v.getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                hour = hourOfDay;
                                min = minute;
                                gio.setText(hour+":"+min);
                            }
                        },hour,min,true);
                timePickerDialog.show();            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu_add++;
                if (thu_add==9)
                    thu=2;
                if (thu_add==8){
                    thumay.setText("Chủ nhật");
                }
                else
                    thumay.setText("Thứ "+thu_add);
            }
        });
        ImageView left = dialog.findViewById(R.id.left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu_add--;
                if (thu_add==1)
                    thu_add=8;
                if (thu_add==8){
                    thumay.setText("Chủ nhật");
                }
                else
                    thumay.setText("Thứ "+thu_add);
            }
        });
//        ImageView thoat = dialog.findViewById(R.id.thoat);
//        thoat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
        Button add = dialog.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                add_thoiganbieu();
                String str = name.getText().toString();
                String nd = ghichu.getText().toString();
                dataBase.QueryData("INSERT INTO ThoiKhoaBieu VALUES ( null ,"+thu_add+",'"+str+"' , "+hour+" , "+min+ " ,'"+nd+"' )" );
                show_thoigianbieu();
                show_all();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static void add_thoiganbieu_acti(){
        Dialog dialog = new Dialog(binding.getRoot().getContext());
        dialog.setContentView(R.layout.dialog_add_thoikhoabieu);
        EditText name = dialog.findViewById(R.id.name);
        EditText ghichu = dialog.findViewById(R.id.ghichu);
        TextView gio = dialog.findViewById(R.id.gio);
        TextView thumay = dialog.findViewById(R.id.thumay);
        ImageView right = dialog.findViewById(R.id.right);
        hour=0 ;min=0;
        gio.setText(hour+":"+min);
        if (thu_add==8){
            thumay.setText("Chủ nhật");
        }
        else
            thumay.setText("Thứ "+thu_add);
        gio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(v.getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                hour = hourOfDay;
                                min = minute;
                                gio.setText(hour+":"+min);
                            }
                        },hour,min,true);
                timePickerDialog.show();            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu_add++;
                if (thu_add==9)
                    thu_add=2;
                if (thu_add==8){
                    thumay.setText("Chủ nhật");
                }
                else
                    thumay.setText("Thứ "+thu_add);
            }
        });
        ImageView left = dialog.findViewById(R.id.left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thu_add--;
                if (thu_add==1)
                    thu_add=8;
                if (thu_add==8){
                    thumay.setText("Chủ nhật");
                }
                else
                    thumay.setText("Thứ "+thu_add);
            }
        });
//        ImageView thoat = dialog.findViewById(R.id.thoat);
//        thoat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
        Button add = dialog.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                add_thoiganbieu();
                String str = name.getText().toString();
                String nd = ghichu.getText().toString();
                dataBase.QueryData("INSERT INTO ThoiKhoaBieu VALUES ( null ,"+thu_add+",'"+str+"' , "+hour+" , "+min+ " ,'"+nd+"' )" );
                show_all();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static void lay_dulieu(){
        Cursor data = dataBase.GetData("SELECT * FROM ThoiKhoaBieu WHERE thu ="+thu+"");
        list = new ArrayList<>();
        while (data.moveToNext()){
            int id = data.getInt(0);
            String name = data.getString(2);
            int gio = data.getInt(3);
            int phut = data.getInt(4);
            String ghichu = data.getString(5);
            list.add(new UTLThoiKhoaBieu(id,thu,name,gio,phut,ghichu));
        }
        for (int i=0;i<list.size()-1;i++)
            for (int j=i+1;j<list.size();j++){
                if (list.get(i).getGio() > list.get(j).getGio()){
                    UTLThoiKhoaBieu tmp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,tmp);
                }
                else if (list.get(i).getGio() == list.get(j).getGio() && list.get(i).getPhut() > list.get(j).getPhut()   ){
                    UTLThoiKhoaBieu tmp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,tmp);
                }

            }
    }

    public static void show_ngayhomday(int thu_may , TextView tt){
        List<UTLThoiKhoaBieu> listtt = new ArrayList<>();
        Cursor data = dataBase.GetData("SELECT * FROM ThoiKhoaBieu WHERE thu ="+thu_may+"");
        listtt = new ArrayList<>();
        String str="";
        while (data.moveToNext()){
            int id = data.getInt(0);
            String name = data.getString(2);
            int gio = data.getInt(3);
            int phut = data.getInt(4);
            String ghichu = data.getString(5);
            listtt.add(new UTLThoiKhoaBieu(id,thu,name,gio,phut,ghichu));
        }

        for (int i=0;i<listtt.size()-1;i++)
            for (int j=i+1;j<listtt.size();j++){
                if (listtt.get(i).getGio() > listtt.get(j).getGio()){
                    UTLThoiKhoaBieu tmp = listtt.get(i);
                    listtt.set(i,listtt.get(j));
                    listtt.set(j,tmp);
                }
                else if (listtt.get(i).getGio() == listtt.get(j).getGio() && listtt.get(i).getPhut() > listtt.get(j).getPhut()   ){
                    UTLThoiKhoaBieu tmp = listtt.get(i);
                    listtt.set(i,listtt.get(j));
                    listtt.set(j,tmp);
                }

            }
        for (UTLThoiKhoaBieu i : listtt){
            str = str + "\n" + i.getGio()+":"+i.getPhut()+" - "+i.getName();
        }
        tt.setText(str);

    }

    public static void show_all(){
        show_ngayhomday(2,binding.tkbThu2);
        show_ngayhomday(3,binding.tkbThu3);
        show_ngayhomday(4,binding.tkbThu4);
        show_ngayhomday(5,binding.tkbThu5);
        show_ngayhomday(6,binding.tkbThu6);
        show_ngayhomday(7,binding.tkbThu7);
        show_ngayhomday(8,binding.tkbThu8);
    }

}