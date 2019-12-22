package com.motiv.piotr;

import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;

public class UsersListFragmentPresenter implements UsersListFragmentContract.Presenter {

    private UsersListFragmentContract.View view;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public UsersListFragmentPresenter(
            UsersListFragmentContract.View view,
            GoRestApi goRestApi,
            DaoRepository daoRepository,
            LocalStorage localStorage) {
        this.view = view;
        this.goRestApi = goRestApi;
        this.daoRepository = daoRepository;
        this.localStorage = localStorage;
    }

    @Override
    public void goRestApigetUsersList() {
        goRestApi.getUsersList(
                new com.motiv.piotr.OnResponseListener<com.motiv.piotr.UsersListResponse>() {
                    @Override
                    public void onSuccess(com.motiv.piotr.UsersListResponse argument0) {
                        view.usersListAdaptersetData(argument0.getResult());
                    }

                    @Override
                    public void onError(Exception argument0) {}
                });
    }

    @Override
    public void eloonItemClick(int argument0, com.motiv.piotr.User argument1) {
        view.navigationControllerstartUserDetailActivity(argument1);
    }
}
