package dfsdf.sdfsdf.sdf.dao;

import androidx.room.*;
import dfsdf.sdfsdf.sdf.Box1049ModelList;

@Dao
public interface Box1049ModelListDao {

    @Insert
    public long saveBox1049ModelList(dfsdf.sdfsdf.sdf.Box1049ModelList box1049ModelList);

    @Delete
    public int deleteBox1049ModelList(dfsdf.sdfsdf.sdf.Box1049ModelList box1049ModelList);

    @Query("SELECT * FROM box1049ModelList")
    public java.util.List<Box1049ModelList> getBox1049ModelLists();

    @Query("SELECT * FROM box1049ModelList WHERE id = :id")
    public Box1049ModelList getBox1049ModelList(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveBox1049ModelLists(
            java.util.List<dfsdf.sdfsdf.sdf.Box1049ModelList> box1049ModelList);
}
