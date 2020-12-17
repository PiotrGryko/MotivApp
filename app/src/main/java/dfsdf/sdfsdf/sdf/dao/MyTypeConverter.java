package dfsdf.sdfsdf.sdf.dao;

import androidx.room.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import dfsdf.sdfsdf.sdf.Box1049ModelList;
import dfsdf.sdfsdf.sdf.Boxt72h5ModelList;
import java.util.List;

public class MyTypeConverter {

    @TypeConverter
    public static java.lang.String box1049modellistToString(
            java.util.List<Box1049ModelList> value) {

        return new Gson().toJson(value, new TypeToken<List<Box1049ModelList>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<Box1049ModelList> stringToBox1049ModelLists(
            java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<Box1049ModelList>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String boxt72h5modellistToString(
            java.util.List<Boxt72h5ModelList> value) {

        return new Gson().toJson(value, new TypeToken<List<Boxt72h5ModelList>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<Boxt72h5ModelList> stringToBoxt72h5ModelLists(
            java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<Boxt72h5ModelList>>() {}.getType());
    }
}
