package dfsdf.sdfsdf.sdf;

import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import dfsdf.sdfsdf.sdf.dao.DaoRepository;
import dfsdf.sdfsdf.sdf.dao.DaoRepositoryFactory;
import dfsdf.sdfsdf.sdf.dao.LocalStorage;

public class MyOrders extends AppCompatActivity {

    private Box1195ViewpagerAdapter box1195ViewpagerAdapter;
    private Box1267ViewpagerAdapter box1267ViewpagerAdapter;
    private Box1280ViewpagerAdapter box1280ViewpagerAdapter;
    private Box1049ListAdapter box1049ListAdapter;
    private Boxt72h5ListAdapter boxt72h5ListAdapter;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private DrawerLayout drawerlayout00;
    private ConstraintLayout constraintlayout10;
    private ViewPager box1280;
    private TabLayout box1279;
    private TextView box1285;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.myorders);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(MyOrders.this.getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(MyOrders.this.getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(MyOrders.this.getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(MyOrders.this);
        localStorage = LocalStorage.getInstance(MyOrders.this);
        navigationController = new NavigationController(MyOrders.this);
        drawerlayout00 = (DrawerLayout) findViewById(R.id.drawerlayout00);
        constraintlayout10 = (ConstraintLayout) findViewById(R.id.constraintlayout10);
        box1280 = (ViewPager) findViewById(R.id.box1280);
        box1279 = (TabLayout) findViewById(R.id.box1279);
        box1285 = (TextView) findViewById(R.id.box1285);

        box1280.setAdapter(box1280ViewpagerAdapter);
        box1279.setupWithViewPager(box1280);
    }
}
