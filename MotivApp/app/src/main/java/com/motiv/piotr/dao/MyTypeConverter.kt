 
package com.motiv.piotr.dao
import androidx.fragment.app.*
import androidx.room.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import com.motiv.piotr.Link
import com.motiv.piotr.Links
import com.motiv.piotr.Meta
import com.motiv.piotr.Photo
import com.motiv.piotr.PhotosListResponse
import com.motiv.piotr.Post
import com.motiv.piotr.PostsListResponse
import com.motiv.piotr.RateLimit
import com.motiv.piotr.User
import com.motiv.piotr.UserResponse
import com.motiv.piotr.UsersListResponse
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List

public class MyTypeConverter {

    @TypeConverter fun userresponseToString(value: List<UserResponse>): String {
        return Gson().toJson(value, object : TypeToken<List<UserResponse>>() {}.type)
    } @TypeConverter fun stringToUserResponses(value: String): List<UserResponse> {
        return Gson().fromJson(value, object : TypeToken<List<UserResponse>>() {}.type)
    } @TypeConverter fun metaToString(value: List<Meta>): String {
        return Gson().toJson(value, object : TypeToken<List<Meta>>() {}.type)
    } @TypeConverter fun stringToMetas(value: String): List<Meta> {
        return Gson().fromJson(value, object : TypeToken<List<Meta>>() {}.type)
    } @TypeConverter fun ratelimitToString(value: List<RateLimit>): String {
        return Gson().toJson(value, object : TypeToken<List<RateLimit>>() {}.type)
    } @TypeConverter fun stringToRateLimits(value: String): List<RateLimit> {
        return Gson().fromJson(value, object : TypeToken<List<RateLimit>>() {}.type)
    } @TypeConverter fun userToString(value: List<User>): String {
        return Gson().toJson(value, object : TypeToken<List<User>>() {}.type)
    } @TypeConverter fun stringToUsers(value: String): List<User> {
        return Gson().fromJson(value, object : TypeToken<List<User>>() {}.type)
    } @TypeConverter fun linksToString(value: List<Links>): String {
        return Gson().toJson(value, object : TypeToken<List<Links>>() {}.type)
    } @TypeConverter fun stringToLinkss(value: String): List<Links> {
        return Gson().fromJson(value, object : TypeToken<List<Links>>() {}.type)
    } @TypeConverter fun linkToString(value: List<Link>): String {
        return Gson().toJson(value, object : TypeToken<List<Link>>() {}.type)
    } @TypeConverter fun stringToLinks(value: String): List<Link> {
        return Gson().fromJson(value, object : TypeToken<List<Link>>() {}.type)
    } @TypeConverter fun userslistresponseToString(value: List<UsersListResponse>): String {
        return Gson().toJson(value, object : TypeToken<List<UsersListResponse>>() {}.type)
    } @TypeConverter fun stringToUsersListResponses(value: String): List<UsersListResponse> {
        return Gson().fromJson(value, object : TypeToken<List<UsersListResponse>>() {}.type)
    } @TypeConverter fun postslistresponseToString(value: List<PostsListResponse>): String {
        return Gson().toJson(value, object : TypeToken<List<PostsListResponse>>() {}.type)
    } @TypeConverter fun stringToPostsListResponses(value: String): List<PostsListResponse> {
        return Gson().fromJson(value, object : TypeToken<List<PostsListResponse>>() {}.type)
    } @TypeConverter fun postToString(value: List<Post>): String {
        return Gson().toJson(value, object : TypeToken<List<Post>>() {}.type)
    } @TypeConverter fun stringToPosts(value: String): List<Post> {
        return Gson().fromJson(value, object : TypeToken<List<Post>>() {}.type)
    } @TypeConverter fun photoslistresponseToString(value: List<PhotosListResponse>): String {
        return Gson().toJson(value, object : TypeToken<List<PhotosListResponse>>() {}.type)
    } @TypeConverter fun stringToPhotosListResponses(value: String): List<PhotosListResponse> {
        return Gson().fromJson(value, object : TypeToken<List<PhotosListResponse>>() {}.type)
    } @TypeConverter fun photoToString(value: List<Photo>): String {
        return Gson().toJson(value, object : TypeToken<List<Photo>>() {}.type)
    } @TypeConverter fun stringToPhotos(value: String): List<Photo> {
        return Gson().fromJson(value, object : TypeToken<List<Photo>>() {}.type)
    }
}
