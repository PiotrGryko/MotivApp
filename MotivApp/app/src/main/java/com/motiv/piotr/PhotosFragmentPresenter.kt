 
package com.motiv.piotr
import androidx.fragment.app.*
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public class PhotosFragmentPresenter(val view: PhotosFragmentContract.View, val goRestApi: GoRestApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : PhotosFragmentContract.Presenter {

    override fun goRestApigetPhotosList() {
        goRestApi.getPhotosList(object : com.motiv.piotr.OnResponseListener<com.motiv.piotr.PhotosListResponse> {
            override fun onSuccess(argument0: com.motiv.piotr.PhotosListResponse) {
                view.photosPagerAdaptersetData(argument0.getResult())
            } override fun onError(argument0: Exception) {
            } 
        })
    }
}
