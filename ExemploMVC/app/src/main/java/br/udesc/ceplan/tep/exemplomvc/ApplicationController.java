package br.udesc.ceplan.tep.exemplomvc;

import android.app.Application;

import br.udesc.ceplan.tep.exemplomvc.dao.DaoFactory;
import br.udesc.ceplan.tep.exemplomvc.dao.sqlite.DaoFactorySQLite;

/**
 * Created by UKTech on 25/10/2016.
 */

public class ApplicationController extends Application {

    private DaoFactory daoFactorySQLite;

    public synchronized DaoFactory getDaoFactorySQLite() {
        if (this.daoFactorySQLite == null) {
            this.daoFactorySQLite = new DaoFactorySQLite(this);
        }
        return this.daoFactorySQLite;
    }
}
