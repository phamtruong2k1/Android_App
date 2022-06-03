package com.codernon2k1.note.zcongdong.singin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.codernon2k1.note.R;
import com.codernon2k1.note.chat.ChatActivity;
import com.codernon2k1.note.databinding.ActivityCongDongBinding;
import com.codernon2k1.note.databinding.ActivityDangNhapBinding;
import com.codernon2k1.note.zcongdong.activity.CongDongAdapter;
import com.codernon2k1.note.zhome.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DangNhapActivity extends AppCompatActivity {

    public static ActivityDangNhapBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDangNhapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DangNhapAdapter adapter = new DangNhapAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPagerDangnhap.setAdapter(adapter);
        binding.viewPagerDangnhap.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        binding.bottomNaviDangnhap.getMenu().findItem(R.id.menu_signin).setChecked(true);
                        break;
                    case 1:
                        binding.bottomNaviDangnhap.getMenu().findItem(R.id.menu_signout).setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        binding.bottomNaviDangnhap.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_signin:
                        binding.viewPagerDangnhap.setCurrentItem(0);
                        break;
                    case R.id.menu_signout:
                        binding.viewPagerDangnhap.setCurrentItem(1);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(binding.getRoot().getContext(), MainActivity.class);
        startActivity(intent);
    }

}