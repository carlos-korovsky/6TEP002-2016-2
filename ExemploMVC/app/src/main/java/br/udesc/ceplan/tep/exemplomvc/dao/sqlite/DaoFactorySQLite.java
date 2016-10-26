package br.udesc.ceplan.tep.exemplomvc.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import br.udesc.ceplan.tep.exemplomvc.dao.DaoFactory;
import br.udesc.ceplan.tep.exemplomvc.dao.TarefaDao;

/**
 * Created by UKTech on 25/10/2016.
 */
public class DaoFactorySQLite implements DaoFactory {

    private final SQLiteOpenHelper sqliteDatabase;


    public DaoFactorySQLite(Context context) {
        this.sqliteDatabase = new SQLiteExemploDatabase(context);
    }


    @Override
    public TarefaDao getTarefaDao() {
        return new TarefaDaoSQLite(this.sqliteDatabase);
    }
}
