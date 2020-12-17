package dfsdf.sdfsdf.sdf;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import dfsdf.sdfsdf.sdf.dao.DaoRepository;
import dfsdf.sdfsdf.sdf.dao.DaoRepositoryFactory;
import dfsdf.sdfsdf.sdf.dao.LocalStorage;

public class SignUp extends AppCompatActivity {

    private Box1195ViewpagerAdapter box1195ViewpagerAdapter;
    private Box1267ViewpagerAdapter box1267ViewpagerAdapter;
    private Box1280ViewpagerAdapter box1280ViewpagerAdapter;
    private Box1049ListAdapter box1049ListAdapter;
    private Boxt72h5ListAdapter boxt72h5ListAdapter;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private ConstraintLayout constraintlayout00;
    private ImageView box1172;
    private TextView box1191;
    private TextView box1192;
    private Button box1175;
    private ImageView box1183;
    private TextInputLayout box1184;
    private TextInputEditText box1184editText;
    private View box1178;
    private ImageView box1179;
    private View box1180;
    private TextInputLayout box1181;
    private TextInputEditText box1181editText;
    private View box1182;
    private ImageView box1176;
    private TextInputLayout box1177;
    private TextInputEditText box1177editText;
    private ImageView box1189;
    private TextView box1190;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(SignUp.this.getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(SignUp.this.getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(SignUp.this.getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(SignUp.this);
        localStorage = LocalStorage.getInstance(SignUp.this);
        navigationController = new NavigationController(SignUp.this);
        constraintlayout00 = (ConstraintLayout) findViewById(R.id.constraintlayout00);
        box1172 = (ImageView) findViewById(R.id.box1172);
        box1191 = (TextView) findViewById(R.id.box1191);
        box1192 = (TextView) findViewById(R.id.box1192);
        box1175 = (Button) findViewById(R.id.box1175);
        box1183 = (ImageView) findViewById(R.id.box1183);
        box1184 = (TextInputLayout) findViewById(R.id.box1184);
        box1184editText = (TextInputEditText) findViewById(R.id.box1184editText);
        box1178 = (View) findViewById(R.id.box1178);
        box1179 = (ImageView) findViewById(R.id.box1179);
        box1180 = (View) findViewById(R.id.box1180);
        box1181 = (TextInputLayout) findViewById(R.id.box1181);
        box1181editText = (TextInputEditText) findViewById(R.id.box1181editText);
        box1182 = (View) findViewById(R.id.box1182);
        box1176 = (ImageView) findViewById(R.id.box1176);
        box1177 = (TextInputLayout) findViewById(R.id.box1177);
        box1177editText = (TextInputEditText) findViewById(R.id.box1177editText);
        box1189 = (ImageView) findViewById(R.id.box1189);
        box1190 = (TextView) findViewById(R.id.box1190);

        box1191.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startSignIn();
                    }
                });
        box1192.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startSignIn();
                    }
                });
        box1175.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startSmoothiesList();
                    }
                });
    }
}
