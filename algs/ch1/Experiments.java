package algs.ch1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 12/4/15.
 */
public class Experiments {
    static double [] dist;
    public static void dices(){
        int SIDES = 6;
        dist = new double[SIDES*2 +1];
        for(int i = 1; i <= SIDES; i++){
            for(int j = 1; j <= SIDES; j++){
                dist[i + j] += 1.0;
            }
        }
        for(int k = 2; k <= 2*SIDES; k++){
            dist[k] /= 36.0;
        }
    }

    public static void throww(double n){
        int i = 0;
        int SIDES = 6;
        double sum = 0.0;
        double [] prob = new double[2*SIDES ];
        while(i <= n){
            prob[(int)StdRandom.uniform(1.0, 6.0) + (int)StdRandom.uniform(1.0, 6.0)] += 1.0;
            i++;
        }
        for(int k = 2; k < prob.length; k++){
            prob[k] /= n;
        }
        for(int k = 2; k < prob.length; k++){
            StdOut.println("Sum k = " + k + " prob = " + prob[k]);
        }
        for(int k = 2; k < prob.length; k++){
            sum += prob[k];
        }
        StdOut.println("Sum: " + sum);
    }
    public static void main(String [] args){
        dices();
        for(int i = 2; i <  dist.length; i++){
            StdOut.println("K=" + i +" prob: " + dist[i]);
        }
        throww(100.0);
    }
}
