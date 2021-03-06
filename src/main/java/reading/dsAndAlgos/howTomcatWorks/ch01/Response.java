package reading.dsAndAlgos.howTomcatWorks.ch01;

import java.io.*;

/**
 *
     HTTP Response = Status-Line
     *(( general-header | response-header | entity-header ) CRLF)
     CRLF
     [ message-body ]
     Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF

 * created by ran
 */
public class Response {
    private static final int BUFFER_SIZE = 1024;

    private OutputStream output;
    private Request request;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        File file = new File(HttpServer.WEB_ROOT, request.getUri());
        System.out.println("Output file path: " + file.getAbsolutePath());
        FileInputStream fis = null;

        // note 因为输入输出流有各自的实现，相互间不能直接传输，所以使用字节数组座位中间转换，nio可以改善这一点？？
        if (file.exists()) {
            fis = new FileInputStream(file);
            int ch = fis.read(bytes, 0, BUFFER_SIZE);
            while (ch != -1) {
                output.write(bytes, 0, ch);
                ch = fis.read(bytes, 0, BUFFER_SIZE);
            }
        } else {
            String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: 23\r\n" +
                    "\r\n" +
                    "<h1>File Not Found</h1>";
            output.write(errorMessage.getBytes());
        }
        if (fis != null) {
            fis.close();
        }
    }
}
