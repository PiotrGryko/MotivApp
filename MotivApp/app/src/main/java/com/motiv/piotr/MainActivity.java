package com.motiv.piotr;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import com.motiv.piotr.databinding.MainactivityBinding;

public class MainActivity extends AppCompatActivity {

    private MainactivityBinding mainactivityBinding;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    private GoRestApi goRestApi;
    private DaoRepository daoRepository = DaoRepositoryFactory.getInstance(MainActivity.this);
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
        localStorage = LocalStorage.getInstance(MainActivity.this);
        navigationController = new NavigationController(MainActivity.this);
        goRestApi = GoRestApiFactory.getInstance(localStorage);
        linearlayout00 = mainactivityBinding.linearlayout00;
        edittext10 = mainactivityBinding.edittext10;
        button11 = mainactivityBinding.button11;

        button11.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        goRestApi.getUser(
                                edittext10.getText().toString(),
                                new com.motiv.piotr.OnResponseListener<
                                        com.motiv.piotr.UserResponse>() {
                                    @Override
                                    public void onSuccess(com.motiv.piotr.UserResponse argument0) {
                                        Toast.makeText(
                                                        MainActivity.this,
                                                        "success",
                                                        Toast.LENGTH_LONG)
                                                .show();
                                        ;
                                        navigationController.startDashboardActivity(
                                                argument0.getResult());
                                    }

                                    @Override
                                    public void onError(Exception argument0) {
                                        Toast.makeText(
                                                        MainActivity.this,
                                                        "error",
                                                        Toast.LENGTH_LONG)
                                                .show();
                                        ;
                                    }
                                });
                    }
                });
    }
}
