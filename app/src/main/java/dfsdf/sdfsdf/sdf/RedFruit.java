package dfsdf.sdfsdf.sdf;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import dfsdf.sdfsdf.sdf.dao.DaoRepository;
import dfsdf.sdfsdf.sdf.dao.DaoRepositoryFactory;
import dfsdf.sdfsdf.sdf.dao.LocalStorage;

public class RedFruit extends AppCompatActivity {

    private Box1195ViewpagerAdapter box1195ViewpagerAdapter;
    private Box1267ViewpagerAdapter box1267ViewpagerAdapter;
    private Box1280ViewpagerAdapter box1280ViewpagerAdapter;
    private Box1049ListAdapter box1049ListAdapter;
    private Boxt72h5ListAdapter boxt72h5ListAdapter;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private ConstraintLayout constraintlayout00;
    private Button box1269;
    private ViewPager box1267;
    private TabLayout box1221;
    private View box1222;
    private View box1263;
    private TextView box1256;
    private ImageView box1254;
    private View boxelhsv;
    private View boxelksq;
    private View box12ocq;
    private View boxxr0go;
    private View boxie4mo;
    private TextView box1255;
    private Toolbar box1233;
    private ImageView box608;
    private ImageView box244;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.redfruit);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(RedFruit.this.getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(RedFruit.this.getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(RedFruit.this.getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(RedFruit.this);
        localStorage = LocalStorage.getInstance(RedFruit.this);
        navigationController = new NavigationController(RedFruit.this);
        constraintlayout00 = (ConstraintLayout) findViewById(R.id.constraintlayout00);
        box1269 = (Button) findViewById(R.id.box1269);
        box1267 = (ViewPager) findViewById(R.id.box1267);
        box1221 = (TabLayout) findViewById(R.id.box1221);
        box1222 = (View) findViewById(R.id.box1222);
        box1263 = (View) findViewById(R.id.box1263);
        box1256 = (TextView) findViewById(R.id.box1256);
        box1254 = (ImageView) findViewById(R.id.box1254);
        boxelhsv = (View) findViewById(R.id.boxelhsv);
        boxelksq = (View) findViewById(R.id.boxelksq);
        box12ocq = (View) findViewById(R.id.box12ocq);
        boxxr0go = (View) findViewById(R.id.boxxr0go);
        boxie4mo = (View) findViewById(R.id.boxie4mo);
        box1255 = (TextView) findViewById(R.id.box1255);
        box1233 = (Toolbar) findViewById(R.id.box1233);
        box608 = (ImageView) findViewById(R.id.box608);
        box244 = (ImageView) findViewById(R.id.box244);

        box1269.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startChooseItems();
                    }
                });
        box1267.setAdapter(box1267ViewpagerAdapter);
    }
}
