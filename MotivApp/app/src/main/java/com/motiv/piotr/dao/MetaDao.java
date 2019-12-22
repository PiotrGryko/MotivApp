package com.motiv.piotr.dao;

import androidx.room.*;
import com.motiv.piotr.MetaWithReferences;

@Dao
public interface MetaDao {

    @Insert
    public long saveMeta(com.motiv.piotr.Meta meta);

    @Delete
    public int deleteMeta(com.motiv.piotr.Meta meta);

    @Query("SELECT * FROM meta")
    @Transaction
    public java.util.List<MetaWithReferences> getMetas();

    @Query("SELECT * FROM meta WHERE id = :id")
    @Transaction
    public MetaWithReferences getMeta(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveMetas(java.util.List<com.motiv.piotr.Meta> meta);
}
