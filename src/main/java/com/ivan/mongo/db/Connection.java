package com.ivan.mongo.db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by feiFan.gou on 2017/5/17 20:20.
 */
public class Connection {

    private static String HOST = "localhost";

    private static Integer PORT = 27017;

    static MongoDatabase database;

    private static MongoClient client;

    private static String DEFAULT_DATABASE = "first_mongo";

    static String DEFAULT_COLLECTION = "first_mongo";

    static {

        client = new MongoClient(HOST, PORT);
        database = client.getDatabase(DEFAULT_DATABASE);
    }

    public void useDataBase(String databaseName) {

        if (null == databaseName) {
            database = client.getDatabase(databaseName);
        } else {
            database = client.getDatabase(DEFAULT_DATABASE);
        }
    }
}
