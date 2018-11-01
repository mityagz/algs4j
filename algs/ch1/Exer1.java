package algs.ch1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 11/22/15.
 */
public class Exer1 {
    public static void e1_1_6() {
        int f = 0;
        int g = 1;
        for(int i = 0; i <= 15; i++){
            StdOut.println(f);
            f = f + g;
            StdOut.println("f: " + f);
            g = f - g;
            StdOut.println("g: " + g);
            StdOut.println("---");
        }
    }

    public static void e1_1_7_a() {
        double t = 9.0;
        while(Math.abs(t - 9.0/t) > .001){
            t = (9.0/t + t) / 2.0;
            StdOut.printf("%.5f\n", t);
        }
    }

    public static void e1_1_7_b() {
        int sum = 0;
        for(int i = 1; i < 1000; i++){
            for(int j = 0; j < i; j++){
                sum++;
            }
            StdOut.println(sum);
        }
        StdOut.println(sum);
    }

    public static void e1_1_7_c() {
        int sum = 0;
        for(int i = 1; i < 1000; i *= 2){
            for(int j = 0; j < i; j++){
                sum++;
            }
            StdOut.println(sum);
        }
        StdOut.println(sum);
    }

    public static void e1_1_8() {
        StdOut.println('b');
        StdOut.println('b' + 'c');
        StdOut.println((char)('a' + 4));
    }

    public static void e1_1_9(int N){
        String s = "";
        for(int n = N; n > 0; n = n / 2){
           s = s + n % 2;
        }
        StdOut.println(s);
    }

     public static void e1_1_11(int N){

        //int [][] a = new int [10][10];

        /*
        boolean [][] a = {{true,false,true,true,true},
                          {true ,false, true ,true,true},
                          {true,false,true,false,true},
                          {true,false,true,true,true},
                          {false,true,false,true,true}};

        */

        boolean [][] a = new boolean[5][5];

        StdRandom.bernoulli();
        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 5; j++){
                    a[i][j] = StdRandom.bernoulli();
            }
        }

        for(int i = 0; i < 5; i++){
           for(int j = 0; j < 5; j++){
               if(j == 0) {
                   StdOut.print(i + " ");
               }else if(i == 0){
                   StdOut.print(j + " ");
               }else{
                   if(a[i][j] == true) {
                       StdOut.print("* ");
                   }else{
                       StdOut.print("  ");
                   }
               }
           }
            StdOut.println();
        }
    }

    public static void e1_1_12(){
        int [] a = new int [10];
        for(int i = 0; i < 10; i++){
            a[i] = 9 -i;
        }

        for(int i = 0; i < 10; i++){
            a[i] = a[a[i]];
        }

        for(int i = 0; i < 10; i++){
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void e1_1_13(){
        int [][] a = {{3, 4, 5, 6, 7}, {5, 7, 8, 1, 4}, {1, 4, 2, 7,2}};
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                StdOut.print(a[i][j] + " ");
            }
            StdOut.println();
        }

        int [][] b = new int [a[0].length][a.length];

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                b[j][i] = a[i][j];
            }
        }

        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < b[0].length; j++){
                StdOut.print(b[i][j] + " ");
            }
            StdOut.println();
        }
    }

    public static int lg(int N){
        int x = 0, a = 2, l = 1;
            while(l < N) {
                l = l * a;
                x++;
                 if(l > N){
                    x--;
                    break;
                }
            }
        return x;
    }

    public static String exR1(int n){
        if(n <= 0) return "";
        return exR1(n - 3) + n  + exR1(n - 2) + n;
    }

    public static long F(int N){
        if(N == 0) return 0;
        if(N == 1) return 1;
        return F(N -1) + F(N -2);
    }

    public static int mystery(int a, int b){
        if(b == 0) return 0;
        if(b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    public static int f(int n){
        if(n == 0)
            return 1;
        return n*f(n - 1);
    }

    static int deep = 0;
    public static double binomial(int N, int k, double p){
        deep++;
        StdOut.println("Deep: " + deep);
        if(N == 0 && k == 0){
            return 1.0;
        }
        if(N < 0 || k < 0){
            return 0.0;
        }
        return (1.0 - p)*binomial(N - 1, k, p) + p*binomial(N - 1, k - 1, p);
    }

    public static void logic_ar(int n){
        boolean [][] a = new boolean [n][n];
        for(int i = 1; i < a.length; i++){
            for(int j = 1; j < a.length; j++){
                if(Euclid.gcd(i, j) > 1){
                    a[i][j] = true;
                } else {
                    a[i][j] = false;
                }
            }
        }
        int k = 1, m = 1;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                if(i == 0){
                    if(j == n - 1){
                        StdOut.println();
                    }else {
                        StdOut.printf("%6dx", k++);
                    }
                }else if(j == 0){
                    StdOut.printf("%d ", m++);
                } else {
                    StdOut.printf("%6b ", a[i][j]);
                }
            }
            StdOut.println();
        }
    }

    public static void main(String [] args){
        // e1_1_6();
        // e1_1_7_a();
        // e1_1_7_b();
        // e1_1_7_c();
        // e1_1_8();
        // e1_1_9(7);
        // e1_1_11(10);
        // e1_1_12();
        // e1_1_13();
        // StdOut.println(lg(31));
        // StdOut.println(exR1(6));
        /*
        for(int i = 0; i < 100; i++){
            StdOut.println(i + ":" + F(i));
        }
        */
        // StdOut.println(mystery(3,25));
        // StdOut.println(mystery(3,11));
        // StdOut.println(f(5));
        // StdOut.println(binomial(10, 100, 50));
        logic_ar(5);
    }
}
