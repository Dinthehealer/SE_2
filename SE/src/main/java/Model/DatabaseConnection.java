package Model;


import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class DatabaseConnection {
    MongoClient mongoClient = new MongoClient();
    MongoDatabase db= mongoClient.getDatabase("local");
    MongoCollection<Document> collection=  db.getCollection("Account");
    Document doc;
    public boolean findRow(String id,String pass){
        try (MongoCursor<Document> cur = collection.find().iterator()) {
            while (cur.hasNext()) {
                var doc = cur.next();
                var acc = new ArrayList<>(doc.values());
                if(id.equals(acc.get(1).toString())&&pass.equals(acc.get(2).toString())){
                    mongoClient.close();
                    return true;
                }
            }
        }
        return false;
    }
    public boolean findID(String id){
        System.out.println("tranfermodel id:"+id);
        try (MongoCursor<Document> cur = collection.find().iterator()) {
            while (cur.hasNext()) {
                var doc = cur.next();
                var acc = new ArrayList<>(doc.values());
                if(id.equals(acc.get(1).toString())){
                    mongoClient.close();
                    return true;
                }
            }
        }
        return false;
    }
    public String[] findRow(String id) {
        String [] Data=new String[5];
        collection=  db.getCollection("AccountData");
        try (MongoCursor<Document> cur = collection.find().iterator()) {
            while (cur.hasNext()) {
                var doc = cur.next();
                var acc = new ArrayList<>(doc.values());
                if(id.equals(acc.get(1).toString())){
                    Data[1]=acc.get(1).toString();
                    Data[2]=acc.get(2).toString();
                    Data[3]=acc.get(3).toString();
                    Data[4]=acc.get(4).toString();
                }
            }
        }
        return Data;
    }



//Insert MongoDB
//    public void dbInsert(){
//        collection=  db.getCollection("AccountData");
//        doc=new Document();
//        doc.put("UId",1994518492);
//        doc.put("Uname","Supawich");
//        doc.put("ULastname","Unsan");
//        doc.put("Balance",0);
//        collection.insertOne(doc);
//    }
        public void dbUpdate(int id,double money){
        collection=  db.getCollection("AccountData");
        Bson filter= eq("UId", id);
        Bson update = set("Balance", money);
        collection.updateOne(filter,update);
    }



}
