 
package com.motiv.piotr
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage

public class ViewPagerActivityPresenter(val view: ViewPagerActivityContract.View, val goRestApi: GoRestApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : ViewPagerActivityContract.Presenter
