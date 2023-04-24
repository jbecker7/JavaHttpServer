# Simple HTTP 1.1 Server

This is a simple HTTP 1.1 server that serves a static web page. It is written in Java and uses the following dependencies, managed by Maven:

- Jackson Core: a JSON parser and generator for Java
- Jackson Databind: a library for binding JSON data to Java objects (using Jackson Core)
- SLF4J API: a logging facade for various logging frameworks, allowing for simple configuration and switching between implementations
- Logback Classic: a logging framework compatible with SLF4J, featuring fast and flexible configuration options
- JUnit Jupiter: a unit testing framework for Java, featuring new features and extensions over the previous JUnit versions.

## Usage

1. Clone the repository or download the files to your local machine.
2. Navigate to the httpserver directory containing the files.
3. Open a terminal or command prompt in the directory.
4. Compile the Java file `HttpServer.java` by running the following command:

   ```javac HttpServer.java```

5. Run the server by executing the following command:

  ```java HttpServer```

6. Open a web browser and navigate to `http://localhost:8080`.
7. You should see the static web page served by the server.

## Customization

If you want to serve a different web page, modify the ```html``` variable found on ```core/HTTPConnectionWorkerThread.java``` with your desired web page.

## Room for Improvement

Right now, my program can handle multiple threads and serve a simple static webpage, but it cannot do a lot of the awesome things specified as part of HTTP 1.1. In the future, it would be great to incorporate some of the following:

- Dealing with status codes and message structure
- Creating more tests
- Dealing with different versions of HTTP
- Parsing the request line

## Recommended Reading

While working on this project, I found it useful to consult the following RFCs from the Internet Engineering Task Force.
- [RFC 7230](https://datatracker.ietf.org/doc/html/rfc7230)
- [RFC 7231](https://datatracker.ietf.org/doc/html/rfc7231)
- [RFC 7232](https://datatracker.ietf.org/doc/html/rfc7232)


## Disclaimer

This is a simple server intended for testing and educational purposes only. It is not suitable for production use.
