package com.motiv.piotr;

import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.DaoRepositoryFactory;
import com.motiv.piotr.dao.LocalStorage;
import com.motiv.piotr.databinding.BottomnavigationactivityBinding;

public class BottomNavigationActivity extends AppCompatActivity
        implements BottomNavigationActivityContract.View {

    private BottomnavigationactivityBinding bottomnavigationactivityBinding;
    private BottomNavigationActivityContract.Presenter presenter;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private RelativeLayout relativelayout00;
    private BottomNavigationView bottomnavigationview11;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        bottomnavigationactivityBinding =
                DataBindingUtil.setContentView(this, R.layout.bottomnavigationactivity);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(
                        BottomNavigationActivity.this.getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(BottomNavigationActivity.this);
        localStorage = LocalStorage.getInstance(BottomNavigationActivity.this);
        navigationController = new NavigationController(BottomNavigationActivity.this);
        goRestApi = GoRestApiFactory.getInstance(localStorage);
        relativelayout00 = bottomnavigationactivityBinding.relativelayout00;
        bottomnavigationview11 = bottomnavigationactivityBinding.bottomnavigationview11;

        presenter =
                new BottomNavigationActivityPresenter(
                        BottomNavigationActivity.this, goRestApi, daoRepository, localStorage);

        bottomnavigationview11.setOnNavigationItemSelectedListener(
                new com.google.android.material.bottomnavigation.BottomNavigationView
                        .OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(android.view.MenuItem argument0) {
                        presenter.eloonNavigationItemSelected(argument0);

                        return false;
                    }
                });
    }

    @Override
    public void navigationControllerstartDestinationById(int arg0) {
        navigationController.startDestinationById(arg0);
    }
}
