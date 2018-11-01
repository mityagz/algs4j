package algs.ch25;

import algs.ch2.Selection;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 9/11/16.
 */
public class StableSort<Key extends Comparable<Key>> {
    Key [] a;
    AuxKey [] auxKeys;
    StableSort(Key [] a) {
        this.a = a;
        auxKeys = new AuxKey[a.length];
        for(int i = 0; i < auxKeys.length; i++) {
            auxKeys[i] = new AuxKey(a[i], i);
        }
    }

    private class AuxKey<Key extends Comparable<Key>> implements Comparable {
        Key key;
        int index;
        AuxKey(Key key, int index) {
            this.key = key;
            this.index = index;
        }

        public Key getKey() {
            return key;
        }

        @Override
        public int compareTo(Object k) {
            AuxKey ak = (AuxKey) k;
            if(this.key.compareTo((Key) ak.key) <0)
                return -1;
            if(this.key.compareTo((Key) ak.key) > 0)
                return 1;
            if(this.key.compareTo((Key) ak.key) == 0) {
                if(this.index == ak.index)
                    return 0;
                if(this.index < ak.index)
                    return -1;
                if(this.index > ak.index)
                    return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Key: " + key + " Index: " + index;
        }
    }

    public Key [] getKey() {
        for(int i = 0; i < auxKeys.length; i++) {
            a[i] = (Key) auxKeys[i].getKey();
        }
        return a;
    }

    public static void main(String [] args) {
        StrStr [] a = new StrStr[10];
        a[0] = new StrStr("Hello"," Hello0");
        a[1] = new StrStr("Hello"," Hello1");
        a[2] = new StrStr("Hello"," Hello2");
        a[3] = new StrStr("Hello1"," Hello3");
        a[4] = new StrStr("Hello"," Hello4");
        a[5] = new StrStr("Hello1"," Hello5");
        a[6] = new StrStr("Hello"," Hello6");
        a[7] = new StrStr("Hello1"," Hello7");
        a[8] = new StrStr("Hello2"," Hello8");
        a[9] = new StrStr("Hello"," Hello9");

        for(int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
        StdOut.println();
        /*
        edu.princeton.cs.algs4.Selection.sort(a);
        for(int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
        */

        StdOut.println();

        StableSort ss = new StableSort(a);
        edu.princeton.cs.algs4.Selection.sort(ss.auxKeys);

        /*
        for(int i = 0; i < a.length; i++) {
            a[i] = (StrStr) ss.auxKeys[i].getKey();
        }
        */

        a = (StrStr[]) ss.getKey();

        for(int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
