package com.motiv.piotr;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.DaoRepositoryFactory;
import com.motiv.piotr.dao.LocalStorage;
import com.motiv.piotr.databinding.PostdetailsactivityBinding;

public class PostDetailsActivity extends AppCompatActivity {

    private PostdetailsactivityBinding postdetailsactivityBinding;
    private com.motiv.piotr.Post post;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private TextView textview10;
    private TextView textview11;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        postdetailsactivityBinding =
                DataBindingUtil.setContentView(this, R.layout.postdetailsactivity);

        post = com.motiv.piotr.Post.fromJson(getIntent().getStringExtra("post"));

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(PostDetailsActivity.this.getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(PostDetailsActivity.this);
        localStorage = LocalStorage.getInstance(PostDetailsActivity.this);
        navigationController = new NavigationController(PostDetailsActivity.this);
        goRestApi = GoRestApiFactory.getInstance(localStorage);
        linearlayout00 = postdetailsactivityBinding.linearlayout00;
        textview10 = postdetailsactivityBinding.textview10;
        textview11 = postdetailsactivityBinding.textview11;

        textview10.setText(post.getTitle());
        textview11.setText(post.getBody());
    }
}
