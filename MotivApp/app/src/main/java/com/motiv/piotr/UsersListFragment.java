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

public class UsersListFragment extends Fragment implements UsersListFragmentContract.View {

    private UserslistfragmentBinding userslistfragmentBinding;
    private UsersListFragmentContract.Presenter presenter;
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
            final @Nullable Bundle savedInstanceState) {

        userslistfragmentBinding = UserslistfragmentBinding.inflate(inflater);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(
                        UsersListFragment.this.getActivity().getSupportFragmentManager());
        localStorage = LocalStorage.getInstance(UsersListFragment.this.getActivity());
        navigationController = new NavigationController(UsersListFragment.this.getActivity());
        goRestApi = GoRestApiFactory.getInstance(localStorage);
        linearlayout00 = userslistfragmentBinding.linearlayout00;
        recyclerview10 = userslistfragmentBinding.recyclerview10;
        presenter =
                new UsersListFragmentPresenter(
                        UsersListFragment.this, goRestApi, daoRepository, localStorage);

        recyclerview10.setLayoutManager(
                new LinearLayoutManager(UsersListFragment.this.getActivity()));

        recyclerview10.setAdapter(usersListAdapter);
        ;
        presenter.goRestApigetUsersList();
        usersListAdapter.setOnItemClickListener(
                new com.motiv.piotr.UsersListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int argument0, com.motiv.piotr.User argument1) {
                        presenter.eloonItemClick(argument0, argument1);
                    }
                });

        return userslistfragmentBinding.getRoot();
    }

    @Override
    public void usersListAdaptersetData(java.util.List<com.motiv.piotr.User> arg0) {
        usersListAdapter.setData(arg0);
    }

    @Override
    public void navigationControllerstartUserDetailActivity(com.motiv.piotr.User arg0) {
        navigationController.startUserDetailActivity(arg0);
    }
}
