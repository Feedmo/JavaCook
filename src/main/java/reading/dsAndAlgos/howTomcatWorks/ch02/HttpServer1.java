package reading.dsAndAlgos.howTomcatWorks.ch02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * created by ran
 */
public class HttpServer1 {
    public static final String WEB_ROOT = System.getProperty("user.dir") + "/target/classes/webroot";
    private static final String SHUTDOWN = "/shutdown";
    private boolean shutdown = false;


    public static void main(String[] args) {
        HttpServer1 server = new HttpServer1();
        server.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        while (!shutdown) {
            try {
                Socket socket = serverSocket.accept();
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                Request request = new Request(in);
                request.parse();

                Response response = new Response(out);
                response.setRequest(request);

                if (request.getUri().startsWith("/servlet/")) {

                } else {
                    StaticResourceProcessor processor = new StaticResourceProcessor();
                    processor.process(request, response);
                }

                socket.close();
                shutdown = request.getUri().equals(SHUTDOWN);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
