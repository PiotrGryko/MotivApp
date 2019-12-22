 
package com.motiv.piotr.dao
import androidx.room.*
import com.motiv.piotr.Post
import com.motiv.piotr.PostWithReferences
import kotlin.collections.List
@Dao
public interface PostDao {

    @Insert
    public fun savePost(post: com.motiv.piotr.Post): Long@Delete
    public fun deletePost(post: com.motiv.piotr.Post): Int@Query("SELECT * FROM post")
    @Transaction
    public fun getPosts(): List<PostWithReferences>@Query("SELECT * FROM post WHERE id = :id")
    @Transaction
    public fun getPost(id: String): PostWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun savePosts(post: List<com.motiv.piotr.Post>): Unit
}
