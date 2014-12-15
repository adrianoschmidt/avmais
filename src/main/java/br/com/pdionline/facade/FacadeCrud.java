package br.com.pdionline.facade;

import br.com.pdionline.mongo.MongoConnection;

import com.mongodb.MongoException;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FacadeCrud<T> implements ICrud<T>{

    // FIELDS
    private JacksonDBCollection<T, String> jacksonDB;
    //private Class<T> entityClass;


    // CONSTUCTORS

    public FacadeCrud(JacksonDBCollection<T, String> jacksonDB) {
        this.jacksonDB = jacksonDB;

    }


    // METHODS


    // OVERRIDEN METHODS


    /**
     * CREATE
     * @param entity
     * @return
     * @throws MongoException
     */
    public T create(T entity) throws MongoException, IOException {

        WriteResult<T, String> result = jacksonDB.insert(entity);

        //T t = getEntityManager().persist(entity);

        return (T) result.getSavedObject();
    }
}
