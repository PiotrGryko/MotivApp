package com.motiv.piotr;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.*;
import androidx.recyclerview.widget.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.*;
import javax.inject.*;

public class PostsListAdapter extends RecyclerView.Adapter<PostsListAdapter.AdapterViewHolder> {

    private OnItemClickListener onItemClickListener;
    private ArrayList<Post> data = new ArrayList();

    public interface OnItemClickListener {

        public void onItemClick(int position, com.motiv.piotr.Post item);
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearlayout00;
        TextView textview10;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            linearlayout00 = (LinearLayout) itemView.findViewById(R.id.linearlayout00);
            textview10 = (TextView) itemView.findViewById(R.id.textview10);
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
        View row = inflater.inflate(R.layout.postslistadapter, parent, false);
        return new AdapterViewHolder(row);
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
        viewHolder.textview10.setText(post.getTitle());
    }

    public void setOnItemClickListener(
            com.motiv.piotr.PostsListAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
