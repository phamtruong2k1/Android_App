package com.codernon2k1.note.zcongdong.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.codernon2k1.note.zcongdong.banbe.FriendFragment;
import com.codernon2k1.note.zcongdong.bangtin.BangTinFragment;
import com.codernon2k1.note.zcongdong.thongtin.ThongTinFragment;
import com.codernon2k1.note.zcongdong.tienich.TienIchFragment;

public class CongDongAdapter extends FragmentStatePagerAdapter {

    public  CongDongAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new BangTinFragment();
//            case 1:
//                return new FriendFragment();
            case 1:
                return new TienIchFragment();
//            case 2:
//                return new ThongTinFragment();
            default:
                return new BangTinFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
