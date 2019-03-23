package reading.dsAndAlgos.howTomcatWorks.ch01;

import java.io.IOException;
import java.io.InputStream;

/**
 * created by ran
 */
public class Request {
    private InputStream input;
    private String uri;

    public Request(InputStream input) {
        this.input = input;
    }

    public void parse() {
        // trans byte stream to str format
        StringBuilder sb = new StringBuilder(2048);
        byte[] buffer = new byte[2048];
        int i;

        try {
            i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }

        for (int j = 0; j < i; j++) {
            sb.append((char) buffer[j]);
        }

        System.out.println("requestString: " + sb);
        uri = parseUri(sb.toString());
    }

    private String parseUri(String requestString) {
        int index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            int index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 != -1) {
                return requestString.substring(index1 + 1, index2);
            }
        }
        return null;
    }

    public String getUri() {
        return uri;
    }
}
