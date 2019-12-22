 
package com.motiv.piotr
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage

public class MainActivityPresenter(val view: MainActivityContract.View, val goRestApi: GoRestApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : MainActivityContract.Presenter {

    override fun eloonClick(argument0: android.view.View) {
        goRestApi.getUser(
            view.edittext10getText().toString(),
            object : com.motiv.piotr.OnResponseListener<com.motiv.piotr.UserResponse> {
                override fun onSuccess(argument0: com.motiv.piotr.UserResponse) {
                    view.showToast("success")
                    view.navigationControllerstartDashboardActivity(argument0.getResult())
                } override fun onError(argument0: Exception) {
                    view.showToast("error")
                } 
            }
        )
    }
}
