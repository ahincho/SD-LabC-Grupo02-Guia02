import java.util.ArrayList;
import java.util.List;

public class Servidor {
    public static void main(String[] args) {
        //capturo el Tiempo inicial del servidor
        int TiempoInicial = (int) (System.currentTimeMillis() / 1000);
        List<RelojThread> clienteReloj = new ArrayList<>();
        //para cada reloj se creo un valor random inicial y se agrega a cada reloj
        clienteReloj.add(new RelojThread((int) (Math.random() * 10000) + TiempoInicial));
        clienteReloj.add(new RelojThread((int) (Math.random() * 10000) + TiempoInicial));
        clienteReloj.add(new RelojThread((int) (Math.random() * 10000) + TiempoInicial));
        for (RelojThread reloj : clienteReloj){
            reloj.start(); //inicia el reloj
            try {
                reloj.join(); //termine el reloj
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int TiempoInicial_2doDesfase = (int) (System.currentTimeMillis() / 1000);
        int promTiempo = (TiempoInicial_2doDesfase - TiempoInicial) / 2;
        int D_cambiada = 0;
        int D[] = new int[clienteReloj.size()];
        // Diferencia notificada "D"
        for(int i=0; i<clienteReloj.size(); i++){
            D[i] = (clienteReloj.get(i).getClock() - TiempoInicial) - promTiempo;
            D_cambiada += D[i];
        }
        int promReloj = D_cambiada / (clienteReloj.size() + 1);

        for(int i = 0 ; i < clienteReloj.size() ; i++){
            int ajuste = promReloj - D[i];
            clienteReloj.get(i).setClock(clienteReloj.get(i).getClock() + ajuste);
            System.out.println("Tiempo Clientes y Servidor: " + clienteReloj.get(i).getClock());
        }
    }
}
