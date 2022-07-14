package com.example.callapi.Api;

import com.example.callapi.model.Curroncy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    // khoi tao gson
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    // khoi tao retrofit
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://www.episodate.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);

    @GET("api/live")
    Call<Curroncy>convertUsdtoVND(@Query("access_key") String access_key,
                                  @Query("currencies") String currencies,
                                  @Query("source") String source,
                                  @Query("format") int format);

//    // cach 2 : su dung duong dan luon (  https://www.episodate.com/api/most-popular?page=1)
    @GET("most-popular?page=1")
    Call<Curroncy> convertUSDtoVND1();
//
//    // su dung map
//    @GET("api/live")
// ================================ CAC LOAI PHUONG THUC GET ======================

    // http://apilayer.net/api/users/list;
    Call<Curroncy>getListUserFromGround();

    // http://apilayer.net/api/ground/1/users
    Call<List<Curroncy>> groupList(@Path("id") int groupId);

    //  http://apilayer.net/api/ground/1/users?sort = desc
    Call<List<Curroncy>>getListUserFrom(@Path("id") int ground, @Query("sort") String sort);

}
