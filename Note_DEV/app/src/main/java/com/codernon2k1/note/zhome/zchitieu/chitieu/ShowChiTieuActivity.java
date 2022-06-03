package com.codernon2k1.note.zhome.zchitieu.chitieu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.ActivityShowChiTieuBinding;
import com.codernon2k1.note.zhome.zchitieu.activity.ChiTieuDataBase;
import com.codernon2k1.note.zhome.zchitieu.activity.SupChiTieu;

import java.util.ArrayList;
import java.util.List;

public class ShowChiTieuActivity extends AppCompatActivity {

    public static ActivityShowChiTieuBinding binding;
    public static ChiTieuDataBase dataBase;
    public static List<UTLChiTieu> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowChiTieuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataBase = new ChiTieuDataBase( binding.getRoot().getContext() , "chitieu.sqlite" , null , 1);

        show();
        binding.thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChiTieuFragment.show();
                finish();
            }
        });

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
                        show();
                    }
                });
                nhao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_chitieu="nhao";
                        dialog.dismiss();
                        show();
                    }
                });
                muasam.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_chitieu="muasam";
                        dialog.dismiss();
                        show();
                    }
                });
                giaitri.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_chitieu="giaitri";
                        dialog.dismiss();
                        show();
                    }
                });
                khac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SupChiTieu.name_chitieu="khac";
                        dialog.dismiss();
                        show();
                    }
                });

                dialog.show();
            }
        });

        binding.left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SupChiTieu.thangct == 0 ){
                    SupChiTieu.thangct=11;
                    SupChiTieu.namct--;
                }
                else
                    SupChiTieu.thangct--;
                show();
            }
        });
        binding.right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SupChiTieu.thangct == 11 ){
                    SupChiTieu.thangct=0;
                    SupChiTieu.namct++;
                }
                else
                    SupChiTieu.thangct++;
                show();
            }
        });



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
    }


    public static void show(){
        show_chon();
        binding.thang.setText((SupChiTieu.thangct+1)+"/"+SupChiTieu.namct);
        list=new ArrayList<>();
        Cursor data = dataBase.GetData("SELECT * FROM ChiTieu WHERE ( thang = " + SupChiTieu.thangct +"  AND nam = "+ SupChiTieu.namct +" AND name = '" + SupChiTieu.name_chitieu + "' )" );
        while (data.moveToNext()){
            list.add(new UTLChiTieu(data.getInt(0),data.getString(1),data.getInt(2),data.getInt(3),data.getInt(4),data.getInt(5),data.getInt(6),data.getInt(7),data.getString(8)));
        }

        Cursor data1 = dataBase.GetData("SELECT SUM(tien) FROM ChiTieu WHERE ( thang = " + SupChiTieu.thangct +"  AND nam = "+ SupChiTieu.namct +" AND name = '" + SupChiTieu.name_chitieu + "' )" );
        int tien=0;
        while (data1.moveToNext()){
            tien= data1.getInt(0);
            System.out.println(tien);
        }
        
        for (int i=0;i<list.size()-1;i++){
            for (int j=i+1 ; j<list.size();j++){
                if (list.get(i).getNgay() < list.get(j).getNgay()){
                    UTLChiTieu tmp = list.get(i);
                    list.set(i , list.get(j));
                    list.set(j , tmp);
                }
            }
        }

        binding.tong.setText("-"+tien);
        ShowChiTieuAdapter adapter  = new ShowChiTieuAdapter(list);
        binding.lvShow.setAdapter(adapter);

    }}