import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Wyking on 9/21/2016.
 */
public class Main {

    ServerSocket serverSocket;

//    this is the entry point for the program
    public static void main(String[] arg) throws Exception {

        System.out.println("OK, let's go!");
        new Main().runServer();
    }

    public void runServer() throws Exception {
//       the ServerSocket creates a server on the specific port number
//       the server will run on the 6543 port number
        serverSocket = new ServerSocket(6543);
        this.acceptRequests();
    }

    private void acceptRequests() throws Exception {
//        we have to accept all the requests
//        the connection is a socket whitch contain the input/output stream
        while (true){
            Socket s = serverSocket.accept();
            ConnectionHandler ch = new ConnectionHandler(s);

            //ch is a thread
            ch.start();
        }
    }
}


/*
getting the request
procesing the request
pass the request to the reponse class
reponse generate the output witch goes back to the browser

Tutorial:
  part1 ---> https://www.youtube.com/watch?v=WDoNm5Irf-4
  part2 ---> https://www.youtube.com/watch?v=fcWR6RnZbBg.
  part3 ---> https://www.youtube.com/watch?v=eXv5H2Y_hF4
  
*/

//Request:
//GET / HTTP/1.1
//Accept: text/html, application/xhtml+xml, image/jxr, */*
//        Accept-Language: en-US,en;q=0.8,ro-RO;q=0.5,ro;q=0.3
//        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393
//        Accept-Encoding: gzip, deflate
//        Host: localhost:6543
//        Connection: Keep-Alive


