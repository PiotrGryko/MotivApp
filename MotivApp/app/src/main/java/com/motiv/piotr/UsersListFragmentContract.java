package com.motiv.piotr;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public interface UsersListFragmentContract {

    public interface View {

        public void usersListAdaptersetData(java.util.List<com.motiv.piotr.User> arg0);

        public void navigationControllerstartUserDetailActivity(com.motiv.piotr.User arg0);
    }

    public interface Presenter {

        public void goRestApigetUsersList();

        public void eloonItemClick(int argument0, com.motiv.piotr.User argument1);
    }
}
