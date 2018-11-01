package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 4/5/16.
 */
public class UserName {

    public static void main(String [] arg){
        String s = "user@vsety.ru";
        String r = "";

        if(s.contains("@")){
           //r = s.replace('@', '_');

           // int i = s.indexOf('@');
            r = s.substring(0, s.indexOf('@'));
        }else{
            r = s;
        }
        System.out.println(r);
    }
}
