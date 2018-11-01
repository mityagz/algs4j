package algs.ch55;

import edu.princeton.cs.algs4.*;

/**
 * Created by mitya on 7/25/17.
 */
public class ELTXCircuitId {
    public static void main(String[] args) {
        String str0 = "GEPON-LTE-801-kopeisk xpon 1 1044 1 33 0";
        String str1 = "GEPON-LTE-802-udar7a xpon 6 1460 0 25 0";
        //String str2 = "GEPON-LTE-201 xpon 0 1020 0 22 0";
        String str2 = "GEPON-HN-Eltex-LTE8-4-Test xpon 0 1000 0 2222 0";

        // match if ((substring(suffix( option agent.circuit-id, 31), 27, 2) = "23") and (substring(suffix( option agent.circuit-id, 31),
        //||     preprocessDhcpRequest [|    20, 4) = "1374") and (binary-to-ascii(10, 8, ".", packet(24, 4)) = "192.168.10.32"));
        String p0 = (str0.substring(str0.length() - 1 - 31, str0.length() - 1)).substring(21, 25);
        String p1 = (str1.substring(str1.length() - 1 - 31, str1.length() - 1)).substring(21, 25);
        String p2 = (str2.substring(str2.length() - 1 - 31, str2.length() - 1)).substring(21, 25);
        //
        //
        String  p3 = str0.split(" ")[3];
        String  p4 = str1.split(" ")[3];
        String  p5 = str2.split(" ")[3];

        StdOut.println(str0);
        StdOut.println(str1);
        StdOut.println(str2);



        StdOut.println(p0 + "|");
        StdOut.println(p1 + "|");
        StdOut.println(p2 + "|");

        StdOut.println(p3 + "|");
        StdOut.println(p4 + "|");
        StdOut.println(p5 + "|");

    }
}
