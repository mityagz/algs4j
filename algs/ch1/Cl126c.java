package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/12/15.
 */
public class Cl126c {
    boolean f = false;
    int i = 0;
    String t, leadchar;

    Cl126c(String a, String b){
        t = b;
        /*
        if(a.length() != b.length()){
            StdOut.println("String a isn't cyclic spine b");
        }
        */

        do{
            if(a.equals(b)){
                f = true;
                StdOut.println("String a is cyclic spine b");
                break;
            }else{
               // b = b.substring(0, b.indexOf(b.length() - 1));
                //StdOut.println(b.length());
                leadchar = (b.substring(b.length() - 1, b.length()));
                StdOut.println(leadchar);
                StdOut.println(b.substring(0, b.length() - 1));
                b = b.substring(b.length() - 1, b.length()) + b.substring(0, b.length() - 1);
                StdOut.println("a after: " + a);
                StdOut.println("b after: " + b);
            }

            i++;
        }while(i < a.length());
        if(!f){
            StdOut.println("String a isn't cyclic spine b");
        }

    }
    public static void main(String [] args){
        //new Cl126c("aHello", "Hello");
        //new Cl126c("ACTGACG", "TGACGAC");
        new Cl126c("Helloa", "aHello");
    }
}
