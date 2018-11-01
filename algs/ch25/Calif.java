package algs.ch25;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 9/24/16.
 */
public class Calif implements Comparable {
    private Character [] set = {'R','W','Q','O','J','M','V','A','H','B','S','G','Z','X','N','T','C','I','E','E','K','U','P','D','Y','F','L'};
    private String s;

    Calif(String s){
        this.s = s;
    }

    @Override
    public int compareTo(Object o) {
        String s1 = ((Calif) o).s;
        int l0 = s.length();
        int l1 = s1.length();

        if(s.equals(s1))
            return 0;
        for(int i = 0, j = 0; i < l0 && i < l1; i++) {
            if(charCompare(s.charAt(i), s1.charAt(i)) < 0){
                return -1;
            } else if (charCompare(s.charAt(i), s1.charAt(i)) > 0) {
                return 1;
            }
        }
        return 0;
    }


    private int charCompare(Character c0, Character c1) {
        int i1 = 0, i2 = 0;
        if(c0.equals(c1)) return 0;
        for(int i = 0; i < set.length; i++) {
            if(c0.compareTo(set[i]) == 0) {
                i1 = i;
            }
            if(c1.compareTo(set[i]) == 0) {
                i2 = i;
            }
        }

        if (i1 < i2)
            return -1;
        if (i1 > i2)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return s;
    }
}
