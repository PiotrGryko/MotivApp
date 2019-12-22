package com.motiv.piotr;


public interface OnResponseListener<T> {

    public void onSuccess(T response);

    public void onError(Exception error);
}
