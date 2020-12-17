package dfsdf.sdfsdf.sdf.dao;

import androidx.room.*;
import dfsdf.sdfsdf.sdf.Box1049ModelList;
import dfsdf.sdfsdf.sdf.Boxt72h5ModelList;

@TypeConverters({MyTypeConverter.class})
@Database(
    entities = {Box1049ModelList.class, Boxt72h5ModelList.class},
    version = 1
)
public abstract class MyRoomDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "test";

    public abstract dfsdf.sdfsdf.sdf.dao.Box1049ModelListDao box1049ModelListDao();

    public abstract dfsdf.sdfsdf.sdf.dao.Boxt72h5ModelListDao boxt72h5ModelListDao();
}
