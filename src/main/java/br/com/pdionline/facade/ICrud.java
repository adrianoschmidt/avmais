package br.com.pdionline.facade;

import java.util.List;

/**
 * Created by supero on 09/12/2014.
 */
public interface ICrud<T> {

    List<T> findAll();

    T find(Object id);
    
    boolean delete(Object id);

    T create(Object T);
}
