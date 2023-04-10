package org.example.httpserver.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpConnectionWorkerThread extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);
    private Socket socket;

    public HttpConnectionWorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            String html = "<html><head><title>Simple Java HTTP Server</title><body><h1>Yay! This page was served with my simple Java HTTP Server :)</h1></body></head> </html>";
            final String CRLF = "\r\n"; //13, 10 ASCII

            //Complies with 1.1 response format
            String response =
                    "HTTP/1.1 200 OK" + CRLF +  //Status Line: HTTP Version Resposnse_Code Response_Message
                            "Content-Length:" + html.getBytes().length + CRLF + // HEADER
                            CRLF +
                            html +
                            CRLF + CRLF;
            outputStream.write(response.getBytes());


            LOGGER.info(" * Connection Processing Finished");
        } catch (IOException e) {
            LOGGER.error("Problem with communication", e);
            e.printStackTrace();
            //Need to handle this later
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                }

            }

        }
    }
}
