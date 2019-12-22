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

public class UsersListFragment extends Fragment {

    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository =
            DaoRepositoryFactory.getInstance(UsersListFragment.this.getActivity());
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private RecyclerView recyclerview10;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.userslistfragment, parent, false);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(
                        UsersListFragment.this.getActivity().getSupportFragmentManager());
        localStorage = LocalStorage.getInstance(UsersListFragment.this.getActivity());
        navigationController = new NavigationController(UsersListFragment.this.getActivity());
        goRestApi = GoRestApiFactory.getInstance(localStorage);
        linearlayout00 = (LinearLayout) v.findViewById(R.id.linearlayout00);
        recyclerview10 = (RecyclerView) v.findViewById(R.id.recyclerview10);

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

        return v;
    }
}
