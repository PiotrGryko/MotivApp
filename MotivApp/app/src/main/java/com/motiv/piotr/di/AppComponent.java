package com.motiv.piotr.di;

import androidx.fragment.app.*;
import com.motiv.piotr.GoRestApi;
import com.motiv.piotr.MyApplication;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

@Singleton
@Component(modules = {AppModule.class, AndroidSupportInjectionModule.class, AppContributions.class})
public interface AppComponent {

    GoRestApi goRestApi();

    void inject(MyApplication myApplication);
}
