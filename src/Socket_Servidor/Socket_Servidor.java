package Socket_Servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Socket_Servidor {

     public static void main(String[] args) throws IOException {
     ServerSocket servidor = new ServerSocket(2050);
     
     System.out.println("Porta 2050 aberta!");
     
     Socket cliente = servidor.accept();
     
     System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
     

     Scanner entrada = new Scanner(cliente.getInputStream());
     
     while (entrada.hasNextLine()) {
       System.out.println("O cliente digitou: " + entrada.nextLine());
     }
     
     entrada.close();
     servidor.close();
   }
}