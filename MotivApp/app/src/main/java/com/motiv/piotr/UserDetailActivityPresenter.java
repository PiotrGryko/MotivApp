package com.motiv.piotr;

import androidx.fragment.app.*;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class UserDetailActivityPresenter implements UserDetailActivityContract.Presenter {

    private UserDetailActivityContract.View view;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public UserDetailActivityPresenter(
            UserDetailActivityContract.View view,
            GoRestApi goRestApi,
            DaoRepository daoRepository,
            LocalStorage localStorage) {
        this.view = view;
        this.goRestApi = goRestApi;
        this.daoRepository = daoRepository;
        this.localStorage = localStorage;
    }
}
