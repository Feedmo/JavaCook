package reading.dsAndAlgos.howTomcatWorks.ch02;

import java.io.IOException;

/**
 * created by ran
 */
public class StaticResourceProcessor {
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
