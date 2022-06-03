package com.codernon2k1.note.zhome.zchitieu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.ActivityChiTieuBinding;
import com.codernon2k1.note.zhome.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ChiTieuActivity extends AppCompatActivity {

    public  static ActivityChiTieuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChiTieuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ChiTieuAdapter adapter = new ChiTieuAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPagerChiTieu.setAdapter(adapter);
        binding.viewPagerChiTieu.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        binding.bottomNaviChiTieu.getMenu().findItem(R.id.menu_chi_tieu).setChecked(true);
                        break;
                    case 1:
                        binding.bottomNaviChiTieu.getMenu().findItem(R.id.menu_thu_nhap).setChecked(true);
                        break;
                    case 2:
                        binding.bottomNaviChiTieu.getMenu().findItem(R.id.menu_thong_ke).setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        binding.bottomNaviChiTieu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_chi_tieu:
                        binding.viewPagerChiTieu.setCurrentItem(0);
                        break;
                    case R.id.menu_thu_nhap:
                        binding.viewPagerChiTieu.setCurrentItem(1);
                        break;
                    case R.id.menu_thong_ke:
                        binding.viewPagerChiTieu.setCurrentItem(2);
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