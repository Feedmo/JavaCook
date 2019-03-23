package reading.dsAndAlgos.howTomcatWorks.ch02;

import reading.dsAndAlgos.howTomcatWorks.ch01.HttpServer;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

/**
 * created by ran
 */
public class Response implements ServletResponse {
    private OutputStream out;
    private Request request;
    private int BUFFER_SIZE = 1024;

    public Response(OutputStream out) {
        this.out = out;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        File file = new File(HttpServer1.WEB_ROOT, request.getUri());
        System.out.println("Output file path: " + file.getAbsolutePath());
        FileInputStream fis = null;

        // note 因为输入输出流有各自的实现，相互间不能直接传输，所以使用字节数组座位中间转换，nio可以改善这一点？？
        if (file.exists()) {
            fis = new FileInputStream(file);
            int ch = fis.read(bytes, 0, BUFFER_SIZE);
            while (ch != -1) {
                out.write(bytes, 0, ch);
                ch = fis.read(bytes, 0, BUFFER_SIZE);
            }
        } else {
            String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: 23\r\n" +
                    "\r\n" +
                    "<h1>File Not Found</h1>";
            out.write(errorMessage.getBytes());
        }
        if (fis != null) {
            fis.close();
        }
    }

    public String getCharacterEncoding() {
        return null;
    }

    public String getContentType() {
        return null;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    public PrintWriter getWriter() throws IOException {
        return null;
    }

    public void setCharacterEncoding(String s) {

    }

    public void setContentLength(int i) {

    }

    public void setContentType(String s) {

    }

    public void setBufferSize(int i) {

    }

    public int getBufferSize() {
        return 0;
    }

    public void flushBuffer() throws IOException {

    }

    public void resetBuffer() {

    }

    public boolean isCommitted() {
        return false;
    }

    public void reset() {

    }

    public void setLocale(Locale locale) {

    }

    public Locale getLocale() {
        return null;
    }
}
