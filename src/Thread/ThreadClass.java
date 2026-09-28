package Thread;

public class ThreadClass extends Thread{
    @Override
    public void run(){
        for(int i=1; i<10; i++){
            if(i%2 == 0){
                System.out.println("Even" + i);
            }
            else{
                System.out.println("Odd" + i);
            }
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
