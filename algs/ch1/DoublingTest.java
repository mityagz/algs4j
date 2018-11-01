package algs.ch1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 2/16/16.
 */
public class DoublingTest {
    int xs, ys, offsetX, offsetY, i;
    int [] nc;
    double [] nTime;
    DoublingTest(){
        xs = 1600;
        ys = 2;
        offsetX = 1000;
        offsetY = 1;
        nc = new int [1000];
        nTime = new double [1000];
        i = 0;
    }

    public void drawF(int n, double time){
        StdDraw.setXscale(0, xs);
        StdDraw.setYscale(0, ys);
        StdDraw.setPenRadius(0.001);
        StdDraw.line(offsetX, offsetY, xs, offsetY);
        StdDraw.line(offsetX, offsetY, offsetX, ys);
        StdDraw.setPenRadius(0.005);
        if(n > xs || time > ys) {
            if (n > xs)
                xs = n + 100;

            if (time > ys)
                ys = (int) time + 2;

            StdDraw.clear();
            StdDraw.setPenRadius(0.001);
            StdDraw.setXscale(0, xs);
            StdDraw.setYscale(0, ys);
            StdDraw.line(offsetX, offsetY, xs, offsetY);
            StdDraw.line(offsetX, offsetY, offsetX, ys);
            StdDraw.setPenRadius(0.005);
            for (int j = 0; j < i; j++) {
               StdDraw.point(nc[j] + offsetX, nTime[j] + offsetY);
               StdDraw.point(nc[j] + offsetX, Math.log(nTime[j]) + offsetY);
               StdDraw.text(nc[j] + offsetX, 0, Integer.toString(nc[j]));
            }
        }
        nc[i] = n;
        nTime[i] = time;
        i++;
        StdDraw.setPenRadius(0.005);
        StdDraw.point(n + offsetX, time + offsetY);
        StdDraw.point(n + offsetX, Math.log(time) + offsetY);
        StdDraw.text(n + offsetX, 0, Integer.toString(n));
    }

    public static double timeTrial(int n){
        int max = 1000000;
        int [] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = StdRandom.uniform(-max, max);
        }
        StopWatch timer = new StopWatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String [] args){
        DoublingTest dt = new DoublingTest();
        for(int n = 250; true; n += n){
            double time = timeTrial(n);
            StdOut.printf("%7d %5.1f\n", n, time);
            dt.drawF(n, time);
        }
    }
}
