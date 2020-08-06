package com.mahmoudjoe333.retrofitapp.data;

import com.mahmoudjoe333.retrofitapp.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static final String BaseUrl="http://jsonplaceholder.typicode.com/";
    private PostFace postFace;
    private static PostClient instance;

    public PostClient() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postFace=retrofit.create(PostFace.class);

    }

    public static PostClient getInstance(){
        if(instance==null)
            instance=new PostClient();
        return instance;
    }

    public Call<List<PostModel>> getPosts(){
        return postFace.getPosts();
    }
    public Call<PostModel> postPosts(PostModel post){
        return postFace.postPosts(post);
    }
}
