package Thread;

public class Mainaclass {
    public static void main(String[] args) {
//        ThreadClass t1 = new ThreadClass();
//        ThreadClass t2 = new ThreadClass();
//        t1.start();
//        t2.start();

        Thread t1 = new Thread(() -> {
            for(int i=1; i<10; i++){
                if(i%2 == 0){
                    System.out.println("even" + i);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=1; i<10; i++){
                if(i%2 != 0){
                    System.out.println("odd" + i);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
