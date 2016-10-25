package br.udesc.ceplan.tep.exemplomvc;

import android.app.Application;

import br.udesc.ceplan.tep.exemplomvc.dao.DaoFactory;

/**
 * Created by UKTech on 25/10/2016.
 */

public class ApplicationController extends Application {

    private final DaoFactory daoFactory;

    public ApplicationController() {
        this.daoFactory = DaoFactory.getFactory(this);
    }

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }
}
