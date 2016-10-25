package br.udesc.ceplan.tep.exemplomvc.dao.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.udesc.ceplan.tep.exemplomvc.dao.TarefaDao;
import br.udesc.ceplan.tep.exemplomvc.model.Tarefa;

/**
 * Created by UKTech on 25/10/2016.
 */
public class TarefasDaoSQLite implements TarefaDao {

    private final SQLiteOpenHelper database;

    public TarefasDaoSQLite(SQLiteOpenHelper database) {
        this.database = database;
    }

    @Override
    public Tarefa create(Tarefa entity) {
        SQLiteDatabase db = this.database.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("name", entity.getName());
            values.put("description", entity.getDescription());
            long id = db.insert("tarefa", "", values);
            entity.setId(id);
            return entity;
        } catch (Exception e) {
            return null;
        } finally {
            db.close();
        }
    }

    @Override
    public Tarefa update(Tarefa entity) {
        SQLiteDatabase db = this.database.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("name", entity.getName());
            values.put("description", entity.getDescription());
            String[] whereArgs = new String[]{ entity.getId().toString() };
            int count = db.update("tarefa", values, "_id=?", whereArgs);
            if (count > 0) {
                return entity;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        } finally {
            db.close();
        }
    }

    @Override
    public Tarefa delete(Tarefa entity) {
        if (this.delete(entity.getId())) {
            entity.setId(null);
            return entity;
        }
        return null;
    }

    @Override
    public boolean delete(Long _id) {
        SQLiteDatabase db = this.database.getWritableDatabase();
        try {
            String[] whereArgs = new String[]{ _id.toString() };
            int count = db.delete("tarefa", "_id=?", whereArgs);
            return  (count > 0);
        } catch (Exception e) {
            return false;
        } finally {
            db.close();
        }
    }

    @Override
    public Tarefa findOneById(Long _id) {
        SQLiteDatabase db = this.database.getWritableDatabase();
        try {
            String[] selectArgs = new String[] { _id.toString() } ;
            Cursor c;
            c = db.query(true, "tarefa", null, "_id=?", selectArgs, null, null, null, "1");
            Tarefa product = toList(c).get(0);
            c.close();
            return product;
        } finally {
            db.close();
        }
    }

    @Override
    public List<Tarefa> findAll() {
        SQLiteDatabase db = this.database.getWritableDatabase();
        try {
            Cursor c;
            c = db.query(true, "tarefa", null, null, null, null, null, null, null);
            List<Tarefa> products = toList(c);
            c.close();
            return products;
        } finally {
            db.close();
        }
    }

    private List<Tarefa> toList(Cursor c) {
        List<Tarefa> tarefas = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                Tarefa tarefa = new Tarefa();
                tarefas.add(tarefa);
                tarefa.setId(c.getLong(c.getColumnIndex("_id")));
                tarefa.setName(c.getString(c.getColumnIndex("name")));
                tarefa.setDescription(c.getString(c.getColumnIndex("description")));
            } while (c.moveToNext());
        }
        return tarefas;
    }
}
