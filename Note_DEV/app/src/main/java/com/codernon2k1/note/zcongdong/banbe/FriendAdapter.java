package com.codernon2k1.note.zcongdong.banbe;

import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codernon2k1.note.R;
import com.codernon2k1.note.chat.ChatActivity;
import com.codernon2k1.note.sup.utl.User;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FriendAdapter extends BaseAdapter {
    List<User> list = new ArrayList<>();

    public FriendAdapter(List<User> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    View view;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.item_show_banbe,parent,false);
        LinearLayout layout = view.findViewById(R.id.show_friend);
        User user = list.get(position);
        ImageView avt = view.findViewById(R.id.avt_friend);
        TextView name = view.findViewById(R.id.name_friend);
        TextView id = view.findViewById(R.id.id_friend);
        name.setText(user.getName_in_app());
        id.setText(user.getId()+"");
        Picasso.get().load(user.getAvt()).into(avt);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_show_ad_friend);
                ImageView avt=dialog.findViewById(R.id.imageviewofuser); ;
                TextView name=dialog.findViewById(R.id.name_in_app);
                TextView sex=dialog.findViewById(R.id.sex);
                TextView quenquan=dialog.findViewById(R.id.quequan);
                TextView honnhan=dialog.findViewById(R.id.honnhan);
                TextView status=dialog.findViewById(R.id.status);
                TextView accid = dialog.findViewById(R.id.accid);
                accid.setText(user.getId()+"");

                Picasso.get().load(user.getAvt()).into(avt);
                name.setText(user.getName_in_app());
                sex.setText(user.getSex());
                quenquan.setText(user.getQuenquan());
                honnhan.setText(user.getHonnhan());
                status.setText(user.getStatus());
                Button chat = dialog.findViewById(R.id.chat);
                chat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(view.getContext(), ChatActivity.class);
                        startActivity(intent);
                    }

                    private void startActivity(Intent intent) {
                        view.getContext().startActivity(intent, null);
                    }
                });

                dialog.show();
            }
        });

        return view;
    }


}
