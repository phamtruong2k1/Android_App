package com.codernon2k1.note.zhome.zthoikhoabieu.acti;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.ActivityThoiKhoaBieuBinding;
import com.codernon2k1.note.zhome.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Collections;


public class ThoiKhoaBieuActivity extends AppCompatActivity {

    public  static ActivityThoiKhoaBieuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThoiKhoaBieuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ThoiKhoaBieuAdapter adapter = new ThoiKhoaBieuAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPagerTkb.setAdapter(adapter);
        binding.viewPagerTkb.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        binding.bottomNaviTkb.getMenu().findItem(R.id.menu_tkb).setChecked(true);
                        break;
                    case 1:
                        binding.bottomNaviTkb.getMenu().findItem(R.id.menu_sukien).setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        binding.bottomNaviTkb.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_tkb:
                        binding.viewPagerTkb.setCurrentItem(0);
                        break;
                    case R.id.menu_sukien:
                        binding.viewPagerTkb.setCurrentItem(1);
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