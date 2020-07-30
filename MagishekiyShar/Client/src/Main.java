import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {



        try (Socket socket = new Socket();) {

            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 5000));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            Scanner getServer = new Scanner(socket.getInputStream());

            while (true) {
                System.out.print("Введите вопрос, на который можно ответить 'да' или 'нет': ");
                Scanner scanner = new Scanner(System.in);
                String vopros = scanner.nextLine();

                printWriter.println(vopros);

               System.out.println(getServer.nextLine());
               System.out.println();
            }

        }
    }
}
