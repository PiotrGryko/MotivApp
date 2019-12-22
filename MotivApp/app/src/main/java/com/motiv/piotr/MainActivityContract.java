package com.motiv.piotr;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public interface MainActivityContract {

    public interface View {

        public java.lang.CharSequence edittext10getText();

        public void showToast(java.lang.String arg0);

        public void navigationControllerstartDashboardActivity(com.motiv.piotr.User arg0);
    }

    public interface Presenter {

        public void eloonClick(android.view.View argument0);
    }
}
