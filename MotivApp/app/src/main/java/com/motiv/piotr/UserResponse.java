package com.motiv.piotr;

import androidx.annotation.NonNull;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import io.realm.*;
import java.util.*;
import java.util.concurrent.*;

public class UserResponse extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("result")
    private com.motiv.piotr.User result;

    @SerializedName("_meta")
    private com.motiv.piotr.Meta meta;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public com.motiv.piotr.User getResult() {

        return this.result;
    }

    public void setResult(com.motiv.piotr.User result) {
        this.result = result;
    }

    public com.motiv.piotr.Meta getMeta() {

        return this.meta;
    }

    public void setMeta(com.motiv.piotr.Meta meta) {
        this.meta = meta;
    }

    public static UserResponse fromJson(String json) {
        return gson.fromJson(json, UserResponse.class);
    }

    public static String toJson(UserResponse object) {
        return gson.toJson(object, UserResponse.class);
    }

    public static String toJsonArray(UserResponse[] array) {
        return gson.toJson(array, UserResponse[].class);
    }

    public static UserResponse[] fromJsonArray(String array) {
        return gson.fromJson(array, UserResponse[].class);
    }
}
