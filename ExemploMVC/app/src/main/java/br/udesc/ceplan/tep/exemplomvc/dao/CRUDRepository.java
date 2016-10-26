package br.udesc.ceplan.tep.exemplomvc.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by UKTech on 25/10/2016.
 */

public interface CRUDRepository<E, K extends Serializable> {

    public E create(E entity);
    public E update(E entity);
    public E delete(E entity);
    public boolean delete(K id);
    public E findOneById(K id);
    public List<E> findAll();

}
