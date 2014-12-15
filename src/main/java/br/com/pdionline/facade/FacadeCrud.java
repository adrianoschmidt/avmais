package br.com.pdionline.facade;

import br.com.pdionline.mongo.MongoConnection;
import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;


public class FacadeCrud<T> implements ICrud{

    // FIELDS
    private static FacadeCrud instance;
    private static DB db = MongoConnection.getDB();
    private static DBCollection collection;
    //JacksonDBCollection<T, String> coll;

    // SINGLETON
    public static FacadeCrud getInstance(String string) {
        collection = db.getCollection(string);
        if (instance == null)
            instance = new FacadeCrud();
        return instance;
    }

    // METHODS


    // OVERRIDEN METHODS
    @Override
    public List<T> findAll() {

        DBCursor cursor = collection.find();
        List<T> aux = new ArrayList<>();
        while (cursor.hasNext()){
            aux.add((T) cursor.next());
        }
        return aux;

    }

    @Override
    public Object find(Object id) {
        DBObject ref = new BasicDBObject("id",id);
        return collection.findOne(ref);
    }

    @Override
    public Object delete(Object id) {
        DBObject ref = new BasicDBObject("id",id);
        WriteResult result = collection.remove(ref);
        return result.getUpsertedId();

    }

    @Override
    public Object create(BasicDBObject query) {
        WriteResult result = collection.insert(query);
        return result.getUpsertedId();
    }
}
