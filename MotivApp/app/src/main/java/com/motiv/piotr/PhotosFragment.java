package com.motiv.piotr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.*;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class PhotosFragment extends Fragment implements PhotosFragmentContract.View {

    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private PhotosFragmentContract.Presenter presenter;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    @Inject GoRestApi goRestApi;
    @Inject DaoRepository daoRepository;
    @Inject LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private TabLayout tablayout10;
    private ViewPager viewpager11;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            final @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.photosfragment, parent, false);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(
                        PhotosFragment.this.getActivity().getSupportFragmentManager());
        navigationController = new NavigationController(PhotosFragment.this.getActivity());
        linearlayout00 = (LinearLayout) v.findViewById(R.id.linearlayout00);
        tablayout10 = (TabLayout) v.findViewById(R.id.tablayout10);
        viewpager11 = (ViewPager) v.findViewById(R.id.viewpager11);
        presenter =
                new PhotosFragmentPresenter(
                        PhotosFragment.this, goRestApi, daoRepository, localStorage);

        viewpager11.setAdapter(photosPagerAdapter);
        presenter.goRestApigetPhotosList();

        return v;
    }

    @Override
    public void photosPagerAdaptersetData(java.util.List<com.motiv.piotr.Photo> arg0) {
        photosPagerAdapter.setData(arg0);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }
}
