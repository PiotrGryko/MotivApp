package com.motiv.piotr;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.*;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import com.motiv.piotr.databinding.PostdetailsactivityBinding;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class PostDetailsActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private PostdetailsactivityBinding postdetailsactivityBinding;
    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private com.motiv.piotr.Post post;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    @Inject GoRestApi goRestApi;
    @Inject DaoRepository daoRepository;
    @Inject LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private TextView textview10;
    private TextView textview11;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        postdetailsactivityBinding =
                DataBindingUtil.setContentView(this, R.layout.postdetailsactivity);

        post = com.motiv.piotr.Post.fromJson(getIntent().getStringExtra("post"));

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(PostDetailsActivity.this.getSupportFragmentManager());
        navigationController = new NavigationController(PostDetailsActivity.this);
        linearlayout00 = postdetailsactivityBinding.linearlayout00;
        textview10 = postdetailsactivityBinding.textview10;
        textview11 = postdetailsactivityBinding.textview11;

        textview10.setText(post.getTitle());
        textview11.setText(post.getBody());
    }
}
