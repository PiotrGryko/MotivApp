package com.motiv.piotr;

import androidx.annotation.NonNull;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import io.realm.*;
import java.util.*;
import java.util.concurrent.*;

public class Post extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("user_id")
    private java.lang.String user_id;

    @SerializedName("_links")
    private com.motiv.piotr.Links links;

    @SerializedName("title")
    private java.lang.String title;

    @SerializedName("body")
    private java.lang.String body;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getUser_id() {

        return this.user_id;
    }

    public void setUser_id(java.lang.String user_id) {
        this.user_id = user_id;
    }

    public com.motiv.piotr.Links getLinks() {

        return this.links;
    }

    public void setLinks(com.motiv.piotr.Links links) {
        this.links = links;
    }

    public java.lang.String getTitle() {

        return this.title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getBody() {

        return this.body;
    }

    public void setBody(java.lang.String body) {
        this.body = body;
    }

    public static Post fromJson(String json) {
        return gson.fromJson(json, Post.class);
    }

    public static String toJson(Post object) {
        return gson.toJson(object, Post.class);
    }

    public static String toJsonArray(Post[] array) {
        return gson.toJson(array, Post[].class);
    }

    public static Post[] fromJsonArray(String array) {
        return gson.fromJson(array, Post[].class);
    }
}
