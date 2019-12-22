 
package com.motiv.piotr.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.piotr.Meta
import com.motiv.piotr.MetaWithReferences
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
@Dao
public interface MetaDao {

    @Insert
    public fun saveMeta(meta: com.motiv.piotr.Meta): Long@Delete
    public fun deleteMeta(meta: com.motiv.piotr.Meta): Int@Query("SELECT * FROM meta")
    @Transaction
    public fun getMetas(): List<MetaWithReferences>@Query("SELECT * FROM meta WHERE id = :id")
    @Transaction
    public fun getMeta(id: String): MetaWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun saveMetas(meta: List<com.motiv.piotr.Meta>): Unit
}
