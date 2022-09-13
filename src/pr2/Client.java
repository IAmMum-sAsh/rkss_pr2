package pr2;

import java.net.*;
import java.io.*;
public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket;
        PrintStream out = null;
        BufferedReader in = null;
        try {
            /* Создается объект сокет, чтобы соединиться с сервером */
            clientSocket = new Socket("0.0.0.0", 1001);
            /* Создается выходной поток, чтобы посылать данные насервер */
            out = new
                    PrintStream(clientSocket.getOutputStream());
            /* Создается входной поток, чтобы принимать данные с сервера */
            in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Unidentified hostname ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O ");
            System.exit(1);
        }
        /* Создается входной поток, чтобы читать данные из окна консоли */
        BufferedReader stdin = new BufferedReader(new
                InputStreamReader(
                (System.in)));

        String str = "";
        System.out.println(in.readLine());
        while ((str = stdin.readLine()) != null) {
            if (str.equals("1227"))
                break;
            /* Прием login */
            out.println(str);
            /* Чтение из сокета */
            System.out.println(in.readLine());
        }
        out.close();
        in.close();
        stdin.close();
    }
}

