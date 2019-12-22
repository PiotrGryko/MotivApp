 
package com.motiv.piotr.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.piotr.PostsListResponse
import com.motiv.piotr.PostsListResponseWithReferences
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
@Dao
public interface PostsListResponseDao {

    @Insert
    public fun savePostsListResponse(postsListResponse: com.motiv.piotr.PostsListResponse): Long@Delete
    public fun deletePostsListResponse(postsListResponse: com.motiv.piotr.PostsListResponse): Int@Query("SELECT * FROM postsListResponse")
    @Transaction
    public fun getPostsListResponses(): List<PostsListResponseWithReferences>@Query("SELECT * FROM postsListResponse WHERE id = :id")
    @Transaction
    public fun getPostsListResponse(id: String): PostsListResponseWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun savePostsListResponses(postsListResponse: List<com.motiv.piotr.PostsListResponse>): Unit
}
