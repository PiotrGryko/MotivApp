package com.motiv.piotr.dao;

import androidx.fragment.app.*;
import androidx.room.*;
import com.motiv.piotr.PhotosListResponseWithReferences;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

@Dao
public interface PhotosListResponseDao {

    @Insert
    public long savePhotosListResponse(com.motiv.piotr.PhotosListResponse photosListResponse);

    @Delete
    public int deletePhotosListResponse(com.motiv.piotr.PhotosListResponse photosListResponse);

    @Query("SELECT * FROM photosListResponse")
    @Transaction
    public java.util.List<PhotosListResponseWithReferences> getPhotosListResponses();

    @Query("SELECT * FROM photosListResponse WHERE id = :id")
    @Transaction
    public PhotosListResponseWithReferences getPhotosListResponse(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void savePhotosListResponses(
            java.util.List<com.motiv.piotr.PhotosListResponse> photosListResponse);
}
