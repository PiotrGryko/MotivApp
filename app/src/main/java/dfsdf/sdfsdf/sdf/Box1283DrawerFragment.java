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

public class Box1283DrawerFragment extends Fragment {

    private Box1195ViewpagerAdapter box1195ViewpagerAdapter;
    private Box1267ViewpagerAdapter box1267ViewpagerAdapter;
    private Box1280ViewpagerAdapter box1280ViewpagerAdapter;
    private Box1049ListAdapter box1049ListAdapter;
    private Boxt72h5ListAdapter boxt72h5ListAdapter;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private ConstraintLayout constraintlayout00;
    private View box2mpqu;
    private RecyclerView boxt72h5;
    private View boxqxtiv;
    private TextView box1nwnf;
    private TextView boxs81hm;
    private View box15voh;
    private TextView boxlbnt9;
    private TextView boxdf45f;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.box1283drawerfragment, parent, false);

        box1195ViewpagerAdapter =
                new Box1195ViewpagerAdapter(
                        Box1283DrawerFragment.this.getActivity().getSupportFragmentManager());
        box1267ViewpagerAdapter =
                new Box1267ViewpagerAdapter(
                        Box1283DrawerFragment.this.getActivity().getSupportFragmentManager());
        box1280ViewpagerAdapter =
                new Box1280ViewpagerAdapter(
                        Box1283DrawerFragment.this.getActivity().getSupportFragmentManager());
        box1049ListAdapter = new Box1049ListAdapter();
        boxt72h5ListAdapter = new Boxt72h5ListAdapter();
        daoRepository = DaoRepositoryFactory.getInstance(Box1283DrawerFragment.this.getActivity());
        localStorage = LocalStorage.getInstance(Box1283DrawerFragment.this.getActivity());
        navigationController = new NavigationController(Box1283DrawerFragment.this.getActivity());
        constraintlayout00 = (ConstraintLayout) v.findViewById(R.id.constraintlayout00);
        box2mpqu = (View) v.findViewById(R.id.box2mpqu);
        boxt72h5 = (RecyclerView) v.findViewById(R.id.boxt72h5);
        boxqxtiv = (View) v.findViewById(R.id.boxqxtiv);
        box1nwnf = (TextView) v.findViewById(R.id.box1nwnf);
        boxs81hm = (TextView) v.findViewById(R.id.boxs81hm);
        box15voh = (View) v.findViewById(R.id.box15voh);
        boxlbnt9 = (TextView) v.findViewById(R.id.boxlbnt9);
        boxdf45f = (TextView) v.findViewById(R.id.boxdf45f);

        boxt72h5.setLayoutManager(
                new LinearLayoutManager(Box1283DrawerFragment.this.getActivity()));

        boxt72h5.setAdapter(boxt72h5ListAdapter);
        ;
        ArrayList<Boxt72h5ModelList> list = new ArrayList<Boxt72h5ModelList>();
        Boxt72h5ModelList element0 = new Boxt72h5ModelList();
        list.add(element0);
        element0.setField0("abeabcfabfbad_c.svg");
        element0.setField1("Smoothies");
        Boxt72h5ModelList element1 = new Boxt72h5ModelList();
        list.add(element1);
        element1.setField0("dbedcfffbd_aae.svg");
        element1.setField1("My orders");
        Boxt72h5ModelList element2 = new Boxt72h5ModelList();
        list.add(element2);
        element2.setField0("fbbaddfeeafaa_aae.svg");
        element2.setField1("Sign Out");
        boxt72h5ListAdapter.setData(list);
        ;

        return v;
    }
}
