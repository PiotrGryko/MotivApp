package dfsdf.sdfsdf.sdf;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.*;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import dfsdf.sdfsdf.sdf.dao.DaoRepository;
import dfsdf.sdfsdf.sdf.dao.DaoRepositoryFactory;
import dfsdf.sdfsdf.sdf.dao.LocalStorage;
import java.util.ArrayList;

public class Box1202DrawerFragment extends Fragment {

    private Box1195ViewpagerAdapter box1195ViewpagerAdapter;
    private Box1267ViewpagerAdapter box1267ViewpagerAdapter;
    private Box1280ViewpagerAdapter box1280ViewpagerAdapter;
    private Box1049ListAdapter box1049ListAdapter;
    private Boxt72h5ListAdapter boxt72h5ListAdapter;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private ConstraintLayout constraintlayout00;
    private View box1048;
    private RecyclerView box1049;
    private View box1211;
    private TextView box1065;
    private TextView box1064;
    private View box1062;
    private TextView box1063;
    private TextView box1374;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.box1202drawerfragment, parent, false);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(
                        Box1202DrawerFragment.this.getActivity().getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(
                        Box1202DrawerFragment.this.getActivity().getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(
                        Box1202DrawerFragment.this.getActivity().getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(Box1202DrawerFragment.this.getActivity());
        localStorage = LocalStorage.getInstance(Box1202DrawerFragment.this.getActivity());
        navigationController = new NavigationController(Box1202DrawerFragment.this.getActivity());
        constraintlayout00 = (ConstraintLayout) v.findViewById(R.id.constraintlayout00);
        box1048 = (View) v.findViewById(R.id.box1048);
        box1049 = (RecyclerView) v.findViewById(R.id.box1049);
        box1211 = (View) v.findViewById(R.id.box1211);
        box1065 = (TextView) v.findViewById(R.id.box1065);
        box1064 = (TextView) v.findViewById(R.id.box1064);
        box1062 = (View) v.findViewById(R.id.box1062);
        box1063 = (TextView) v.findViewById(R.id.box1063);
        box1374 = (TextView) v.findViewById(R.id.box1374);

        box1049.setLayoutManager(new LinearLayoutManager(Box1202DrawerFragment.this.getActivity()));

        box1049.setAdapter(box1049ListAdapter);
        ;
        ArrayList<Box1049ModelList> list = new ArrayList<Box1049ModelList>();
        Box1049ModelList element0 = new Box1049ModelList();
        list.add(element0);
        element0.setField0("abeabcfabfbad_c.svg");
        element0.setField1("Smoothies");
        Box1049ModelList element1 = new Box1049ModelList();
        list.add(element1);
        element1.setField0("dbedcfffbd_aae.svg");
        element1.setField1("My orders");
        Box1049ModelList element2 = new Box1049ModelList();
        list.add(element2);
        element2.setField0("fbbaddfeeafaa_aae.svg");
        element2.setField1("Sign Out");
        box1049ListAdapter.setData(list);
        ;

        return v;
    }
}
