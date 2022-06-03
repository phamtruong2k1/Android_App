package com.codernon2k1.note.zhome.zthoikhoabieu.acti;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.codernon2k1.note.zhome.zthoikhoabieu.sukien.SuKienFragment;
import com.codernon2k1.note.zhome.zthoikhoabieu.thoigianbieu.ThoiGianBieuFragment;


public class ThoiKhoaBieuAdapter extends FragmentStatePagerAdapter {


    public ThoiKhoaBieuAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ThoiGianBieuFragment();
            case 1:
                return new SuKienFragment();
            default:
                return new ThoiGianBieuFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
