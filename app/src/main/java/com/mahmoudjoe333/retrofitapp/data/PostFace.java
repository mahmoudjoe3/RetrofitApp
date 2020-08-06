package com.mahmoudjoe333.retrofitapp.data;

import com.mahmoudjoe333.retrofitapp.pojo.PostModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

interface PostFace {
    @GET("posts")
    Call<List<PostModel>> getPosts();

    @POST("posts")
    Call<PostModel> postPosts(@Body PostModel postModel);
}
