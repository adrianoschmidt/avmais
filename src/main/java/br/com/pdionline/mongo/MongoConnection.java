package br.com.pdionline.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.util.Arrays;

public class MongoConnection {

    private static final MongoCredential credential = MongoCredential.createCredential("admin", "avmais", "3i3_Ui6Z1u4x".toCharArray());

    // Variáveis para saber se esta local ou em prod
    private static final String URL_MONGO = System.getenv("OPENSHIFT_MONGODB_DB_HOST") != null ?
            System.getenv("OPENSHIFT_MONGODB_DB_HOST") : "localhost";

    private static final String PORTA = System.getenv("OPENSHIFT_MONGODB_DB_PORT") != null ?
            System.getenv("OPENSHIFT_MONGODB_DB_PORT") : "27017";


    public static DB getDB(){

        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( new ServerAddress(URL_MONGO) , Arrays.asList(credential));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DB db = mongoClient.getDB( "avmais" );

        return db;
    }
}
