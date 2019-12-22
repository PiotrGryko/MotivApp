package com.motiv.piotr;


public interface BottomNavigationActivityContract {

    public interface View {

        public void navigationControllerstartDestinationById(int arg0);
    }

    public interface Presenter {

        public void eloonNavigationItemSelected(android.view.MenuItem argument0);
    }
}
