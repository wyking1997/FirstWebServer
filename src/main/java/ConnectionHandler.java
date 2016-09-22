import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Wyking on 9/22/2016.
 */

//This class handles all the requests
public class ConnectionHandler extends Thread {

    Socket s;
    PrintWriter pw;                 //sending the output
    BufferedReader br;              //getting the input

    public ConnectionHandler(Socket s) throws Exception {
        this.s = s;
        this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        this.pw = new PrintWriter(s.getOutputStream());
    }

//    when the thread is started this is called automatically
//    here we read the request and give the response
    @Override
    public void run(){
        try {
            String reqS = "";

            //from br we have to read out request
            while (br.ready())
                reqS += (char) br.read();
            System.out.println(reqS);

            Request req = new Request(reqS);
            Response res = new Response(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
