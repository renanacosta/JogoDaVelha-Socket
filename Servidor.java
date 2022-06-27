/*
 * Author: Renan Gomes Acosta
 * [Redes de Computadores] IFRS - Campus Rio Grande
 * Professor: Luciano Vargas Gonçalves
 * Jogo da Velha usando sockets
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        final int port = 10000;
        DataOutputStream out1 = null;
        DataInputStream in1 = null;
        DataOutputStream out2 = null;
        DataInputStream in2 = null;
        try (ServerSocket serverSocket = new ServerSocket(port)

        ) {
            System.out.println("\nServidor iniciado.");
            System.out.println("\nSocket criado.\n");
            System.out.println("\nAguardando conexão dos clientes....\n");
            Socket clientSocket1 = serverSocket.accept();
            System.out.println("\nCliente 1 conectado.");
            Socket clientSocket2 = serverSocket.accept();
            System.out.println("\nCliente 2 conectado.");
            System.out.println("\nClientes conectados ao servidor.\n");
            System.out.println("\nIniciando jogo...");

            // Cria fluxos de entrada e saida dos clientes
            out1 = new DataOutputStream(clientSocket1.getOutputStream());
            in1 = new DataInputStream(clientSocket1.getInputStream());
            out2 = new DataOutputStream(clientSocket2.getOutputStream());
            in2 = new DataInputStream(clientSocket2.getInputStream());

            String cliente1;
            String cliente2;

            out1.writeUTF("\n\nJOGO INICIADO!!!\n");
            out1.writeUTF("-------------------------------------------------");
            out1.writeUTF("******** [ BEM VINDO AO JOGO DA VELHA! ] ********");
            out1.writeUTF("-------------------------------------------------");
            
            out2.writeUTF("\n\nJOGO INICIADO!!!\n");
            out2.writeUTF("-------------------------------------------------");
            out2.writeUTF("******** [ BEM VINDO AO JOGO DA VELHA! ] ********");
            out2.writeUTF("-------------------------------------------------");
                     
            out2.writeUTF("\nAguardando cliente 1 inserir um nome...\n");
            out1.writeUTF("\nDigite um nome para o Cliente 1: ");
            out1.writeUTF("n"); // entrada do cliente 1
            cliente1 = in1.readUTF();
            out1.writeUTF("\nOlá " + cliente1 + ".\n");
            out2.writeUTF("\nCliente 1 escolheu o nome " + cliente1 + ".\n");

            out1.writeUTF("\nAguardando cliente 2 inserir um nome...");
            out2.writeUTF("\nDigite um nome para o Cliente 2: ");
            out2.writeUTF("n"); // entrada do cliente 2
            cliente2 = in2.readUTF();
            out2.writeUTF("\nOlá " + cliente2 + ".\n");
            out1.writeUTF("\nCliente 2 escolheu o nome " + cliente2 + ".\n");

            out1.writeUTF("\nVocê é o XIS [ X ]\n");
            out2.writeUTF("\nVocê é o BOLINHA [ O ]\n");

            Velha jogo = new Velha(cliente1, cliente2, in1, out1, in2, out2);
            jogo.iniciaJogo();

            clientSocket1.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
