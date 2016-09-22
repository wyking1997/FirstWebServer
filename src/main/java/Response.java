import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Wyking on 9/22/2016.
 */
public class Response {

    Request req;

//    final generated response
    String response;

//    root path of the srtver
    String root = "E:/Documents//Java//First Web Server/root";

    public Response(Request request){
        req = request;
        //now we have to open the file mentioned in the request
        File f = new File(root + req.fileName);


        try {
//            read this file
            FileInputStream fis = new FileInputStream(f);

//            HTTP/1.0 200 Document follows
//            MIME-Version: 1.0
//            Server: CERN/3.0
//            Date: Sunday, 10-Nov-96 06:54:46 GMT
//            Content-Type: text/html
//            Content-Length: 4531
//            Last-Modified: Wednesday, 16-Oct-96 10:14:01 GMT

            //http version + status code (200 meas everything is ok)
            response = "HTTP/1.1 200\r\n";

            response += "Server : Our Java Server/1.0 \r\n";
            response += "Content-Type: text/html \r\n";
            response += "Content-Length: " + f.length() + "\r\n";
            response += "\r\n";

            //after the blank line we have to append file data
            int s;
            while ((s = fis.read()) != -1){
                response += (char) s;
            }
        } catch (FileNotFoundException e) {
            //if we do not get file the we want to have error 404
            response = response.replace("200", "404");
        } catch (Exception e){
            //else we want 500
            response = response.replace("200", "500");
        }
    }
}
