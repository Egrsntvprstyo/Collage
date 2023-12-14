import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPFinder {
    public static void main(String[] args) throws IOException {
        String host;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter host name:");
        host = input.readLine();

        try {
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress address : addresses) {
                System.out.println("IP Address: " + address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println("Could not find " + host);
        }
    }
}
