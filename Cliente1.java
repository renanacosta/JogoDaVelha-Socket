/*
 * Author: Renan Gomes Acosta
 * [Redes de Computadores] IFRS - Campus Rio Grande
 * Professor: Luciano Vargas Gonçalves
 * Jogo da Velha usando sockets
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente1 {
    public static void main(String[] args) {
        final int port = 10000;
        final String host = "localhost";

        Scanner scanner = new Scanner(System.in);
        DataOutputStream out = null;
        DataInputStream in = null;
        try {
            Socket clientSocket = new Socket(host, port);
            System.out.println("\nCliente 1 iniciado.");
            System.out.println("\nSocket criado.");
            System.out.println("\nCliente 1 conectado ao servidor.\n");

            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new DataInputStream(clientSocket.getInputStream());

            try {
                String str = "";
                while (!(str = in.readUTF()).equals("Over")) {

                    if (str.equals("n")) {
                        out.writeUTF(scanner.nextLine());
                    } else {
                        System.out.println(str);
                    }
                }
            } catch (EOFException e) {
            }

            scanner.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
