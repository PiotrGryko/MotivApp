 
package com.motiv.piotr
import kotlin.collections.List

public interface UsersListFragmentContract {

    public interface View {

        public fun usersListAdaptersetData(arg0: List<com.motiv.piotr.User>): Unit
        public fun navigationControllerstartUserDetailActivity(arg0: com.motiv.piotr.User): Unit
    }

    public interface Presenter {

        public fun goRestApigetUsersList(): Unit
        public fun eloonItemClick(argument0: Int, argument1: com.motiv.piotr.User): Unit
    }
}
