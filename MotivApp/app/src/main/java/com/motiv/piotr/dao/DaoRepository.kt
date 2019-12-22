 
package com.motiv.piotr.dao
import androidx.fragment.app.*
import com.motiv.piotr.Link
import com.motiv.piotr.Links
import com.motiv.piotr.Meta
import com.motiv.piotr.OnResponseListener
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
import io.realm.*
import java.util.*
import java.util.concurrent.*
import javax.inject.*
import kotlin.collections.List

public class DaoRepository {

    private var myDatabase: Realm

    constructor(myDatabase: Realm) {
        this.myDatabase = myDatabase
    }

    fun saveUserResponses(userResponses: List<com.motiv.piotr.UserResponse>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.UserResponse>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (userResponse: UserResponse in userResponses) {
                    it.copyToRealm(userResponse)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(userResponses)
            }
        )
    } fun loadUserResponse(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.UserResponse>) {
        var realmResponse = myDatabase.where(UserResponse::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadUserResponses(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.UserResponse>>) {
        val result = myDatabase.where(UserResponse::class.java).findAll()
        val userResponses = mutableListOf<UserResponse>()
        for (i in result.indices) {
            userResponses.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(userResponses)
    } fun saveUserResponse(userResponse: UserResponse, onResponseListener: com.motiv.piotr.OnResponseListener<UserResponse>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(userResponse)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(userResponse)
            }
        )
    } fun saveMetas(metas: List<com.motiv.piotr.Meta>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Meta>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (meta: Meta in metas) {
                    it.copyToRealm(meta)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(metas)
            }
        )
    } fun loadMeta(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Meta>) {
        var realmResponse = myDatabase.where(Meta::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadMetas(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Meta>>) {
        val result = myDatabase.where(Meta::class.java).findAll()
        val metas = mutableListOf<Meta>()
        for (i in result.indices) {
            metas.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(metas)
    } fun saveMeta(meta: Meta, onResponseListener: com.motiv.piotr.OnResponseListener<Meta>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(meta)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(meta)
            }
        )
    } fun saveRateLimits(rateLimits: List<com.motiv.piotr.RateLimit>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.RateLimit>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (rateLimit: RateLimit in rateLimits) {
                    it.copyToRealm(rateLimit)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(rateLimits)
            }
        )
    } fun loadRateLimit(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.RateLimit>) {
        var realmResponse = myDatabase.where(RateLimit::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadRateLimits(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.RateLimit>>) {
        val result = myDatabase.where(RateLimit::class.java).findAll()
        val rateLimits = mutableListOf<RateLimit>()
        for (i in result.indices) {
            rateLimits.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(rateLimits)
    } fun saveRateLimit(rateLimit: RateLimit, onResponseListener: com.motiv.piotr.OnResponseListener<RateLimit>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(rateLimit)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(rateLimit)
            }
        )
    } fun saveUsers(users: List<com.motiv.piotr.User>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.User>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (user: User in users) {
                    it.copyToRealm(user)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(users)
            }
        )
    } fun loadUser(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.User>) {
        var realmResponse = myDatabase.where(User::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadUsers(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.User>>) {
        val result = myDatabase.where(User::class.java).findAll()
        val users = mutableListOf<User>()
        for (i in result.indices) {
            users.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(users)
    } fun saveUser(user: User, onResponseListener: com.motiv.piotr.OnResponseListener<User>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(user)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(user)
            }
        )
    } fun saveLinkss(linkss: List<com.motiv.piotr.Links>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Links>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (links: Links in linkss) {
                    it.copyToRealm(links)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(linkss)
            }
        )
    } fun loadLinks(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Links>) {
        var realmResponse = myDatabase.where(Links::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadLinkss(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Links>>) {
        val result = myDatabase.where(Links::class.java).findAll()
        val linkss = mutableListOf<Links>()
        for (i in result.indices) {
            linkss.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(linkss)
    } fun saveLinks(links: Links, onResponseListener: com.motiv.piotr.OnResponseListener<Links>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(links)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(links)
            }
        )
    } fun saveLinks(links: List<com.motiv.piotr.Link>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Link>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (link: Link in links) {
                    it.copyToRealm(link)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(links)
            }
        )
    } fun loadLink(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Link>) {
        var realmResponse = myDatabase.where(Link::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadLinks(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Link>>) {
        val result = myDatabase.where(Link::class.java).findAll()
        val links = mutableListOf<Link>()
        for (i in result.indices) {
            links.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(links)
    } fun saveLink(link: Link, onResponseListener: com.motiv.piotr.OnResponseListener<Link>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(link)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(link)
            }
        )
    } fun saveUsersListResponses(usersListResponses: List<com.motiv.piotr.UsersListResponse>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.UsersListResponse>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (usersListResponse: UsersListResponse in usersListResponses) {
                    it.copyToRealm(usersListResponse)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(usersListResponses)
            }
        )
    } fun loadUsersListResponse(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.UsersListResponse>) {
        var realmResponse = myDatabase.where(UsersListResponse::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadUsersListResponses(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.UsersListResponse>>) {
        val result = myDatabase.where(UsersListResponse::class.java).findAll()
        val usersListResponses = mutableListOf<UsersListResponse>()
        for (i in result.indices) {
            usersListResponses.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(usersListResponses)
    } fun saveUsersListResponse(usersListResponse: UsersListResponse, onResponseListener: com.motiv.piotr.OnResponseListener<UsersListResponse>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(usersListResponse)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(usersListResponse)
            }
        )
    } fun savePostsListResponses(postsListResponses: List<com.motiv.piotr.PostsListResponse>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.PostsListResponse>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (postsListResponse: PostsListResponse in postsListResponses) {
                    it.copyToRealm(postsListResponse)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(postsListResponses)
            }
        )
    } fun loadPostsListResponse(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.PostsListResponse>) {
        var realmResponse = myDatabase.where(PostsListResponse::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadPostsListResponses(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.PostsListResponse>>) {
        val result = myDatabase.where(PostsListResponse::class.java).findAll()
        val postsListResponses = mutableListOf<PostsListResponse>()
        for (i in result.indices) {
            postsListResponses.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(postsListResponses)
    } fun savePostsListResponse(postsListResponse: PostsListResponse, onResponseListener: com.motiv.piotr.OnResponseListener<PostsListResponse>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(postsListResponse)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(postsListResponse)
            }
        )
    } fun savePosts(posts: List<com.motiv.piotr.Post>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Post>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (post: Post in posts) {
                    it.copyToRealm(post)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(posts)
            }
        )
    } fun loadPost(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Post>) {
        var realmResponse = myDatabase.where(Post::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadPosts(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Post>>) {
        val result = myDatabase.where(Post::class.java).findAll()
        val posts = mutableListOf<Post>()
        for (i in result.indices) {
            posts.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(posts)
    } fun savePost(post: Post, onResponseListener: com.motiv.piotr.OnResponseListener<Post>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(post)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(post)
            }
        )
    } fun savePhotosListResponses(photosListResponses: List<com.motiv.piotr.PhotosListResponse>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.PhotosListResponse>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (photosListResponse: PhotosListResponse in photosListResponses) {
                    it.copyToRealm(photosListResponse)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(photosListResponses)
            }
        )
    } fun loadPhotosListResponse(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.PhotosListResponse>) {
        var realmResponse = myDatabase.where(PhotosListResponse::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadPhotosListResponses(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.PhotosListResponse>>) {
        val result = myDatabase.where(PhotosListResponse::class.java).findAll()
        val photosListResponses = mutableListOf<PhotosListResponse>()
        for (i in result.indices) {
            photosListResponses.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(photosListResponses)
    } fun savePhotosListResponse(photosListResponse: PhotosListResponse, onResponseListener: com.motiv.piotr.OnResponseListener<PhotosListResponse>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(photosListResponse)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(photosListResponse)
            }
        )
    } fun savePhotos(photos: List<com.motiv.piotr.Photo>, onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Photo>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (photo: Photo in photos) {
                    it.copyToRealm(photo)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(photos)
            }
        )
    } fun loadPhoto(id: String, onResponseListener: com.motiv.piotr.OnResponseListener<com.motiv.piotr.Photo>) {
        var realmResponse = myDatabase.where(Photo::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadPhotos(onResponseListener: com.motiv.piotr.OnResponseListener<List<com.motiv.piotr.Photo>>) {
        val result = myDatabase.where(Photo::class.java).findAll()
        val photos = mutableListOf<Photo>()
        for (i in result.indices) {
            photos.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(photos)
    } fun savePhoto(photo: Photo, onResponseListener: com.motiv.piotr.OnResponseListener<Photo>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(photo)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(photo)
            }
        )
    }
}
