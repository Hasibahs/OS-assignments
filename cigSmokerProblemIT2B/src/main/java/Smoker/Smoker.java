package Smoker;

import java.util.concurrent.Semaphore;

public class Smoker implements Runnable {
    private String i; //ingredient
    private Semaphore agent;
    private Semaphore sI; //smoker Ingredient
    private Semaphore aI; //the additional ingredient the smoker needs

    public Smoker(String i, Semaphore agent, Semaphore sI, Semaphore aI) {
        this.i = i;
        this.agent = agent;
        this.sI = sI;
        this.aI = aI;
    }


    @Override
    public void run() {
        try {
            while (true) {
                this.sI.acquire(); //block the smoker's own ingredient
                System.out.println("The smoker with " + this.i + " has obtained their ingredient");

                this.aI.acquire(); //block the additional ingredient that the smoker needs
                System.out.println("The smoker with " + this.i + " has obtained their additional ingredient");

                //Here, now the smoker can roll and smoke a ciggy
                System.out.println("Smoker with " + this.i + " is rolling and smoking the ciggy");

                Thread.sleep(2000); //I wanted to see how the the sleep method of thread works so we simulate rolling and smoking the ciggy process

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
