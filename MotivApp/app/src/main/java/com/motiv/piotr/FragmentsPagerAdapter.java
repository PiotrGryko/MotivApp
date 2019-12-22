package com.motiv.piotr;

import androidx.fragment.app.*;

public class FragmentsPagerAdapter extends FragmentStatePagerAdapter {

    public FragmentsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {

        return 3;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new UsersListFragment();
            case 1:
                return new PostsListFragment();
            case 2:
                return new PhotosFragment();
        }
        throw new RuntimeException();
    }

    @Override
    public java.lang.String getPageTitle(int position) {

        switch (position) {
            case 0:
                return "UsersListFragment";
            case 1:
                return "PostsListFragment";
            case 2:
                return "PhotosFragment";
        }
        return "";
    }
}
