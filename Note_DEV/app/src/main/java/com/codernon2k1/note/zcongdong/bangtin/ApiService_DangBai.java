package com.codernon2k1.note.zcongdong.bangtin;

import com.codernon2k1.note.sup.utl.BaiViet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService_DangBai {
    public  static final String DOMAIN = "https://appnote-codernon.herokuapp.com/api/";

    Gson gson = new GsonBuilder().setDateFormat("yyyy MM dd HH:mm::ss").create();


    ApiService_DangBai apiSever = new Retrofit.Builder()
            .baseUrl(DOMAIN)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService_DangBai.class);

    @Multipart
    @POST("baiviet")
    Call<BaiViet> registerAcc (@Part("id_user") RequestBody id_user ,
                               @Part("time") RequestBody time ,
                               @Part MultipartBody.Part img ,
                               @Part("status") RequestBody status
                            );
}
