package com.motiv.piotr;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public interface BottomNavigationActivityContract {

    public interface View {

        public void navigationControllerstartDestinationById(int arg0);
    }

    public interface Presenter {

        public void eloonNavigationItemSelected(android.view.MenuItem argument0);
    }
}
