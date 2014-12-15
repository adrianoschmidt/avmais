package br.com.pdionline.facade;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;

import java.io.IOException;
import java.util.List;


public interface ICrud<T> {

    //List<T> findAll();

    //T find(Object id);

    //Object delete(Object id);

    T create(T entity) throws MongoException, IOException;
}
