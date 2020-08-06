package com.mahmoudjoe333.retrofitapp.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mahmoudjoe333.retrofitapp.data.PostClient;
import com.mahmoudjoe333.retrofitapp.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<PostModel>> postList=new MutableLiveData<>();

    public MutableLiveData<List<PostModel>> getPostList() {
        return postList;
    }

    public void downLoadPosts(){
        Call<List<PostModel>> Posts=PostClient.getInstance().getPosts();
        Posts.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });
    }
    public Object uploadPost(PostModel post){
        Call<PostModel> mpost=PostClient.getInstance().postPosts(post);
        final Object[] obj = new Object[1];
        mpost.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                obj[0] =new PostModel(response.body());
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                obj[0]=t.getMessage();
            }
        });
        return obj[0];
    }

}
