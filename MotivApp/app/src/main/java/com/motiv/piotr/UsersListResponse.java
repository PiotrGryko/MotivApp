package com.motiv.piotr;

import androidx.annotation.NonNull;
import androidx.fragment.app.*;
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

public class UsersListResponse extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("result")
    private RealmList<com.motiv.piotr.User> result;

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

    public void setResult(RealmList<com.motiv.piotr.User> result) {
        this.result = result;
    }

    public com.motiv.piotr.Meta getMeta() {

        return this.meta;
    }

    public void setMeta(com.motiv.piotr.Meta meta) {
        this.meta = meta;
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
}
