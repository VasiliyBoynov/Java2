package Lesson6.MyTread;


import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;


import static Lesson6.Server.ServerMessage.myPrint;

public class MyInputStreamTread extends Thread {

    private Socket socket;
    private DataInputStream input;

    public MyInputStreamTread(Socket socket) throws IOException {

        this.socket = socket;
        input = new DataInputStream(socket.getInputStream());
    }

    private void handle()  throws IOException {

        while (!socket.isClosed()){
                String messageIn = input.readLine();
                if (messageIn.equals("/end")) {
                    //System.out.println(messageIn);
                    break;
                }
                myPrint("> " + messageIn);
            }
        socket.close();
        input.close();
    }

    @Override
    public void run() {
        try {
            handle();
        } catch (IOException e) {
            myPrint("Соединение разорвано");
        }

    }
}
