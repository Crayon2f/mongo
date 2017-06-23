package com.ivan.mongo.db;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.List;

/**
 * Created by feiFan.gou on 2017/5/17 20:22.
 */
public class Update extends Connection {

    @Test
    public void simpleUpdate() {

        MongoCollection<Document> collection = database.getCollection(DEFAULT_COLLECTION);

        Bson filter = Filters.eq("_id", new ObjectId("591eae0675f5833248da2b6e"));
        BasicDBObject update = new BasicDBObject();
        update.append("name", "Tome");
//        Bson update = Filters.eq("name", "Tom");
        collection.updateOne(filter, new BasicDBObject("$set", update));

        FindIterable<Document> iterable = collection.find(filter);
//        MongoCursor<Document> cursor = iterable.iterator();
//        while (cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
        for (Document document : iterable) {
            System.out.println(document.get("name"));
        }

    }

    public void test() {

        FindIterable<Document> iterable = null;
//                collection.find(new Document("scores.type", "homework")).sort(Sorts.orderBy(Sorts.ascending("_id")));

        MongoCursor<Document> iterableDocument = iterable.iterator();

        while (iterableDocument.hasNext()) {
            Document wholeDocument = iterableDocument.next();
            List<Document> scores = (List<Document>) wholeDocument.get("scores");

            System.out.println("Student id: " + wholeDocument.get("_id"));
            System.out.println("Student name: " + wholeDocument.get("name"));

            for (final Document score1 : scores) {
//                for (final Document score2 : scores) {
//                    if (score1.get("type").toString().equalsIgnoreCase("homework") && score2.get("type").toString().equalsIgnoreCase("homework")) {
//
//                        Double homeworkScore1 = (Double) score1.get("score");
//                        Double homeworkScore2 = (Double) score2.get("score");
//
//                        if (homeworkScore1 < homeworkScore2) {
//                            BasicDBList homeworkScores = new BasicDBList();
//                            homeworkScores.add(new BasicDBObject("type", "homework").append("score", homeworkScore1));
//                            BasicDBObject lowScoreToRemove = new BasicDBObject("scores", homeworkScores);
//
//                            System.out.println("Lowest Homework score is: " + homeworkScore1);
//                            System.out.println("Document that will be updated: " + wholeDocument);
//                            System.out.println("Pull Document: " + new Document("$pull", lowScoreToRemove));
//                            UpdateResult result = collection.updateOne(new Document("_id", wholeDocument.get("_id")), new BasicDBObject("$pull",
//                                    lowScoreToRemove));
//                            System.out.println("UpdateResult: " + result + "\n");
//                        }
//                    }
//                }
            }
        }
        iterableDocument.close();
    }
}
