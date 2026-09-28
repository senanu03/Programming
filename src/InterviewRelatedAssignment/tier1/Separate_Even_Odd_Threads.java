package InterviewRelatedAssignment.tier1;

public class Separate_Even_Odd_Threads {

    private static final Object lock = new Object();
    private static int number = 1;

    public static void main(String[] args) {

        Thread evenThread = new Thread(() -> {
            while (number <= 10) {
                synchronized (lock) {

                    while (number <= 10 && number % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    if (number <= 10) {
                        System.out.println("Even: " + number);
                        number++;

                        lock.notify();
                    }
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            while (number <= 10) {
                synchronized (lock) {

                    while (number <= 10 && number % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    if (number <= 10) {
                        System.out.println("Odd: " + number);
                        number++;

                        lock.notify();
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();

    }
}
