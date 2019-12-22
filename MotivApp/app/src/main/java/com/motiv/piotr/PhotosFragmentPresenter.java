package com.motiv.piotr;

import androidx.fragment.app.*;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class PhotosFragmentPresenter implements PhotosFragmentContract.Presenter {

    private PhotosFragmentContract.View view;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public PhotosFragmentPresenter(
            PhotosFragmentContract.View view,
            GoRestApi goRestApi,
            DaoRepository daoRepository,
            LocalStorage localStorage) {
        this.view = view;
        this.goRestApi = goRestApi;
        this.daoRepository = daoRepository;
        this.localStorage = localStorage;
    }

    @Override
    public void goRestApigetPhotosList() {
        goRestApi.getPhotosList(
                new com.motiv.piotr.OnResponseListener<com.motiv.piotr.PhotosListResponse>() {
                    @Override
                    public void onSuccess(com.motiv.piotr.PhotosListResponse argument0) {
                        view.photosPagerAdaptersetData(argument0.getResult());
                    }

                    @Override
                    public void onError(Exception argument0) {}
                });
    }
}
