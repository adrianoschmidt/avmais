package br.com.pdionline.facade;

import br.com.pdionline.mongo.MongoConnection;
import com.mongodb.DB;
import com.mongodb.DBCollection;

import java.util.List;

/**
 * Created by supero on 09/12/2014.
 */
public class FacadeCrud implements ICrud{

    private DB db = MongoConnection.getDB();
    DBCollection col = db.getCollection("post");

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object find(Object id) {
        return null;
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }

    @Override
    public Object create(Object T) {
        return null;
    }
}
