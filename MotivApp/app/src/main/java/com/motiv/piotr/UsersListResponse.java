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

@Entity(tableName = "userslistresponse")
public class UsersListResponse {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "metaId")
    @ForeignKey(entity = com.motiv.piotr.Meta.class, parentColumns = "id", childColumns = "metaId")
    private java.lang.String metaId;

    @Ignore
    @SerializedName("result")
    private java.util.List<com.motiv.piotr.User> result;

    @Ignore
    @SerializedName("_meta")
    private com.motiv.piotr.Meta meta;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.util.List<com.motiv.piotr.User> getResult() {

        return this.result;
    }

    public void setResult(java.util.List<com.motiv.piotr.User> result) {
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

    public static UsersListResponse fromJson(String json) {
        return gson.fromJson(json, UsersListResponse.class);
    }

    public static String toJson(UsersListResponse object) {
        return gson.toJson(object, UsersListResponse.class);
    }

    public static String toJsonArray(UsersListResponse[] array) {
        return gson.toJson(array, UsersListResponse[].class);
    }

    public static UsersListResponse[] fromJsonArray(String array) {
        return gson.fromJson(array, UsersListResponse[].class);
    }

    public java.lang.String getMetaId() {
        return this.metaId;
    };

    public void setMetaId(java.lang.String metaId) {
        this.metaId = metaId;
    }
}
