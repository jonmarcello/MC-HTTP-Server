# MC-Test-Server
Host a HTTP Server within your Spigot Plugin

## Description
This is a super simple example of hosting a HTTP Server within your Spitgot plugin.
From here you could be able to send remote commands via HTTP and have something custom happen on the server.

## Example
```java
public static void start() throws IOException {
    // setup listen port
    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

    // setup route
    server.createContext("/test", new MyHandler());

    // creates a default executor
    server.setExecutor(null);

    // start
    server.start();
}
```

```java
static class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) {
        // do something, like send a message
        SendMessage("Test");
    }
}
```

See `com.sun.net.httpserver` for more https://docs.oracle.com/javase/8/docs/jre/api/net/httpserver/spec/com/sun/net/httpserver/HttpServer.html
