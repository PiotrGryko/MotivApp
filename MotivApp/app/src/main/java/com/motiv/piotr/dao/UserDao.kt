 
package com.motiv.piotr.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.piotr.User
import com.motiv.piotr.UserWithReferences
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
@Dao
public interface UserDao {

    @Insert
    public fun saveUser(user: com.motiv.piotr.User): Long@Delete
    public fun deleteUser(user: com.motiv.piotr.User): Int@Query("SELECT * FROM user")
    @Transaction
    public fun getUsers(): List<UserWithReferences>@Query("SELECT * FROM user WHERE id = :id")
    @Transaction
    public fun getUser(id: String): UserWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun saveUsers(user: List<com.motiv.piotr.User>): Unit
}
