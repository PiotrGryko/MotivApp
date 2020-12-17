package dfsdf.sdfsdf.sdf;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.*;
import dfsdf.sdfsdf.sdf.dao.DaoRepository;
import dfsdf.sdfsdf.sdf.dao.DaoRepositoryFactory;
import dfsdf.sdfsdf.sdf.dao.LocalStorage;

public class Box1195Page2 extends Fragment {

    private Box1195ViewpagerAdapter box1195ViewpagerAdapter;
    private Box1267ViewpagerAdapter box1267ViewpagerAdapter;
    private Box1280ViewpagerAdapter box1280ViewpagerAdapter;
    private Box1049ListAdapter box1049ListAdapter;
    private Boxt72h5ListAdapter boxt72h5ListAdapter;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private ConstraintLayout constraintlayout00;
    private TextView box1262;
    private ImageView box1260;
    private TextView box1261;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.box1195page2, parent, false);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(
                        Box1195Page2.this.getActivity().getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(
                        Box1195Page2.this.getActivity().getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(
                        Box1195Page2.this.getActivity().getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(Box1195Page2.this.getActivity());
        localStorage = LocalStorage.getInstance(Box1195Page2.this.getActivity());
        navigationController = new NavigationController(Box1195Page2.this.getActivity());
        constraintlayout00 = (ConstraintLayout) v.findViewById(R.id.constraintlayout00);
        box1262 = (TextView) v.findViewById(R.id.box1262);
        box1260 = (ImageView) v.findViewById(R.id.box1260);
        box1261 = (TextView) v.findViewById(R.id.box1261);

        return v;
    }
}
