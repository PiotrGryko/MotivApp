package dfsdf.sdfsdf.sdf;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import dfsdf.sdfsdf.sdf.dao.DaoRepository;
import dfsdf.sdfsdf.sdf.dao.DaoRepositoryFactory;
import dfsdf.sdfsdf.sdf.dao.LocalStorage;

public class SmoothiesList extends AppCompatActivity {

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
    private ScrollView box1198;
    private RelativeLayout relativelayout30;
    private ConstraintLayout constraintlayout40;
    private ImageView box1212;
    private TextView box1213;
    private TextView box1214;
    private View box188;
    private View box197;
    private View box198;
    private View box199;
    private View box200;
    private Button box1362;
    private ImageView box1235;
    private TextView box1236;
    private TextView box1237;
    private View box3ifdw;
    private View boxm7uao;
    private View boxiiyob;
    private View boxgxifq;
    private View boxasz1c;
    private Button box1360;
    private ImageView box1240;
    private TextView box1241;
    private TextView box1242;
    private View boxdnspi;
    private View boxr7q98;
    private View boxvl58b;
    private View boxi9mi7;
    private View boxxo08a;
    private Button box1359;
    private ImageView box77;
    private View box1264;
    private TextView box1210;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.smoothieslist);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(SmoothiesList.this.getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(SmoothiesList.this.getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(SmoothiesList.this.getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(SmoothiesList.this);
        localStorage = LocalStorage.getInstance(SmoothiesList.this);
        navigationController = new NavigationController(SmoothiesList.this);
        drawerlayout00 = (DrawerLayout) findViewById(R.id.drawerlayout00);
        constraintlayout10 = (ConstraintLayout) findViewById(R.id.constraintlayout10);
        box1198 = (ScrollView) findViewById(R.id.box1198);
        relativelayout30 = (RelativeLayout) findViewById(R.id.relativelayout30);
        constraintlayout40 = (ConstraintLayout) findViewById(R.id.constraintlayout40);
        box1212 = (ImageView) findViewById(R.id.box1212);
        box1213 = (TextView) findViewById(R.id.box1213);
        box1214 = (TextView) findViewById(R.id.box1214);
        box188 = (View) findViewById(R.id.box188);
        box197 = (View) findViewById(R.id.box197);
        box198 = (View) findViewById(R.id.box198);
        box199 = (View) findViewById(R.id.box199);
        box200 = (View) findViewById(R.id.box200);
        box1362 = (Button) findViewById(R.id.box1362);
        box1235 = (ImageView) findViewById(R.id.box1235);
        box1236 = (TextView) findViewById(R.id.box1236);
        box1237 = (TextView) findViewById(R.id.box1237);
        box3ifdw = (View) findViewById(R.id.box3ifdw);
        boxm7uao = (View) findViewById(R.id.boxm7uao);
        boxiiyob = (View) findViewById(R.id.boxiiyob);
        boxgxifq = (View) findViewById(R.id.boxgxifq);
        boxasz1c = (View) findViewById(R.id.boxasz1c);
        box1360 = (Button) findViewById(R.id.box1360);
        box1240 = (ImageView) findViewById(R.id.box1240);
        box1241 = (TextView) findViewById(R.id.box1241);
        box1242 = (TextView) findViewById(R.id.box1242);
        boxdnspi = (View) findViewById(R.id.boxdnspi);
        boxr7q98 = (View) findViewById(R.id.boxr7q98);
        boxvl58b = (View) findViewById(R.id.boxvl58b);
        boxi9mi7 = (View) findViewById(R.id.boxi9mi7);
        boxxo08a = (View) findViewById(R.id.boxxo08a);
        box1359 = (Button) findViewById(R.id.box1359);
        box77 = (ImageView) findViewById(R.id.box77);
        box1264 = (View) findViewById(R.id.box1264);
        box1210 = (TextView) findViewById(R.id.box1210);

        box1362.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startRedFruit();
                    }
                });
        box1360.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startRedFruit();
                    }
                });
        box1359.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startRedFruit();
                    }
                });
    }
}
