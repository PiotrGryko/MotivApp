package com.motiv.piotr;

import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class BottomNavigationActivity extends AppCompatActivity
        implements HasSupportFragmentInjector {

    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    @Inject GoRestApi goRestApi;
    @Inject DaoRepository daoRepository;
    @Inject LocalStorage localStorage;
    private NavigationController navigationController;
    private RelativeLayout relativelayout00;
    private BottomNavigationView bottomnavigationview11;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomnavigationactivity);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(
                        BottomNavigationActivity.this.getSupportFragmentManager());
        navigationController = new NavigationController(BottomNavigationActivity.this);
        relativelayout00 = (RelativeLayout) findViewById(R.id.relativelayout00);
        bottomnavigationview11 = (BottomNavigationView) findViewById(R.id.bottomnavigationview11);

        bottomnavigationview11.setOnNavigationItemSelectedListener(
                new com.google.android.material.bottomnavigation.BottomNavigationView
                        .OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(android.view.MenuItem argument0) {
                        navigationController.startDestinationById(argument0.getItemId());

                        return false;
                    }
                });
    }
}
