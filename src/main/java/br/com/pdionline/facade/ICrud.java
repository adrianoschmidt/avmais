package br.com.pdionline.facade;

import com.mongodb.BasicDBObject;

import java.util.List;


public interface ICrud<T> {

    List<T> findAll();

    T find(Object id);
    
    Object delete(Object id);

    Object create(BasicDBObject query);
}
