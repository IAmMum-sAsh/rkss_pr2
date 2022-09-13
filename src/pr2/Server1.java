package pr2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 extends Thread {
    private ServerSocket serverSocket;
    public Server1() {
        try {
            serverSocket = new ServerSocket(1001);
        }
        catch(IOException e) {
            fail(e, "Невозможно запустить сервер.");
        }
        System.out.println("Сервер запущен. . .");
        this.start(); // Запускается поток
    }

    public static void fail(Exception e, String str) {
        System.out.println(str + "." + e);
    }

    public void run()
    {
        try
        {
            while(true)
            {
                Socket client = serverSocket.accept();
                Connection1 con = new Connection1(client);
            }
        }
        catch(IOException e)
        {
            fail(e, "Не прослушивается");
        }
    }


}
