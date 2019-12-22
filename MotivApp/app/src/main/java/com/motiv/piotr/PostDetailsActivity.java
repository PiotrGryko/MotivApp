package com.motiv.piotr;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.DaoRepositoryFactory;
import com.motiv.piotr.dao.LocalStorage;

public class PostDetailsActivity extends AppCompatActivity
        implements PostDetailsActivityContract.View {

    private com.motiv.piotr.Post post;
    private PostDetailsActivityContract.Presenter presenter;
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
        setContentView(R.layout.postdetailsactivity);

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
        linearlayout00 = (LinearLayout) findViewById(R.id.linearlayout00);
        textview10 = (TextView) findViewById(R.id.textview10);
        textview11 = (TextView) findViewById(R.id.textview11);

        presenter =
                new PostDetailsActivityPresenter(
                        PostDetailsActivity.this, goRestApi, daoRepository, localStorage);

        textview10.setText(post.getTitle());
        textview11.setText(post.getBody());
    }
}
