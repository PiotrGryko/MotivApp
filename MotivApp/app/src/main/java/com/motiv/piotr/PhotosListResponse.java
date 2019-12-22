package com.motiv.piotr;

import androidx.annotation.NonNull;
import androidx.room.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import java.util.*;
import java.util.concurrent.*;

@Entity(tableName = "photoslistresponse")
public class PhotosListResponse {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "metaId")
    @ForeignKey(entity = com.motiv.piotr.Meta.class, parentColumns = "id", childColumns = "metaId")
    private java.lang.String metaId;

    @Ignore
    @SerializedName("result")
    private java.util.List<com.motiv.piotr.Photo> result;

    @Ignore
    @SerializedName("_meta")
    private com.motiv.piotr.Meta meta;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.util.List<com.motiv.piotr.Photo> getResult() {

        return this.result;
    }

    public void setResult(java.util.List<com.motiv.piotr.Photo> result) {
        this.result = result;
    }

    public com.motiv.piotr.Meta getMeta() {

        return this.meta;
    }

    public void setMeta(com.motiv.piotr.Meta meta) {
        this.meta = meta;
    }

    public static PhotosListResponse fromJson(String json) {
        return gson.fromJson(json, PhotosListResponse.class);
    }

    public static String toJson(PhotosListResponse object) {
        return gson.toJson(object, PhotosListResponse.class);
    }

    public static String toJsonArray(PhotosListResponse[] array) {
        return gson.toJson(array, PhotosListResponse[].class);
    }

    public static PhotosListResponse[] fromJsonArray(String array) {
        return gson.fromJson(array, PhotosListResponse[].class);
    }

    public java.lang.String getMetaId() {
        return this.metaId;
    };

    public void setMetaId(java.lang.String metaId) {
        this.metaId = metaId;
    }
}
