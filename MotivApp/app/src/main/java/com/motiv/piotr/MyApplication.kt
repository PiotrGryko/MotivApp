 
package com.motiv.piotr
import android.app.Activity
import android.app.Application
import androidx.fragment.app.*
import com.motiv.piotr.di.AppComponent
import com.motiv.piotr.di.AppModule
import com.motiv.piotr.di.DaggerAppComponent
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public class MyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent.inject(this)
    } override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    } fun getAppComponent(): AppComponent {
        return appComponent
    }
}
