package com.motiv.piotr;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.*;
import com.bumptech.glide.Glide;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import io.realm.*;
import java.util.*;
import java.util.concurrent.*;
import javax.inject.*;

public class PostsListResponse extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("result")
    private RealmList<com.motiv.piotr.Post> result;

    @SerializedName("_meta")
    private com.motiv.piotr.Meta meta;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.util.List<com.motiv.piotr.Post> getResult() {

        return this.result;
    }

    public void setResult(RealmList<com.motiv.piotr.Post> result) {
        this.result = result;
    }

    public com.motiv.piotr.Meta getMeta() {

        return this.meta;
    }

    public void setMeta(com.motiv.piotr.Meta meta) {
        this.meta = meta;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, java.lang.String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    public static PostsListResponse fromJson(String json) {
        return gson.fromJson(json, PostsListResponse.class);
    }

    public static String toJson(PostsListResponse object) {
        return gson.toJson(object, PostsListResponse.class);
    }

    public static String toJsonArray(PostsListResponse[] array) {
        return gson.toJson(array, PostsListResponse[].class);
    }

    public static PostsListResponse[] fromJsonArray(String array) {
        return gson.fromJson(array, PostsListResponse[].class);
    }
}
