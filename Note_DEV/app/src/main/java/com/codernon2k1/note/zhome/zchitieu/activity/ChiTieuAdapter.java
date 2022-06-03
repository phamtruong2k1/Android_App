package com.codernon2k1.note.zhome.zchitieu.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.codernon2k1.note.zhome.zchitieu.chitieu.ChiTieuFragment;
import com.codernon2k1.note.zhome.zchitieu.thongke.ThongKeFragment;
import com.codernon2k1.note.zhome.zchitieu.thunhap.ThuNhapFragment;

public class ChiTieuAdapter extends FragmentStatePagerAdapter {

    public  ChiTieuAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ChiTieuFragment();
            case 1:
                return new ThuNhapFragment();
            case 2:
                return new ThongKeFragment();
            default:
                return new ChiTieuFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}

