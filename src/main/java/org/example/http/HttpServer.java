package org.example.http;

import org.example.http.config.Configuration;
import org.example.http.config.ConfigurationManager;
import org.example.http.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

/*
Things we need to serve pages:
1. Handle TCP Connections to send pages
2. Understand HTTP protocol
*/

//This is the driver class for the HTTP server
public class HttpServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);


    public static void main(String[] args) {
        LOGGER.info("Server Starting!");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        LOGGER.info("Using Port:" + conf.getPort());
        LOGGER.info("Using WebRoot:" + conf.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();

            //Still need to handle this catch
        }


    }

}
