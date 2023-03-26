package org.example.http;

import org.example.http.config.Configuration;
import org.example.http.config.ConfigurationManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CRL;

/*
Things we need to serve pages:
1. Handle TCP Connections to send pages
2. Understand HTTP protocol
*/

//This is the driver class for the HTTP server
public class HttpServer {

    public static void main(String[] args) {
        System.out.println("Server Starting!");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        System.out.println("Using Port:" + conf.getPort());
        System.out.println("Using WebRoot:" + conf.getWebroot());

        try {
            ServerSocket serverSocket = new ServerSocket(conf.getPort());
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            String html = "<html><head><title>Simple Java HTTP Server</title><body><h1>Yay! This page was served with my simple Java HTTP Server :)</h1></body></head> </html>";
            final String CRLF = "\r\n"; //13, 10 ASCII

            //Complies with 1.1 response format
            String response =
                    "HTTP/1.1 200 OK" + CRLF +  //Status Line: HTTP Version Resposnse_Code Response_Message
                    "Content-Length:" + html.getBytes().length + CRLF + // HEADER
                            CRLF +
                            html +
                            CRLF + CRLF ;

            outputStream.write(response.getBytes());
            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
