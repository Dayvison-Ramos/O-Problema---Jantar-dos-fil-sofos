package Main;

import java.util.concurrent.Semaphore;


class Filosofo extends Thread {
    private Semaphore garfoEsquerda, garfoDireita; 
    private int id; 

  
    public Filosofo(int id, Semaphore garfoEsquerda, Semaphore garfoDireita) {
        this.id = id;
        this.garfoEsquerda = garfoEsquerda;
        this.garfoDireita = garfoDireita;
    }

    
    public void run() {
        while (true) {
            pensar(); 
            try {
                garfoEsquerda.acquire();
                garfoDireita.acquire(); 
                comer(); 
                garfoEsquerda.release(); 
                garfoDireita.release(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    
    private void pensar() {
        System.out.println("Filósofo " + id + " está pensando.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    
    private void comer() {
        System.out.println("Filósofo " + id + " está comendo.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
