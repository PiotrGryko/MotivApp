package com.motiv.piotr.dao;

import androidx.fragment.app.*;
import androidx.room.*;
import com.motiv.piotr.PhotoWithReferences;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

@Dao
public interface PhotoDao {

    @Insert
    public long savePhoto(com.motiv.piotr.Photo photo);

    @Delete
    public int deletePhoto(com.motiv.piotr.Photo photo);

    @Query("SELECT * FROM photo")
    @Transaction
    public java.util.List<PhotoWithReferences> getPhotos();

    @Query("SELECT * FROM photo WHERE id = :id")
    @Transaction
    public PhotoWithReferences getPhoto(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void savePhotos(java.util.List<com.motiv.piotr.Photo> photo);
}
