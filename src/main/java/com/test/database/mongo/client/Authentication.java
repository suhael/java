package com.test.database.mongo.client;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sakhtar on 02/07/2015.
 */
public class Authentication {
//    mongo:
//    host: ukndchvm-dev-mongo01.dev.nd.lnet
//    port: 27017
//    username: devteam
//    password: d3vt3@m
//    database: velocity
//    collection: consignments

    public static void main(String[] args) {

        ServerAddress serverAddress = new ServerAddress("ukndchvm-iqa-mongo01.iqa.nd.lnet", 27017);
        MongoCredential credential = MongoCredential.createCredential("devteam", "velocity",new char[]{'d','3','v','t','3','@','m'});

        MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));

        MongoDatabase database = mongoClient.getDatabase("velocity");
        MongoCollection<Document> collection = database.getCollection("consignments");

        MongoCursor<Document> documents = collection.find(Filters.eq("consignment.zNumber", "77878z414049"))
                .iterator();

        if(documents.hasNext()){
            System.out.println(documents.next().toJson());
        } else {
            System.out.println("not found");
        }



    }

}
