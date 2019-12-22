package com.motiv.piotr;

import androidx.fragment.app.*;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class ViewPagerActivityPresenter implements ViewPagerActivityContract.Presenter {

    private ViewPagerActivityContract.View view;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public ViewPagerActivityPresenter(
            ViewPagerActivityContract.View view,
            GoRestApi goRestApi,
            DaoRepository daoRepository,
            LocalStorage localStorage) {
        this.view = view;
        this.goRestApi = goRestApi;
        this.daoRepository = daoRepository;
        this.localStorage = localStorage;
    }
}
