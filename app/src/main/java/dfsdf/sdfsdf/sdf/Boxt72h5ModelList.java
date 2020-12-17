package dfsdf.sdfsdf.sdf;

import androidx.annotation.NonNull;
import androidx.room.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import java.util.*;
import java.util.concurrent.*;

@Entity(tableName = "boxt72h5modellist")
public class Boxt72h5ModelList {

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

    public static Boxt72h5ModelList fromJson(String json) {
        return gson.fromJson(json, Boxt72h5ModelList.class);
    }

    public static String toJson(Boxt72h5ModelList object) {
        return gson.toJson(object, Boxt72h5ModelList.class);
    }

    public static String toJsonArray(Boxt72h5ModelList[] array) {
        return gson.toJson(array, Boxt72h5ModelList[].class);
    }

    public static Boxt72h5ModelList[] fromJsonArray(String array) {
        return gson.fromJson(array, Boxt72h5ModelList[].class);
    }
}
