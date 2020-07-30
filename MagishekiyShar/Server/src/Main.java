import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String vopros;

        try(ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket = serverSocket.accept();) {

            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            while (scanner.hasNextLine()) {

                vopros = scanner.nextLine();

                System.out.println("Пришел вопрос: " + vopros);

                int random = (int) Math.round(Math.random());

                 if (random == 1) {
                    printWriter.println("Ответ: Да");
                }  else {
                    printWriter.println("Ответ: Нет");
                }

            }
        }
    }
}
