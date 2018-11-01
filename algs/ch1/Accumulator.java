package algs.ch1;

/**
 * Created by mitya on 12/13/15.
 */
public class Accumulator {
    private double m;
    private double s;
    private int n;

    public void addDataValue(double x){
        n++;
        s = s + 1.0 * (n - 1) / n * (x - m) * (x - m);
        m = m + (x - m) / n;
    }

    public double mean(){
        return m;
    }

    public double var(){
        return s / (n - 1);
    }

    public double stddev(){
        return Math.sqrt(this.var());
    }
}
