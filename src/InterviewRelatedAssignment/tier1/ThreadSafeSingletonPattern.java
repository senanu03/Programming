package InterviewRelatedAssignment.tier1;

import java.io.Serializable;

public class ThreadSafeSingletonPattern implements Serializable, Cloneable{
    private static volatile ThreadSafeSingletonPattern instance;

    private ThreadSafeSingletonPattern() {
    }

    public static ThreadSafeSingletonPattern getInstance() {

        if (instance == null) {

            synchronized (ThreadSafeSingletonPattern.class) {

                if (instance == null) {
                    instance = new ThreadSafeSingletonPattern();
                }
            }
        }

        return instance;
    }

    // Prevent creating another object during deserialization
    protected Object readResolve() {
        return getInstance();
    }

    // Prevent creating another object using clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
