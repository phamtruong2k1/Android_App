package com.codernon2k1.note.zhome.tienich.anuong;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.codernon2k1.note.zhome.tienich.anuong.angi.AnGiFragment;
import com.codernon2k1.note.zhome.tienich.anuong.monan.MonAnFragment;
import com.codernon2k1.note.zhome.tienich.anuong.tinhtoan.TinhToanFragment;

public class AnUongAdapter extends FragmentStatePagerAdapter {

    public AnUongAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MonAnFragment();
            case 1:
                return new AnGiFragment();
            case 2:
                return new TinhToanFragment();
            default:
                return new MonAnFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
