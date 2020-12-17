package dfsdf.sdfsdf.sdf;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.*;
import dfsdf.sdfsdf.sdf.dao.DaoRepository;
import dfsdf.sdfsdf.sdf.dao.DaoRepositoryFactory;
import dfsdf.sdfsdf.sdf.dao.LocalStorage;

public class Box1267Page0 extends Fragment {

    private Box1195ViewpagerAdapter box1195ViewpagerAdapter;
    private Box1267ViewpagerAdapter box1267ViewpagerAdapter;
    private Box1280ViewpagerAdapter box1280ViewpagerAdapter;
    private Box1049ListAdapter box1049ListAdapter;
    private Boxt72h5ListAdapter boxt72h5ListAdapter;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private ConstraintLayout constraintlayout00;
    private View box1387;
    private View box1389;
    private View box1390;
    private View box1391;
    private View box1392;
    private View box1393;
    private View box1394;
    private TextView box1388;
    private TextView box1396;
    private TextView box1397;
    private TextView box1398;
    private TextView box1399;
    private TextView box1400;
    private TextView box1401;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.box1267page0, parent, false);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(
                        Box1267Page0.this.getActivity().getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(
                        Box1267Page0.this.getActivity().getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(
                        Box1267Page0.this.getActivity().getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(Box1267Page0.this.getActivity());
        localStorage = LocalStorage.getInstance(Box1267Page0.this.getActivity());
        navigationController = new NavigationController(Box1267Page0.this.getActivity());
        constraintlayout00 = (ConstraintLayout) v.findViewById(R.id.constraintlayout00);
        box1387 = (View) v.findViewById(R.id.box1387);
        box1389 = (View) v.findViewById(R.id.box1389);
        box1390 = (View) v.findViewById(R.id.box1390);
        box1391 = (View) v.findViewById(R.id.box1391);
        box1392 = (View) v.findViewById(R.id.box1392);
        box1393 = (View) v.findViewById(R.id.box1393);
        box1394 = (View) v.findViewById(R.id.box1394);
        box1388 = (TextView) v.findViewById(R.id.box1388);
        box1396 = (TextView) v.findViewById(R.id.box1396);
        box1397 = (TextView) v.findViewById(R.id.box1397);
        box1398 = (TextView) v.findViewById(R.id.box1398);
        box1399 = (TextView) v.findViewById(R.id.box1399);
        box1400 = (TextView) v.findViewById(R.id.box1400);
        box1401 = (TextView) v.findViewById(R.id.box1401);

        return v;
    }
}
