package com.mahmoudjoe333.retrofitapp.ui.main;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.mahmoudjoe333.retrofitapp.R;
import com.mahmoudjoe333.retrofitapp.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private ArrayList<PostModel> mlist = new ArrayList<>();
    private Resources mresources;

    public void setList(List<PostModel> list) {
        this.mlist = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    public void setRes(Resources res) {
        mresources = res;
    }

    public PostModel getItemAt(int position) {
        return mlist.get(position);
    }


    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        PostHolder PostHolder = new PostHolder(view);
        return PostHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        PostModel item = mlist.get(position);
        holder.mTitle.setText(item.getTitle());
        holder.mBody.setText(item.getBody());
        holder.mUserId.setText(item.getUserId()+"");
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        public TextView mUserId,mBody, mTitle;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            mTitle=itemView.findViewById(R.id.title);
            mBody=itemView.findViewById(R.id.body);
            mUserId=itemView.findViewById(R.id.userid);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (mListener != null && position != RecyclerView.NO_POSITION) {
                        mListener.OnClick(mlist.get(position));
                    }
                }
            });

        }
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnItemClickListener {
        void OnClick(PostModel item);
    }
}
