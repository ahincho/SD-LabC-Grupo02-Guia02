
/*
* @Autor: Darwin Neira Carrasco
* @Email: dneirac@unsa.edu.pe
* @Descripcion:
*/
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class ClockCristianCliente {
  public static void main(String[] args) throws IOException {

    String port, hostName;
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Ingresar numero de puerto: ");
    port = stdIn.readLine();

    int portNumber = Integer.parseInt(port);
    System.out.println("Ingresar nombre del host: ");
    hostName = stdIn.readLine();
    try (
        Socket echoSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));) {
      System.out.println("Cliente Iniciado");
      System.out.println("Enter Exit to Stop");
      long tiempoCero;
      long tiempo_Servidor;
      long tiempoUno;
      long tiempo_final;
      out.println(tiempoCero = System.currentTimeMillis());
      tiempo_Servidor = Long.parseLong(in.readLine());
      tiempoUno = System.currentTimeMillis();
      tiempo_final = (tiempo_Servidor + (tiempoUno - tiempoCero) / 2);
      DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
      System.out.println("Tiempo del cliente: " + formatter.format(new Date(tiempoUno)));
      System.out.println("Tiempo del servidor: " + formatter.format(new Date(tiempo_Servidor)));
      System.out.println("Tiempo del cliente despues del reinicio: " + formatter.format(new Date(tiempo_final)));
      out.println("salida");
    } catch (Exception ex) {
      System.out.println("Tiempo Agotado");
    }

  }

}
