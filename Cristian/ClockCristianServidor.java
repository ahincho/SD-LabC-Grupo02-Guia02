/*
* @Autor: Darwin Neira Carrasco
* @Email: dneirac@unsa.edu.pe
* @Descripcion:
*/
import java.io.*;
import java.net.*;

public class ClockCristianServidor {
  public static void main(String [] args) throws IOException{
    String port;
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Ingresar el numero del puerto");
    
    port = stdIn.readLine();
    int portNumber = Integer.parseInt(port);
    try(  

        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket clienteSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
    )
    {
      String inputLine;
      System.out.println("Servidor Iniciado");
      while(true){
        inputLine = in.readLine();
        if (inputLine.equalsIgnoreCase("Exit")){
          System.out.println("Exiting");
          out.println("Server Exiting");
          break;
        }
        out.println(System.currentTimeMillis()+5000);
      }

    }catch(Exception ex){
      System.out.println("Tiempo Agotado");
    }



  }

}

