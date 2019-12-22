package com.motiv.piotr.di;

import androidx.fragment.app.*;
import com.motiv.piotr.BottomNavigationActivity;
import com.motiv.piotr.DashboardActivity;
import com.motiv.piotr.MainActivity;
import com.motiv.piotr.PhotosFragment;
import com.motiv.piotr.PostDetailsActivity;
import com.motiv.piotr.PostsListFragment;
import com.motiv.piotr.UserDetailActivity;
import com.motiv.piotr.UsersListFragment;
import com.motiv.piotr.ViewPagerActivity;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

@Module
public abstract class AppContributions {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract DashboardActivity contributeDashboardActivity();

    @ContributesAndroidInjector
    abstract UserDetailActivity contributeUserDetailActivity();

    @ContributesAndroidInjector
    abstract PostDetailsActivity contributePostDetailsActivity();

    @ContributesAndroidInjector
    abstract BottomNavigationActivity contributeBottomNavigationActivity();

    @ContributesAndroidInjector
    abstract ViewPagerActivity contributeViewPagerActivity();

    @ContributesAndroidInjector
    abstract UsersListFragment contributeUsersListFragment();

    @ContributesAndroidInjector
    abstract PostsListFragment contributePostsListFragment();

    @ContributesAndroidInjector
    abstract PhotosFragment contributePhotosFragment();
}
