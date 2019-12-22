 
package com.motiv.piotr
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage

public class BottomNavigationActivityPresenter(val view: BottomNavigationActivityContract.View, val goRestApi: GoRestApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : BottomNavigationActivityContract.Presenter {

    override fun eloonNavigationItemSelected(argument0: android.view.MenuItem) {
        view.navigationControllerstartDestinationById(argument0.getItemId())
    }
}
