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
import com.motiv.piotr.dao.DaoRepositoryFactory;
import com.motiv.piotr.dao.LocalStorage;
import com.motiv.piotr.databinding.PhotosfragmentBinding;

public class PhotosFragment extends Fragment implements PhotosFragmentContract.View {

    private PhotosfragmentBinding photosfragmentBinding;
    private PhotosFragmentContract.Presenter presenter;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private TabLayout tablayout10;
    private ViewPager viewpager11;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            final @Nullable Bundle savedInstanceState) {

        photosfragmentBinding = PhotosfragmentBinding.inflate(inflater);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(
                        PhotosFragment.this.getActivity().getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(PhotosFragment.this.getActivity());
        localStorage = LocalStorage.getInstance(PhotosFragment.this.getActivity());
        navigationController = new NavigationController(PhotosFragment.this.getActivity());
        goRestApi = GoRestApiFactory.getInstance(localStorage);
        linearlayout00 = photosfragmentBinding.linearlayout00;
        tablayout10 = photosfragmentBinding.tablayout10;
        viewpager11 = photosfragmentBinding.viewpager11;
        presenter =
                new PhotosFragmentPresenter(
                        PhotosFragment.this, goRestApi, daoRepository, localStorage);

        viewpager11.setAdapter(photosPagerAdapter);
        presenter.goRestApigetPhotosList();

        return photosfragmentBinding.getRoot();
    }

    @Override
    public void photosPagerAdaptersetData(java.util.List<com.motiv.piotr.Photo> arg0) {
        photosPagerAdapter.setData(arg0);
    }
}
