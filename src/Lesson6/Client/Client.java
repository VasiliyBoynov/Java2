package Lesson6.Client;

import Lesson6.MyTread.MyInputStreamTread;
import Lesson6.MyTread.MyOutputStreamTread;

import java.io.IOException;
import java.net.Socket;

import static Lesson6.Server.ServerMessage.myPrint;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("localhost", 8052);
            try {
                MyInputStreamTread treadInput = new MyInputStreamTread(socket);
                MyOutputStreamTread treadOutput = new MyOutputStreamTread(socket);
                treadInput.start();
                treadOutput.start();
            } catch (Exception e) {
                myPrint("Соединение разорвано");
            }

        } catch (Exception e)
        {
            myPrint("Сервер не доступен");
        }




    }
}
