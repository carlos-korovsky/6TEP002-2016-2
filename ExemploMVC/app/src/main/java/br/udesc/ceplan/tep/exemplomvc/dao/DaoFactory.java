package br.udesc.ceplan.tep.exemplomvc.dao;

import android.content.Context;

import br.udesc.ceplan.tep.exemplomvc.dao.sqlite.DaoFactorySQLite;

/**
 * Created by UKTech on 25/10/2016.
 */

public abstract class DaoFactory {

    private static DaoFactory instance;
    private static Context lastContext  = null;;

    protected DaoFactory() {

    }

    public static synchronized DaoFactory getFactory(Context context) {
        if ((!lastContext.equals(context)) || (DaoFactory.instance == null)) {
            DaoFactory.instance = new DaoFactorySQLite(context);
        }
        return DaoFactory.instance;
    }

    public abstract TarefaDao getTarefaDao();

}
