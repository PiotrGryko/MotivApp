 
package com.motiv.piotr
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage

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
