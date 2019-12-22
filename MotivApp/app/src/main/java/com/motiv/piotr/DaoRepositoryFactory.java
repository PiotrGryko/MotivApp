package com.motiv.piotr;

import android.content.Context;
import com.motiv.piotr.dao.DaoRepository;
import io.realm.*;

public class DaoRepositoryFactory {

    private static DaoRepository daoRepository;
    private static DaoRepositoryFactory instance;

    private DaoRepositoryFactory(Context context) {

        this.daoRepository = new DaoRepository(Realm.getDefaultInstance());
    }

    public static DaoRepository getInstance(Context context) {
        if (instance == null) {
            instance = new DaoRepositoryFactory(context);
        }
        return instance.daoRepository;
    }
}
