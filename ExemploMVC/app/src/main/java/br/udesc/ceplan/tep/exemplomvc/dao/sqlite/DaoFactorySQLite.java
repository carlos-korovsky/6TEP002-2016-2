package br.udesc.ceplan.tep.exemplomvc.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import br.udesc.ceplan.tep.exemplomvc.dao.DaoFactory;
import br.udesc.ceplan.tep.exemplomvc.dao.TarefaDao;

/**
 * Created by UKTech on 25/10/2016.
 */
public class DaoFactorySQLite extends DaoFactory {

    private final SQLiteOpenHelper database;


    public DaoFactorySQLite(Context context) {
        this.database = new SQLiteExemploDatabase(context);
    }


    @Override
    public TarefaDao getTarefaDao() {
        return new TarefasDaoSQLite(database);
    }
}
