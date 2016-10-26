package br.udesc.ceplan.tep.exemplomvc.dao;

import android.content.Context;

import br.udesc.ceplan.tep.exemplomvc.dao.sqlite.DaoFactorySQLite;

/**
 * Created by UKTech on 25/10/2016.
 */

public interface DaoFactory {

    public abstract TarefaDao getTarefaDao();

}
