package com.codernon2k1.note.zhome.zthoikhoabieu.sukien;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.FragmentSuKienBinding;
import com.codernon2k1.note.zhome.zthoikhoabieu.acti.ThoiGianBieuDataBase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.codernon2k1.note.R.color.lich_sukien;


public class SuKienFragment extends Fragment {
    public static FragmentSuKienBinding binding;
    public static Calendar cal ;
    public static Calendar cal_ngayhomnay ;
    public static Calendar cal_tao ;
    public static int thang_show,nam_show;
    public static UTLLich[][] liches = new UTLLich[9][9];
    public static ThoiGianBieuDataBase dataBase;
    public static Dialog dialog_okok;
    int ngay_add=0;
    int thang_add=0;
    int nam_add=0;
    int gio_add=0;
    int phut_add=0;
    int baothuc_gio_add=0;
    int baothuc_phut_add=0;
    int baothuc_add=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSuKienBinding.inflate(inflater, container, false);
        cal = Calendar.getInstance();
        cal_ngayhomnay = Calendar.getInstance();
        binding.homnay.setText("Hôm nay: "+cal_ngayhomnay.get(Calendar.DAY_OF_MONTH)+"/"+ cal_ngayhomnay.get(Calendar.MONTH)+"/"+ cal_ngayhomnay.get(Calendar.YEAR));
        thang_show=cal.get(Calendar.MONTH);
        nam_show=cal.get(Calendar.YEAR);
        dataBase = new ThoiGianBieuDataBase(binding.getRoot().getContext() , "sukien.sqlite" , null , 1);
        dataBase.QueryData(" CREATE TABLE IF NOT EXISTS SuKien(Id INTEGER PRIMARY KEY AUTOINCREMENT ,name NVARCHAR(1000) ,  day INTEGER ,month INTEGER, year INTEGER , gio INTEGER,  phut INTEGER ,baothuc_gio INTEGER,  baothuc_phut INTEGER , baothuc INTEGER , Ndghichu NVARCHAR(1000) ) ");

