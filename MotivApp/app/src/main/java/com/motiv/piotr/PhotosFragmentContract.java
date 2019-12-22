package com.motiv.piotr;


public interface PhotosFragmentContract {

    public interface View {

        public void photosPagerAdaptersetData(java.util.List<com.motiv.piotr.Photo> arg0);
    }

    public interface Presenter {

        public void goRestApigetPhotosList();
    }
}
