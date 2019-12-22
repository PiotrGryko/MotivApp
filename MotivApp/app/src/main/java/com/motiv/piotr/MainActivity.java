package com.motiv.piotr;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.DaoRepositoryFactory;
import com.motiv.piotr.dao.LocalStorage;
import com.motiv.piotr.databinding.MainactivityBinding;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private MainactivityBinding mainactivityBinding;
    private MainActivityContract.Presenter presenter;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private EditText edittext10;
    private Button button11;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mainactivityBinding = DataBindingUtil.setContentView(this, R.layout.mainactivity);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(MainActivity.this.getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(MainActivity.this);
        localStorage = LocalStorage.getInstance(MainActivity.this);
        navigationController = new NavigationController(MainActivity.this);
        goRestApi = GoRestApiFactory.getInstance(localStorage);
        linearlayout00 = mainactivityBinding.linearlayout00;
        edittext10 = mainactivityBinding.edittext10;
        button11 = mainactivityBinding.button11;

        presenter =
                new MainActivityPresenter(
                        MainActivity.this, goRestApi, daoRepository, localStorage);

        button11.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        presenter.eloonClick(argument0);
                    }
                });
    }

    @Override
    public java.lang.CharSequence edittext10getText() {
        return edittext10.getText().toString();
    }

    @Override
    public void showToast(java.lang.String arg0) {
        Toast.makeText(MainActivity.this, arg0, Toast.LENGTH_LONG).show();
        ;
    }

    @Override
    public void navigationControllerstartDashboardActivity(com.motiv.piotr.User arg0) {
        navigationController.startDashboardActivity(arg0);
    }
}
