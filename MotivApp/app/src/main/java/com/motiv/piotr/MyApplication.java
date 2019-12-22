package com.motiv.piotr;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.*;
import com.motiv.piotr.di.AppComponent;
import com.motiv.piotr.di.AppModule;
import com.motiv.piotr.di.DaggerAppComponent;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class MyApplication extends Application implements HasActivityInjector {

    @Inject DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    private AppComponent appComponent;

    @Override
    public void onCreate() {

        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {

        return dispatchingAndroidInjector;
    }

    public AppComponent getAppComponent() {

        return appComponent;
    }
}
