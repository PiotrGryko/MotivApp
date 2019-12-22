package com.motiv.piotr.dao;

import androidx.fragment.app.*;
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
import io.realm.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import javax.inject.*;

public class DaoRepository {

    private Realm myDatabase;

    public DaoRepository(Realm myDatabase) {
        this.myDatabase = myDatabase;
    }

    public void saveUserResponses(
            final java.util.List<com.motiv.piotr.UserResponse> userResponses,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.UserResponse>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (UserResponse userResponse : userResponses) {
                            realm.copyToRealm(userResponse);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(userResponses);
                    }
                });
    }

    public void loadUserResponse(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.UserResponse>
                    onResponseListener) {
        UserResponse realmResponse =
                myDatabase.where(UserResponse.class).equalTo("id", id).findFirst();
        UserResponse result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadUserResponses(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.UserResponse>>
                    onResponseListener) {
        RealmResults<UserResponse> result = myDatabase.where(UserResponse.class).findAll();
        final List<UserResponse> userResponses = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            userResponses.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(userResponses);
    }

    public void saveUserResponse(
            final UserResponse userResponse,
            final com.motiv.piotr.OnResponseListener<UserResponse> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(userResponse);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(userResponse);
                    }
                });
    }

    public void saveMetas(
            final java.util.List<com.motiv.piotr.Meta> metas,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Meta>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (Meta meta : metas) {
                            realm.copyToRealm(meta);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(metas);
                    }
                });
    }

    public void loadMeta(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Meta> onResponseListener) {
        Meta realmResponse = myDatabase.where(Meta.class).equalTo("id", id).findFirst();
        Meta result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadMetas(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Meta>>
                    onResponseListener) {
        RealmResults<Meta> result = myDatabase.where(Meta.class).findAll();
        final List<Meta> metas = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            metas.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(metas);
    }

    public void saveMeta(
            final Meta meta, final com.motiv.piotr.OnResponseListener<Meta> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(meta);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(meta);
                    }
                });
    }

    public void saveRateLimits(
            final java.util.List<com.motiv.piotr.RateLimit> rateLimits,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.RateLimit>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (RateLimit rateLimit : rateLimits) {
                            realm.copyToRealm(rateLimit);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(rateLimits);
                    }
                });
    }

    public void loadRateLimit(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.RateLimit>
                    onResponseListener) {
        RateLimit realmResponse = myDatabase.where(RateLimit.class).equalTo("id", id).findFirst();
        RateLimit result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadRateLimits(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.RateLimit>>
                    onResponseListener) {
        RealmResults<RateLimit> result = myDatabase.where(RateLimit.class).findAll();
        final List<RateLimit> rateLimits = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            rateLimits.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(rateLimits);
    }

    public void saveRateLimit(
            final RateLimit rateLimit,
            final com.motiv.piotr.OnResponseListener<RateLimit> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(rateLimit);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(rateLimit);
                    }
                });
    }

    public void saveUsers(
            final java.util.List<com.motiv.piotr.User> users,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.User>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (User user : users) {
                            realm.copyToRealm(user);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(users);
                    }
                });
    }

    public void loadUser(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.User> onResponseListener) {
        User realmResponse = myDatabase.where(User.class).equalTo("id", id).findFirst();
        User result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadUsers(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.User>>
                    onResponseListener) {
        RealmResults<User> result = myDatabase.where(User.class).findAll();
        final List<User> users = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            users.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(users);
    }

    public void saveUser(
            final User user, final com.motiv.piotr.OnResponseListener<User> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(user);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(user);
                    }
                });
    }

    public void saveLinkss(
            final java.util.List<com.motiv.piotr.Links> linkss,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Links>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (Links links : linkss) {
                            realm.copyToRealm(links);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(linkss);
                    }
                });
    }

    public void loadLinks(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Links> onResponseListener) {
        Links realmResponse = myDatabase.where(Links.class).equalTo("id", id).findFirst();
        Links result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadLinkss(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Links>>
                    onResponseListener) {
        RealmResults<Links> result = myDatabase.where(Links.class).findAll();
        final List<Links> linkss = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            linkss.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(linkss);
    }

    public void saveLinks(
            final Links links, final com.motiv.piotr.OnResponseListener<Links> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(links);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(links);
                    }
                });
    }

    public void saveLinks(
            final java.util.List<com.motiv.piotr.Link> links,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Link>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (Link link : links) {
                            realm.copyToRealm(link);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(links);
                    }
                });
    }

    public void loadLink(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Link> onResponseListener) {
        Link realmResponse = myDatabase.where(Link.class).equalTo("id", id).findFirst();
        Link result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadLinks(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Link>>
                    onResponseListener) {
        RealmResults<Link> result = myDatabase.where(Link.class).findAll();
        final List<Link> links = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            links.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(links);
    }

    public void saveLink(
            final Link link, final com.motiv.piotr.OnResponseListener<Link> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(link);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(link);
                    }
                });
    }

    public void saveUsersListResponses(
            final java.util.List<com.motiv.piotr.UsersListResponse> usersListResponses,
            final com.motiv.piotr.OnResponseListener<
                            java.util.List<com.motiv.piotr.UsersListResponse>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (UsersListResponse usersListResponse : usersListResponses) {
                            realm.copyToRealm(usersListResponse);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(usersListResponses);
                    }
                });
    }

    public void loadUsersListResponse(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.UsersListResponse>
                    onResponseListener) {
        UsersListResponse realmResponse =
                myDatabase.where(UsersListResponse.class).equalTo("id", id).findFirst();
        UsersListResponse result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadUsersListResponses(
            final com.motiv.piotr.OnResponseListener<
                            java.util.List<com.motiv.piotr.UsersListResponse>>
                    onResponseListener) {
        RealmResults<UsersListResponse> result =
                myDatabase.where(UsersListResponse.class).findAll();
        final List<UsersListResponse> usersListResponses = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            usersListResponses.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(usersListResponses);
    }

    public void saveUsersListResponse(
            final UsersListResponse usersListResponse,
            final com.motiv.piotr.OnResponseListener<UsersListResponse> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(usersListResponse);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(usersListResponse);
                    }
                });
    }

    public void savePostsListResponses(
            final java.util.List<com.motiv.piotr.PostsListResponse> postsListResponses,
            final com.motiv.piotr.OnResponseListener<
                            java.util.List<com.motiv.piotr.PostsListResponse>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (PostsListResponse postsListResponse : postsListResponses) {
                            realm.copyToRealm(postsListResponse);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(postsListResponses);
                    }
                });
    }

    public void loadPostsListResponse(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.PostsListResponse>
                    onResponseListener) {
        PostsListResponse realmResponse =
                myDatabase.where(PostsListResponse.class).equalTo("id", id).findFirst();
        PostsListResponse result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadPostsListResponses(
            final com.motiv.piotr.OnResponseListener<
                            java.util.List<com.motiv.piotr.PostsListResponse>>
                    onResponseListener) {
        RealmResults<PostsListResponse> result =
                myDatabase.where(PostsListResponse.class).findAll();
        final List<PostsListResponse> postsListResponses = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            postsListResponses.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(postsListResponses);
    }

    public void savePostsListResponse(
            final PostsListResponse postsListResponse,
            final com.motiv.piotr.OnResponseListener<PostsListResponse> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(postsListResponse);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(postsListResponse);
                    }
                });
    }

    public void savePosts(
            final java.util.List<com.motiv.piotr.Post> posts,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Post>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (Post post : posts) {
                            realm.copyToRealm(post);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(posts);
                    }
                });
    }

    public void loadPost(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Post> onResponseListener) {
        Post realmResponse = myDatabase.where(Post.class).equalTo("id", id).findFirst();
        Post result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadPosts(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Post>>
                    onResponseListener) {
        RealmResults<Post> result = myDatabase.where(Post.class).findAll();
        final List<Post> posts = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            posts.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(posts);
    }

    public void savePost(
            final Post post, final com.motiv.piotr.OnResponseListener<Post> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(post);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(post);
                    }
                });
    }

    public void savePhotosListResponses(
            final java.util.List<com.motiv.piotr.PhotosListResponse> photosListResponses,
            final com.motiv.piotr.OnResponseListener<
                            java.util.List<com.motiv.piotr.PhotosListResponse>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (PhotosListResponse photosListResponse : photosListResponses) {
                            realm.copyToRealm(photosListResponse);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(photosListResponses);
                    }
                });
    }

    public void loadPhotosListResponse(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.PhotosListResponse>
                    onResponseListener) {
        PhotosListResponse realmResponse =
                myDatabase.where(PhotosListResponse.class).equalTo("id", id).findFirst();
        PhotosListResponse result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadPhotosListResponses(
            final com.motiv.piotr.OnResponseListener<
                            java.util.List<com.motiv.piotr.PhotosListResponse>>
                    onResponseListener) {
        RealmResults<PhotosListResponse> result =
                myDatabase.where(PhotosListResponse.class).findAll();
        final List<PhotosListResponse> photosListResponses = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            photosListResponses.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(photosListResponses);
    }

    public void savePhotosListResponse(
            final PhotosListResponse photosListResponse,
            final com.motiv.piotr.OnResponseListener<PhotosListResponse> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(photosListResponse);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(photosListResponse);
                    }
                });
    }

    public void savePhotos(
            final java.util.List<com.motiv.piotr.Photo> photos,
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Photo>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (Photo photo : photos) {
                            realm.copyToRealm(photo);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(photos);
                    }
                });
    }

    public void loadPhoto(
            final java.lang.String id,
            final com.motiv.piotr.OnResponseListener<com.motiv.piotr.Photo> onResponseListener) {
        Photo realmResponse = myDatabase.where(Photo.class).equalTo("id", id).findFirst();
        Photo result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadPhotos(
            final com.motiv.piotr.OnResponseListener<java.util.List<com.motiv.piotr.Photo>>
                    onResponseListener) {
        RealmResults<Photo> result = myDatabase.where(Photo.class).findAll();
        final List<Photo> photos = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            photos.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(photos);
    }

    public void savePhoto(
            final Photo photo, final com.motiv.piotr.OnResponseListener<Photo> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(photo);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(photo);
                    }
                });
    }
}
