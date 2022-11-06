package org.example.client;

import org.example.server_client.QueryType;
import org.example.server_client.ServerClientCommunicator;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.Socket;

public class QueryManager {
    private Socket socket;
    public QueryManager(Socket socket){
        this.socket=socket;
    }
    public JSONObject createDatabase(String databaseName){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.CREATE_DATABASE.toString());
            jsonObject.put("databaseName",databaseName);
            ServerClientCommunicator.sendObject(socket,jsonObject);
//            JSONObject message= (JSONObject)ServerClientCommunicator.readObj(socket);
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteDatabase(String databaseName){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.DELETE_DATABASE.toString());
            jsonObject.put("databaseName",databaseName);
            ServerClientCommunicator.sendObject(socket,jsonObject);
//            JSONObject message= (JSONObject)ServerClientCommunicator.readObj(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public JSONObject createCollection(String databaseName,String collectionName,JSONObject schema){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.CREATE_COLLECTION.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            jsonObject.put("schema",schema);
            ServerClientCommunicator.sendObject(socket,jsonObject);
//            JSONObject message= (JSONObject)ServerClientCommunicator.readObj(socket);
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteCollection(String databaseName,String collectionName){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.DELETE_COLLECTION.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            ServerClientCommunicator.sendObject(socket,jsonObject);
//            JSONObject message= (JSONObject)ServerClientCommunicator.readObj(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public JSONObject createDocument(String databaseName,String collectionName,JSONObject document){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.CREATE_DOCUMENT.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            jsonObject.put("document",document);
            ServerClientCommunicator.sendObject(socket,jsonObject);
//            JSONObject message= (JSONObject)ServerClientCommunicator.readObj(socket);
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteDocument(String databaseName,String collectionName,String documentId){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.DELETE_DOCUMENT.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            jsonObject.put("documentId",documentId);
            ServerClientCommunicator.sendObject(socket,jsonObject);
//            JSONObject message= (JSONObject)ServerClientCommunicator.readObj(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public JSONObject createIndex(String databaseName,String collectionName,JSONObject indexProperty){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.CREATE_INDEX.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            jsonObject.put("indexProperty",indexProperty);
            ServerClientCommunicator.sendObject(socket,jsonObject);
//            JSONObject message= (JSONObject)ServerClientCommunicator.readObj(socket);
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public JSONObject find(String databaseName,String collectionName,JSONObject searchObject){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.FIND.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            jsonObject.put("searchObject",searchObject);
            ServerClientCommunicator.sendObject(socket,jsonObject);
//            JSONObject message= (JSONObject)ServerClientCommunicator.readObj(socket);
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public JSONObject findAll(String databaseName,String collectionName){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.FIND_ALL.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            ServerClientCommunicator.sendObject(socket,jsonObject);
//            JSONObject message= (JSONObject)ServerClientCommunicator.readObj(socket);
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
