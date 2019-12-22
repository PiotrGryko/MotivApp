package com.motiv.piotr;

import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;

public class DashboardActivityPresenter implements DashboardActivityContract.Presenter {

    private DashboardActivityContract.View view;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public DashboardActivityPresenter(
            DashboardActivityContract.View view,
            GoRestApi goRestApi,
            DaoRepository daoRepository,
            LocalStorage localStorage) {
        this.view = view;
        this.goRestApi = goRestApi;
        this.daoRepository = daoRepository;
        this.localStorage = localStorage;
    }

    @Override
    public void eloonNavigationItemSelected(android.view.MenuItem argument0) {
        view.navigationControllerstartDestinationById(argument0.getItemId());
    }

    @Override
    public void eloonClick(android.view.View argument0) {
        view.navigationControllerstartUserDetailActivity(view.getloggedUser());
    }
}
