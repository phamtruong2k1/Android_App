package com.codernon2k1.note.chat;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.codernon2k1.note.chat.call.CallFragment;
import com.codernon2k1.note.chat.chat.ChatFragment;
import com.codernon2k1.note.zhome.tienich.anuong.angi.AnGiFragment;
import com.codernon2k1.note.zhome.tienich.anuong.monan.MonAnFragment;
import com.codernon2k1.note.zhome.tienich.anuong.tinhtoan.TinhToanFragment;

public class ChatAdapter extends FragmentStatePagerAdapter {
    public ChatAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ChatFragment();
            case 1:
                return new CallFragment();
            default:
                return new ChatFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
