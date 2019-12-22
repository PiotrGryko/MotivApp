 
package com.motiv.piotr
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage

public class PostDetailsActivityPresenter(val view: PostDetailsActivityContract.View, val goRestApi: GoRestApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : PostDetailsActivityContract.Presenter
