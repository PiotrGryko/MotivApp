package com.motiv.piotr;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.DaoRepositoryFactory;
import com.motiv.piotr.dao.LocalStorage;
import com.motiv.piotr.databinding.UserdetailactivityBinding;
import com.squareup.picasso.Picasso;

public class UserDetailActivity extends AppCompatActivity {

    private UserdetailactivityBinding userdetailactivityBinding;
    private com.motiv.piotr.User user;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private ImageView imageview10;
    private TextView textview11;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        userdetailactivityBinding =
                DataBindingUtil.setContentView(this, R.layout.userdetailactivity);

        user = com.motiv.piotr.User.fromJson(getIntent().getStringExtra("user"));

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(UserDetailActivity.this.getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(UserDetailActivity.this);
        localStorage = LocalStorage.getInstance(UserDetailActivity.this);
        navigationController = new NavigationController(UserDetailActivity.this);
        goRestApi = GoRestApiFactory.getInstance(localStorage);
        linearlayout00 = userdetailactivityBinding.linearlayout00;
        imageview10 = userdetailactivityBinding.imageview10;
        textview11 = userdetailactivityBinding.textview11;

        Picasso.with(UserDetailActivity.this)
                .load(user.getLinks().getAvatar().getHref())
                .into(imageview10);
        ;
        textview11.setText(user.getFirst_name());
    }
}
