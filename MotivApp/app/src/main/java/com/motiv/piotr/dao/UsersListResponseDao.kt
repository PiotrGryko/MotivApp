 
package com.motiv.piotr.dao
import androidx.room.*
import com.motiv.piotr.UsersListResponse
import com.motiv.piotr.UsersListResponseWithReferences
import kotlin.collections.List
@Dao
public interface UsersListResponseDao {

    @Insert
    public fun saveUsersListResponse(usersListResponse: com.motiv.piotr.UsersListResponse): Long@Delete
    public fun deleteUsersListResponse(usersListResponse: com.motiv.piotr.UsersListResponse): Int@Query("SELECT * FROM usersListResponse")
    @Transaction
    public fun getUsersListResponses(): List<UsersListResponseWithReferences>@Query("SELECT * FROM usersListResponse WHERE id = :id")
    @Transaction
    public fun getUsersListResponse(id: String): UsersListResponseWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun saveUsersListResponses(usersListResponse: List<com.motiv.piotr.UsersListResponse>): Unit
}
