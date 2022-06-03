package com.codernon2k1.note.zhome.tienich.anuong;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.codernon2k1.note.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class AnUongActivity extends AppCompatActivity {

    ViewPager viewPagerMain;
    BottomNavigationView bottomNaviMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_uong);
        viewPagerMain=findViewById(R.id.view_pager_an_uong);
        bottomNaviMain=findViewById(R.id.bottom_navi_an_uong);



        AnUongAdapter adapter = new AnUongAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerMain.setAdapter(adapter);
        viewPagerMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNaviMain.getMenu().findItem(R.id.menu_monan).setChecked(true);
                        break;
                    case 1:
                        bottomNaviMain.getMenu().findItem(R.id.menu_angi).setChecked(true);
                        break;
                    case 2:
                        bottomNaviMain.getMenu().findItem(R.id.menu_tinhtoan).setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNaviMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_monan:
                        viewPagerMain.setCurrentItem(0);
                        break;
                    case R.id.menu_angi:
                        viewPagerMain.setCurrentItem(1);
                        break;
                    case R.id.menu_tinhtoan:
                        viewPagerMain.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }
}