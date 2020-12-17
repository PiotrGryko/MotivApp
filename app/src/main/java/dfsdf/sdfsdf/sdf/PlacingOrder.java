package dfsdf.sdfsdf.sdf;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import dfsdf.sdfsdf.sdf.dao.DaoRepository;
import dfsdf.sdfsdf.sdf.dao.DaoRepositoryFactory;
import dfsdf.sdfsdf.sdf.dao.LocalStorage;

public class PlacingOrder extends AppCompatActivity {

    private Box1195ViewpagerAdapter box1195ViewpagerAdapter;
    private Box1267ViewpagerAdapter box1267ViewpagerAdapter;
    private Box1280ViewpagerAdapter box1280ViewpagerAdapter;
    private Box1049ListAdapter box1049ListAdapter;
    private Boxt72h5ListAdapter boxt72h5ListAdapter;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private ConstraintLayout constraintlayout00;
    private View box1273;
    private TextView box1274;
    private ImageView box1276;
    private View box6qz0o;
    private TextView boxyx61p;
    private ImageView boxxmqvp;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.placingorder);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(PlacingOrder.this.getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(PlacingOrder.this.getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(PlacingOrder.this.getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(PlacingOrder.this);
        localStorage = LocalStorage.getInstance(PlacingOrder.this);
        navigationController = new NavigationController(PlacingOrder.this);
        constraintlayout00 = (ConstraintLayout) findViewById(R.id.constraintlayout00);
        box1273 = (View) findViewById(R.id.box1273);
        box1274 = (TextView) findViewById(R.id.box1274);
        box1276 = (ImageView) findViewById(R.id.box1276);
        box6qz0o = (View) findViewById(R.id.box6qz0o);
        boxyx61p = (TextView) findViewById(R.id.boxyx61p);
        boxxmqvp = (ImageView) findViewById(R.id.boxxmqvp);

        constraintlayout00.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startMyOrders();
                    }
                });
    }
}
