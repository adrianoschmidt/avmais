package br.com.pdionline.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class MongoConnection {

    private static final String URL_MONGO_OPENSHIFT = "mongodb://$OPENSHIFT_MONGODB_DB_HOST:$OPENSHIFT_MONGODB_DB_PORT/ ";
    private static final String URL_MONGO = System.getenv("OPENSHIFT_WILDFLY_DIR") != null ?  URL_MONGO_OPENSHIFT : "localhost";
    private static final String PORTA =  System.getenv("OPENSHIFT_MONGODB_DB_PORT");

    public static DB getDB(){

        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( URL_MONGO_OPENSHIFT , Integer.valueOf(PORTA));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DB db = mongoClient.getDB( "pdionline" );

        return db;
    }
}
