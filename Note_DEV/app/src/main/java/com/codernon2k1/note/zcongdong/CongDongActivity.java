package com.codernon2k1.note.zcongdong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.codernon2k1.note.R;
import com.codernon2k1.note.chat.ChatActivity;
import com.codernon2k1.note.chat.chat.ProfileActivity;
import com.codernon2k1.note.chat.chat.userprofile;
import com.codernon2k1.note.databinding.ActivityCongDongBinding;
import com.codernon2k1.note.zcongdong.activity.CongDongAdapter;
import com.codernon2k1.note.zhome.MainActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class CongDongActivity extends AppCompatActivity {

    public static ActivityCongDongBinding binding;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    FirebaseFirestore firebaseFirestore;
    private String ImageURIacessToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCongDongBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseFirestore= FirebaseFirestore.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseStorage= FirebaseStorage.getInstance();

        storageReference=firebaseStorage.getReference();
        storageReference.child("Images").child(firebaseAuth.getUid()).child("Profile Pic").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                ImageURIacessToken=uri.toString();
                Picasso.get().load(ImageURIacessToken).into(binding.viewuserimageinimageview);
            }
        });

        DatabaseReference databaseReference=firebaseDatabase.getReference(firebaseAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userprofile muserprofile=snapshot.getValue(userprofile.class);
                binding.nameUser.setText(muserprofile.getUsername());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Failed To Fetch",Toast.LENGTH_SHORT).show();
            }
        });

        binding.congdongChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ChatActivity.class));
            }
        });
        binding.viewuserimageinimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ProfileActivity.class));
            }
        });

        CongDongAdapter adapter = new CongDongAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPagerCongdong.setAdapter(adapter);
        binding.viewPagerCongdong.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        binding.bottomNaviCongdong.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;
                    case 1:
                        binding.bottomNaviCongdong.getMenu().findItem(R.id.menu_tienich).setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        binding.bottomNaviCongdong.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        binding.viewPagerCongdong.setCurrentItem(0);
                        break;
                    case R.id.menu_tienich:
                        binding.viewPagerCongdong.setCurrentItem(1);
                        break;

                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(binding.getRoot().getContext(), MainActivity.class);
        startActivity(intent);
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        DocumentReference documentReference=firebaseFirestore.collection("Users").document(firebaseAuth.getUid());
//        documentReference.update("status","Offline").addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//            }
//        });
//
//    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        DocumentReference documentReference=firebaseFirestore.collection("Users").document(firebaseAuth.getUid());
//        documentReference.update("status","Online").addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//            }
//        });
//
//    }




}