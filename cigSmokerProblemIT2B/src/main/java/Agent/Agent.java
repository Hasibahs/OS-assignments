package Agent;

import java.util.concurrent.Semaphore;

public class Agent implements Runnable { //create Thread (ez way)
    private Semaphore agent;
    private Semaphore t; //tobacco
    private Semaphore p; //paper
    private Semaphore m; //matches

    public Agent(Semaphore agent, Semaphore t, Semaphore p, Semaphore m) {
        this.agent = agent;
        this.t = t;
        this.p = p;
        this.m = m;
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.agent.acquire(); //block until a permit is available (Sempahore)
                //Now we have to put two ingredients on the table (from the three available)
                //We are going to use the Math.random method to have two random ingredients on the table
                int random = (int) (Math.random() * 3); //We have to cast this line to int
                if (random == 0) {
                    //So, if the random number is equal to 0 then we have to release the tobacco and paper (two ingredients)
                    this.t.release(); //release blocked permit
                    this.p.release(); //release blocked permit
                    //Result for what the agent has placed on the table
                    System.out.println("Agent has placed tobacco and paper on the table");
                }
                //We do the same things for the other cases but we just add the matches in the case and switch around with paper and matches and so on
                else if (random == 1) {
                    this.t.release();
                    this.m.release();
                    System.out.println("Agent has placed tobacco and matches on the table");
                } else {
                    this.p.release();
                    this.m.release();
                    System.out.println("Agent placed paper and matches on the table");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //Interrupt the current thread if an exception is thrown
        }
    }
}
