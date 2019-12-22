 
package com.motiv.piotr

public interface OnResponseListener<T> {

    public fun onSuccess(response: T): Unit
    public fun onError(error: Exception): Unit
}
