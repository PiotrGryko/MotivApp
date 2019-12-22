package com.motiv.piotr.dao;

import androidx.fragment.app.*;
import androidx.room.*;
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
import javax.inject.*;

@TypeConverters({MyTypeConverter.class})
@Database(
    entities = {
        Meta.class,
        Photo.class,
        User.class,
        UserResponse.class,
        PhotosListResponse.class,
        Links.class,
        RateLimit.class,
        Post.class,
        PostsListResponse.class,
        Link.class,
        UsersListResponse.class
    },
    version = 1
)
public abstract class MyRoomDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "test";

    public abstract com.motiv.piotr.dao.UserResponseDao userResponseDao();

    public abstract com.motiv.piotr.dao.MetaDao metaDao();

    public abstract com.motiv.piotr.dao.RateLimitDao rateLimitDao();

    public abstract com.motiv.piotr.dao.UserDao userDao();

    public abstract com.motiv.piotr.dao.LinksDao linksDao();

    public abstract com.motiv.piotr.dao.LinkDao linkDao();

    public abstract com.motiv.piotr.dao.UsersListResponseDao usersListResponseDao();

    public abstract com.motiv.piotr.dao.PostsListResponseDao postsListResponseDao();

    public abstract com.motiv.piotr.dao.PostDao postDao();

    public abstract com.motiv.piotr.dao.PhotosListResponseDao photosListResponseDao();

    public abstract com.motiv.piotr.dao.PhotoDao photoDao();
}
