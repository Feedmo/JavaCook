package reading.dsAndAlgos.howTomcatWorks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            String requestString = sb.toString();
            System.out.println(requestString);

            uri = parseUri(requestString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String parseUri(String requestString) {
        int index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            int index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 != -1) {
                return requestString.substring(index1 + 1, index2);
            }
        }
        return null;
    }
}
