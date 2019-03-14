package reading.dsAndAlgos.howTomcatWorks;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * created by ran
 */
public class HttpServer {
    // WEB_ROOT

    private static final String SHUT_DOWM = "/shutdown";
    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        int port = 9527;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!shutdown) {
            try {
                Socket socket = serverSocket.accept();
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                Request request = new Request(input);
                request.parse();

                Response response = new Response(output);
                response.setRequest(request);

                // socket.close(); //note 这里close有必要吗

                // check shutdown value base on request url
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
