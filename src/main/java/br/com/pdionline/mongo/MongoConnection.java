package br.com.pdionline.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class MongoConnection {

    // Variáveis para saber se esta local ou em prod
    private static final String URL_MONGO = System.getenv("OPENSHIFT_WILDFLY_DIR") != null ?
            System.getenv("OPENSHIFT_WILDFLY_DIR") : "localhost";

    private static final String PORTA = System.getenv("OPENSHIFT_MONGODB_DB_PORT") != null ?
            System.getenv("OPENSHIFT_MONGODB_DB_PORT") : "27017";

    public static DB getDB(){

        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( URL_MONGO , Integer.valueOf(PORTA));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DB db = mongoClient.getDB( "pdionline" );

        return db;
    }
}
