package com.example.project_android.retrofit;

import com.example.project_android.Entity.Resource;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("users")
    Call<Pojo> getData();

}
