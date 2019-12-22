package com.motiv.piotr;

import androidx.room.*;

public class PostsListResponseWithReferences {

    @Embedded private com.motiv.piotr.PostsListResponse postsListResponse;

    @Relation(entity = com.motiv.piotr.Meta.class, parentColumn = "metaId", entityColumn = "id")
    public java.util.List<com.motiv.piotr.Meta> meta;

    @Relation(
        entity = com.motiv.piotr.Post.class,
        parentColumn = "id",
        entityColumn = "resultOwnerId"
    )
    public java.util.List<com.motiv.piotr.Post> result;

    public PostsListResponse getPostsListResponse() {
        if (meta.size() > 0) {
            postsListResponse.setMeta(meta.get(0));
        }
        postsListResponse.setResult(result);

        return postsListResponse;
    }

    public void setPostsListResponse(PostsListResponse postsListResponse) {
        this.postsListResponse = postsListResponse;
    }
}
