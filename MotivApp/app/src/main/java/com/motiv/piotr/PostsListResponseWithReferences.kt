 
package com.motiv.piotr
import androidx.room.*
import kotlin.collections.List

public class PostsListResponseWithReferences {

    @Embedded
    private lateinit var postsListResponse: com.motiv.piotr.PostsListResponse

    @Relation(entity = com.motiv.piotr.Meta::class, parentColumn = "metaId", entityColumn = "id")

    public var meta: List<com.motiv.piotr.Meta> = arrayListOf()
    @Relation(entity = com.motiv.piotr.Post::class, parentColumn = "id", entityColumn = "resultOwnerId")
    public var result: List<com.motiv.piotr.Post> = arrayListOf()

    fun getPostsListResponse(): PostsListResponse {
        if (meta.size > 0) {
            postsListResponse.setMeta(meta.get(0))
        }
        postsListResponse.setResult(result)

        return postsListResponse
    } public fun setPostsListResponse(postsListResponse: PostsListResponse) { this.postsListResponse = postsListResponse; }
}
