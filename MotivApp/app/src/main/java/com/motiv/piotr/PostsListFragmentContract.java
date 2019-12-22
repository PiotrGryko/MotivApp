package com.motiv.piotr;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public interface PostsListFragmentContract {

    public interface View {

        public void postsListAdaptersetData(java.util.List<com.motiv.piotr.Post> arg0);

        public void navigationControllerstartPostDetailsActivity(com.motiv.piotr.Post arg0);
    }

    public interface Presenter {

        public void goRestApigetPostsList();

        public void eloonItemClick(int argument0, com.motiv.piotr.Post argument1);
    }
}
