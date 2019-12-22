package com.motiv.piotr;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.*;
import androidx.room.*;
import com.bumptech.glide.Glide;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import java.util.*;
import java.util.concurrent.*;
import javax.inject.*;

@Entity(tableName = "meta")
public class Meta {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "rateLimitId")
    @ForeignKey(
        entity = com.motiv.piotr.RateLimit.class,
        parentColumns = "id",
        childColumns = "rateLimitId"
    )
    private java.lang.String rateLimitId;

    @ColumnInfo(name = "code")
    @SerializedName("code")
    private int code;

    @Ignore
    @SerializedName("rateLimit")
    private com.motiv.piotr.RateLimit rateLimit;

    @ColumnInfo(name = "success")
    @SerializedName("success")
    private boolean success;

    @ColumnInfo(name = "message")
    @SerializedName("message")
    private java.lang.String message;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public int getCode() {

        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public com.motiv.piotr.RateLimit getRateLimit() {

        return this.rateLimit;
    }

    public void setRateLimit(com.motiv.piotr.RateLimit rateLimit) {
        this.rateLimit = rateLimit;
    }

    public boolean getSuccess() {

        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public java.lang.String getMessage() {

        return this.message;
    }

    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, java.lang.String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    public static Meta fromJson(String json) {
        return gson.fromJson(json, Meta.class);
    }

    public static String toJson(Meta object) {
        return gson.toJson(object, Meta.class);
    }

    public static String toJsonArray(Meta[] array) {
        return gson.toJson(array, Meta[].class);
    }

    public static Meta[] fromJsonArray(String array) {
        return gson.fromJson(array, Meta[].class);
    }

    public java.lang.String getRateLimitId() {
        return this.rateLimitId;
    };

    public void setRateLimitId(java.lang.String rateLimitId) {
        this.rateLimitId = rateLimitId;
    }
}
