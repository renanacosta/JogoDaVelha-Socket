/*
 * Author: Renan Gomes Acosta
 * [Redes de Computadores] IFRS - Campus Rio Grande
 * Professor: Luciano Vargas Gonçalves
 * Jogo da Velha usando sockets
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Velha {

    private char[] tabuleiro;
    private String cliente1;
    private String cliente2;
    private DataInputStream c1in;
    private DataOutputStream c1out;
    private DataInputStream c2in;
    private DataOutputStream c2out;

    private boolean estadoDoCliente;

    public Velha() {

    }

    public Velha(String clr1, String clr2, DataInputStream input1, DataOutputStream output1, DataInputStream input2,
            DataOutputStream output2) {
        tabuleiro = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        cliente1 = clr1;
        cliente2 = clr2;
        c1in = input1;
        c1out = output1;
        c2in = input2;
        c2out = output2;
        estadoDoCliente = true;

    }

    public void setEstadoDoCliente(boolean estadoDoCliente) {
        this.estadoDoCliente = estadoDoCliente;
    }

    public boolean getEstadoDoCliente() {
        return estadoDoCliente;
    }

    public void iniciaJogo() throws IOException {
        c1out.writeUTF("\nJogo criado!\n");
        c2out.writeUTF("\nJogo criado!\n");

        while (linha() == 0) {
            int value;
            printTabuleiro();
            (estadoDoCliente ? c1out : c2out).writeUTF(getCliente() + " Escolha o número da célula para jogar: \n");
            (!estadoDoCliente ? c1out : c2out).writeUTF("Aguardando " + getCliente() + " jogar...\n");
            System.out.println("\n");
            (estadoDoCliente ? c1out : c2out).writeUTF("n");
            while (!insereNaCelula(value = Integer.parseInt((estadoDoCliente ? c1in : c2in).readUTF())) || value > 8
                    || value < 0 || value != (int) value) {
                (estadoDoCliente ? c1out : c2out).writeUTF("Número de célula incorreto!\nEscolha um número válido: \n");
                System.out.println("\n");
                (estadoDoCliente ? c1out : c2out).writeUTF("n");
            }
            estadoDoCliente = !estadoDoCliente;
        }
        estadoDoCliente = !estadoDoCliente;

        printTabuleiro();

        c2out.writeUTF("\n$$$**** " + getCliente() + " Ganhou. ****$$$\n");
        c2out.writeUTF("\n############### [ GAME OVER! ] ###############\n");
        c1out.writeUTF("\n$$$**** " + getCliente() + " Ganhou. ****$$$\n");
        c1out.writeUTF("\n############### [ GAME OVER! ] ###############\n");

    }

    public boolean insereNaCelula(int nCelula) {
        if (nCelula > 8 || nCelula < 0 || nCelula != (int) nCelula) {
            return false;
        }
        if (tabuleiro[nCelula - 1] == 'X' || tabuleiro[nCelula - 1] == 'O') {
            return false;
        }
        tabuleiro[nCelula - 1] = (estadoDoCliente ? 'X' : 'O');
        return true;
    }

    private void printTabuleiro() throws IOException {

        System.out.println("\nO tabuleiro segue esquema abaixo: \n");

        for (int i = 1; i < 10; i++)
            if ((i == 3) || (i == 6))
                System.out.println(i + "\n----------");
            else if (i == 9)
                System.out.println(i);
            else
                System.out.print(i + " | ");

        c1out.writeUTF(this.tabuleiro[0] + " | " + this.tabuleiro[1] + " | " + this.tabuleiro[2] + "\n----------\n"
                + this.tabuleiro[3]
                + " | "
                + this.tabuleiro[4] + " | " + this.tabuleiro[5] + "\n----------\n" + this.tabuleiro[6] + " | "
                + this.tabuleiro[7] + " | "
                + this.tabuleiro[8] + "\n\n__________\n");
        c2out.writeUTF(this.tabuleiro[0] + " | " + this.tabuleiro[1] + " | " + this.tabuleiro[2] + "\n----------\n"
                + this.tabuleiro[3]
                + " | "
                + this.tabuleiro[4] + " | " + this.tabuleiro[5] + "\n----------\n" + this.tabuleiro[6] + " | "
                + this.tabuleiro[7] + " | "
                + this.tabuleiro[8] + "\n\n__________\n");
    }

    public int linha() {
        if (this.tabuleiro[0] == this.tabuleiro[1] && this.tabuleiro[1] == this.tabuleiro[2]
                && this.tabuleiro[0] != ' ') {
            return this.tabuleiro[0];
        }
        if (this.tabuleiro[0] == this.tabuleiro[3] && this.tabuleiro[3] == this.tabuleiro[6]
                && this.tabuleiro[0] != ' ') {
            return this.tabuleiro[0];
        }
        if (this.tabuleiro[3] == this.tabuleiro[4] && this.tabuleiro[4] == this.tabuleiro[5]
                && this.tabuleiro[3] != ' ') {
            return this.tabuleiro[3];
        }
        if (this.tabuleiro[1] == this.tabuleiro[4] && this.tabuleiro[4] == this.tabuleiro[7]
                && this.tabuleiro[1] != ' ') {
            return this.tabuleiro[1];
        }
        if (this.tabuleiro[6] == this.tabuleiro[7] && this.tabuleiro[7] == this.tabuleiro[8]
                && this.tabuleiro[6] != ' ') {
            return this.tabuleiro[6];
        }
        if (this.tabuleiro[2] == this.tabuleiro[5] &&
                this.tabuleiro[5] == this.tabuleiro[8] && this.tabuleiro[2] != ' ') {
            return this.tabuleiro[2];
        }
        return 0;
    }

    private String getCliente() {
        return this.estadoDoCliente ? this.cliente1 : this.cliente2;
    }
}
