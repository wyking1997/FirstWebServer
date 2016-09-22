/**
 * Created by Wyking on 9/22/2016.
 */
public class Request {

    //First line: 1->request type 2->file name 3->http version
    String fileName;

    public Request(String request){
        String lines[] = request.split("\n");
        fileName = lines[0].split(" ")[1];
    }
}

//Request:
//GET / HTTP/1.1
//Accept: text/html, application/xhtml+xml, image/jxr, */*
//        Accept-Language: en-US,en;q=0.8,ro-RO;q=0.5,ro;q=0.3
//        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393
//        Accept-Encoding: gzip, deflate
//        Host: localhost:6543
//        Connection: Keep-Alive

