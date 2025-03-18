package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;
    final Lock lock = new ReentrantLock();
    public int getBalance(){
        return balance;
    }
    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " is attempting to withdraw " + amount);
        if(lock.tryLock()){
            if(balance>=amount){
                try{
                    System.out.println(Thread.currentThread().getName() + " is proceeding with withdrawal");
                    Thread.sleep(3000);
                    balance -= amount;
                }
                catch(InterruptedException e){}
                finally{
                    lock.unlock();
                }
            }
            else{
                System.out.println("Insufficient balance");
            }
        }
        else{
            System.out.println("Could not acquire the lock. Will try later");
        }

    }

}
