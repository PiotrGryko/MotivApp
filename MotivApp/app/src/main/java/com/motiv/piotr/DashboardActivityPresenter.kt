 
package com.motiv.piotr
import androidx.fragment.app.*
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public class DashboardActivityPresenter(val view: DashboardActivityContract.View, val goRestApi: GoRestApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : DashboardActivityContract.Presenter {

    override fun eloonNavigationItemSelected(argument0: android.view.MenuItem) {
        view.navigationControllerstartDestinationById(argument0.getItemId())
    } override fun eloonClick(argument0: android.view.View) {
        view.navigationControllerstartUserDetailActivity(view.getloggedUser())
    }
}
