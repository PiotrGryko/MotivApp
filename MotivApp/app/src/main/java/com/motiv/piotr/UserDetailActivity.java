package com.motiv.piotr;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.*;
import com.bumptech.glide.Glide;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import com.motiv.piotr.databinding.UserdetailactivityBinding;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class UserDetailActivity extends AppCompatActivity
        implements UserDetailActivityContract.View, HasSupportFragmentInjector {

    private UserdetailactivityBinding userdetailactivityBinding;
    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private com.motiv.piotr.User user;
    private UserDetailActivityContract.Presenter presenter;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    @Inject GoRestApi goRestApi;
    @Inject DaoRepository daoRepository;
    @Inject LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private ImageView imageview10;
    private TextView textview11;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        userdetailactivityBinding =
                DataBindingUtil.setContentView(this, R.layout.userdetailactivity);

        user = com.motiv.piotr.User.fromJson(getIntent().getStringExtra("user"));

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(UserDetailActivity.this.getSupportFragmentManager());
        navigationController = new NavigationController(UserDetailActivity.this);
        linearlayout00 = userdetailactivityBinding.linearlayout00;
        imageview10 = userdetailactivityBinding.imageview10;
        textview11 = userdetailactivityBinding.textview11;

        presenter =
                new UserDetailActivityPresenter(
                        UserDetailActivity.this, goRestApi, daoRepository, localStorage);

        Glide.with(UserDetailActivity.this)
                .load(user.getLinks().getAvatar().getHref())
                .into(imageview10);
        ;
        textview11.setText(user.getFirst_name());
    }
}
