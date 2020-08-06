package com.mahmoudjoe333.retrofitapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mahmoudjoe333.retrofitapp.R;
import com.mahmoudjoe333.retrofitapp.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainViewModel viewModel;
    RecyclerView recyclerView;
    PostAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel= ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.downLoadPosts();//fill live data
        buildRecycle();

        viewModel.getPostList().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });
    }

    private void buildRecycle() {
        recyclerView=findViewById(R.id.container);
        adapter=new PostAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();
    }
}