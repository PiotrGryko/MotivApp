package com.motiv.piotr.dao;

import android.os.Handler;
import androidx.fragment.app.*;
import com.motiv.piotr.Link;
import com.motiv.piotr.Links;
import com.motiv.piotr.LinksWithReferences;
import com.motiv.piotr.Meta;
import com.motiv.piotr.MetaWithReferences;
import com.motiv.piotr.OnResponseListener;
import com.motiv.piotr.Photo;
import com.motiv.piotr.PhotoWithReferences;
import com.motiv.piotr.PhotosListResponse;
import com.motiv.piotr.PhotosListResponseWithReferences;
import com.motiv.piotr.Post;
import com.motiv.piotr.PostWithReferences;
import com.motiv.piotr.PostsListResponse;
import com.motiv.piotr.PostsListResponseWithReferences;
import com.motiv.piotr.RateLimit;
import com.motiv.piotr.User;
import com.motiv.piotr.UserResponse;
import com.motiv.piotr.UserResponseWithReferences;
import com.motiv.piotr.UserWithReferences;
import com.motiv.piotr.UsersListResponse;
import com.motiv.piotr.UsersListResponseWithReferences;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import javax.inject.*;

public class DaoRepository {

    private MyRoomDatabase myRoomDatabase;
    private Handler handler;
    private Executor executor;

    public DaoRepository(Handler handler, MyRoomDatabase myRoomDatabase, Executor executor) {
        this.handler = handler;
        this.myRoomDatabase = myRoomDatabase;
        this.executor = executor;
    }

