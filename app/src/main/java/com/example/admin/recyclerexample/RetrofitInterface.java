package com.example.admin.recyclerexample;


import android.util.Log;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.GET;




public interface RetrofitInterface {

    @GET("https://jsonplaceholder.typicode.com/users/")
    public Call<List<Example>> getAllPost();


}