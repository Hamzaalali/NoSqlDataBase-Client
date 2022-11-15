package org.example.client.query;
import org.example.client.QueryManager;
import org.example.server_client.QueryType;
import org.example.server_client.ServerClientCommunicator;
import org.json.simple.JSONObject;

import java.net.Socket;
import java.util.Optional;

public class DeleteDatabaseQuery extends DatabaseQuery{
    public DeleteDatabaseQuery(QueryManager queryManager) {
        super(queryManager);
    }

    @Override
    public JSONObject execute(JSONObject query, Socket socket) {
        try{
            ServerClientCommunicator.sendJson(socket,query);
            JSONObject messageFromServer= ServerClientCommunicator.readJson(socket);
            queryManager.handleMessage(messageFromServer,query);
            return messageFromServer;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
