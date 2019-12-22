package com.motiv.piotr;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.DaoRepositoryFactory;
import com.motiv.piotr.dao.LocalStorage;
import com.motiv.piotr.databinding.DashboardactivityBinding;
import com.squareup.picasso.Picasso;

public class DashboardActivity extends AppCompatActivity {

    private DashboardactivityBinding dashboardactivityBinding;
    private com.motiv.piotr.User loggedUser;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private DrawerLayout drawerlayout00;
    private NavigationView navigationview11;
    private LinearLayout headerlinearlayout00;
    private ImageView headerimageview10;
    private TextView headertextview11;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        dashboardactivityBinding = DataBindingUtil.setContentView(this, R.layout.dashboardactivity);

        loggedUser = com.motiv.piotr.User.fromJson(getIntent().getStringExtra("loggedUser"));

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(DashboardActivity.this.getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(DashboardActivity.this);
        localStorage = LocalStorage.getInstance(DashboardActivity.this);
        navigationController = new NavigationController(DashboardActivity.this);
        goRestApi = GoRestApiFactory.getInstance(localStorage);
        drawerlayout00 = dashboardactivityBinding.drawerlayout00;
        navigationview11 = dashboardactivityBinding.navigationview11;
        headerlinearlayout00 =
                (LinearLayout) navigationview11.getHeaderView(0).findViewById(R.id.linearlayout00);
        headerimageview10 =
                (ImageView) navigationview11.getHeaderView(0).findViewById(R.id.imageview10);
        headertextview11 =
                (TextView) navigationview11.getHeaderView(0).findViewById(R.id.textview11);

        navigationview11.setNavigationItemSelectedListener(
                new com.google.android.material.navigation.NavigationView
                        .OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(android.view.MenuItem argument0) {
                        navigationController.startDestinationById(argument0.getItemId());

                        return false;
                    }
                });
        headertextview11.setText(loggedUser.getFirst_name());

        Picasso.with(DashboardActivity.this)
                .load(loggedUser.getLinks().getAvatar().getHref())
                .into(headerimageview10);
        ;
        headerlinearlayout00.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startUserDetailActivity(loggedUser);
                    }
                });
    }
}
