 
package com.motiv.piotr

public interface BottomNavigationActivityContract {

    public interface View {

        public fun navigationControllerstartDestinationById(arg0: Int): Unit
    }

    public interface Presenter {

        public fun eloonNavigationItemSelected(argument0: android.view.MenuItem): Unit
    }
}
