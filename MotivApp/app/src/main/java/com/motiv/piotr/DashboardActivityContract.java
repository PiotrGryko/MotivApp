package com.motiv.piotr;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public interface DashboardActivityContract {

    public interface View {

        public void navigationControllerstartDestinationById(int arg0);

        public void navigationControllerstartUserDetailActivity(com.motiv.piotr.User arg0);

        public com.motiv.piotr.User getloggedUser();
    }

    public interface Presenter {

        public void eloonNavigationItemSelected(android.view.MenuItem argument0);

        public void eloonClick(android.view.View argument0);
    }
}
