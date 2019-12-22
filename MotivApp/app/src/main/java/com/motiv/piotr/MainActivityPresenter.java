package com.motiv.piotr;

import androidx.fragment.app.*;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public MainActivityPresenter(
            MainActivityContract.View view,
            GoRestApi goRestApi,
            DaoRepository daoRepository,
            LocalStorage localStorage) {
        this.view = view;
        this.goRestApi = goRestApi;
        this.daoRepository = daoRepository;
        this.localStorage = localStorage;
    }

    @Override
    public void eloonClick(android.view.View argument0) {
        goRestApi.getUser(
                view.edittext10getText().toString(),
                new com.motiv.piotr.OnResponseListener<com.motiv.piotr.UserResponse>() {
                    @Override
                    public void onSuccess(com.motiv.piotr.UserResponse argument0) {
                        view.showToast("success");
                        view.navigationControllerstartDashboardActivity(argument0.getResult());
                    }

                    @Override
                    public void onError(Exception argument0) {
                        view.showToast("error");
                    }
                });
    }
}
