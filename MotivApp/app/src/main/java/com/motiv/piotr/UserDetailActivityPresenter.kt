 
package com.motiv.piotr
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage

public class UserDetailActivityPresenter(val view: UserDetailActivityContract.View, val goRestApi: GoRestApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : UserDetailActivityContract.Presenter
