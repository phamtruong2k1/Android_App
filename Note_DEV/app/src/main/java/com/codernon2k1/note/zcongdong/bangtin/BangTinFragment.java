package com.codernon2k1.note.zcongdong.bangtin;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.codernon2k1.note.R;
import com.codernon2k1.note.sup.data.Config;
import com.codernon2k1.note.sup.data.JsonVolley;
import com.codernon2k1.note.databinding.FragmentBangTinBinding;
import com.codernon2k1.note.profile.RealPathUtil;
import com.codernon2k1.note.sup.utl.BaiViet;
import com.codernon2k1.note.zcongdong.support.Data_User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;


public class BangTinFragment extends Fragment {

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    FirebaseFirestore firebaseFirestore;

    public static  FragmentBangTinBinding binding;
    public static List<BaiViet> baiVietList=new ArrayList<>();

    public static String str_status;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentBangTinBinding.inflate(inflater, container, false);

        binding.dangBangtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dangbai();

            }
        });

        binding.tailaiBangtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                laybaiviet();
            }
        });
        laybaiviet();
        return binding.getRoot();
    }

    public  void Dangbai(){
        Dialog dialog = new Dialog(binding.getRoot().getContext());
        dialog.setContentView(R.layout.dialog_dangtin);
        img = dialog.findViewById(R.id.anh);
        EditText noidung = dialog.findViewById(R.id.status);
        Button dang = dialog.findViewById(R.id.dang);
        Button huy = dialog.findViewById(R.id.huy);
        dang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_status = noidung.getText().toString();
                callAPI_up_AVT();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        laybaiviet();
                    }
                },3000);
                dialog.dismiss();
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRequestPermission();
            }
        });
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }



    public void laybaiviet(){
        baiVietList.clear();
        baiVietList=new ArrayList<>();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Config.url_baiviet, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            System.out.println(response);
                            for (int i = response.length()-1; i>=0 ; i--) {
                                JSONObject jsonObject1 = response.getJSONObject(i);
                                int baivietId = jsonObject1.getInt("baivietId");
                                String id_user = jsonObject1.getString("id_user");
                                String time = jsonObject1.getString("time");
                                String img = jsonObject1.getString("img");
                                String status = jsonObject1.getString("status");
                                int liked = jsonObject1.getInt("liked");
                                int disliked = jsonObject1.getInt("disliked");
                                baiVietList.add(new BaiViet(baivietId,id_user,time,img,status,liked,disliked));
                            }
                            BangTinAdapter adapter = new BangTinAdapter(baiVietList);
                            binding.lvBangtin.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        JsonVolley.getInstance(this.getContext()).getRequestQueue().add(request);
    }

    Uri muri;
    public static ImageView img;
    private static final int MY_REQUEST_CODE = 10;
    private static final String TAG = BangTinFragment.class.getName();
    private ActivityResultLauncher<Intent> mActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.e(TAG,"onActivityResult");
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        if (data==null){
                            return;
                        }
                        Uri uri = data.getData();
                        muri=uri;
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(binding.getRoot().getContext().getContentResolver(),uri);
                            img.setBackground(null);
                            img.setImageBitmap(bitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

    );
    private void callAPI_up_AVT() {
        firebaseFirestore= FirebaseFirestore.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseStorage= FirebaseStorage.getInstance();
        Calendar cal = Calendar.getInstance();
        String time = "";
        time+=cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.HOUR)+"-";
        time+=cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR);

        RequestBody requestBodyidUser =  RequestBody.create(MediaType.parse("multipart/from-data") , ( firebaseAuth.getUid()));

        RequestBody requestBodytime =  RequestBody.create(MediaType.parse("multipart/from-data") , ( time ));

        RequestBody requestBodystatus =  RequestBody.create(MediaType.parse("multipart/from-data") , ( str_status ));

        String strRealPath = RealPathUtil.getRealPath(binding.getRoot().getContext(),muri);
        Log.e("Okla",strRealPath);

        File file = new File(strRealPath);

        RequestBody requestBodyimg = RequestBody.create(MediaType.parse("multipart/from-data") , file );
        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("img" , file.getName() , requestBodyimg);
        ApiService_DangBai.apiSever.registerAcc( requestBodyidUser,requestBodytime, multipartBody ,requestBodystatus).enqueue(new Callback<BaiViet>() {
            @Override
            public void onResponse(Call<BaiViet> call, retrofit2.Response<BaiViet> response) {
                Toast.makeText(binding.getRoot().getContext(),"Đăng thành công" ,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<BaiViet> call, Throwable t) {

            }
        });
    }
    private void onClickRequestPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            openGallery();
            return;
        }


        if (binding.getRoot().getContext().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            openGallery();
        }else{
            String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
            requestPermissions(permission, MY_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_REQUEST_CODE){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openGallery();
            }
        }


    }

    private void openGallery(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        mActivityResultLauncher.launch(Intent.createChooser(intent,"Select AVT"));
    }


}