package algs.ch25;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.Arrays;

/**
 * Created by mitya on 10/7/16.
 */
public class FileSorter {

    public static void main(String [] args) {
        File f = new File(args[0]);
        if(!f.exists()) {
            StdOut.println(f.getName() + " don't exist");
            return;
        }
        if(!f.isDirectory()) {
            StdOut.println(f.getName() + " isn't directory");
            return;
        }

        String [] names = f.list();

        Arrays.sort(names);

        for(String name : names)
            StdOut.println(name);
    }
}
