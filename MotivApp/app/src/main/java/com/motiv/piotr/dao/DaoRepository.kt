 
package com.motiv.piotr.dao
import android.os.Handler
import com.motiv.piotr.Link
import com.motiv.piotr.Links
import com.motiv.piotr.LinksWithReferences
import com.motiv.piotr.Meta
import com.motiv.piotr.MetaWithReferences
import com.motiv.piotr.OnResponseListener
import com.motiv.piotr.Photo
import com.motiv.piotr.PhotoWithReferences
import com.motiv.piotr.PhotosListResponse
import com.motiv.piotr.PhotosListResponseWithReferences
import com.motiv.piotr.Post
import com.motiv.piotr.PostWithReferences
import com.motiv.piotr.PostsListResponse
import com.motiv.piotr.PostsListResponseWithReferences
import com.motiv.piotr.RateLimit
import com.motiv.piotr.User
import com.motiv.piotr.UserResponse
import com.motiv.piotr.UserResponseWithReferences
import com.motiv.piotr.UserWithReferences
import com.motiv.piotr.UsersListResponse
import com.motiv.piotr.UsersListResponseWithReferences
import java.util.*
import java.util.concurrent.*
import kotlin.collections.List

public class DaoRepository(val handler: Handler, val myRoomDatabase: MyRoomDatabase, val executor: Executor) {

