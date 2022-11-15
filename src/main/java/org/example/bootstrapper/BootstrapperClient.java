package org.example.bootstrapper;
import org.example.client.QueryManager;
import org.example.server_client.ServerClientCommunicator;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
public class BootstrapperClient {


    private Socket socket;
    public  BootstrapperClient(String hostUrl,int port){
        try{
            socket=new Socket(hostUrl,port);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void register(String username,String password){
        try{
            JSONObject request=new JSONObject();
            request.put("username",username);
            request.put("password",password);
            request.put("requestType",BootstrapperRequests.REGISTER.toString());
            ServerClientCommunicator.sendJson(socket,request);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
