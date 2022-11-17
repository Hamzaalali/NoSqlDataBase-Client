package org.example.json;

import org.json.simple.JSONObject;

public class JsonBuilder {
    private JSONObject jsonObject;
    private JsonBuilder(){
        jsonObject=new JSONObject();
    }

    public JsonBuilder add(String key,Object value){
        jsonObject.put(key,value);
        return this;
    }
    public JSONObject build(){
        return jsonObject;
    }
    public static JsonBuilder getBuilder(){
        JsonBuilder jsonBuilder=new JsonBuilder();
        return jsonBuilder;
    }
}
