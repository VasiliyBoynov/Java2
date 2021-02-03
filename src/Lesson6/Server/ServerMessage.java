package Lesson6.Server;

import Lesson6.MyTread.MyInputStreamTread;
import Lesson6.MyTread.MyOutputStreamTread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ServerMessage {
    public static void main(String[] args) throws IOException {

        try {
            ServerSocket server = new ServerSocket(8052);
            Socket socket = server.accept();
            myPrint("Соединение установлено ");

            try {
                MyInputStreamTread treadInput = new MyInputStreamTread(socket);
                MyOutputStreamTread treadOutput = new MyOutputStreamTread(socket);
                treadInput.start();
                treadOutput.start();
            } catch (Exception e) {
                myPrint("Соединение разорвано");
            }
        } catch (Exception e) {
            myPrint("Сервер не доступен");
        }


    }

    public synchronized static void myPrint(String message){
        Calendar data = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("HH:mm:ss ");
        System.out.println( df.format(data.getTime()) + message);
    }
}
