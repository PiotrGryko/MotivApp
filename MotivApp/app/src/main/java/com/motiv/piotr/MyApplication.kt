 
package com.motiv.piotr
import android.app.Application
import io.realm.*

public class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)
    }
}
