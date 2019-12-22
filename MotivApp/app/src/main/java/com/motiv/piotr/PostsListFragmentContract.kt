 
package com.motiv.piotr
import androidx.fragment.app.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List

public interface PostsListFragmentContract {

    public interface View {

        public fun postsListAdaptersetData(arg0: List<com.motiv.piotr.Post>): Unit
        public fun navigationControllerstartPostDetailsActivity(arg0: com.motiv.piotr.Post): Unit
    }

    public interface Presenter {

        public fun goRestApigetPostsList(): Unit
        public fun eloonItemClick(argument0: Int, argument1: com.motiv.piotr.Post): Unit
    }
}
