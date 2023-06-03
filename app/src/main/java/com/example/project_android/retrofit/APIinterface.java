package com.example.project_android.retrofit;




import com.example.project_android.Entity.Resource;
import com.example.project_android.Entity.UserEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface APIinterface {

    @GET("api/unknown")
    Call<Resource> getResourcesList();

    @GET("api/users?")
    Call<UserEntity> getUserData(@Query("page") String page);

//    @GET("/api/unknown")
//    Call<Datum> getDatumList();
}