    public void saveUserResponse(
            final com.motiv.piotr.UserResponse userResponse,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.UserResponse>
                    onResponseListener) {
        updateUserResponse(userResponse);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.userResponseDao().saveUserResponse(userResponse);
                        passSuccessResultToUi(userResponse, onResponseListener);
                    }
                });
    }

    public void saveUserResponses(
            final java.util.List<com.motiv.piotr.UserResponse> userResponses,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.UserResponse>>
                    onResponseListener) {
        updateUserResponses(userResponses);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.userResponseDao().saveUserResponses(userResponses);
                        passSuccessResultToUi(userResponses, onResponseListener);
                    }
                });
    }

    public void loadUserResponses(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.UserResponse>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<UserResponseWithReferences> resultWithReferences =
                                myRoomDatabase.userResponseDao().getUserResponses();
                        List<UserResponse> result = new ArrayList<>();
                        for (UserResponseWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getUserResponse());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadUserResponse(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.UserResponse>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final UserResponseWithReferences resultWithReference =
                                myRoomDatabase.userResponseDao().getUserResponse(id);
                        passSuccessResultToUi(
                                resultWithReference.getUserResponse(), onResponseListener);
                    }
                });
    }

    public void saveMeta(
            final com.motiv.piotr.Meta meta,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Meta> onResponseListener) {
        updateMeta(meta);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.metaDao().saveMeta(meta);
                        passSuccessResultToUi(meta, onResponseListener);
                    }
                });
    }

    public void saveMetas(
            final java.util.List<com.motiv.piotr.Meta> metas,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Meta>>
                    onResponseListener) {
        updateMetas(metas);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.metaDao().saveMetas(metas);
                        passSuccessResultToUi(metas, onResponseListener);
                    }
                });
    }

    public void loadMetas(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Meta>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<MetaWithReferences> resultWithReferences =
                                myRoomDatabase.metaDao().getMetas();
                        List<Meta> result = new ArrayList<>();
                        for (MetaWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getMeta());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadMeta(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Meta> onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final MetaWithReferences resultWithReference =
                                myRoomDatabase.metaDao().getMeta(id);
                        passSuccessResultToUi(resultWithReference.getMeta(), onResponseListener);
                    }
                });
    }

    public void saveRateLimit(
            final com.motiv.piotr.RateLimit rateLimit,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.RateLimit>
                    onResponseListener) {
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.rateLimitDao().saveRateLimit(rateLimit);
                        passSuccessResultToUi(rateLimit, onResponseListener);
                    }
                });
    }

    public void saveRateLimits(
            final java.util.List<com.motiv.piotr.RateLimit> rateLimits,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.RateLimit>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.rateLimitDao().saveRateLimits(rateLimits);
                        passSuccessResultToUi(rateLimits, onResponseListener);
                    }
                });
    }

    public void loadRateLimits(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.RateLimit>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<RateLimit> result =
                                myRoomDatabase.rateLimitDao().getRateLimits();
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadRateLimit(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.RateLimit>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final RateLimit result = myRoomDatabase.rateLimitDao().getRateLimit(id);
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void saveUser(
            final com.motiv.piotr.User user,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.User> onResponseListener) {
        updateUser(user);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.userDao().saveUser(user);
                        passSuccessResultToUi(user, onResponseListener);
                    }
                });
    }

    public void saveUsers(
            final java.util.List<com.motiv.piotr.User> users,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.User>>
                    onResponseListener) {
        updateUsers(users);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.userDao().saveUsers(users);
                        passSuccessResultToUi(users, onResponseListener);
                    }
                });
    }

    public void loadUsers(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.User>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<UserWithReferences> resultWithReferences =
                                myRoomDatabase.userDao().getUsers();
                        List<User> result = new ArrayList<>();
                        for (UserWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getUser());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadUser(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.User> onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final UserWithReferences resultWithReference =
                                myRoomDatabase.userDao().getUser(id);
                        passSuccessResultToUi(resultWithReference.getUser(), onResponseListener);
                    }
                });
    }

    public void saveLinks(
            final com.motiv.piotr.Links links,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Links> onResponseListener) {
        updateLinks(links);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.linksDao().saveLinks(links);
                        passSuccessResultToUi(links, onResponseListener);
                    }
                });
    }

    public void saveLinkss(
            final java.util.List<com.motiv.piotr.Links> linkss,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Links>>
                    onResponseListener) {
        updateLinkss(linkss);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.linksDao().saveLinkss(linkss);
                        passSuccessResultToUi(linkss, onResponseListener);
                    }
                });
    }

    public void loadLinkss(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Links>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<LinksWithReferences> resultWithReferences =
                                myRoomDatabase.linksDao().getLinkss();
                        List<Links> result = new ArrayList<>();
                        for (LinksWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getLinks());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadLinks(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Links> onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final LinksWithReferences resultWithReference =
                                myRoomDatabase.linksDao().getLinks(id);
                        passSuccessResultToUi(resultWithReference.getLinks(), onResponseListener);
                    }
                });
    }

    public void saveLink(
            final com.motiv.piotr.Link link,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Link> onResponseListener) {
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.linkDao().saveLink(link);
                        passSuccessResultToUi(link, onResponseListener);
                    }
                });
    }

    public void saveLinks(
            final java.util.List<com.motiv.piotr.Link> links,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Link>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.linkDao().saveLinks(links);
                        passSuccessResultToUi(links, onResponseListener);
                    }
                });
    }

    public void loadLinks(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Link>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<Link> result = myRoomDatabase.linkDao().getLinks();
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadLink(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Link> onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final Link result = myRoomDatabase.linkDao().getLink(id);
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void saveUsersListResponse(
            final com.motiv.piotr.UsersListResponse usersListResponse,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.UsersListResponse>
                    onResponseListener) {
        updateUsersListResponse(usersListResponse);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .usersListResponseDao()
                                .saveUsersListResponse(usersListResponse);
                        passSuccessResultToUi(usersListResponse, onResponseListener);
                    }
                });
    }

    public void saveUsersListResponses(
            final java.util.List<com.motiv.piotr.UsersListResponse> usersListResponses,
            final com.motiv.piotr.OnResponseListener<
                            java.util.List<com.motiv.piotr.UsersListResponse>>
                    onResponseListener) {
        updateUsersListResponses(usersListResponses);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .usersListResponseDao()
                                .saveUsersListResponses(usersListResponses);
                        passSuccessResultToUi(usersListResponses, onResponseListener);
                    }
                });
    }

    public void loadUsersListResponses(
            final com.motiv.piotr.OnResponseListener<
                            java.util.List<com.motiv.piotr.UsersListResponse>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<UsersListResponseWithReferences> resultWithReferences =
                                myRoomDatabase.usersListResponseDao().getUsersListResponses();
                        List<UsersListResponse> result = new ArrayList<>();
                        for (UsersListResponseWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getUsersListResponse());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadUsersListResponse(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.UsersListResponse>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final UsersListResponseWithReferences resultWithReference =
                                myRoomDatabase.usersListResponseDao().getUsersListResponse(id);
                        passSuccessResultToUi(
                                resultWithReference.getUsersListResponse(), onResponseListener);
                    }
                });
    }

    public void savePostsListResponse(
            final com.motiv.piotr.PostsListResponse postsListResponse,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.PostsListResponse>
                    onResponseListener) {
        updatePostsListResponse(postsListResponse);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .postsListResponseDao()
                                .savePostsListResponse(postsListResponse);
                        passSuccessResultToUi(postsListResponse, onResponseListener);
                    }
                });
    }

    public void savePostsListResponses(
            final java.util.List<com.motiv.piotr.PostsListResponse> postsListResponses,
            final com.motiv.piotr.OnResponseListener<
                            java.util.List<com.motiv.piotr.PostsListResponse>>
                    onResponseListener) {
        updatePostsListResponses(postsListResponses);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .postsListResponseDao()
                                .savePostsListResponses(postsListResponses);
                        passSuccessResultToUi(postsListResponses, onResponseListener);
                    }
                });
    }

    public void loadPostsListResponses(
            final com.motiv.piotr.OnResponseListener<
                            java.util.List<com.motiv.piotr.PostsListResponse>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<PostsListResponseWithReferences> resultWithReferences =
                                myRoomDatabase.postsListResponseDao().getPostsListResponses();
                        List<PostsListResponse> result = new ArrayList<>();
                        for (PostsListResponseWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getPostsListResponse());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadPostsListResponse(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.PostsListResponse>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final PostsListResponseWithReferences resultWithReference =
                                myRoomDatabase.postsListResponseDao().getPostsListResponse(id);
                        passSuccessResultToUi(
                                resultWithReference.getPostsListResponse(), onResponseListener);
                    }
                });
    }

    public void savePost(
            final com.motiv.piotr.Post post,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Post> onResponseListener) {
        updatePost(post);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.postDao().savePost(post);
                        passSuccessResultToUi(post, onResponseListener);
                    }
                });
    }

    public void savePosts(
            final java.util.List<com.motiv.piotr.Post> posts,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Post>>
                    onResponseListener) {
        updatePosts(posts);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.postDao().savePosts(posts);
                        passSuccessResultToUi(posts, onResponseListener);
                    }
                });
    }

    public void loadPosts(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Post>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<PostWithReferences> resultWithReferences =
                                myRoomDatabase.postDao().getPosts();
                        List<Post> result = new ArrayList<>();
                        for (PostWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getPost());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadPost(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Post> onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final PostWithReferences resultWithReference =
                                myRoomDatabase.postDao().getPost(id);
                        passSuccessResultToUi(resultWithReference.getPost(), onResponseListener);
                    }
                });
    }

    public void savePhotosListResponse(
            final com.motiv.piotr.PhotosListResponse photosListResponse,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.PhotosListResponse>
                    onResponseListener) {
        updatePhotosListResponse(photosListResponse);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .photosListResponseDao()
                                .savePhotosListResponse(photosListResponse);
                        passSuccessResultToUi(photosListResponse, onResponseListener);
                    }
                });
    }

    public void savePhotosListResponses(
            final java.util.List<com.motiv.piotr.PhotosListResponse> photosListResponses,
            final com.motiv.piotr.OnResponseListener<
                            java.util.List<com.motiv.piotr.PhotosListResponse>>
                    onResponseListener) {
        updatePhotosListResponses(photosListResponses);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .photosListResponseDao()
                                .savePhotosListResponses(photosListResponses);
                        passSuccessResultToUi(photosListResponses, onResponseListener);
                    }
                });
    }

    public void loadPhotosListResponses(
            final com.motiv.piotr.OnResponseListener<
                            java.util.List<com.motiv.piotr.PhotosListResponse>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<PhotosListResponseWithReferences> resultWithReferences =
                                myRoomDatabase.photosListResponseDao().getPhotosListResponses();
                        List<PhotosListResponse> result = new ArrayList<>();
                        for (PhotosListResponseWithReferences withReference :
                                resultWithReferences) {
                            result.add(withReference.getPhotosListResponse());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadPhotosListResponse(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.PhotosListResponse>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final PhotosListResponseWithReferences resultWithReference =
                                myRoomDatabase.photosListResponseDao().getPhotosListResponse(id);
                        passSuccessResultToUi(
                                resultWithReference.getPhotosListResponse(), onResponseListener);
                    }
                });
    }

    public void savePhoto(
            final com.motiv.piotr.Photo photo,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Photo> onResponseListener) {
        updatePhoto(photo);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.photoDao().savePhoto(photo);
                        passSuccessResultToUi(photo, onResponseListener);
                    }
                });
    }

    public void savePhotos(
            final java.util.List<com.motiv.piotr.Photo> photos,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Photo>>
                    onResponseListener) {
        updatePhotos(photos);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.photoDao().savePhotos(photos);
                        passSuccessResultToUi(photos, onResponseListener);
                    }
                });
    }

    public void loadPhotos(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Photo>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<PhotoWithReferences> resultWithReferences =
                                myRoomDatabase.photoDao().getPhotos();
                        List<Photo> result = new ArrayList<>();
                        for (PhotoWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getPhoto());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadPhoto(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Photo> onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final PhotoWithReferences resultWithReference =
                                myRoomDatabase.photoDao().getPhoto(id);
                        passSuccessResultToUi(resultWithReference.getPhoto(), onResponseListener);
                    }
                });
    }

    public static void updateUserResponse(UserResponse userResponse) {
        userResponse.setResultId(userResponse.getResult().getId());
        userResponse.setMetaId(userResponse.getMeta().getId());
    }

    public static void updateUserResponses(java.util.List<UserResponse> userResponses) {
        for (UserResponse userResponse : userResponses) {
            updateUserResponse(userResponse);
        }
    }

    public static void updateMeta(Meta meta) {
        meta.setRateLimitId(meta.getRateLimit().getId());
    }

    public static void updateMetas(java.util.List<Meta> metas) {
        for (Meta meta : metas) {
            updateMeta(meta);
        }
    }

    public static void updateUser(User user) {
        user.setLinksId(user.getLinks().getId());
    }

    public static void updateUsers(java.util.List<User> users) {
        for (User user : users) {
            updateUser(user);
        }
    }

    public static void updateLinks(Links links) {
        links.setEditId(links.getEdit().getId());
        links.setSelfId(links.getSelf().getId());
        links.setAvatarId(links.getAvatar().getId());
    }

    public static void updateLinkss(java.util.List<Links> linkss) {
        for (Links links : linkss) {
            updateLinks(links);
        }
    }

    public static void updateUsersListResponse(UsersListResponse usersListResponse) {
        usersListResponse.setMetaId(usersListResponse.getMeta().getId());
        for (com.motiv.piotr.User user : usersListResponse.getResult()) {
            user.setResultOwnerId(usersListResponse.getId());
        }
    }

    public static void updateUsersListResponses(
            java.util.List<UsersListResponse> usersListResponses) {
        for (UsersListResponse usersListResponse : usersListResponses) {
            updateUsersListResponse(usersListResponse);
        }
    }

    public static void updatePostsListResponse(PostsListResponse postsListResponse) {
        postsListResponse.setMetaId(postsListResponse.getMeta().getId());
        for (com.motiv.piotr.Post post : postsListResponse.getResult()) {
            post.setResultOwnerId(postsListResponse.getId());
        }
    }

    public static void updatePostsListResponses(
            java.util.List<PostsListResponse> postsListResponses) {
        for (PostsListResponse postsListResponse : postsListResponses) {
            updatePostsListResponse(postsListResponse);
        }
    }

    public static void updatePost(Post post) {
        post.setLinksId(post.getLinks().getId());
    }

    public static void updatePosts(java.util.List<Post> posts) {
        for (Post post : posts) {
            updatePost(post);
        }
    }

    public static void updatePhotosListResponse(PhotosListResponse photosListResponse) {
        photosListResponse.setMetaId(photosListResponse.getMeta().getId());
        for (com.motiv.piotr.Photo photo : photosListResponse.getResult()) {
            photo.setResultOwnerId(photosListResponse.getId());
        }
    }

    public static void updatePhotosListResponses(
            java.util.List<PhotosListResponse> photosListResponses) {
        for (PhotosListResponse photosListResponse : photosListResponses) {
            updatePhotosListResponse(photosListResponse);
        }
    }

    public static void updatePhoto(Photo photo) {
        photo.setLinksId(photo.getLinks().getId());
    }

    public static void updatePhotos(java.util.List<Photo> photos) {
        for (Photo photo : photos) {
            updatePhoto(photo);
        }
    }

    private <T> void passSuccessResultToUi(
            final T result, final OnResponseListener<T> onResponseListener) {
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        onResponseListener.onSuccess(result);
                    }
                });
    }
}
