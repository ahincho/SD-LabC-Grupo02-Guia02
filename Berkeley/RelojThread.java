public class RelojThread extends Thread{
    // Los hilos simulan ser RelojThreads
    private int reloj;  
    public RelojThread(int tiempoInicial) {
        System.out.println("Tiempo inicial de cada reloj: " + tiempoInicial);
        this.reloj = tiempoInicial;
    }
    public int getClock() {
        return reloj;
    }
    public void setClock(int reloj){
        this.reloj = reloj;
    }
    @Override
    public void run() {
        try {
            // Segundos diferente para cada RelojThread 
            int time = (int) (Math.random() * 3 * 1000);
            Thread.sleep(time);
            // Luego de el sleep tomo el tiempo 
            reloj = (reloj + time); //solo se le agrega a ese reloj el desfase
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
