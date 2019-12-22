package com.motiv.piotr;

import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.*;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class ViewPagerActivity extends AppCompatActivity
        implements ViewPagerActivityContract.View, HasSupportFragmentInjector {

    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private ViewPagerActivityContract.Presenter presenter;
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
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpageractivity);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(ViewPagerActivity.this.getSupportFragmentManager());
        navigationController = new NavigationController(ViewPagerActivity.this);
        linearlayout00 = (LinearLayout) findViewById(R.id.linearlayout00);
        tablayout10 = (TabLayout) findViewById(R.id.tablayout10);
        viewpager11 = (ViewPager) findViewById(R.id.viewpager11);

        presenter =
                new ViewPagerActivityPresenter(
                        ViewPagerActivity.this, goRestApi, daoRepository, localStorage);

        viewpager11.setAdapter(fragmentsPagerAdapter);
    }
}
