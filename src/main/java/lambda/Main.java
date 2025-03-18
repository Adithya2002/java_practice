package lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String args[]){
        Runnable run = () -> {System.out.println("hello");};
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("hello");
                Thread.sleep(100);
                System.out.println("t1 over");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2 start");
                Thread.sleep(100);
                System.out.println("world");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
//        t1.start();
//        t2.start();
        Predicate<Integer> isEven = (x) -> x%2==0;
        System.out.println(isEven.test(21));
        Function<Integer,Integer> tripleIt = (x) -> x*3;
        System.out.println(tripleIt.apply(30));

    }
}
