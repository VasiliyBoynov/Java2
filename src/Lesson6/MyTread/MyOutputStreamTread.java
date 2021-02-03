package Lesson6.MyTread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class MyOutputStreamTread extends Thread {

    private volatile Socket socket;

    public MyOutputStreamTread(Socket socket) {
        this.socket = socket;
    }

    private void handle () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());
        String message = "";
        while(!socket.isClosed()){
                message = reader.readLine();
                if (socket.isClosed()){
                    break;
                }
                if (message.equals("/end")){
                    out.writeBytes(message);
                    out.flush();
                    break;
                }
                out.writeBytes("> " + message + "\r\n");
                out.flush();

        }

        reader.close();
        out.close();
    }
    public void run() {
        try {
            handle();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
