package com.ivan.mongo.db;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.Test;

/**
 * Created by feiFan.gou on 2017/5/17 20:22.
 */
public class Find extends Connection {


    @Test
    public void simpleFind() {

        MongoCollection<Document> collection = database.getCollection(DEFAULT_COLLECTION);

        FindIterable<Document> iterable = collection.find();
        for (Document document : iterable) {
            System.out.println(document.get("_id"));
        }

    }
}
