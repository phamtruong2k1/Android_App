package com.codernon2k1.note.zcongdong.singin;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.codernon2k1.note.zcongdong.banbe.FriendFragment;
import com.codernon2k1.note.zcongdong.bangtin.BangTinFragment;
import com.codernon2k1.note.zcongdong.thongtin.ThongTinFragment;
import com.codernon2k1.note.zcongdong.tienich.TienIchFragment;

public class DangNhapAdapter extends FragmentStatePagerAdapter {

    public  DangNhapAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LoginFragment();
            case 1:
                return new LogoutFragment();
            default:
                return new LoginFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
