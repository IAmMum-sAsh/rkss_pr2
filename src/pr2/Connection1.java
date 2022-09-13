package pr2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

class Connection1 extends Thread
{
    protected Socket netClient;
    protected BufferedReader fromClient;
    protected PrintStream toClient;
    public Connection1(Socket client)
    {
        netClient = client;
        try
        {
            fromClient = new BufferedReader(new
                    InputStreamReader(netClient.getInputStream()));
            toClient = new PrintStream(netClient.getOutputStream());
        }
        catch(IOException e)
        {
            try
            {
                netClient.close();
            }
            catch(IOException e1)
            {
                System.err.println("Unable to set up streams"
                        + e1);
                return;
            }
        }
        this.start();
    }
    public void run()
    {
        String clientMessage;
        try
        {
            for(;;)
            {
                clientMessage = fromClient.readLine();
                if(clientMessage == null)
                    break;
// Посылает подтверждение клиенту
                toClient.println("Received");
            }
        }
        catch(IOException e)
        {}
        finally
        {
            try
            {
                netClient.close();
            }
            catch(IOException e)
            {}
        }
    }
}

