package com.motiv.piotr;

import androidx.fragment.app.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;
import retrofit2.*;
import retrofit2.http.*;

public class GoRestApi {

    private static GoRestApiApi goRestApiApi;

    public GoRestApi(GoRestApiApi goRestApiApi) {
        this.goRestApiApi = goRestApiApi;
    }

    public void getUser(
            java.lang.String userId,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.UserResponse>
                    onResponseListener) {

        goRestApiApi
                .getUser(userId)
                .enqueue(
                        new Callback<com.motiv.piotr.UserResponse>() {
                            @Override
                            public void onResponse(
                                    Call<com.motiv.piotr.UserResponse> call,
                                    retrofit2.Response<com.motiv.piotr.UserResponse> response) {

                                onResponseListener.onSuccess(response.body());
                            }

                            @Override
                            public void onFailure(
                                    Call<com.motiv.piotr.UserResponse> call, Throwable t) {
                                onResponseListener.onError(new Exception(t.getMessage()));
                            }
                        });
    }

    public void getUsersList(
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.UsersListResponse>
                    onResponseListener) {
        goRestApiApi
                .getUsersList()
                .enqueue(
                        new Callback<com.motiv.piotr.UsersListResponse>() {
                            @Override
                            public void onResponse(
                                    Call<com.motiv.piotr.UsersListResponse> call,
                                    retrofit2.Response<com.motiv.piotr.UsersListResponse>
                                            response) {

                                onResponseListener.onSuccess(response.body());
                            }

                            @Override
                            public void onFailure(
                                    Call<com.motiv.piotr.UsersListResponse> call, Throwable t) {

                                onResponseListener.onError(new Exception(t.getMessage()));
                            }
                        });
    }

    public void getPostsList(
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.PostsListResponse>
                    onResponseListener) {
        goRestApiApi
                .getPostsList()
                .enqueue(
                        new Callback<com.motiv.piotr.PostsListResponse>() {
                            @Override
                            public void onResponse(
                                    Call<com.motiv.piotr.PostsListResponse> call,
                                    retrofit2.Response<com.motiv.piotr.PostsListResponse>
                                            response) {

                                onResponseListener.onSuccess(response.body());
                            }

                            @Override
                            public void onFailure(
                                    Call<com.motiv.piotr.PostsListResponse> call, Throwable t) {

                                onResponseListener.onError(new Exception(t.getMessage()));
                            }
                        });
    }

    public void getPhotosList(
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.PhotosListResponse>
                    onResponseListener) {
        goRestApiApi
                .getPhotosList()
                .enqueue(
                        new Callback<com.motiv.piotr.PhotosListResponse>() {
                            @Override
                            public void onResponse(
                                    Call<com.motiv.piotr.PhotosListResponse> call,
                                    retrofit2.Response<com.motiv.piotr.PhotosListResponse>
                                            response) {

                                onResponseListener.onSuccess(response.body());
                            }

                            @Override
                            public void onFailure(
                                    Call<com.motiv.piotr.PhotosListResponse> call, Throwable t) {

                                onResponseListener.onError(new Exception(t.getMessage()));
                            }
                        });
    }
}
