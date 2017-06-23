package com.ivan.mongo.db;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.Test;

/**
 * Created by feiFan.gou on 2017/5/17 20:21.
 */
public class Insert extends Connection {

    @Test
    public void simpleInsert() {

        Document document = new Document();
        document.put("name", "Jim");
        document.put("age", 12);
        MongoCollection<Document> collection = database.getCollection(DEFAULT_COLLECTION);
        collection.insertOne(document);
    }
}
