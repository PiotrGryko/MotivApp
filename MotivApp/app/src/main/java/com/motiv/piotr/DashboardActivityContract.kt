 
package com.motiv.piotr
import androidx.fragment.app.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public interface DashboardActivityContract {

    public interface View {

        public fun navigationControllerstartDestinationById(arg0: Int): Unit
        public fun navigationControllerstartUserDetailActivity(arg0: com.motiv.piotr.User): Unit
        public fun getloggedUser(): com.motiv.piotr.User
    }

    public interface Presenter {

        public fun eloonNavigationItemSelected(argument0: android.view.MenuItem): Unit
        public fun eloonClick(argument0: android.view.View): Unit
    }
}
