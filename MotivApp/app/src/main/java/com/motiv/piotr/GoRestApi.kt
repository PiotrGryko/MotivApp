 
package com.motiv.piotr
import androidx.fragment.app.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import retrofit2.*
import retrofit2.http.*

public class GoRestApi(val goRestApiApi: GoRestApiApi) {

    fun getUser(userId: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.UserResponse>) {
        goRestApiApi!!.getUser(userId).enqueue(object : Callback<com.motiv.piotr.UserResponse> {
            override fun onFailure(call: Call<com.motiv.piotr.UserResponse>?, t: Throwable?) {
                onResponseListener.onError(Exception(t?.message))
            }

            override fun onResponse(call: Call<com.motiv.piotr.UserResponse>?, response: Response<com.motiv.piotr.UserResponse>?) {
                onResponseListener.onSuccess(response?.body() as com.motiv.piotr.UserResponse)
            }
        })
    } fun getUsersList(onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.UsersListResponse>) {
        goRestApiApi!!.getUsersList().enqueue(object : Callback<com.motiv.piotr.UsersListResponse> {
            override fun onFailure(call: Call<com.motiv.piotr.UsersListResponse>?, t: Throwable?) {
                onResponseListener.onError(Exception(t?.message))
            }

            override fun onResponse(call: Call<com.motiv.piotr.UsersListResponse>?, response: Response<com.motiv.piotr.UsersListResponse>?) {
                onResponseListener.onSuccess(response?.body() as com.motiv.piotr.UsersListResponse)
            }
        })
    } fun getPostsList(onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.PostsListResponse>) {
        goRestApiApi!!.getPostsList().enqueue(object : Callback<com.motiv.piotr.PostsListResponse> {
            override fun onFailure(call: Call<com.motiv.piotr.PostsListResponse>?, t: Throwable?) {
                onResponseListener.onError(Exception(t?.message))
            }

            override fun onResponse(call: Call<com.motiv.piotr.PostsListResponse>?, response: Response<com.motiv.piotr.PostsListResponse>?) {
                onResponseListener.onSuccess(response?.body() as com.motiv.piotr.PostsListResponse)
            }
        })
    } fun getPhotosList(onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.PhotosListResponse>) {
        goRestApiApi!!.getPhotosList().enqueue(object : Callback<com.motiv.piotr.PhotosListResponse> {
            override fun onFailure(call: Call<com.motiv.piotr.PhotosListResponse>?, t: Throwable?) {
                onResponseListener.onError(Exception(t?.message))
            }

            override fun onResponse(call: Call<com.motiv.piotr.PhotosListResponse>?, response: Response<com.motiv.piotr.PhotosListResponse>?) {
                onResponseListener.onSuccess(response?.body() as com.motiv.piotr.PhotosListResponse)
            }
        })
    }
}
