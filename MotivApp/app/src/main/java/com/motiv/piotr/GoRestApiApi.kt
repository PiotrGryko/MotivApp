 
package com.motiv.piotr
import retrofit2.*
import retrofit2.http.*

public interface GoRestApiApi {

    @GET("users/{userId}")
    fun getUser(
        @Path("userId")
        userId: String
    ): Call<UserResponse>@GET("users")
    fun getUsersList(): Call<UsersListResponse>@GET("posts")
    fun getPostsList(): Call<PostsListResponse>@GET("photos")
    fun getPhotosList(): Call<PhotosListResponse>
}
