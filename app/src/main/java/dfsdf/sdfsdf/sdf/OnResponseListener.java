package dfsdf.sdfsdf.sdf;


public interface OnResponseListener<T> {

    public void onSuccess(T response);

    public void onError(Exception error);
}
