package com.motiv.piotr;

import androidx.fragment.app.*;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class PostsListFragmentPresenter implements PostsListFragmentContract.Presenter {

    private PostsListFragmentContract.View view;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public PostsListFragmentPresenter(
            PostsListFragmentContract.View view,
            GoRestApi goRestApi,
            DaoRepository daoRepository,
            LocalStorage localStorage) {
        this.view = view;
        this.goRestApi = goRestApi;
        this.daoRepository = daoRepository;
        this.localStorage = localStorage;
    }

    @Override
    public void goRestApigetPostsList() {
        goRestApi.getPostsList(
                new com.motiv.piotr.OnResponseListener<com.motiv.piotr.PostsListResponse>() {
                    @Override
                    public void onSuccess(com.motiv.piotr.PostsListResponse argument0) {
                        view.postsListAdaptersetData(argument0.getResult());
                    }

                    @Override
                    public void onError(Exception argument0) {}
                });
    }

    @Override
    public void eloonItemClick(int argument0, com.motiv.piotr.Post argument1) {
        view.navigationControllerstartPostDetailsActivity(argument1);
    }
}
