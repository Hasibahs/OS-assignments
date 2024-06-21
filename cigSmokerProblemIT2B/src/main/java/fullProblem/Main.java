package fullProblem;

//IT2B Cigarrette-Smokers Problem

import Agent.Agent;
import Smoker.Smoker;

import java.nio.channels.GatheringByteChannel;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        //Creating the objects

        //Creating the semaphores
        Semaphore t = new Semaphore(0); //Permit (the number) for semaphore, also t is tobacco
        Semaphore p = new Semaphore(0); //paper
        Semaphore m = new Semaphore(0); //matches
        Semaphore a = new Semaphore(1); //agent

        //Creating threads
        Thread aT = new Thread(new Agent(a, t, p, m)); //agent thread
        Thread sTOne = new Thread(new Smoker("tobacco", a, t, p)); //the first smoker has tobacco
        Thread sTTwo = new Thread(new Smoker("paper", a, p, m)); //the second smoker has paper
        Thread stThree = new Thread(new Smoker("matches", a, m, t)); //the third smoker has matches

        //Starting the threads
        aT.start();
        sTOne.start();
        sTTwo.start();
        stThree.start();


    }

}