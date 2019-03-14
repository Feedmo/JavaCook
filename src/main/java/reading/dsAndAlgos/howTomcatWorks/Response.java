package reading.dsAndAlgos.howTomcatWorks;

import java.io.OutputStream;

/**
 * created by ran
 */
public class Response {
    private OutputStream output;
    private Request request;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
