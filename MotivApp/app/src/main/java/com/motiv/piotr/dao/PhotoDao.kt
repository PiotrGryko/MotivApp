 
package com.motiv.piotr.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.piotr.Photo
import com.motiv.piotr.PhotoWithReferences
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
@Dao
public interface PhotoDao {

    @Insert
    public fun savePhoto(photo: com.motiv.piotr.Photo): Long@Delete
    public fun deletePhoto(photo: com.motiv.piotr.Photo): Int@Query("SELECT * FROM photo")
    @Transaction
    public fun getPhotos(): List<PhotoWithReferences>@Query("SELECT * FROM photo WHERE id = :id")
    @Transaction
    public fun getPhoto(id: String): PhotoWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun savePhotos(photo: List<com.motiv.piotr.Photo>): Unit
}
