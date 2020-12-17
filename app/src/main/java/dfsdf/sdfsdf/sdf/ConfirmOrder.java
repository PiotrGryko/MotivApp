package dfsdf.sdfsdf.sdf;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import dfsdf.sdfsdf.sdf.dao.DaoRepository;
import dfsdf.sdfsdf.sdf.dao.DaoRepositoryFactory;
import dfsdf.sdfsdf.sdf.dao.LocalStorage;

public class ConfirmOrder extends AppCompatActivity {

    private Box1195ViewpagerAdapter box1195ViewpagerAdapter;
    private Box1267ViewpagerAdapter box1267ViewpagerAdapter;
    private Box1280ViewpagerAdapter box1280ViewpagerAdapter;
    private Box1049ListAdapter box1049ListAdapter;
    private Boxt72h5ListAdapter boxt72h5ListAdapter;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private ConstraintLayout constraintlayout00;
    private TextView box1306;
    private Button box1310;
    private Button box1295;
    private ImageView box1296;
    private View box1356;
    private TextView box1358;
    private TextView box1357;
    private View box1355;
    private TextView box1348;
    private TextView box1346;
    private TextView box1345;
    private TextView box1343;
    private TextView box1342;
    private TextView box1341;
    private TextView box1344;
    private TextView box1375;
    private TextView box1376;
    private Toolbar box1312;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmorder);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(ConfirmOrder.this.getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(ConfirmOrder.this.getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(ConfirmOrder.this.getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(ConfirmOrder.this);
        localStorage = LocalStorage.getInstance(ConfirmOrder.this);
        navigationController = new NavigationController(ConfirmOrder.this);
        constraintlayout00 = (ConstraintLayout) findViewById(R.id.constraintlayout00);
        box1306 = (TextView) findViewById(R.id.box1306);
        box1310 = (Button) findViewById(R.id.box1310);
        box1295 = (Button) findViewById(R.id.box1295);
        box1296 = (ImageView) findViewById(R.id.box1296);
        box1356 = (View) findViewById(R.id.box1356);
        box1358 = (TextView) findViewById(R.id.box1358);
        box1357 = (TextView) findViewById(R.id.box1357);
        box1355 = (View) findViewById(R.id.box1355);
        box1348 = (TextView) findViewById(R.id.box1348);
        box1346 = (TextView) findViewById(R.id.box1346);
        box1345 = (TextView) findViewById(R.id.box1345);
        box1343 = (TextView) findViewById(R.id.box1343);
        box1342 = (TextView) findViewById(R.id.box1342);
        box1341 = (TextView) findViewById(R.id.box1341);
        box1344 = (TextView) findViewById(R.id.box1344);
        box1375 = (TextView) findViewById(R.id.box1375);
        box1376 = (TextView) findViewById(R.id.box1376);
        box1312 = (Toolbar) findViewById(R.id.box1312);

        box1310.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startPlacingOrder();
                    }
                });
    }
}
