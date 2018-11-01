package algs.ch1;


import java.util.Arrays;

/**
 * Created by mitya on 11/28/15.
 */
public class UniqSortArray {
    static int [] a = {3, 1, 3, 5, 6, 7, 7, 8, 9, 5, 4, 6, 5, 6, 8, 6, 8, 6, 8};
    static int tail = a.length;

    public static void  uniqsort(){
        for(int i = 0; i < tail; i++){
            if((i+1) < tail)
            if(a[i] == a[i+1]){
                //System.out.println("i: " + i );
                //System.out.println("a[" + i + "] = " + a[i] + "     "+ "a[" + (i + 1) + "] = " + a[i+1]);
                for(int j = i; j <= tail; j++){
                    if((j + 1) < tail) {
                        a[j] = a[j + 1];
                    }
                }
                i--;
                tail--;
            }
        }
    }


    public static void main(String [] args){
        Arrays.sort(a);
        for(int i = 0; i < tail; i++){
            System.out.println(a[i]);
        }
        System.out.println();
        UniqSortArray.uniqsort();
        for(int i = 0; i < tail; i++){
            System.out.println(a[i]);
        }
    }
}
