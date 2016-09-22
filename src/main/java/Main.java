import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Wyking on 9/21/2016.
 */
public class Main {

    ServerSocket serverSocket;

//    this is the entry point for the program
    public static void main(String[] arg) throws IOException {

        System.out.println("OK, let's go!");
        new Main().runServer();
    }

    public void runServer() throws IOException {
//       the ServerSocket creates a server on the specific port number
//       the server will run on the 6543 port number
        serverSocket = new ServerSocket(6543);
    }

    private void acceptRequests() throws IOException {
//        we have to accept all the requests
//        the connection is a socket whitch contain the input/output stream
        while (true){
            Socket s = serverSocket.accept();
        }
    }
}


/*
getting the request
procesing the request
pass the request to the reponse class
reponse generate the output witch goes back to the browser

The tutorial:
  part 1 ---> https://www.youtube.com/watch?v=WDoNm5Irf-4
*/
