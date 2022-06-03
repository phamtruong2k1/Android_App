package com.codernon2k1.note.zcongdong.thongtin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.codernon2k1.note.R;
import com.codernon2k1.note.databinding.FragmentBangTinBinding;
import com.codernon2k1.note.databinding.FragmentThongTinBinding;
import com.codernon2k1.note.zcongdong.support.Data_User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class ThongTinFragment extends Fragment {

    public static FragmentThongTinBinding binding;

    private EditText mnewusername;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;


    private FirebaseFirestore firebaseFirestore;

    private ImageView mgetnewimageinimageview;

    private StorageReference storageReference;

    private String ImageURIacessToken;

    private androidx.appcompat.widget.Toolbar mtoolbarofupdateprofile;
    private ImageButton mbackbuttonofupdateprofile;


    private FirebaseStorage firebaseStorage;


    ProgressBar mprogressbarofupdateprofile;

    private Uri imagepath;

    Intent intent;

    private static int PICK_IMAGE=123;

    android.widget.Button mupdateprofilebutton;
    String newname;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThongTinBinding.inflate(inflater, container, false);

        firebaseAuth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        firebaseStorage= FirebaseStorage.getInstance();
        firebaseFirestore= FirebaseFirestore.getInstance();

        return binding.getRoot();
    }



}