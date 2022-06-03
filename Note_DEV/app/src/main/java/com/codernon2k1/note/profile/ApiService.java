package com.codernon2k1.note.profile;

import com.codernon2k1.note.sup.utl.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.Part;

public interface ApiService {
    public  static final String DOMAIN = "http://192.168.31.113:8080/api/acc/";

    Gson gson = new GsonBuilder().setDateFormat("yyyy MM dd HH:mm::ss").create();


    ApiService apiSever = new Retrofit.Builder()
            .baseUrl(DOMAIN)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @Multipart
    @PATCH("update/avt")
    Call<User> registerAcc (@Part("id") RequestBody id ,
                            @Part MultipartBody.Part avt
                            );
}