        {
            binding.left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (thang_show == 0 ){
                        thang_show=11;
                        nam_show--;
                    }
                    else
                        thang_show--;
                    show();
                }
            });
            binding.right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (thang_show == 11 ){
                        thang_show=0;
                        nam_show++;
                    }
                    else
                        thang_show++;
                    show();
                }
            });
        }

        show();

        binding.addSukien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
                show();
            }
        });
        //============================================
        {
            {
                binding.o11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[1][1]);
                    }
                });
                binding.o12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[1][2]);
                    }
                });
                binding.o13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[1][3]);
                    }
                });
                binding.o14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[1][4]);
                    }
                });
                binding.o15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[1][5]);
                    }
                });
                binding.o16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[1][6]);
                    }
                });
                binding.o17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[1][7]);
                    }
                });
            }

            {
                binding.o21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[2][1]);
                    }
                });
                binding.o22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[2][2]);
                    }
                });
                binding.o23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[2][3]);
                    }
                });
                binding.o24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[2][4]);
                    }
                });
                binding.o25.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[2][5]);
                    }
                });
                binding.o26.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[2][6]);
                    }
                });
                binding.o27.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[2][7]);
                    }
                });
            }

            {
                binding.o31.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[3][1]);
                    }
                });
                binding.o32.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[3][2]);
                    }
                });
                binding.o33.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[3][3]);
                    }
                });
                binding.o34.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[3][4]);
                    }
                });
                binding.o35.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[3][5]);
                    }
                });
                binding.o36.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[3][6]);
                    }
                });
                binding.o37.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[3][7]);
                    }
                });
            }

            {
                binding.o41.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[4][1]);
                    }
                });
                binding.o42.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[4][2]);
                    }
                });
                binding.o43.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[4][3]);
                    }
                });
                binding.o44.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[4][4]);
                    }
                });
                binding.o45.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[4][5]);
                    }
                });
                binding.o46.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[4][6]);
                    }
                });
                binding.o47.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[4][7]);
                    }
                });
            }

            {
                binding.o51.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[5][1]);
                    }
                });
                binding.o52.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[5][2]);
                    }
                });
                binding.o53.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[5][3]);
                    }
                });
                binding.o54.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[5][4]);
                    }
                });
                binding.o55.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[5][5]);
                    }
                });
                binding.o56.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[5][6]);
                    }
                });
                binding.o57.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[5][7]);
                    }
                });
            }

            {
                binding.o61.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[6][1]);
                    }
                });
                binding.o62.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[6][2]);
                    }
                });
                binding.o63.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[6][3]);
                    }
                });
                binding.o64.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[6][4]);
                    }
                });
                binding.o65.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[6][5]);
                    }
                });
                binding.o66.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[6][6]);
                    }
                });
                binding.o67.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show_sukien(liches[6][7]);
                    }
                });
            }

        }
        //============================================
        return binding.getRoot();

    }

    private void add(){
        Dialog dialog = new Dialog(binding.getRoot().getContext());
        dialog.setContentView(R.layout.dialog_them_sukien);
        Calendar cal_add = Calendar.getInstance();
        baothuc_gio_add = 0;
        baothuc_phut_add = 0;
        gio_add = 0;
        phut_add = 0;
        ngay_add = cal_add.get(Calendar.DATE);
        thang_add = cal_add.get(Calendar.MONTH);
        nam_add = cal_add.get(Calendar.YEAR);
        EditText name = dialog.findViewById(R.id.name);
        EditText ghichu = dialog.findViewById(R.id.ghichu);
        Button add = dialog.findViewById(R.id.them);
        Button huy = dialog.findViewById(R.id.huy);
        TextView ngay = dialog.findViewById(R.id.ngay);
        TextView gio = dialog.findViewById(R.id.gio);
        TextView gio_baothuc = dialog.findViewById(R.id.baothuc);
        CheckBox isBaothuc = dialog.findViewById(R.id.baothuc_khong);
        ngay.setText(ngay_add+"/"+(thang_add+1)+"/"+nam_add);
        gio.setText(gio_add+":"+phut_add);
        gio_baothuc.setText(baothuc_gio_add+":"+baothuc_phut_add);
        gio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(v.getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                gio_add = hourOfDay;
                                phut_add = minute;
                                ngay.setText(ngay_add+"/"+(thang_add+1)+"/"+nam_add);
                                gio.setText(gio_add+":"+phut_add);
                            }
                        },gio_add,phut_add,true);
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
                                ngay_add = dayOfMonth;
                                thang_add = month;
                                nam_add = year;
                                ngay.setText(ngay_add+"/"+(thang_add+1)+"/"+nam_add);

                            }
                        },nam_add,thang_add,ngay_add);
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
                                baothuc_gio_add = hourOfDay;
                                baothuc_phut_add = minute;
                                gio_baothuc.setText(baothuc_gio_add+":"+baothuc_phut_add);
                            }
                        },baothuc_gio_add,baothuc_phut_add,true);
                timePickerDialog.show();
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = name.getText().toString();
                String nd = ghichu.getText().toString();
                if (isBaothuc.isChecked()){
                    baothuc_add=1;
                }
                if (str.equals("")){
                    Toast.makeText(dialog.getContext(),"Tên sự kiện không thể trống" , Toast.LENGTH_LONG).show();
                }
                else{
                    dataBase.QueryData("INSERT INTO SuKien VALUES ( null ,'"+str+"' , "+ngay_add+" ,"+thang_add+" , "+nam_add+ ","+gio_add+" , "+phut_add+ " ,"+baothuc_gio_add+"," +baothuc_phut_add+","+baothuc_add+", '"+nd+"' )" );
                    dialog.dismiss();
                    show();
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

    public  static  void show(){
        tao_lich();
        show_lich();
        binding.thang.setText((thang_show+1)+"/"+nam_show);
    }

    public static void show_sukien(UTLLich lich){
        Sup_SuKien.utlLich=lich;
        int day = lich.getDay(); int month=lich.getMonyh(); int year=lich.getYear();
        Cursor data = dataBase.GetData("SELECT * FROM SuKien WHERE day="+day+" AND month="+month+" AND year=" + year);
        List<UTLSuKien> suKiens = new ArrayList<>();
        while (data.moveToNext()){
            int id = data.getInt(0);
            String name = data.getString(1);
            int ngay = data.getInt(2);
            int thang = data.getInt(3);
            int nam = data.getInt(4);
            int gio = data.getInt(5);
            int phut = data.getInt(6);
            int gio_bt = data.getInt(7);
            int phut_bt = data.getInt(8);
            int baothuc = data.getInt(9);
            String ghichu = data.getString(10);
            suKiens.add(new UTLSuKien(id,name,ngay,thang,nam,gio,phut,gio_bt,phut_bt,baothuc,ghichu));

        }
        if (day!=0){
//            if (suKiens.size()==0){
//                Toast.makeText(binding.getRoot().getContext(),"Không có sự kiện ở ngày này" , Toast.LENGTH_LONG).show();
//            }
//            else
                {
                    dialog_okok = new Dialog(binding.getRoot().getContext());
                    dialog_okok.setContentView(R.layout.dialog_show_sukien_ngay);
                TextView ngay = dialog_okok.findViewById(R.id.ngay_sk);
                ngay.setText(day+"/"+month+"/"+year);
                ListView lv = dialog_okok.findViewById(R.id.lv_sk);
                ShowSuKienAdapter adapter = new ShowSuKienAdapter(suKiens);
                lv.setAdapter(adapter);
                    dialog_okok.show();
            }
        }

    }


    public static void tao_lich(){
        cal_tao = Calendar.getInstance();
        cal_tao.set(nam_show,thang_show,1,0,7);
        for (int i=0;i<=8;i++)
            for (int j=0;j<=8;j++)
                liches[i][j] = new UTLLich();

        int[] nam_k_nhuan = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int[] nam_nhuan =  new int[] {31,29,31,30,31,30,31,31,30,31,30,31};

        int thu_bat_dau = cal_tao.get(Calendar.DAY_OF_WEEK);
        int j=0,max;
        int xong=0;

        
        if (nam_show%4!=0 || (nam_show%400!=0 && nam_show%100==0))
             max = nam_k_nhuan[thang_show];
        else
            max = nam_nhuan[thang_show];
        if (thu_bat_dau==1){
            j=7;
            liches[1][7].setDay(1);
            liches[1][7].setMonyh(thang_show);
            liches[1][7].setYear(nam_show);
        }
        else {
            j=thu_bat_dau-1;
            liches[1][thu_bat_dau-1].setDay(1);
            liches[1][thu_bat_dau-1].setMonyh(thang_show);
            liches[1][thu_bat_dau-1].setYear(nam_show);
        }
        int trc;
        for (int i=1;i<=7;i++)
        {
            for (;j<=7;j++)
            {

                if (liches[i][j].getDay()==0 && xong==0){
                    if (j==1){
                        trc=liches[i-1][7].getDay();
                    }
                    else
                        trc=liches[i][j-1].getDay();
                    if (trc < max ){
                        liches[i][j].setDay(trc+1);
                        liches[i][j].setMonyh(thang_show);
                        liches[i][j].setYear(nam_show);
                    }
                    else {
                        xong=1;
                    }
                }
            }
            j=1;
        }
    }


    public static void show_lich(){
        show_xoa();
        if (liches[1][1].getDay() !=0 )
            binding.o11.setText(liches[1][1].getDay()+"");
        if (liches[1][2].getDay() !=0 )
            binding.o12.setText(liches[1][2].getDay()+"");
        if (liches[1][3].getDay() !=0 )
            binding.o13.setText(liches[1][3].getDay()+"");
        if (liches[1][4].getDay() !=0 )
            binding.o14.setText(liches[1][4].getDay()+"");
        if (liches[1][5].getDay() !=0 )
            binding.o15.setText(liches[1][5].getDay()+"");
        if (liches[1][6].getDay() !=0 )
            binding.o16.setText(liches[1][6].getDay()+"");
        if (liches[1][7].getDay() !=0 )
            binding.o17.setText(liches[1][7].getDay()+"");
        if (liches[2][1].getDay() !=0 )
            binding.o21.setText(liches[2][1].getDay()+"");
        if (liches[2][2].getDay() !=0 )
            binding.o22.setText(liches[2][2].getDay()+"");
        if (liches[2][3].getDay() !=0 )
            binding.o23.setText(liches[2][3].getDay()+"");
        if (liches[2][4].getDay() !=0 )
            binding.o24.setText(liches[2][4].getDay()+"");
        if (liches[2][5].getDay() !=0 )
            binding.o25.setText(liches[2][5].getDay()+"");
        if (liches[2][6].getDay() !=0 )
            binding.o26.setText(liches[2][6].getDay()+"");
        if (liches[2][7].getDay() !=0 )
            binding.o27.setText(liches[2][7].getDay()+"");
        if (liches[3][1].getDay() !=0 )
            binding.o31.setText(liches[3][1].getDay()+"");
        if (liches[3][2].getDay() !=0 )
            binding.o32.setText(liches[3][2].getDay()+"");
        if (liches[3][3].getDay() !=0 )
            binding.o33.setText(liches[3][3].getDay()+"");
        if (liches[3][4].getDay() !=0 )
            binding.o34.setText(liches[3][4].getDay()+"");
        if (liches[3][5].getDay() !=0 )
            binding.o35.setText(liches[3][5].getDay()+"");
        if (liches[3][6].getDay() !=0 )
            binding.o36.setText(liches[3][6].getDay()+"");
        if (liches[3][7].getDay() !=0 )
            binding.o37.setText(liches[3][7].getDay()+"");
        if (liches[4][1].getDay() !=0 )
            binding.o41.setText(liches[4][1].getDay()+"");
        if (liches[4][2].getDay() !=0 )
            binding.o42.setText(liches[4][2].getDay()+"");
        if (liches[4][3].getDay() !=0 )
            binding.o43.setText(liches[4][3].getDay()+"");
        if (liches[4][4].getDay() !=0 )
            binding.o44.setText(liches[4][4].getDay()+"");
        if (liches[4][5].getDay() !=0 )
            binding.o45.setText(liches[4][5].getDay()+"");
        if (liches[4][6].getDay() !=0 )
            binding.o46.setText(liches[4][6].getDay()+"");
        if (liches[4][7].getDay() !=0 )
            binding.o47.setText(liches[4][7].getDay()+"");
        if (liches[5][1].getDay() !=0 )
            binding.o51.setText(liches[5][1].getDay()+"");
        if (liches[5][2].getDay() !=0 )
            binding.o52.setText(liches[5][2].getDay()+"");
        if (liches[5][3].getDay() !=0 )
            binding.o53.setText(liches[5][3].getDay()+"");
        if (liches[5][4].getDay() !=0 )
            binding.o54.setText(liches[5][4].getDay()+"");
        if (liches[5][5].getDay() !=0 )
            binding.o55.setText(liches[5][5].getDay()+"");
        if (liches[5][6].getDay() !=0 )
            binding.o56.setText(liches[5][6].getDay()+"");
        if (liches[5][7].getDay() !=0 )
            binding.o57.setText(liches[5][7].getDay()+"");
        if (liches[6][1].getDay() !=0 )
            binding.o61.setText(liches[6][1].getDay()+"");
        if (liches[6][2].getDay() !=0 )
            binding.o62.setText(liches[6][2].getDay()+"");
        if (liches[6][3].getDay() !=0 )
            binding.o63.setText(liches[6][3].getDay()+"");
        if (liches[6][4].getDay() !=0 )
            binding.o64.setText(liches[6][4].getDay()+"");
        if (liches[6][5].getDay() !=0 )
            binding.o65.setText(liches[6][5].getDay()+"");
        if (liches[6][6].getDay() !=0 )
            binding.o66.setText(liches[6][6].getDay()+"");
        if (liches[6][7].getDay() !=0 )
            binding.o67.setText(liches[6][7].getDay()+"");
        tomau_sukien(liches[1][1],binding.o11);
        tomau_sukien(liches[1][2],binding.o12);
        tomau_sukien(liches[1][3],binding.o13);
        tomau_sukien(liches[1][4],binding.o14);
        tomau_sukien(liches[1][5],binding.o15);
        tomau_sukien(liches[1][6],binding.o16);
        tomau_sukien(liches[1][7],binding.o17);
        tomau_sukien(liches[2][1],binding.o21);
        tomau_sukien(liches[2][2],binding.o22);
        tomau_sukien(liches[2][3],binding.o23);
        tomau_sukien(liches[2][4],binding.o24);
        tomau_sukien(liches[2][5],binding.o25);
        tomau_sukien(liches[2][6],binding.o26);
        tomau_sukien(liches[2][7],binding.o27);
        tomau_sukien(liches[3][1],binding.o31);
        tomau_sukien(liches[3][2],binding.o32);
        tomau_sukien(liches[3][3],binding.o33);
        tomau_sukien(liches[3][4],binding.o34);
        tomau_sukien(liches[3][5],binding.o35);
        tomau_sukien(liches[3][6],binding.o36);
        tomau_sukien(liches[3][7],binding.o37);
        tomau_sukien(liches[4][1],binding.o41);
        tomau_sukien(liches[4][2],binding.o42);
        tomau_sukien(liches[4][3],binding.o43);
        tomau_sukien(liches[4][4],binding.o44);
        tomau_sukien(liches[4][5],binding.o45);
        tomau_sukien(liches[4][6],binding.o46);
        tomau_sukien(liches[4][7],binding.o47);
        tomau_sukien(liches[5][1],binding.o51);
        tomau_sukien(liches[5][2],binding.o52);
        tomau_sukien(liches[5][3],binding.o53);
        tomau_sukien(liches[5][4],binding.o54);
        tomau_sukien(liches[5][5],binding.o55);
        tomau_sukien(liches[5][6],binding.o56);
        tomau_sukien(liches[5][7],binding.o57);
        tomau_sukien(liches[6][1],binding.o61);
        tomau_sukien(liches[6][2],binding.o62);
        tomau_sukien(liches[6][3],binding.o63);
        tomau_sukien(liches[6][4],binding.o64);
        tomau_sukien(liches[6][5],binding.o65);
        tomau_sukien(liches[6][6],binding.o66);
        tomau_sukien(liches[6][7],binding.o67);

    }


    @SuppressLint("ResourceAsColor")
    public static void tomau_sukien(UTLLich lich, TextView oo){
        Calendar cal_homnay =  Calendar.getInstance();
        int day = lich.getDay(); int month=lich.getMonyh(); int year=lich.getYear();
        if (day==cal_homnay.get(Calendar.DAY_OF_MONTH) && month==cal_homnay.get(Calendar.MONTH) && year==cal_homnay.get(Calendar.YEAR))
        {
            oo.setBackgroundResource(R.color.hom_nay_sukien);
        }
        Cursor data = dataBase.GetData("SELECT * FROM SuKien WHERE day="+day+" AND month="+month+" AND year=" + year);
        String id ="";
        while (data.moveToNext()){
            id = data.getString(1);
        }
        if (!id.equals("") ) {
            oo.setBackgroundResource(lich_sukien);
            return;
        }
        oo.setBackground(null);
        return;

    }


    @SuppressLint("ResourceAsColor")
    public static void show_xoa(){
        binding.o11.setText("");
        binding.o12.setText("");
        binding.o13.setText("");
        binding.o14.setText("");
        binding.o15.setText("");
        binding.o16.setText("");
        binding.o17.setText("");
        binding.o51.setText("");
        binding.o52.setText("");
        binding.o53.setText("");
        binding.o54.setText("");
        binding.o55.setText("");
        binding.o56.setText("");
        binding.o57.setText("");
        binding.o61.setText("");
        binding.o62.setText("");
        binding.o63.setText("");
        binding.o64.setText("");
        binding.o65.setText("");
        binding.o66.setText("");
        binding.o67.setText("");

//        binding.o11.setTextColor(R.color.black);
//        binding.o12.setTextColor(R.color.black);
//        binding.o13.setTextColor(R.color.black);
//        binding.o14.setTextColor(R.color.black);
//        binding.o15.setTextColor(R.color.black);
//        binding.o16.setTextColor(R.color.lich_red);
//        binding.o17.setTextColor(R.color.lich_red);
//
//        binding.o21.setTextColor(R.color.black);
//        binding.o22.setTextColor(R.color.black);
//        binding.o23.setTextColor(R.color.black);
//        binding.o24.setTextColor(R.color.black);
//        binding.o25.setTextColor(R.color.black);
//        binding.o26.setTextColor(R.color.lich_red);
//        binding.o27.setTextColor(R.color.lich_red);
//
//        binding.o31.setTextColor(R.color.black);
//        binding.o32.setTextColor(R.color.black);
//        binding.o33.setTextColor(R.color.black);
//        binding.o34.setTextColor(R.color.black);
//        binding.o35.setTextColor(R.color.black);
//        binding.o36.setTextColor(R.color.lich_red);
//        binding.o37.setTextColor(R.color.lich_red);
//
//        binding.o41.setTextColor(R.color.black);
//        binding.o42.setTextColor(R.color.black);
//        binding.o43.setTextColor(R.color.black);
//        binding.o44.setTextColor(R.color.black);
//        binding.o45.setTextColor(R.color.black);
//        binding.o46.setTextColor(R.color.lich_red);
//        binding.o47.setTextColor(R.color.lich_red);
//
//        binding.o51.setTextColor(R.color.black);
//        binding.o52.setTextColor(R.color.black);
//        binding.o53.setTextColor(R.color.black);
//        binding.o54.setTextColor(R.color.black);
//        binding.o55.setTextColor(R.color.black);
//        binding.o56.setTextColor(R.color.lich_red);
//        binding.o57.setTextColor(R.color.lich_red);
//
//        binding.o61.setTextColor(R.color.black);
//        binding.o62.setTextColor(R.color.black);
//        binding.o63.setTextColor(R.color.black);
//        binding.o64.setTextColor(R.color.black);
//        binding.o65.setTextColor(R.color.black);
//        binding.o66.setTextColor(R.color.lich_red);
//        binding.o67.setTextColor(R.color.lich_red);

    }


}