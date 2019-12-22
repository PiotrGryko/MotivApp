 
package com.motiv.piotr
import androidx.fragment.app.*
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public class PostsListFragmentPresenter(val view: PostsListFragmentContract.View, val goRestApi: GoRestApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : PostsListFragmentContract.Presenter {

    override fun goRestApigetPostsList() {
        goRestApi.getPostsList(object : com.motiv.piotr.OnResponseListener<com.motiv.piotr.PostsListResponse> {
            override fun onSuccess(argument0: com.motiv.piotr.PostsListResponse) {
                view.postsListAdaptersetData(argument0.getResult())
            } override fun onError(argument0: Exception) {
            } 
        })
    } override fun eloonItemClick(argument0: Int, argument1: com.motiv.piotr.Post) {
        view.navigationControllerstartPostDetailsActivity(argument1)
    }
}
