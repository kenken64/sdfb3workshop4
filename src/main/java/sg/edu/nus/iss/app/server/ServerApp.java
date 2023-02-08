package sg.edu.nus.iss.app.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

class CookieClientHandler implements Runnable{
    private Socket sock;
    private String cookieFile;

    public CookieClientHandler(Socket s , String cookieFile){
        this.sock = s;
        this.cookieFile = cookieFile;
    }
    
    @Override
    public void run(){
        NetworkIO netIO = null;
        String req = "";
        String randomCookieResp = "";
        try{
            netIO = new NetworkIO(sock);
            while(true){
                req = netIO.read();
                if(req.trim().equals("end"))
                    break;

                if(req.trim().equals("get-cookie")){    
                    randomCookieResp = Cookie
                            .getRandomCookie(this.cookieFile);
                    netIO.write(randomCookieResp);
                    break;
                }else{
                    netIO.write("ERROR ! invalid command");
                }
            }
            netIO.close();
            sock.close();
            System.out.println("Exiting the thread ");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

class NetworkIO {
    private InputStream is;
    private DataInputStream dis;
    private OutputStream os;
    private DataOutputStream dos;
    

    public NetworkIO(Socket socket) throws IOException{
        is = socket.getInputStream();
        dis = new DataInputStream(is);
        os = socket.getOutputStream();
        dos = new DataOutputStream(os);
    }

    public String read() throws IOException{
        return dis.readUTF();
    }

    public void write(String msg)throws IOException{
        dos.writeUTF(msg);
        dos.flush();
    }

    public void close() throws IOException{
        dis.close();
        is.close();
        dos.close();
        os.close();
    }
}
