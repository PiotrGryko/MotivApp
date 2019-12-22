package com.motiv.piotr;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;
import retrofit2.*;
import retrofit2.http.*;

public interface GoRestApiApi {

    @GET("users/{userId}")
    Call<UserResponse> getUser(@Path("userId") java.lang.String userId);

    @GET("users")
    Call<UsersListResponse> getUsersList();

    @GET("posts")
    Call<PostsListResponse> getPostsList();

    @GET("photos")
    Call<PhotosListResponse> getPhotosList();
}
