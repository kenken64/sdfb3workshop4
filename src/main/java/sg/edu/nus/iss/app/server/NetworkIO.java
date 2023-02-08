package sg.edu.nus.iss.app.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkIO {
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
