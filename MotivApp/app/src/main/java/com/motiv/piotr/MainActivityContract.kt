 
package com.motiv.piotr

public interface MainActivityContract {

    public interface View {

        public fun edittext10getText(): CharSequence
        public fun showToast(arg0: String): Unit
        public fun navigationControllerstartDashboardActivity(arg0: com.motiv.piotr.User): Unit
    }

    public interface Presenter {

        public fun eloonClick(argument0: android.view.View): Unit
    }
}
