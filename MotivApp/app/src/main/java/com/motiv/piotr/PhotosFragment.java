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
import com.motiv.piotr.databinding.PhotosfragmentBinding;

public class PhotosFragment extends Fragment {

    private PhotosfragmentBinding photosfragmentBinding;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository =
            DaoRepositoryFactory.getInstance(PhotosFragment.this.getActivity());
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private TabLayout tablayout10;
    private ViewPager viewpager11;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            @Nullable Bundle savedInstanceState) {

        photosfragmentBinding = PhotosfragmentBinding.inflate(inflater);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(
                        PhotosFragment.this.getActivity().getSupportFragmentManager());
        localStorage = LocalStorage.getInstance(PhotosFragment.this.getActivity());
        navigationController = new NavigationController(PhotosFragment.this.getActivity());
        goRestApi = GoRestApiFactory.getInstance(localStorage);
        linearlayout00 = photosfragmentBinding.linearlayout00;
        tablayout10 = photosfragmentBinding.tablayout10;
        viewpager11 = photosfragmentBinding.viewpager11;

        viewpager11.setAdapter(photosPagerAdapter);
        goRestApi.getPhotosList(
                new com.motiv.piotr.OnResponseListener<com.motiv.piotr.PhotosListResponse>() {
                    @Override
                    public void onSuccess(com.motiv.piotr.PhotosListResponse argument0) {
                        photosPagerAdapter.setData(argument0.getResult());
                    }

                    @Override
                    public void onError(Exception argument0) {}
                });

        return photosfragmentBinding.getRoot();
    }
}
