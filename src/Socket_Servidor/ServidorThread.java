package Socket_Servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Bardon
 */
public class ServidorThread implements Runnable {
    Socket cliente;
    ServerSocket servidor;
    
    ServidorThread(ServerSocket servidor){
        this.servidor = servidor;
    }
    
    @Override
    public void run() {
        try {
            cliente = servidor.accept();
            Servidor.textAreaServidor.append("\nO Cliente " + cliente.getInetAddress().getHostAddress() + " está conectado.");
            Servidor.textAreaServidor.append("\n____________________________________________________");
            
            Scanner entrada = new Scanner(cliente.getInputStream());
            
            while (entrada.hasNextLine()) {
                Servidor.textAreaServidor.append("\n"+cliente.getInetAddress().getHostAddress()+": "+ entrada.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Erro na thread: " + e);
        }
    }
}