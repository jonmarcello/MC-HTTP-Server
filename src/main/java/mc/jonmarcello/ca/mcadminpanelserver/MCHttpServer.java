package mc.jonmarcello.ca.mcadminpanelserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class MCHttpServer {
    static HttpServer server;

    public static void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public static void stop() {
        server.stop(0);
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "This is the response";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();

            SendMessage("Test");
        }
    }

    private static void SendMessage(String msg) {
        MCAdminPanelServer.getPlugin(MCAdminPanelServer.class).getServer().broadcastMessage(msg);
    }
}
