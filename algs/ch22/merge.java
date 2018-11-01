package algs.ch22;

import algs.ch2.Insertion;

/**
 * Created by mitya on 7/9/16.
 */
public class merge {
    static Comparable [] a = {'A', 'E', 'Q', 'S', 'U', 'Y', 'E', 'I', 'N', 'O', 'S'};
    static Comparable [] aux = new Comparable[a.length];

    public static void merge(Comparable [] a, int  lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;

        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++){
            if(i > mid){
                a[k] = aux[j++];
            }else if(j > hi){
                a[k] = aux[i++];
            }else if(Insertion.less(aux[i], aux[j])){
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }

    }
    public static void main(String [] args){
        merge(a, 0, 0 + (0 + (a.length - 1))/2, a.length - 1);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}
