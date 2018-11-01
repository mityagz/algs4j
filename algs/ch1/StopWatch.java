package algs.ch1;

/**
 * Created by mitya on 2/16/16.
 */
public class StopWatch {
    private final long start;
    public StopWatch(){
        start = System.currentTimeMillis();
    }

    public double intermediateTime(){
        long now = System.currentTimeMillis();
        return (now - start)/1000.0;
    }

    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start)/1000.0;
    }
}
