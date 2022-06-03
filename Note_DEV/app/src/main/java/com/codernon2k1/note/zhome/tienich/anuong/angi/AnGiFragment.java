package com.codernon2k1.note.zhome.tienich.anuong.angi;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.codernon2k1.note.R;
import com.codernon2k1.note.sup.data.Data_Off;
import com.codernon2k1.note.zhome.tienich.anuong.monan.MonAnDataBase;

import java.util.ArrayList;
import java.util.List;


public class AnGiFragment extends Fragment {

    View view;
    EditText noidung;
    TextView kq,lay_mon;
    Button random;
    CheckBox lay_xoa;
    public static MonAnDataBase dataBase;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_an_gi, container, false);
        dataBase = new MonAnDataBase(view.getContext() , "monan.sqlite" , null , 1);
        noidung=view.findViewById(R.id.an_gi_nhap);
        kq=view.findViewById(R.id.an_gi_kq);
        lay_mon=view.findViewById(R.id.an_gi_lay_off);
        random=view.findViewById(R.id.an_gi_random);
        lay_xoa=view.findViewById(R.id.lay_xong_xoa);
        lay_mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = new ArrayList<>();
                Cursor data = dataBase.GetData("SELECT * FROM MonAn1");
                while (data.moveToNext()){
                    String name = data.getString(1);
                    list.add(name);
                }

                String str= "";
                for (String i : list){
                    str = i+"\n"+str;
                }
                noidung.setText(str);
            }
        });


        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data_Off.angiList.clear();
                String str = noidung.getText().toString().trim();
                if (!str.equals("")){
                    String strings="";
                    for (int i=0;i<str.length();i++){
                        if ( str.charAt(i)=='\n'  ){
                            Data_Off.angiList.add(strings);
                            strings="";
                        }
                        else
                        {
                            strings+=str.charAt(i);
                        }
                    }
                    if (strings!=""){
                        Data_Off.angiList.add(strings);
                    }
                    kq.setText(Randomm());
                }
            }
        });
        return view;
    }

    private String Randomm(){
        int x ;
        String kq="";
        do{
            x= (int) (Math.random()*10);
            System.out.println(x);
        }while ( x < 0 || x >= Data_Off.angiList.size());
        kq=Data_Off.angiList.get(x);
        if (lay_xoa.isChecked()){
            Data_Off.angiList.remove(x);
            Data_Off.angis="";
            for (String i :Data_Off.angiList)
                Data_Off.angis+=i+'\n';
            noidung.setText(Data_Off.angis);
        }

        return kq;
    }
}