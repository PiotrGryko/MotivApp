 
package com.motiv.piotr
import androidx.room.*
import kotlin.collections.List

public class PostWithReferences {

    @Embedded
    private lateinit var post: com.motiv.piotr.Post

    @Relation(entity = com.motiv.piotr.Links::class, parentColumn = "linksId", entityColumn = "id")

    public var links: List<com.motiv.piotr.Links> = arrayListOf()

    fun getPost(): Post {
        if (links.size > 0) {
            post.setLinks(links.get(0))
        }

        return post
    } public fun setPost(post: Post) { this.post = post; }
}
