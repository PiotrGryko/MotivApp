package com.motiv.piotr.dao;

import androidx.room.*;
import com.motiv.piotr.LinksWithReferences;

@Dao
public interface LinksDao {

    @Insert
    public long saveLinks(com.motiv.piotr.Links links);

    @Delete
    public int deleteLinks(com.motiv.piotr.Links links);

    @Query("SELECT * FROM links")
    @Transaction
    public java.util.List<LinksWithReferences> getLinkss();

    @Query("SELECT * FROM links WHERE id = :id")
    @Transaction
    public LinksWithReferences getLinks(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveLinkss(java.util.List<com.motiv.piotr.Links> links);
}
