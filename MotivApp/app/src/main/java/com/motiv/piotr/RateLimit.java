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

public class RateLimit extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("limit")
    private int limit;

    @SerializedName("reset")
    private int reset;

    @SerializedName("remaining")
    private int remaining;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public int getLimit() {

        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getReset() {

        return this.reset;
    }

    public void setReset(int reset) {
        this.reset = reset;
    }

    public int getRemaining() {

        return this.remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, java.lang.String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    public static RateLimit fromJson(String json) {
        return gson.fromJson(json, RateLimit.class);
    }

    public static String toJson(RateLimit object) {
        return gson.toJson(object, RateLimit.class);
    }

    public static String toJsonArray(RateLimit[] array) {
        return gson.toJson(array, RateLimit[].class);
    }

    public static RateLimit[] fromJsonArray(String array) {
        return gson.fromJson(array, RateLimit[].class);
    }
}
