package dfsdf.sdfsdf.sdf;

import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import dfsdf.sdfsdf.sdf.dao.DaoRepository;
import dfsdf.sdfsdf.sdf.dao.DaoRepositoryFactory;
import dfsdf.sdfsdf.sdf.dao.LocalStorage;

public class Onboarding extends AppCompatActivity {

    private Box1195ViewpagerAdapter box1195ViewpagerAdapter;
    private Box1267ViewpagerAdapter box1267ViewpagerAdapter;
    private Box1280ViewpagerAdapter box1280ViewpagerAdapter;
    private Box1049ListAdapter box1049ListAdapter;
    private Boxt72h5ListAdapter boxt72h5ListAdapter;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private ConstraintLayout constraintlayout00;
    private Button box1194;
    private TabLayout box1196;
    private ViewPager box1195;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(Onboarding.this.getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(Onboarding.this.getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(Onboarding.this.getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(Onboarding.this);
        localStorage = LocalStorage.getInstance(Onboarding.this);
        navigationController = new NavigationController(Onboarding.this);
        constraintlayout00 = (ConstraintLayout) findViewById(R.id.constraintlayout00);
        box1194 = (Button) findViewById(R.id.box1194);
        box1196 = (TabLayout) findViewById(R.id.box1196);
        box1195 = (ViewPager) findViewById(R.id.box1195);

        box1194.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startSignIn();
                    }
                });
        box1196.setupWithViewPager(box1195);
        box1195.setAdapter(box1195ViewpagerAdapter);
    }
}
