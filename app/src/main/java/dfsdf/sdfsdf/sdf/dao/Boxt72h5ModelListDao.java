package dfsdf.sdfsdf.sdf.dao;

import androidx.room.*;
import dfsdf.sdfsdf.sdf.Boxt72h5ModelList;

@Dao
public interface Boxt72h5ModelListDao {

    @Insert
    public long saveBoxt72h5ModelList(dfsdf.sdfsdf.sdf.Boxt72h5ModelList boxt72h5ModelList);

    @Delete
    public int deleteBoxt72h5ModelList(dfsdf.sdfsdf.sdf.Boxt72h5ModelList boxt72h5ModelList);

    @Query("SELECT * FROM boxt72h5ModelList")
    public java.util.List<Boxt72h5ModelList> getBoxt72h5ModelLists();

    @Query("SELECT * FROM boxt72h5ModelList WHERE id = :id")
    public Boxt72h5ModelList getBoxt72h5ModelList(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveBoxt72h5ModelLists(
            java.util.List<dfsdf.sdfsdf.sdf.Boxt72h5ModelList> boxt72h5ModelList);
}
