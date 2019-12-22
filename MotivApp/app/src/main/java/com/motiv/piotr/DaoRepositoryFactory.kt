 
package com.motiv.piotr
import android.content.Context
import com.motiv.piotr.dao.DaoRepository
import io.realm.*

public class DaoRepositoryFactory {

    private var daoRepository: DaoRepository

    constructor(context: Context) {
        this.daoRepository = DaoRepository(Realm.getDefaultInstance())
    }

    companion object {
        private var instance: DaoRepositoryFactory? = null
        fun getInstance(context: Context): DaoRepository = instance?.daoRepository
            ?: DaoRepositoryFactory(context).daoRepository
    }
}
