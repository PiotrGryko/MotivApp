 
package com.motiv.piotr.dao
import androidx.room.*
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
@TypeConverters(MyTypeConverter::class)
@Database(entities = [PostsListResponse::class, PhotosListResponse::class, UsersListResponse::class, RateLimit::class, Links::class, User::class, Post::class, UserResponse::class, Photo::class, Link::class, Meta::class], version = 1)
public abstract class MyRoomDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME: String = "test"
    }

    public abstract fun userResponseDao(): com.motiv.piotr.dao.UserResponseDao
    public abstract fun metaDao(): com.motiv.piotr.dao.MetaDao
    public abstract fun rateLimitDao(): com.motiv.piotr.dao.RateLimitDao
    public abstract fun userDao(): com.motiv.piotr.dao.UserDao
    public abstract fun linksDao(): com.motiv.piotr.dao.LinksDao
    public abstract fun linkDao(): com.motiv.piotr.dao.LinkDao
    public abstract fun usersListResponseDao(): com.motiv.piotr.dao.UsersListResponseDao
    public abstract fun postsListResponseDao(): com.motiv.piotr.dao.PostsListResponseDao
    public abstract fun postDao(): com.motiv.piotr.dao.PostDao
    public abstract fun photosListResponseDao(): com.motiv.piotr.dao.PhotosListResponseDao
    public abstract fun photoDao(): com.motiv.piotr.dao.PhotoDao
}
