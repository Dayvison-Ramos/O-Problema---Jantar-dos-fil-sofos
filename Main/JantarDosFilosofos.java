package Main;


import java.util.concurrent.Semaphore;



public class JantarDosFilosofos {
    public static void main(String[] args) {
        int numFilosofos = 5; 
        Semaphore[] garfos = new Semaphore[numFilosofos]; 
        Filosofo[] filosofos = new Filosofo[numFilosofos]; 
        for (int i = 0; i < numFilosofos; i++) {
            garfos[i] = new Semaphore(1); 
        }

        for (int i = 0; i < numFilosofos; i++) {
            int garfoEsquerdaIndex = i;
            int garfoDireitaIndex = (i + 1) % numFilosofos;
            filosofos[i] = new Filosofo(i, garfos[garfoEsquerdaIndex], garfos[garfoDireitaIndex]); 
            filosofos[i].start(); 
        }
    }
}
