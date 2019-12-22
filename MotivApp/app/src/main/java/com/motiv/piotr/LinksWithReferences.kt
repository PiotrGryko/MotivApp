 
package com.motiv.piotr
import androidx.fragment.app.*
import androidx.room.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List

public class LinksWithReferences {

    @Embedded
    private lateinit var links: com.motiv.piotr.Links

    @Relation(entity = com.motiv.piotr.Link::class, parentColumn = "editId", entityColumn = "id")

    public var edit: List<com.motiv.piotr.Link> = arrayListOf()
    @Relation(entity = com.motiv.piotr.Link::class, parentColumn = "selfId", entityColumn = "id")
    public var self: List<com.motiv.piotr.Link> = arrayListOf()
    @Relation(entity = com.motiv.piotr.Link::class, parentColumn = "avatarId", entityColumn = "id")
    public var avatar: List<com.motiv.piotr.Link> = arrayListOf()

    fun getLinks(): Links {
        if (edit.size > 0) {
            links.setEdit(edit.get(0))
        }
        if (self.size > 0) {
            links.setSelf(self.get(0))
        }
        if (avatar.size > 0) {
            links.setAvatar(avatar.get(0))
        }

        return links
    } public fun setLinks(links: Links) { this.links = links; }
}
