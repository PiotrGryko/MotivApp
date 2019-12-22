package com.motiv.piotr;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.*;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private UsersListAdapter usersListAdapter;
    private PostsListAdapter postsListAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private FragmentsPagerAdapter fragmentsPagerAdapter;
    @Inject GoRestApi goRestApi;
    @Inject DaoRepository daoRepository;
    @Inject LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private EditText edittext10;
    private Button button11;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        usersListAdapter = new UsersListAdapter();
        postsListAdapter = new PostsListAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        fragmentsPagerAdapter =
                new FragmentsPagerAdapter(MainActivity.this.getSupportFragmentManager());
        navigationController = new NavigationController(MainActivity.this);
        linearlayout00 = (LinearLayout) findViewById(R.id.linearlayout00);
        edittext10 = (EditText) findViewById(R.id.edittext10);
        button11 = (Button) findViewById(R.id.button11);

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
