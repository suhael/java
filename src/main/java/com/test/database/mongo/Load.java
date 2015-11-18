package com.test.database.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import com.mongodb.MongoClient;

/**
 * Created by sakhtar on 25/06/2015.
 */
public class Load {

    final MongoClient client;
    final MongoCollection<Document> collection;

    public Load(){
        client = new MongoClient("localhost", 27017);
        collection = client.getDatabase("netdespatch").getCollection("consignment");
    }

    public void projection(){
        String uniqueRef = "37753z343210";
        MongoCursor<Document> documents = collection.find(Filters.eq("consignment.zNumber", uniqueRef))
                //.projection(Projections.include("consignment.deliveryVendor.vendorIntegrations"))
                .iterator();

        if(documents.hasNext()){
            System.out.println("found");
            System.out.println(documents.next().toJson());
        } else {
            System.out.println("not found");
        }
    }

    public void load(){
        String uniqueRef = "123z456";
        MongoCursor<Document> documents = collection.find(Filters.eq("consignment.zNumber", uniqueRef)).iterator();

        if(documents.hasNext()){
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }

    public static void main(String[] args) {

        Load load = new Load();
        load.projection();



    }
}
