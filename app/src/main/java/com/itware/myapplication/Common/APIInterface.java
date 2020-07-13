package com.itware.myapplication.Common;

import com.itware.myapplication.ui.models.ModelClass;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface APIInterface {

    @GET("data")
     Call<ModelClass> getList();

}
