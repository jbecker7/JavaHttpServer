package org.example.http;

import org.example.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;


public class HttpParser {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

    //This parser COULD be static, but we don't do that so that we remake it and configure for each
    public void parseHttpRequest(InputStream inputStream) {

    }
}
