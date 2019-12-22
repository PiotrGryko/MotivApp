 
package com.motiv.piotr
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage

public class UsersListFragmentPresenter(val view: UsersListFragmentContract.View, val goRestApi: GoRestApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : UsersListFragmentContract.Presenter {

    override fun goRestApigetUsersList() {
        goRestApi.getUsersList(object : com.motiv.piotr.OnResponseListener<com.motiv.piotr.UsersListResponse> {
            override fun onSuccess(argument0: com.motiv.piotr.UsersListResponse) {
                view.usersListAdaptersetData(argument0.getResult())
            } override fun onError(argument0: Exception) {
            } 
        })
    } override fun eloonItemClick(argument0: Int, argument1: com.motiv.piotr.User) {
        view.navigationControllerstartUserDetailActivity(argument1)
    }
}
