package com.motiv.piotr.dao;

import androidx.fragment.app.*;
import androidx.room.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import com.motiv.piotr.Link;
import com.motiv.piotr.Links;
import com.motiv.piotr.Meta;
import com.motiv.piotr.Photo;
import com.motiv.piotr.PhotosListResponse;
import com.motiv.piotr.Post;
import com.motiv.piotr.PostsListResponse;
import com.motiv.piotr.RateLimit;
import com.motiv.piotr.User;
import com.motiv.piotr.UserResponse;
import com.motiv.piotr.UsersListResponse;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import java.util.List;
import javax.inject.*;

public class MyTypeConverter {

    @TypeConverter
    public static java.lang.String userresponseToString(java.util.List<UserResponse> value) {

        return new Gson().toJson(value, new TypeToken<List<UserResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<UserResponse> stringToUserResponses(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<UserResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String metaToString(java.util.List<Meta> value) {

        return new Gson().toJson(value, new TypeToken<List<Meta>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<Meta> stringToMetas(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<Meta>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String ratelimitToString(java.util.List<RateLimit> value) {

        return new Gson().toJson(value, new TypeToken<List<RateLimit>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<RateLimit> stringToRateLimits(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<RateLimit>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String userToString(java.util.List<User> value) {

        return new Gson().toJson(value, new TypeToken<List<User>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<User> stringToUsers(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<User>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String linksToString(java.util.List<Links> value) {

        return new Gson().toJson(value, new TypeToken<List<Links>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<Links> stringToLinkss(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<Links>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String linkToString(java.util.List<Link> value) {

        return new Gson().toJson(value, new TypeToken<List<Link>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<Link> stringToLinks(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<Link>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String userslistresponseToString(
            java.util.List<UsersListResponse> value) {

        return new Gson().toJson(value, new TypeToken<List<UsersListResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<UsersListResponse> stringToUsersListResponses(
            java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<UsersListResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String postslistresponseToString(
            java.util.List<PostsListResponse> value) {

        return new Gson().toJson(value, new TypeToken<List<PostsListResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<PostsListResponse> stringToPostsListResponses(
            java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<PostsListResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String postToString(java.util.List<Post> value) {

        return new Gson().toJson(value, new TypeToken<List<Post>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<Post> stringToPosts(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<Post>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String photoslistresponseToString(
            java.util.List<PhotosListResponse> value) {

        return new Gson().toJson(value, new TypeToken<List<PhotosListResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<PhotosListResponse> stringToPhotosListResponses(
            java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<PhotosListResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String photoToString(java.util.List<Photo> value) {

        return new Gson().toJson(value, new TypeToken<List<Photo>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<Photo> stringToPhotos(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<Photo>>() {}.getType());
    }
}
