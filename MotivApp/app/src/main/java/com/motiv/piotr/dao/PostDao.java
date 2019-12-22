package com.motiv.piotr.dao;

import androidx.room.*;
import com.motiv.piotr.PostWithReferences;

@Dao
public interface PostDao {

    @Insert
    public long savePost(com.motiv.piotr.Post post);

    @Delete
    public int deletePost(com.motiv.piotr.Post post);

    @Query("SELECT * FROM post")
    @Transaction
    public java.util.List<PostWithReferences> getPosts();

    @Query("SELECT * FROM post WHERE id = :id")
    @Transaction
    public PostWithReferences getPost(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void savePosts(java.util.List<com.motiv.piotr.Post> post);
}
