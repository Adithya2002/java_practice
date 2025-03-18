package threads;

public class HelloWorldThread extends Thread{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("hello world thread");
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
