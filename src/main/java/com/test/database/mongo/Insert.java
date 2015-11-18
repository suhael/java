package com.test.database.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by sakhtar on 25/06/2015.
 */
public class Insert {

    public static void main(String[] args) {
        Mongo mongo = new Mongo("localhost", 27017);
        DB db = mongo.getDB("netdespatch");

        DBCollection collection = db.getCollection("consignment");

        try {
            String content = FileUtils.readFileToString(new File("C:\\projects\\learning\\javaTestScripts\\src\\main\\java\\com\\test\\database\\mongo\\consignment.json"));
            DBObject dbObject = (DBObject) JSON.parse(content);
            collection.insert(dbObject);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
