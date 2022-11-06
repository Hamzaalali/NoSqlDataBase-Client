package org.example;

import org.example.client.NoSQlClient;
import org.example.client.QueryManager;
import org.example.server_client.DocumentDataTypes;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NoSQlClient noSQlClient=new NoSQlClient();
        noSQlClient.connect("localhost",8085);
        QueryManager queryManager=noSQlClient.getQueryManager();

        queryManager.createDatabase("bank");

        JSONObject agentSchema=new JSONObject();
        List<JSONObject>phones=new ArrayList<>();
        JSONObject phone=new JSONObject();
        phone.put("number",DocumentDataTypes.STRING.toString());
        phones.add(phone);
        agentSchema.put("phones",phones);
        JSONObject name=new JSONObject();
        name.put("firstName",DocumentDataTypes.STRING.toString());
        name.put("secondName",DocumentDataTypes.STRING.toString());
        agentSchema.put("name", name);
        agentSchema.put("credit",DocumentDataTypes.INTEGER.toString());
        queryManager.createCollection("bank","agent",agentSchema);


        JSONObject agent=new JSONObject();
         name=new JSONObject();
        phones=new ArrayList<>();
        phone=new JSONObject();
        phone.put("number","0796992566");
        phones.add(phone);
        agent.put("phones",phones);
        name.put("firstName","ahmad");
        name.put("secondName","alali");
        agent.put("name",name);
        agent.put("credit",60);
        queryManager.createDocument("bank","agent",agent);


        agent=new JSONObject();
        name=new JSONObject();
        phones=new ArrayList<>();
        phone=new JSONObject();
        phone.put("number","0796992544");
        phones.add(phone);
        agent.put("phones",phones);
        name.put("firstName","omar");
        name.put("secondName","alali");
        agent.put("name", name);
        agent.put("credit",50);
        queryManager.createDocument("bank","agent",agent);



        JSONObject indexObject=new JSONObject();
        phones=new ArrayList<>();
        phone=new JSONObject();
        phone.put("number","0798355363");
        phones.add(phone);
        indexObject.put("phones",phones);
        queryManager.createIndex("bank","agent",indexObject);



        agent=new JSONObject();
        name=new JSONObject();
        phones=new ArrayList<>();
        phone=new JSONObject();
        phone.put("number","0796992566");
        phones.add(phone);
        agent.put("phones",phones);
        name.put("firstName","ahmad");
        name.put("secondName","alali");
        agent.put("name", name);
        agent.put("credit",20);
        queryManager.createDocument("bank","agent",agent);


        agent=new JSONObject();
        name=new JSONObject();
        phones=new ArrayList<>();
        phone=new JSONObject();
        phone.put("number","0790443286");
        phones.add(phone);

        agent.put("phones",phones);
        name.put("firstName","hamza");
        name.put("secondName","alali");
        agent.put("name", name);
        agent.put("credit",60);
        queryManager.createDocument("bank","agent",agent);

        JSONObject searchObject=new JSONObject();
        phones=new ArrayList<>();
        phone=new JSONObject();
        phone.put("number","0796992566");
        phones.add(phone);
        searchObject.put("phones",phones);
        queryManager.find("bank","agent",searchObject);

        queryManager.findAll("bank","agent");
    }
}