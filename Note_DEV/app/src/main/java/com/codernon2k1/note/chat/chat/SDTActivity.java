package com.codernon2k1.note.chat.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.codernon2k1.note.R;
import com.codernon2k1.note.sup.network.CheckNetwork;
import com.codernon2k1.note.zcongdong.CongDongActivity;
import com.codernon2k1.note.zhome.MainActivity;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class SDTActivity extends AppCompatActivity {
    EditText mgetphonenumber;
    android.widget.Button msendotp;
    CountryCodePicker mcountrycodepicker;
    String countrycode;
    String phonenumber;
    FirebaseAuth firebaseAuth;
    ProgressBar mprogressbarofmain;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    String codesent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdt);
        mcountrycodepicker=findViewById(R.id.countrycodepicker);
        msendotp=findViewById(R.id.sendotpbutton);
        mgetphonenumber=findViewById(R.id.getphonenumber);
        mprogressbarofmain=findViewById(R.id.progressbarofmain);
        firebaseAuth= FirebaseAuth.getInstance();
        countrycode=mcountrycodepicker.getSelectedCountryCodeWithPlus();
        mcountrycodepicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                countrycode=mcountrycodepicker.getSelectedCountryCodeWithPlus();
            }
        });

        msendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number;
                number=mgetphonenumber.getText().toString();
                if(number.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập số điện thoại",Toast.LENGTH_SHORT).show();
                }
                else if(number.length()<10)
                {
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập đúng số điện thoại",Toast.LENGTH_SHORT).show();
                }
                else if (!CheckNetwork.isConnectedInternet(SDTActivity.this)){
                    Toast.makeText(SDTActivity.this,"Vui lòng kiểm tra kết nối internet" , Toast.LENGTH_LONG).show();
                }
                else
                {
                    mprogressbarofmain.setVisibility(View.VISIBLE);
                    phonenumber=countrycode+number;
                    PhoneAuthOptions options= PhoneAuthOptions.newBuilder(firebaseAuth)
                            .setPhoneNumber(phonenumber)
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setActivity(SDTActivity.this)
                            .setCallbacks(mCallbacks)
                            .build();
                    PhoneAuthProvider.verifyPhoneNumber(options);

                }


            }
        });



        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                //how to automatically fetch code here
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {

            }


            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                Toast.makeText(getApplicationContext(),"OTP đã gửi",Toast.LENGTH_SHORT).show();
                mprogressbarofmain.setVisibility(View.INVISIBLE);
                codesent=s;
                Intent intent=new Intent(SDTActivity.this, otpAuthentication.class);
                intent.putExtra("otp",codesent);
                startActivity(intent);
            }
        };



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SDTActivity.this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null)
        {
            Intent intent=new Intent(SDTActivity.this, CongDongActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

    }
}