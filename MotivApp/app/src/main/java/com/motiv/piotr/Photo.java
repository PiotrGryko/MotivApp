package com.motiv.piotr;

import androidx.annotation.NonNull;
import androidx.room.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import java.util.*;
import java.util.concurrent.*;

@Entity(tableName = "photo")
public class Photo {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "resultOwnerId")
    @ForeignKey(
        entity = com.motiv.piotr.PhotosListResponse.class,
        parentColumns = "id",
        childColumns = "resultOwnerId"
    )
    private java.lang.String resultOwnerId;

    @ColumnInfo(name = "linksId")
    @ForeignKey(
        entity = com.motiv.piotr.Links.class,
        parentColumns = "id",
        childColumns = "linksId"
    )
    private java.lang.String linksId;

    @ColumnInfo(name = "thumbnail")
    @SerializedName("thumbnail")
    private java.lang.String thumbnail;

    @Ignore
    @SerializedName("_links")
    private com.motiv.piotr.Links links;

    @ColumnInfo(name = "album_id")
    @SerializedName("album_id")
    private java.lang.String album_id;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private java.lang.String title;

    @ColumnInfo(name = "url")
    @SerializedName("url")
    private java.lang.String url;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getThumbnail() {

        return this.thumbnail;
    }

    public void setThumbnail(java.lang.String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public com.motiv.piotr.Links getLinks() {

        return this.links;
    }

    public void setLinks(com.motiv.piotr.Links links) {
        this.links = links;
    }

    public java.lang.String getAlbum_id() {

        return this.album_id;
    }

    public void setAlbum_id(java.lang.String album_id) {
        this.album_id = album_id;
    }

    public java.lang.String getTitle() {

        return this.title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getUrl() {

        return this.url;
    }

    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    public static Photo fromJson(String json) {
        return gson.fromJson(json, Photo.class);
    }

    public static String toJson(Photo object) {
        return gson.toJson(object, Photo.class);
    }

    public static String toJsonArray(Photo[] array) {
        return gson.toJson(array, Photo[].class);
    }

    public static Photo[] fromJsonArray(String array) {
        return gson.fromJson(array, Photo[].class);
    }

    public java.lang.String getResultOwnerId() {
        return this.resultOwnerId;
    };

    public void setResultOwnerId(java.lang.String resultOwnerId) {
        this.resultOwnerId = resultOwnerId;
    }

    public java.lang.String getLinksId() {
        return this.linksId;
    };

    public void setLinksId(java.lang.String linksId) {
        this.linksId = linksId;
    }
}
