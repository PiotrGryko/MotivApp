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

public class Links extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("edit")
    private com.motiv.piotr.Link edit;

    @SerializedName("self")
    private com.motiv.piotr.Link self;

    @SerializedName("avatar")
    private com.motiv.piotr.Link avatar;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public com.motiv.piotr.Link getEdit() {

        return this.edit;
    }

    public void setEdit(com.motiv.piotr.Link edit) {
        this.edit = edit;
    }

    public com.motiv.piotr.Link getSelf() {

        return this.self;
    }

    public void setSelf(com.motiv.piotr.Link self) {
        this.self = self;
    }

    public com.motiv.piotr.Link getAvatar() {

        return this.avatar;
    }

    public void setAvatar(com.motiv.piotr.Link avatar) {
        this.avatar = avatar;
    }

    public static Links fromJson(String json) {
        return gson.fromJson(json, Links.class);
    }

    public static String toJson(Links object) {
        return gson.toJson(object, Links.class);
    }

    public static String toJsonArray(Links[] array) {
        return gson.toJson(array, Links[].class);
    }

    public static Links[] fromJsonArray(String array) {
        return gson.fromJson(array, Links[].class);
    }
}
