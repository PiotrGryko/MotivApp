 
package com.motiv.piotr.dao
import androidx.room.*
import com.motiv.piotr.Links
import com.motiv.piotr.LinksWithReferences
import kotlin.collections.List
@Dao
public interface LinksDao {

    @Insert
    public fun saveLinks(links: com.motiv.piotr.Links): Long@Delete
    public fun deleteLinks(links: com.motiv.piotr.Links): Int@Query("SELECT * FROM links")
    @Transaction
    public fun getLinkss(): List<LinksWithReferences>@Query("SELECT * FROM links WHERE id = :id")
    @Transaction
    public fun getLinks(id: String): LinksWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun saveLinkss(links: List<com.motiv.piotr.Links>): Unit
}
