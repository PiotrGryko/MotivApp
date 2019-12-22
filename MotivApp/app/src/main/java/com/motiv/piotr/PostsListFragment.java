package com.motiv.piotr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.*;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import com.motiv.piotr.databinding.PostslistfragmentBinding;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class PostsListFragment extends Fragment implements PostsListFragmentContract.View {

    private PostslistfragmentBinding postslistfragmentBinding;
    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private PostsListFragmentContract.Presenter presenter;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    @Inject GoRestApi goRestApi;
    @Inject DaoRepository daoRepository;
    @Inject LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private RecyclerView recyclerview10;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            final @Nullable Bundle savedInstanceState) {

        postslistfragmentBinding = PostslistfragmentBinding.inflate(inflater);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(
                        PostsListFragment.this.getActivity().getSupportFragmentManager());
        navigationController = new NavigationController(PostsListFragment.this.getActivity());
        linearlayout00 = postslistfragmentBinding.linearlayout00;
        recyclerview10 = postslistfragmentBinding.recyclerview10;
        presenter =
                new PostsListFragmentPresenter(
                        PostsListFragment.this, goRestApi, daoRepository, localStorage);

        recyclerview10.setLayoutManager(
                new LinearLayoutManager(PostsListFragment.this.getActivity()));

        recyclerview10.setAdapter(postsListAdapter);
        ;
        presenter.goRestApigetPostsList();
        postsListAdapter.setOnItemClickListener(
                new com.motiv.piotr.PostsListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int argument0, com.motiv.piotr.Post argument1) {
                        presenter.eloonItemClick(argument0, argument1);
                    }
                });

        return postslistfragmentBinding.getRoot();
    }

    @Override
    public void postsListAdaptersetData(java.util.List<com.motiv.piotr.Post> arg0) {
        postsListAdapter.setData(arg0);
    }

    @Override
    public void navigationControllerstartPostDetailsActivity(com.motiv.piotr.Post arg0) {
        navigationController.startPostDetailsActivity(arg0);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }
}
