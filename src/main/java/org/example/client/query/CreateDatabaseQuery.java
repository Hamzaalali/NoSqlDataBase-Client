package org.example.client.query;
import org.example.client.QueryManager;
import org.example.server_client.QueryType;
import org.example.server_client.ServerClientCommunicator;
import org.json.simple.JSONObject;
import java.net.Socket;
public class CreateDatabaseQuery extends DatabaseQuery {
    public CreateDatabaseQuery(QueryManager queryManager) {
        super(queryManager);
    }

    @Override
    public JSONObject execute(JSONObject query, Socket socket) {
        try{
            ServerClientCommunicator.sendJson(socket,query);
            JSONObject message= ServerClientCommunicator.readJson(socket);
            queryManager.handleMessage(message,query);
            return message;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
