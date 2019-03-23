package reading.dsAndAlgos.howTomcatWorks.ch01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接收请求，后续工作委托给request和response实例完成
 * created by ran
 */
public class HttpServer {
    public static final String WEB_ROOT = System.getProperty("user.dir") + "/target/classes/webroot";

    private static final String SHUT_DOWN = "/shutdown";
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
            Socket socket;
            InputStream input;
            OutputStream output;

            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                Request request = new Request(input);
                request.parse();

                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();

                socket.close();

                // check shutdown value base on request url
                shutdown = SHUT_DOWN.equals(request.getUri());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
