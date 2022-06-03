package com.codernon2k1.note.chat.chat;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.codernon2k1.note.chat.call.CallFragment;
import com.codernon2k1.note.chat.chat.ChatFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabcount;




    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;




    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new ChatFragment();


            case 1:

                return new CallFragment();


            default:
                return null;
        }



    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
