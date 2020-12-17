package dfsdf.sdfsdf.sdf;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.*;
import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Boxt72h5ListAdapter
        extends RecyclerView.Adapter<Boxt72h5ListAdapter.AdapterViewHolder> {

    private OnItemClickListener onItemClickListener;
    private ArrayList<Boxt72h5ModelList> data = new ArrayList();

    public interface OnItemClickListener {

        public void onItemClick(int position, dfsdf.sdfsdf.sdf.Boxt72h5ModelList item);
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout constraintlayout00;
        ImageView field0;
        TextView field1;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            constraintlayout00 = (ConstraintLayout) itemView.findViewById(R.id.constraintlayout00);
            field0 = (ImageView) itemView.findViewById(R.id.field0);
            field1 = (TextView) itemView.findViewById(R.id.field1);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public Boxt72h5ModelList getElement(int position) {

        return data.get(position);
    }

    public void setData(java.util.List<dfsdf.sdfsdf.sdf.Boxt72h5ModelList> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.boxt72h5listadapter, parent, false);
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
        Boxt72h5ModelList boxt72h5ModelList = data.get(position);
        viewHolder.field1.setText(boxt72h5ModelList.getField1());
    }

    public void setOnItemClickListener(
            dfsdf.sdfsdf.sdf.Boxt72h5ListAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
