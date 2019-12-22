 
package com.motiv.piotr
import androidx.fragment.app.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List

public interface PhotosFragmentContract {

    public interface View {

        public fun photosPagerAdaptersetData(arg0: List<com.motiv.piotr.Photo>): Unit
    }

    public interface Presenter {

        public fun goRestApigetPhotosList(): Unit
    }
}
