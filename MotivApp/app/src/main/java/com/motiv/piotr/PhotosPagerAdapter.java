package com.motiv.piotr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class PhotosPagerAdapter extends PagerAdapter {

    private ArrayList<Photo> data = new ArrayList();
    private LinearLayout linearlayout00;
    private ImageView imageview10;

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {

        return view == o;
    }

    public void setData(java.util.List<com.motiv.piotr.Photo> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object o) {
        container.removeView((View) o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View v = inflater.inflate(R.layout.photospageradapter, container, false);
        linearlayout00 = (LinearLayout) v.findViewById(R.id.linearlayout00);
        imageview10 = (ImageView) v.findViewById(R.id.imageview10);
        Photo photo = data.get(position);

        Picasso.with(container.getContext()).load(photo.getUrl()).into(imageview10);
        ;

        container.addView(v);
        return v;
    }
}
