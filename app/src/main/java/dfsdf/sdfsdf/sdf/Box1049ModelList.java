package dfsdf.sdfsdf.sdf;

import androidx.annotation.NonNull;
import androidx.room.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import java.util.*;
import java.util.concurrent.*;

@Entity(tableName = "box1049modellist")
public class Box1049ModelList {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "field0")
    @SerializedName("field0")
    private java.lang.String field0;

    @ColumnInfo(name = "field1")
    @SerializedName("field1")
    private java.lang.String field1;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getField0() {

        return this.field0;
    }

    public void setField0(java.lang.String field0) {
        this.field0 = field0;
    }

    public java.lang.String getField1() {

        return this.field1;
    }

    public void setField1(java.lang.String field1) {
        this.field1 = field1;
    }

    public static Box1049ModelList fromJson(String json) {
        return gson.fromJson(json, Box1049ModelList.class);
    }

    public static String toJson(Box1049ModelList object) {
        return gson.toJson(object, Box1049ModelList.class);
    }

    public static String toJsonArray(Box1049ModelList[] array) {
        return gson.toJson(array, Box1049ModelList[].class);
    }

    public static Box1049ModelList[] fromJsonArray(String array) {
        return gson.fromJson(array, Box1049ModelList[].class);
    }
}
