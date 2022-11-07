package org.example.client;

import org.example.server_client.ClientMessage;
import org.example.server_client.QueryType;
import org.example.server_client.ServerClientCommunicator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.Socket;

public class QueryManager {
    private Socket socket;
    public QueryManager(Socket socket){
        this.socket=socket;
    }
    public void createDatabase(String databaseName){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.CREATE_DATABASE.toString());
            jsonObject.put("databaseName",databaseName);
            ServerClientCommunicator.sendObject(socket,jsonObject);
            ClientMessage message= (ClientMessage) ServerClientCommunicator.readObj(socket);
            if(message.getCodeNumber()==1){
                throw new RuntimeException(message.getErrorMessage());
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteDatabase(String databaseName){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.DELETE_DATABASE.toString());
            jsonObject.put("databaseName",databaseName);
            ServerClientCommunicator.sendObject(socket,jsonObject);
            ClientMessage message= (ClientMessage) ServerClientCommunicator.readObj(socket);
            if(message.getCodeNumber()==1){
                throw new RuntimeException(message.getErrorMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void createCollection(String databaseName,String collectionName,JSONObject schema){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.CREATE_COLLECTION.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            jsonObject.put("schema",schema);
            ServerClientCommunicator.sendObject(socket,jsonObject);
            ClientMessage message= (ClientMessage) ServerClientCommunicator.readObj(socket);
            if(message.getCodeNumber()==1){
                throw new RuntimeException(message.getErrorMessage());
            }
        } catch (Exception e) {
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
            ClientMessage message= (ClientMessage) ServerClientCommunicator.readObj(socket);
            if(message.getCodeNumber()==1){
                throw new RuntimeException(message.getErrorMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void createDocument(String databaseName,String collectionName,JSONObject document){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.CREATE_DOCUMENT.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            jsonObject.put("document",document);
            ServerClientCommunicator.sendObject(socket,jsonObject);
            ClientMessage message= (ClientMessage) ServerClientCommunicator.readObj(socket);

            if(message.getCodeNumber()==1){
                throw new RuntimeException(message.getErrorMessage());
            }
        } catch (Exception e) {
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
            ClientMessage message= (ClientMessage) ServerClientCommunicator.readObj(socket);
            if(message.getCodeNumber()==1){
                throw new RuntimeException(message.getErrorMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void createIndex(String databaseName,String collectionName,JSONObject indexProperty){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.CREATE_INDEX.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            jsonObject.put("indexProperty",indexProperty);
            ServerClientCommunicator.sendObject(socket,jsonObject);
            ClientMessage message= (ClientMessage) ServerClientCommunicator.readObj(socket);
            if(message.getCodeNumber()==1){
                throw new RuntimeException(message.getErrorMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public JSONArray find(String databaseName, String collectionName, JSONObject searchObject){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.FIND.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            jsonObject.put("searchObject",searchObject);
            ServerClientCommunicator.sendObject(socket,jsonObject);
            ClientMessage message= (ClientMessage) ServerClientCommunicator.readObj(socket);
            if(message.getCodeNumber()==1){
                throw new RuntimeException(message.getErrorMessage());
            }
            return message.getDataArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public JSONArray findAll(String databaseName,String collectionName){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.FIND_ALL.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            ServerClientCommunicator.sendObject(socket,jsonObject);
            ClientMessage message= (ClientMessage) ServerClientCommunicator.readObj(socket);
            if(message.getCodeNumber()==1){
                throw new RuntimeException(message.getErrorMessage());
            }
            return message.getDataArray();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public JSONObject updateDocument(String databaseName,String collectionName,String documentId,JSONObject data){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("queryType",QueryType.UPDATE_DOCUMENT.toString());
            jsonObject.put("databaseName",databaseName);
            jsonObject.put("collectionName",collectionName);
            jsonObject.put("documentId",documentId);
            jsonObject.put("data",data);
            ServerClientCommunicator.sendObject(socket,jsonObject);
            ClientMessage message= (ClientMessage) ServerClientCommunicator.readObj(socket);
            if(message.getCodeNumber()==1){
                throw new RuntimeException(message.getErrorMessage());
            }
            return message.getData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
