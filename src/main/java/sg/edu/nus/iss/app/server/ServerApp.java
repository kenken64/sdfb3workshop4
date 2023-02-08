package sg.edu.nus.iss.app.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp {
    public static void main(String[] args) throws IOException{
        int port =  3001;
        if(args.length > 0){
            port= Integer.parseInt(args[0]);
        }
        String cookieFile = args[1];
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ServerSocket server = new ServerSocket(port);
        System.out.printf("Cookie Server started %s", port);
        while(true){
            Socket sock = server.accept();
            CookieClientHandler cch = 
                new CookieClientHandler(sock, cookieFile);
            threadPool.submit(cch);
        }
    }
}
