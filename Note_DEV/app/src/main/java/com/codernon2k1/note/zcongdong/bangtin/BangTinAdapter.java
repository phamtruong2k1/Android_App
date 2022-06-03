package com.codernon2k1.note.zcongdong.bangtin;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.codernon2k1.note.R;
import com.codernon2k1.note.chat.chat.userprofile;
import com.codernon2k1.note.sup.data.Config;
import com.codernon2k1.note.sup.utl.BaiViet;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BangTinAdapter extends BaseAdapter {
    List<BaiViet> list = new ArrayList<>();

    public BangTinAdapter(List<BaiViet> list) {
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
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    FirebaseFirestore firebaseFirestore;
    private String ImageURIacessToken;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.item_show_bai_viet,parent,false);

        firebaseFirestore= FirebaseFirestore.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseStorage= FirebaseStorage.getInstance();

        BaiViet baiViet = list.get(position);
        ImageView avt= view.findViewById(R.id.baiviet_avt);
//        Picasso.get().load(baiViet.getAvt()).into(avt);
        TextView name = view.findViewById(R.id.baiviet_name);
        TextView time = view.findViewById(R.id.baiviet_time);
        time.setText(baiViet.getTime());
        ImageView img= view.findViewById(R.id.baiviet_img);

        Picasso.get().load(baiViet.getImg()).into(img);

        TextView status = view.findViewById(R.id.baiviet_status);
        status.setText(baiViet.getStatus());
        TextView liked = view.findViewById(R.id.baiviet_liked);
        liked.setText(baiViet.getLiked()+"");
        TextView disliked = view.findViewById(R.id.baiviet_disliked);
        disliked.setText(baiViet.getDisliked()+"");

        storageReference=firebaseStorage.getReference();
        storageReference.child("Images").child(baiViet.getId_user()).child("Profile Pic").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                ImageURIacessToken=uri.toString();
                Picasso.get().load(ImageURIacessToken).into(avt);
            }
        });

        DatabaseReference databaseReference=firebaseDatabase.getReference(baiViet.getId_user());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userprofile muserprofile=snapshot.getValue(userprofile.class);
                name.setText(muserprofile.getUsername());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });



//        Button sua = view.findViewById(R.id.baiviet_sua);
//        sua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        ImageView an_like= view.findViewById(R.id.baiviet_an_liked);
        an_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baiViet.setLiked(baiViet.getLiked()+1);
                liked.setText(baiViet.getLiked()+"");
                updata_bai(baiViet.getBaivietId(),baiViet.getLiked(),baiViet.getDisliked());
            }
        });
        ImageView an_dislike= view.findViewById(R.id.baiviet_an_disliked);
        an_dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baiViet.setDisliked(baiViet.getDisliked()+1);
                disliked.setText(baiViet.getDisliked()+"");
                updata_bai(baiViet.getBaivietId(),baiViet.getLiked(),baiViet.getDisliked());
            }
        });

        return view;
    }


    public void  updata_bai(int id , int x , int y){
        RequestQueue queue = Volley.newRequestQueue(view.getContext());
        StringRequest request = new StringRequest(Request.Method.PATCH , Config.url_baiviet_uplike, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse response = error.networkResponse;
                if (error instanceof ServerError && response != null) {
                    try {
                        String res = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                        // Now you can use any deserializer to make sense of data
                        JSONObject obj = new JSONObject(res);
                    } catch (UnsupportedEncodingException e1) {
                        // Couldn't properly decode data to string
                        e1.printStackTrace();
                    } catch (JSONException e2) {
                        // returned data is not JSONObject?
                        e2.printStackTrace();
                    }
                }
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("id", id+"");
                params.put("liked", x+"");
                params.put("disliked", y+"");
                return params;
            }
        };
        queue.add(request);
    }
}
