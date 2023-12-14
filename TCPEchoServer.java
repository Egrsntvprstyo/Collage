import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {
    private static ServerSocket serverSocket;
    private static final int port = 50000;

    public static void main(String[] args) {
        System.out.println("Opening Port.......\n");
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Unable to attach to port");
            System.exit(1);
        }

        do {
            run();
        } while (true);
    }

    private static void run() {
        Socket link = null;
        try {
            link = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
            PrintWriter out = new PrintWriter(link.getOutputStream(), true);

            int numMessages = 0;
            String message = in.readLine();

            while (!message.equals("close")) {
                System.out.println("Message received: " + message);
                numMessages++;
                out.println("Message " + numMessages + ": " + message);
                message = in.readLine();
            }
            out.println(numMessages + " messages received.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("********Closing Connection********");
                if (link != null) {
                    link.close();
                }
            } catch (IOException e) {
                System.out.println("Unable to disconnect");
                System.exit(1);
            }
        }
    }
}
