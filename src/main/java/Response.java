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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
