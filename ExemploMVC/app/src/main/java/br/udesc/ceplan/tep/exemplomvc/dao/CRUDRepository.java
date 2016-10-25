package br.udesc.ceplan.tep.exemplomvc.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by UKTech on 25/10/2016.
 */

public interface CRUDRepository<T, ID extends Serializable> {

    public T create(T entity);
    public T update(T entity);
    public T delete(T entity);
    public boolean delete(ID id);
    public T findOneById(ID id);
    public List<T> findAll();

}
