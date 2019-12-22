 
package com.motiv.piotr.dao
import androidx.room.*
import com.motiv.piotr.PhotosListResponse
import com.motiv.piotr.PhotosListResponseWithReferences
import kotlin.collections.List
@Dao
public interface PhotosListResponseDao {

    @Insert
    public fun savePhotosListResponse(photosListResponse: com.motiv.piotr.PhotosListResponse): Long@Delete
    public fun deletePhotosListResponse(photosListResponse: com.motiv.piotr.PhotosListResponse): Int@Query("SELECT * FROM photosListResponse")
    @Transaction
    public fun getPhotosListResponses(): List<PhotosListResponseWithReferences>@Query("SELECT * FROM photosListResponse WHERE id = :id")
    @Transaction
    public fun getPhotosListResponse(id: String): PhotosListResponseWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun savePhotosListResponses(photosListResponse: List<com.motiv.piotr.PhotosListResponse>): Unit
}
