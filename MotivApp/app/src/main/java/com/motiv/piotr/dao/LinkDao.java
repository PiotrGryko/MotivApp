package com.motiv.piotr.dao;

import androidx.fragment.app.*;
import androidx.room.*;
import com.motiv.piotr.Link;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

@Dao
public interface LinkDao {

    @Insert
    public long saveLink(com.motiv.piotr.Link link);

    @Delete
    public int deleteLink(com.motiv.piotr.Link link);

    @Query("SELECT * FROM link")
    public java.util.List<Link> getLinks();

    @Query("SELECT * FROM link WHERE id = :id")
    public Link getLink(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveLinks(java.util.List<com.motiv.piotr.Link> link);
}
