package org.example;
import org.example.client.NoSQlClient;
import org.example.client.QueryManager;
import org.example.json.JsonArrayBuilder;
import org.example.json.JsonBuilder;
import org.example.server_client.DataTypes;
import org.json.simple.JSONObject;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        NoSQlClient noSQlClient=new NoSQlClient();
        noSQlClient.connect("localhost",3001);
        QueryManager queryManager=noSQlClient.getQueryManager();
        queryManager.login("admin","admin");
        queryManager.createDatabase("bank");

        JSONObject agentSchema= JsonBuilder.getBuilder()
                .add("name",JsonBuilder.getBuilder()
                        .add("firstName", DataTypes.STRING)
                        .add("secondName",DataTypes.STRING)
                        .build())
                .add("phoneNumbers", JsonArrayBuilder.getBuilder()
                        .add(JsonBuilder.getBuilder()
                                .add("phoneNumber",DataTypes.STRING)
                                .build())
                        .build())
                .add("isMarried",DataTypes.BOOLEAN)
                .add("salary",DataTypes.DOUBLE)
                .add("credit",DataTypes.LONG)
                .build();
        queryManager.createCollection("bank","agent",agentSchema);


        JSONObject agent= JsonBuilder.getBuilder()
                .add("name",JsonBuilder.getBuilder()
                        .add("firstName","ahmad")
                        .add("secondName","alali")
                        .build())
                .add("phoneNumbers", JsonArrayBuilder.getBuilder()
                        .add(JsonBuilder.getBuilder()
                                .add("phoneNumber","0796992522")
                                .build())
                        .add(JsonBuilder.getBuilder()
                                .add("phoneNumber","0790443286")
                                .build())
                        .build())
                .add("isMarried",true)
                .add("salary",55.5)
                .add("credit",100)
                .build();
        queryManager.createDocument("bank","agent",agent);

        Thread.sleep(3000);
        agent= JsonBuilder.getBuilder()
                .add("name",JsonBuilder.getBuilder()
                        .add("firstName","hamza")
                        .add("secondName","alali")
                        .build())
                .add("phoneNumbers", JsonArrayBuilder.getBuilder()
                        .add(JsonBuilder.getBuilder()
                                .add("phoneNumber","0795522446")
                                .build())
                        .add(JsonBuilder.getBuilder()
                                .add("phoneNumber","0790443286")
                                .build())
                        .build())
                .add("isMarried",false)
                .add("salary",55.5)
                .add("credit",50)
                .build();
        queryManager.createDocument("bank","agent",agent);


        agent= JsonBuilder.getBuilder()
                .add("name",JsonBuilder.getBuilder()
                        .add("firstName","omar")
                        .add("secondName","abuali")
                        .build())
                .add("phoneNumbers", JsonArrayBuilder.getBuilder()
                        .add(JsonBuilder.getBuilder()
                                .add("phoneNumber","0796355383")
                                .build())
                        .add(JsonBuilder.getBuilder()
                                .add("phoneNumber","0790443286")
                                .build())
                        .build())
                .add("isMarried",true)
                .add("salary",55.0)
                .add("credit",50)
                .build();
        queryManager.createDocument("bank","agent",agent);

        Thread.sleep(3000);


        agent= JsonBuilder.getBuilder()
                .add("name",JsonBuilder.getBuilder()
                        .add("firstName","khalid")
                        .add("secondName","abuali")
                        .build())
                .add("phoneNumbers", JsonArrayBuilder.getBuilder()
                        .add(JsonBuilder.getBuilder()
                                .add("phoneNumber","0796355383")
                                .build())
                        .add(JsonBuilder.getBuilder()
                                .add("phoneNumber","0796992522")
                                .build())
                        .build())
                .add("isMarried",false)
                .add("salary",55.0)
                .add("credit",100)
                .build();
        queryManager.createDocument("bank","agent",agent);



        JSONObject indexObject=JsonBuilder.getBuilder()
                .add("salary","")
                .build();
        queryManager.createIndex("bank","agent",indexObject);

//
//        JSONObject agent=new JSONObject();
//        JSONObject name=new JSONObject();
//        name.put("secondName","abuali");
//        agent.put("name", name);
//        agent.put("credit",100);
//        System.out.println(queryManager.updateDocument("bank","agent","9e992cad-866f-4312-9e1e-11fb24e3c1ab",agent));


        JSONObject searchObject=JsonBuilder.getBuilder()
                .add("salary",55.5)
                .build();
        System.out.println(queryManager.find("bank","agent",searchObject));
        searchObject=JsonBuilder.getBuilder()
                .add("salary",55.0)
                .build();
        System.out.println(queryManager.find("bank","agent",searchObject));
        System.out.println(queryManager.findAll("bank","agent"));
    }
}