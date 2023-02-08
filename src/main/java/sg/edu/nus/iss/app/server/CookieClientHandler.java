package sg.edu.nus.iss.app.server;

import java.io.IOException;
import java.net.Socket;

public class CookieClientHandler implements Runnable{
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
