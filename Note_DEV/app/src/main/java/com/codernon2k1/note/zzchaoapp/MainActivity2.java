package com.codernon2k1.note.zzchaoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.ActivityMain2Binding;
import com.codernon2k1.note.databinding.ActivityMainBinding;
import com.codernon2k1.note.zhome.MainActivity;

import java.util.List;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    public  static SharedPreferences sharedPreferences;
    public  static SharedPreferences sharedPreferences_user;
    private static int SPLASH_TIMER=3000;
    public static ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("matkhau_ungdung",MODE_PRIVATE);
        sharedPreferences_user = getSharedPreferences("thongtin_user",MODE_PRIVATE);
        String pass = sharedPreferences.getString("noidung","");
        String ngonngu = sharedPreferences.getString("ngonngu","");
        if (!ngonngu.equals("")){
            Locale locale = new Locale(ngonngu);
            Configuration config = new Configuration();
            config.locale = locale;
            binding.getRoot().getContext().getResources().updateConfiguration(
                    config,
                    binding.getRoot().getContext().getResources().getDisplayMetrics()
            );
        }


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (pass.equals("")){
                    Intent intent=new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Dialog dialog = new Dialog(MainActivity2.this);
                    dialog.setContentView(R.layout.dialog_pass_app);
                    EditText pass_app = dialog.findViewById(R.id.pass_app_nhap);
                    Button huy = dialog.findViewById(R.id.thoat_pass_app);
                    Button nhap = dialog.findViewById(R.id.nhap_pass_app);
                    nhap.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String ed_pass = pass_app.getText().toString();
                            if (ed_pass.equals(pass)){
                                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(MainActivity2.this, "Mật khẩu sai", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                    huy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    dialog.show();
                }
            }
        },SPLASH_TIMER);

    }
}