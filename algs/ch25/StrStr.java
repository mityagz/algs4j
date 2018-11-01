package algs.ch25;

/**
 * Created by mitya on 9/11/16.
 */
public class StrStr implements Comparable {
    private String str0;
    private String str1;

    StrStr(String a, String b) {
        str0 = a;
        str1 = b;
    }

    @Override
    public int compareTo(Object o) {
        StrStr s = (StrStr) o;
        if(this.str0.compareTo(s.str0) < 0)
            return -1;
        if(this.str0.compareTo(s.str0) > 0)
            return 1;
        /*
        if(this.str1.compareTo(s.str1) < 0)
            return -1;
        if(this.str1.compareTo(s.str1) > 0)
            return 1;
        */
        return 0;
    }

    @Override
    public String toString() {
        return "String0: " + str0 + " String1: " + str1;
        //return super.toString();
    }
}
