package dfsdf.sdfsdf.sdf;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import dfsdf.sdfsdf.sdf.dao.DaoRepository;
import dfsdf.sdfsdf.sdf.dao.DaoRepositoryFactory;
import dfsdf.sdfsdf.sdf.dao.LocalStorage;

public class ChooseItems extends AppCompatActivity {

    private Box1195ViewpagerAdapter box1195ViewpagerAdapter;
    private Box1267ViewpagerAdapter box1267ViewpagerAdapter;
    private Box1280ViewpagerAdapter box1280ViewpagerAdapter;
    private Box1049ListAdapter box1049ListAdapter;
    private Boxt72h5ListAdapter boxt72h5ListAdapter;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private ConstraintLayout constraintlayout00;
    private Button box1339;
    private View box1336;
    private TextView box1338;
    private TextView box1337;
    private View box1335;
    private CheckBox box1334;
    private TextView box1328;
    private TextView box1327;
    private CheckBox box1333;
    private TextView box1326;
    private CheckBox box1332;
    private TextView box1325;
    private TextView box1324;
    private CheckBox box1331;
    private TextView box1323;
    private CheckBox box1330;
    private TextView box1322;
    private CheckBox box1329;
    private TextView box1321;
    private TextView box1372;
    private ImageView box1366;
    private ImageView box1367;
    private Toolbar box1319;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseitems);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(ChooseItems.this.getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(ChooseItems.this.getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(ChooseItems.this.getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(ChooseItems.this);
        localStorage = LocalStorage.getInstance(ChooseItems.this);
        navigationController = new NavigationController(ChooseItems.this);
        constraintlayout00 = (ConstraintLayout) findViewById(R.id.constraintlayout00);
        box1339 = (Button) findViewById(R.id.box1339);
        box1336 = (View) findViewById(R.id.box1336);
        box1338 = (TextView) findViewById(R.id.box1338);
        box1337 = (TextView) findViewById(R.id.box1337);
        box1335 = (View) findViewById(R.id.box1335);
        box1334 = (CheckBox) findViewById(R.id.box1334);
        box1328 = (TextView) findViewById(R.id.box1328);
        box1327 = (TextView) findViewById(R.id.box1327);
        box1333 = (CheckBox) findViewById(R.id.box1333);
        box1326 = (TextView) findViewById(R.id.box1326);
        box1332 = (CheckBox) findViewById(R.id.box1332);
        box1325 = (TextView) findViewById(R.id.box1325);
        box1324 = (TextView) findViewById(R.id.box1324);
        box1331 = (CheckBox) findViewById(R.id.box1331);
        box1323 = (TextView) findViewById(R.id.box1323);
        box1330 = (CheckBox) findViewById(R.id.box1330);
        box1322 = (TextView) findViewById(R.id.box1322);
        box1329 = (CheckBox) findViewById(R.id.box1329);
        box1321 = (TextView) findViewById(R.id.box1321);
        box1372 = (TextView) findViewById(R.id.box1372);
        box1366 = (ImageView) findViewById(R.id.box1366);
        box1367 = (ImageView) findViewById(R.id.box1367);
        box1319 = (Toolbar) findViewById(R.id.box1319);

        box1339.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startConfirmOrder();
                    }
                });
    }
}
