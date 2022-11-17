package org.example;
import org.example.bootstrapper.BootstrapperClient;
import org.example.client.NoSQlClient;
import org.example.client.QueryManager;
import org.example.server_client.DocumentDataTypes;
import org.json.simple.JSONObject;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NoSQlClient noSQlClient=new NoSQlClient();
        noSQlClient.connect("localhost",3001);
        QueryManager queryManager=noSQlClient.getQueryManager();
        queryManager.login("admin","admin");
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
        agentSchema.put("firstName",DocumentDataTypes.STRING.toString());
        agentSchema.put("credit",DocumentDataTypes.LONG.toString());
        agentSchema.put("isMarried",DocumentDataTypes.BOOLEAN.toString());
        agentSchema.put("salary",DocumentDataTypes.DOUBLE.toString());
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
        agent.put("firstName","hamza");
        agent.put("isMarried",false);
        agent.put("salary",55.5);
        queryManager.createDocument("bank","agent",agent);

        Thread.sleep(3000);
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
        agent.put("firstName","hamza");
        agent.put("isMarried",true);
        agent.put("salary",55.0);
        queryManager.createDocument("bank","agent",agent);


//
//
//        agent=new JSONObject();
//        name=new JSONObject();
//        phones=new ArrayList<>();
//        phone=new JSONObject();
//        phone.put("number","0796992566");
//        phones.add(phone);
//        agent.put("phones",phones);
//        name.put("firstName","ahmad");
//        name.put("secondName","alali");
//        agent.put("name", name);
//        agent.put("credit",20);
//        agent.put("firstName","hamza");
//
//        queryManager.createDocument("bank","agent",agent);

        Thread.sleep(3000);

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
        agent.put("firstName","hamza");
        agent.put("isMarried",false);
        agent.put("salary",55.5);
        queryManager.createDocument("bank","agent",agent);



        JSONObject indexObject=new JSONObject();
        phones=new ArrayList<>();
        phone=new JSONObject();
        indexObject.put("salary","");
        queryManager.createIndex("bank","agent",indexObject);

//
//        JSONObject agent=new JSONObject();
//        JSONObject name=new JSONObject();
//        name.put("secondName","abuali");
//        agent.put("name", name);
//        agent.put("credit",100);
//        System.out.println(queryManager.updateDocument("bank","agent","9e992cad-866f-4312-9e1e-11fb24e3c1ab",agent));


        JSONObject searchObject=new JSONObject();
        name=new JSONObject();
//        name.put("credit",60);
        searchObject.put("salary",55.5);
        System.out.println(queryManager.find("bank","agent",searchObject));
        searchObject.put("salary",55.0);
        System.out.println(queryManager.find("bank","agent",searchObject));
        System.out.println(queryManager.findAll("bank","agent"));
    }
}