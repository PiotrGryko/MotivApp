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
import com.motiv.piotr.databinding.UserslistfragmentBinding;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class UsersListFragment extends Fragment {

    private UserslistfragmentBinding userslistfragmentBinding;
    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            @Nullable Bundle savedInstanceState) {

        userslistfragmentBinding = UserslistfragmentBinding.inflate(inflater);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(
                        UsersListFragment.this.getActivity().getSupportFragmentManager());
        navigationController = new NavigationController(UsersListFragment.this.getActivity());
        linearlayout00 = userslistfragmentBinding.linearlayout00;
        recyclerview10 = userslistfragmentBinding.recyclerview10;

        recyclerview10.setLayoutManager(
                new LinearLayoutManager(UsersListFragment.this.getActivity()));

        recyclerview10.setAdapter(usersListAdapter);
        ;
        goRestApi.getUsersList(
                new com.motiv.piotr.OnResponseListener<com.motiv.piotr.UsersListResponse>() {
                    @Override
                    public void onSuccess(com.motiv.piotr.UsersListResponse argument0) {
                        usersListAdapter.setData(argument0.getResult());
                    }

                    @Override
                    public void onError(Exception argument0) {}
                });
        usersListAdapter.setOnItemClickListener(
                new com.motiv.piotr.UsersListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int argument0, com.motiv.piotr.User argument1) {
                        navigationController.startUserDetailActivity(argument1);
                    }
                });

        return userslistfragmentBinding.getRoot();
    }
}
