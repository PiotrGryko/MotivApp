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
import com.motiv.piotr.dao.DaoRepositoryFactory;
import com.motiv.piotr.dao.LocalStorage;
import com.motiv.piotr.databinding.PostslistfragmentBinding;

public class PostsListFragment extends Fragment {

    private PostslistfragmentBinding postslistfragmentBinding;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private RecyclerView recyclerview10;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            @Nullable Bundle savedInstanceState) {

        postslistfragmentBinding = PostslistfragmentBinding.inflate(inflater);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(
                        PostsListFragment.this.getActivity().getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(PostsListFragment.this.getActivity());
        localStorage = LocalStorage.getInstance(PostsListFragment.this.getActivity());
        navigationController = new NavigationController(PostsListFragment.this.getActivity());
        goRestApi = GoRestApiFactory.getInstance(localStorage);
        linearlayout00 = postslistfragmentBinding.linearlayout00;
        recyclerview10 = postslistfragmentBinding.recyclerview10;

        recyclerview10.setLayoutManager(
                new LinearLayoutManager(PostsListFragment.this.getActivity()));

        recyclerview10.setAdapter(postsListAdapter);
        ;
        goRestApi.getPostsList(
                new com.motiv.piotr.OnResponseListener<com.motiv.piotr.PostsListResponse>() {
                    @Override
                    public void onSuccess(com.motiv.piotr.PostsListResponse argument0) {
                        postsListAdapter.setData(argument0.getResult());
                    }

                    @Override
                    public void onError(Exception argument0) {}
                });
        postsListAdapter.setOnItemClickListener(
                new com.motiv.piotr.PostsListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int argument0, com.motiv.piotr.Post argument1) {
                        navigationController.startPostDetailsActivity(argument1);
                    }
                });

        return postslistfragmentBinding.getRoot();
    }
}
