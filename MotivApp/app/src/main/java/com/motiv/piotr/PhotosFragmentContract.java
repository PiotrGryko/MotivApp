package com.motiv.piotr;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public interface PhotosFragmentContract {

    public interface View {

        public void photosPagerAdaptersetData(java.util.List<com.motiv.piotr.Photo> arg0);
    }

    public interface Presenter {

        public void goRestApigetPhotosList();
    }
}
