package synchronization;

import synchronization.Counter;
import synchronization.MyThread;
import threads.HelloWorldThread;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        Counter count = new Counter();
        Thread t1 = new MyThread(count);
        Thread t2 = new MyThread(count);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){

        }
        System.out.println(count.getCount());
    }
}