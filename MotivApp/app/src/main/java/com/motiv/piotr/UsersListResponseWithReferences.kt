 
package com.motiv.piotr
import androidx.fragment.app.*
import androidx.room.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List

public class UsersListResponseWithReferences {

    @Embedded
    private lateinit var usersListResponse: com.motiv.piotr.UsersListResponse

    @Relation(entity = com.motiv.piotr.Meta::class, parentColumn = "metaId", entityColumn = "id")

    public var meta: List<com.motiv.piotr.Meta> = arrayListOf()
    @Relation(entity = com.motiv.piotr.User::class, parentColumn = "id", entityColumn = "resultOwnerId")
    public var result: List<com.motiv.piotr.User> = arrayListOf()

    fun getUsersListResponse(): UsersListResponse {
        if (meta.size > 0) {
            usersListResponse.setMeta(meta.get(0))
        }
        usersListResponse.setResult(result)

        return usersListResponse
    } public fun setUsersListResponse(usersListResponse: UsersListResponse) { this.usersListResponse = usersListResponse; }
}
