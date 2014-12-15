package br.com.pdionline.facade;

import java.io.IOException;

import org.mongojack.JacksonDBCollection;

import br.com.pdionline.entity.MyPdi;
import br.com.pdionline.mongo.MongoConnection;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoException;


public interface ICrud<T> {

    //List<T> findAll();

    //T find(Object id);

    //Object delete(Object id);

    T create(T entity) throws MongoException, IOException;
    
    public static ICrud getInstance(Class clazz) {
    	DB db = MongoConnection.getDB();
    	DBCollection collection = db.getCollection(clazz.getSimpleName());
    	JacksonDBCollection<MyPdi, String> jacksonDB = JacksonDBCollection.wrap(collection, clazz, String.class);
    	ICrud<MyPdi> crud = new FacadeCrud<>(jacksonDB);
    	return crud;
    }
}
