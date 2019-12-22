package com.motiv.piotr;

import androidx.annotation.NonNull;
import androidx.room.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import java.util.*;
import java.util.concurrent.*;

@Entity(tableName = "links")
public class Links {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "editId")
    @ForeignKey(entity = com.motiv.piotr.Link.class, parentColumns = "id", childColumns = "editId")
    private java.lang.String editId;

    @ColumnInfo(name = "selfId")
    @ForeignKey(entity = com.motiv.piotr.Link.class, parentColumns = "id", childColumns = "selfId")
    private java.lang.String selfId;

    @ColumnInfo(name = "avatarId")
    @ForeignKey(
        entity = com.motiv.piotr.Link.class,
        parentColumns = "id",
        childColumns = "avatarId"
    )
    private java.lang.String avatarId;

    @Ignore
    @SerializedName("edit")
    private com.motiv.piotr.Link edit;

    @Ignore
    @SerializedName("self")
    private com.motiv.piotr.Link self;

    @Ignore
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

    public java.lang.String getEditId() {
        return this.editId;
    };

    public void setEditId(java.lang.String editId) {
        this.editId = editId;
    }

    public java.lang.String getSelfId() {
        return this.selfId;
    };

    public void setSelfId(java.lang.String selfId) {
        this.selfId = selfId;
    }

    public java.lang.String getAvatarId() {
        return this.avatarId;
    };

    public void setAvatarId(java.lang.String avatarId) {
        this.avatarId = avatarId;
    }
}
