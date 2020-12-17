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

public class SignIn extends AppCompatActivity {

    private Box1195ViewpagerAdapter box1195ViewpagerAdapter;
    private Box1267ViewpagerAdapter box1267ViewpagerAdapter;
    private Box1280ViewpagerAdapter box1280ViewpagerAdapter;
    private Box1049ListAdapter box1049ListAdapter;
    private Boxt72h5ListAdapter boxt72h5ListAdapter;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private ConstraintLayout constraintlayout00;
    private ImageView box1155;
    private TextView box1156;
    private TextView box1157;
    private Button box1158;
    private View box1162;
    private ImageView box1163;
    private TextInputLayout box1164;
    private TextInputEditText box1164editText;
    private View box1159;
    private ImageView box1160;
    private TextInputLayout box1161;
    private TextInputEditText box1161editText;
    private ImageView box1169;
    private TextView box1167;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(SignIn.this.getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(SignIn.this.getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(SignIn.this.getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(SignIn.this);
        localStorage = LocalStorage.getInstance(SignIn.this);
        navigationController = new NavigationController(SignIn.this);
        constraintlayout00 = (ConstraintLayout) findViewById(R.id.constraintlayout00);
        box1155 = (ImageView) findViewById(R.id.box1155);
        box1156 = (TextView) findViewById(R.id.box1156);
        box1157 = (TextView) findViewById(R.id.box1157);
        box1158 = (Button) findViewById(R.id.box1158);
        box1162 = (View) findViewById(R.id.box1162);
        box1163 = (ImageView) findViewById(R.id.box1163);
        box1164 = (TextInputLayout) findViewById(R.id.box1164);
        box1164editText = (TextInputEditText) findViewById(R.id.box1164editText);
        box1159 = (View) findViewById(R.id.box1159);
        box1160 = (ImageView) findViewById(R.id.box1160);
        box1161 = (TextInputLayout) findViewById(R.id.box1161);
        box1161editText = (TextInputEditText) findViewById(R.id.box1161editText);
        box1169 = (ImageView) findViewById(R.id.box1169);
        box1167 = (TextView) findViewById(R.id.box1167);

        box1156.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startSignUp();
                    }
                });
        box1157.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startSignUp();
                    }
                });
        box1158.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startSmoothiesList();
                    }
                });
    }
}
