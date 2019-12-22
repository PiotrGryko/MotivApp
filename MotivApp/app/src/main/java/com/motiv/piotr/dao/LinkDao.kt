 
package com.motiv.piotr.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.piotr.Link
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
@Dao
public interface LinkDao {

    @Insert
    public fun saveLink(link: com.motiv.piotr.Link): Long@Delete
    public fun deleteLink(link: com.motiv.piotr.Link): Int@Query("SELECT * FROM link")
    public fun getLinks(): List<Link>@Query("SELECT * FROM link WHERE id = :id")
    public fun getLink(id: String): Link@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun saveLinks(link: List<com.motiv.piotr.Link>): Unit
}
