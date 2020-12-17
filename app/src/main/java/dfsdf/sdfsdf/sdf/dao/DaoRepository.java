package dfsdf.sdfsdf.sdf.dao;

import android.os.Handler;
import dfsdf.sdfsdf.sdf.Box1049ModelList;
import dfsdf.sdfsdf.sdf.Boxt72h5ModelList;
import dfsdf.sdfsdf.sdf.OnResponseListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;

public class DaoRepository {

    private MyRoomDatabase myRoomDatabase;
    private Handler handler;
    private Executor executor;

    public DaoRepository(Handler handler, MyRoomDatabase myRoomDatabase, Executor executor) {
        this.handler = handler;
        this.myRoomDatabase = myRoomDatabase;
        this.executor = executor;
    }

    public void saveBox1049ModelList(
            final dfsdf.sdfsdf.sdf.Box1049ModelList box1049ModelList,
            final dfsdf.sdfsdf.sdf.OnResponseListener<dfsdf.sdfsdf.sdf.Box1049ModelList>
                    onResponseListener) {
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.box1049ModelListDao().saveBox1049ModelList(box1049ModelList);
                        passSuccessResultToUi(box1049ModelList, onResponseListener);
                    }
                });
    }

    public void saveBox1049ModelLists(
            final java.util.List<dfsdf.sdfsdf.sdf.Box1049ModelList> box1049ModelLists,
            final dfsdf.sdfsdf.sdf.OnResponseListener<
                            java.util.List<dfsdf.sdfsdf.sdf.Box1049ModelList>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .box1049ModelListDao()
                                .saveBox1049ModelLists(box1049ModelLists);
                        passSuccessResultToUi(box1049ModelLists, onResponseListener);
                    }
                });
    }

    public void loadBox1049ModelLists(
            final dfsdf.sdfsdf.sdf.OnResponseListener<
                            java.util.List<dfsdf.sdfsdf.sdf.Box1049ModelList>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<Box1049ModelList> result =
                                myRoomDatabase.box1049ModelListDao().getBox1049ModelLists();
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadBox1049ModelList(
            final java.lang.String id,
            final dfsdf.sdfsdf.sdf.OnResponseListener<dfsdf.sdfsdf.sdf.Box1049ModelList>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final Box1049ModelList result =
                                myRoomDatabase.box1049ModelListDao().getBox1049ModelList(id);
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void saveBoxt72h5ModelList(
            final dfsdf.sdfsdf.sdf.Boxt72h5ModelList boxt72h5ModelList,
            final dfsdf.sdfsdf.sdf.OnResponseListener<dfsdf.sdfsdf.sdf.Boxt72h5ModelList>
                    onResponseListener) {
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .boxt72h5ModelListDao()
                                .saveBoxt72h5ModelList(boxt72h5ModelList);
                        passSuccessResultToUi(boxt72h5ModelList, onResponseListener);
                    }
                });
    }

    public void saveBoxt72h5ModelLists(
            final java.util.List<dfsdf.sdfsdf.sdf.Boxt72h5ModelList> boxt72h5ModelLists,
            final dfsdf.sdfsdf.sdf.OnResponseListener<
                            java.util.List<dfsdf.sdfsdf.sdf.Boxt72h5ModelList>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .boxt72h5ModelListDao()
                                .saveBoxt72h5ModelLists(boxt72h5ModelLists);
                        passSuccessResultToUi(boxt72h5ModelLists, onResponseListener);
                    }
                });
    }

    public void loadBoxt72h5ModelLists(
            final dfsdf.sdfsdf.sdf.OnResponseListener<
                            java.util.List<dfsdf.sdfsdf.sdf.Boxt72h5ModelList>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<Boxt72h5ModelList> result =
                                myRoomDatabase.boxt72h5ModelListDao().getBoxt72h5ModelLists();
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadBoxt72h5ModelList(
            final java.lang.String id,
            final dfsdf.sdfsdf.sdf.OnResponseListener<dfsdf.sdfsdf.sdf.Boxt72h5ModelList>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final Boxt72h5ModelList result =
                                myRoomDatabase.boxt72h5ModelListDao().getBoxt72h5ModelList(id);
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    private <T> void passSuccessResultToUi(
            final T result, final OnResponseListener<T> onResponseListener) {
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        onResponseListener.onSuccess(result);
                    }
                });
    }
}
