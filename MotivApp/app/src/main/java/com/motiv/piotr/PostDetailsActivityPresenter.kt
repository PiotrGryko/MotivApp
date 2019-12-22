 
package com.motiv.piotr
import androidx.fragment.app.*
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public class PostDetailsActivityPresenter(val view: PostDetailsActivityContract.View, val goRestApi: GoRestApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : PostDetailsActivityContract.Presenter