    fun saveUserResponse(userResponse: com.motiv.piotr.UserResponse, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.UserResponse>) {
        updateUserResponse(userResponse); executor.execute {
            myRoomDatabase.userResponseDao().saveUserResponse(userResponse)
            passSuccessResultToUi(userResponse, onResponseListener)
        }
    } fun saveUserResponses(userResponses: List<com.motiv.piotr.UserResponse>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.UserResponse>>) {
        updateUserResponses(userResponses)
        executor.execute {
            myRoomDatabase.userResponseDao().saveUserResponses(userResponses)
            passSuccessResultToUi(userResponses, onResponseListener)
        }
    } fun loadUserResponses(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.UserResponse>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.userResponseDao().getUserResponses()
            val result = ArrayList<UserResponse>()
            for (withReference: UserResponseWithReferences in resultWithReferences) {
                result.add(withReference.getUserResponse())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadUserResponse(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.UserResponse>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.userResponseDao().getUserResponse(id)
            passSuccessResultToUi(resultWithReference.getUserResponse(), onResponseListener)
        }
    } fun saveMeta(meta: com.motiv.piotr.Meta, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Meta>) {
        updateMeta(meta); executor.execute {
            myRoomDatabase.metaDao().saveMeta(meta)
            passSuccessResultToUi(meta, onResponseListener)
        }
    } fun saveMetas(metas: List<com.motiv.piotr.Meta>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Meta>>) {
        updateMetas(metas)
        executor.execute {
            myRoomDatabase.metaDao().saveMetas(metas)
            passSuccessResultToUi(metas, onResponseListener)
        }
    } fun loadMetas(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Meta>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.metaDao().getMetas()
            val result = ArrayList<Meta>()
            for (withReference: MetaWithReferences in resultWithReferences) {
                result.add(withReference.getMeta())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadMeta(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Meta>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.metaDao().getMeta(id)
            passSuccessResultToUi(resultWithReference.getMeta(), onResponseListener)
        }
    } fun saveRateLimit(rateLimit: com.motiv.piotr.RateLimit, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.RateLimit>) {
        executor.execute {
            myRoomDatabase.rateLimitDao().saveRateLimit(rateLimit)
            passSuccessResultToUi(rateLimit, onResponseListener)
        }
    } fun saveRateLimits(rateLimits: List<com.motiv.piotr.RateLimit>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.RateLimit>>) {
        executor.execute {
            myRoomDatabase.rateLimitDao().saveRateLimits(rateLimits)
            passSuccessResultToUi(rateLimits, onResponseListener)
        }
    } fun loadRateLimits(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.RateLimit>>) {
        executor.execute {
            var result: List<RateLimit> = myRoomDatabase.rateLimitDao().getRateLimits()
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadRateLimit(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.RateLimit>) {
        executor.execute {
            var result: RateLimit = myRoomDatabase.rateLimitDao().getRateLimit(id)
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun saveUser(user: com.motiv.piotr.User, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.User>) {
        updateUser(user); executor.execute {
            myRoomDatabase.userDao().saveUser(user)
            passSuccessResultToUi(user, onResponseListener)
        }
    } fun saveUsers(users: List<com.motiv.piotr.User>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.User>>) {
        updateUsers(users)
        executor.execute {
            myRoomDatabase.userDao().saveUsers(users)
            passSuccessResultToUi(users, onResponseListener)
        }
    } fun loadUsers(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.User>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.userDao().getUsers()
            val result = ArrayList<User>()
            for (withReference: UserWithReferences in resultWithReferences) {
                result.add(withReference.getUser())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadUser(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.User>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.userDao().getUser(id)
            passSuccessResultToUi(resultWithReference.getUser(), onResponseListener)
        }
    } fun saveLinks(links: com.motiv.piotr.Links, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Links>) {
        updateLinks(links); executor.execute {
            myRoomDatabase.linksDao().saveLinks(links)
            passSuccessResultToUi(links, onResponseListener)
        }
    } fun saveLinkss(linkss: List<com.motiv.piotr.Links>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Links>>) {
        updateLinkss(linkss)
        executor.execute {
            myRoomDatabase.linksDao().saveLinkss(linkss)
            passSuccessResultToUi(linkss, onResponseListener)
        }
    } fun loadLinkss(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Links>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.linksDao().getLinkss()
            val result = ArrayList<Links>()
            for (withReference: LinksWithReferences in resultWithReferences) {
                result.add(withReference.getLinks())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadLinks(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Links>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.linksDao().getLinks(id)
            passSuccessResultToUi(resultWithReference.getLinks(), onResponseListener)
        }
    } fun saveLink(link: com.motiv.piotr.Link, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Link>) {
        executor.execute {
            myRoomDatabase.linkDao().saveLink(link)
            passSuccessResultToUi(link, onResponseListener)
        }
    } fun saveLinks(links: List<com.motiv.piotr.Link>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Link>>) {
        executor.execute {
            myRoomDatabase.linkDao().saveLinks(links)
            passSuccessResultToUi(links, onResponseListener)
        }
    } fun loadLinks(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Link>>) {
        executor.execute {
            var result: List<Link> = myRoomDatabase.linkDao().getLinks()
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadLink(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Link>) {
        executor.execute {
            var result: Link = myRoomDatabase.linkDao().getLink(id)
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun saveUsersListResponse(usersListResponse: com.motiv.piotr.UsersListResponse, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.UsersListResponse>) {
        updateUsersListResponse(usersListResponse); executor.execute {
            myRoomDatabase.usersListResponseDao().saveUsersListResponse(usersListResponse)
            passSuccessResultToUi(usersListResponse, onResponseListener)
        }
    } fun saveUsersListResponses(usersListResponses: List<com.motiv.piotr.UsersListResponse>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.UsersListResponse>>) {
        updateUsersListResponses(usersListResponses)
        executor.execute {
            myRoomDatabase.usersListResponseDao().saveUsersListResponses(usersListResponses)
            passSuccessResultToUi(usersListResponses, onResponseListener)
        }
    } fun loadUsersListResponses(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.UsersListResponse>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.usersListResponseDao().getUsersListResponses()
            val result = ArrayList<UsersListResponse>()
            for (withReference: UsersListResponseWithReferences in resultWithReferences) {
                result.add(withReference.getUsersListResponse())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadUsersListResponse(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.UsersListResponse>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.usersListResponseDao().getUsersListResponse(id)
            passSuccessResultToUi(resultWithReference.getUsersListResponse(), onResponseListener)
        }
    } fun savePostsListResponse(postsListResponse: com.motiv.piotr.PostsListResponse, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.PostsListResponse>) {
        updatePostsListResponse(postsListResponse); executor.execute {
            myRoomDatabase.postsListResponseDao().savePostsListResponse(postsListResponse)
            passSuccessResultToUi(postsListResponse, onResponseListener)
        }
    } fun savePostsListResponses(postsListResponses: List<com.motiv.piotr.PostsListResponse>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.PostsListResponse>>) {
        updatePostsListResponses(postsListResponses)
        executor.execute {
            myRoomDatabase.postsListResponseDao().savePostsListResponses(postsListResponses)
            passSuccessResultToUi(postsListResponses, onResponseListener)
        }
    } fun loadPostsListResponses(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.PostsListResponse>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.postsListResponseDao().getPostsListResponses()
            val result = ArrayList<PostsListResponse>()
            for (withReference: PostsListResponseWithReferences in resultWithReferences) {
                result.add(withReference.getPostsListResponse())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadPostsListResponse(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.PostsListResponse>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.postsListResponseDao().getPostsListResponse(id)
            passSuccessResultToUi(resultWithReference.getPostsListResponse(), onResponseListener)
        }
    } fun savePost(post: com.motiv.piotr.Post, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Post>) {
        updatePost(post); executor.execute {
            myRoomDatabase.postDao().savePost(post)
            passSuccessResultToUi(post, onResponseListener)
        }
    } fun savePosts(posts: List<com.motiv.piotr.Post>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Post>>) {
        updatePosts(posts)
        executor.execute {
            myRoomDatabase.postDao().savePosts(posts)
            passSuccessResultToUi(posts, onResponseListener)
        }
    } fun loadPosts(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Post>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.postDao().getPosts()
            val result = ArrayList<Post>()
            for (withReference: PostWithReferences in resultWithReferences) {
                result.add(withReference.getPost())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadPost(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Post>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.postDao().getPost(id)
            passSuccessResultToUi(resultWithReference.getPost(), onResponseListener)
        }
    } fun savePhotosListResponse(photosListResponse: com.motiv.piotr.PhotosListResponse, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.PhotosListResponse>) {
        updatePhotosListResponse(photosListResponse); executor.execute {
            myRoomDatabase.photosListResponseDao().savePhotosListResponse(photosListResponse)
            passSuccessResultToUi(photosListResponse, onResponseListener)
        }
    } fun savePhotosListResponses(photosListResponses: List<com.motiv.piotr.PhotosListResponse>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.PhotosListResponse>>) {
        updatePhotosListResponses(photosListResponses)
        executor.execute {
            myRoomDatabase.photosListResponseDao().savePhotosListResponses(photosListResponses)
            passSuccessResultToUi(photosListResponses, onResponseListener)
        }
    } fun loadPhotosListResponses(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.PhotosListResponse>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.photosListResponseDao().getPhotosListResponses()
            val result = ArrayList<PhotosListResponse>()
            for (withReference: PhotosListResponseWithReferences in resultWithReferences) {
                result.add(withReference.getPhotosListResponse())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadPhotosListResponse(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.PhotosListResponse>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.photosListResponseDao().getPhotosListResponse(id)
            passSuccessResultToUi(resultWithReference.getPhotosListResponse(), onResponseListener)
        }
    } fun savePhoto(photo: com.motiv.piotr.Photo, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Photo>) {
        updatePhoto(photo); executor.execute {
            myRoomDatabase.photoDao().savePhoto(photo)
            passSuccessResultToUi(photo, onResponseListener)
        }
    } fun savePhotos(photos: List<com.motiv.piotr.Photo>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Photo>>) {
        updatePhotos(photos)
        executor.execute {
            myRoomDatabase.photoDao().savePhotos(photos)
            passSuccessResultToUi(photos, onResponseListener)
        }
    } fun loadPhotos(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Photo>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.photoDao().getPhotos()
            val result = ArrayList<Photo>()
            for (withReference: PhotoWithReferences in resultWithReferences) {
                result.add(withReference.getPhoto())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadPhoto(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Photo>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.photoDao().getPhoto(id)
            passSuccessResultToUi(resultWithReference.getPhoto(), onResponseListener)
        }
    } fun updateUserResponse(userResponse: UserResponse) {
        userResponse.setResultId(userResponse.getResult()?.getId()); userResponse.setMetaId(userResponse.getMeta()?.getId())
    } fun updateUserResponses(userResponses: List<UserResponse>) {
        for (userResponse: UserResponse in userResponses) {
            updateUserResponse(userResponse)
        }
    } fun updateMeta(meta: Meta) {
        meta.setRateLimitId(meta.getRateLimit()?.getId())
    } fun updateMetas(metas: List<Meta>) {
        for (meta: Meta in metas) {
            updateMeta(meta)
        }
    } fun updateUser(user: User) {
        user.setLinksId(user.getLinks()?.getId())
    } fun updateUsers(users: List<User>) {
        for (user: User in users) {
            updateUser(user)
        }
    } fun updateLinks(links: Links) {
        links.setEditId(links.getEdit()?.getId()); links.setSelfId(links.getSelf()?.getId()); links.setAvatarId(links.getAvatar()?.getId())
    } fun updateLinkss(linkss: List<Links>) {
        for (links: Links in linkss) {
            updateLinks(links)
        }
    } fun updateUsersListResponse(usersListResponse: UsersListResponse) {
        usersListResponse.setMetaId(usersListResponse.getMeta()?.getId()); for (user: com.motiv.piotr.User in usersListResponse.getResult()) {
            user.setResultOwnerId(usersListResponse.getId())
        }
    } fun updateUsersListResponses(usersListResponses: List<UsersListResponse>) {
        for (usersListResponse: UsersListResponse in usersListResponses) {
            updateUsersListResponse(usersListResponse)
        }
    } fun updatePostsListResponse(postsListResponse: PostsListResponse) {
        postsListResponse.setMetaId(postsListResponse.getMeta()?.getId()); for (post: com.motiv.piotr.Post in postsListResponse.getResult()) {
            post.setResultOwnerId(postsListResponse.getId())
        }
    } fun updatePostsListResponses(postsListResponses: List<PostsListResponse>) {
        for (postsListResponse: PostsListResponse in postsListResponses) {
            updatePostsListResponse(postsListResponse)
        }
    } fun updatePost(post: Post) {
        post.setLinksId(post.getLinks()?.getId())
    } fun updatePosts(posts: List<Post>) {
        for (post: Post in posts) {
            updatePost(post)
        }
    } fun updatePhotosListResponse(photosListResponse: PhotosListResponse) {
        photosListResponse.setMetaId(photosListResponse.getMeta()?.getId()); for (photo: com.motiv.piotr.Photo in photosListResponse.getResult()) {
            photo.setResultOwnerId(photosListResponse.getId())
        }
    } fun updatePhotosListResponses(photosListResponses: List<PhotosListResponse>) {
        for (photosListResponse: PhotosListResponse in photosListResponses) {
            updatePhotosListResponse(photosListResponse)
        }
    } fun updatePhoto(photo: Photo) {
        photo.setLinksId(photo.getLinks()?.getId())
    } fun updatePhotos(photos: List<Photo>) {
        for (photo: Photo in photos) {
            updatePhoto(photo)
        }
    } private fun <T> passSuccessResultToUi(result: T, onResponseListener: OnResponseListener<T>) {
        handler.post { onResponseListener.onSuccess(result); }
    }
}
