package com.motiv.piotr;

import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.*;
import com.motiv.piotr.databinding.PostslistadapterBinding;
import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class PostsListAdapter extends RecyclerView.Adapter<PostsListAdapter.AdapterViewHolder> {

    private OnItemClickListener onItemClickListener;
    private ArrayList<Post> data = new ArrayList();

    public interface OnItemClickListener {

        public void onItemClick(int position, com.motiv.piotr.Post item);
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        private PostslistadapterBinding binding;

        public AdapterViewHolder(PostslistadapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public Post getElement(int position) {

        return data.get(position);
    }

    public void setData(java.util.List<com.motiv.piotr.Post> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PostslistadapterBinding binding = PostslistadapterBinding.inflate(inflater);
        return new AdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final AdapterViewHolder viewHolder, final int position) {
        viewHolder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (onItemClickListener != null)
                            onItemClickListener.onItemClick(position, data.get(position));
                    }
                });
        Post post = data.get(position);
        viewHolder.binding.textview10.setText(post.getTitle());
    }

    public void setOnItemClickListener(
            com.motiv.piotr.PostsListAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
