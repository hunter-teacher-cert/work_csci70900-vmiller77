/**
 * Team 2
 * Michelle Best
 * Michelle Persaud
 * Eric Liu
 *
 * Team 2
 * Victoria B.
 * Brian M.
 * Eric Liu
 */

import java.io.*;
import java.util.*;

public class DlistDriver{
    public static void main(String[] args) {

        // Node a = new Node("a");
        // Node b = new Node("b");
        // Node c = new Node("c");

        Dlist n = new Dlist();
        n.addFront("b");
        System.out.println(n);
        System.out.println("Back:"+ n.toStringBack());
        n.addFront("a");
        System.out.println(n);
        System.out.println("Back:"+n.toStringBack());
        n.addBack("c");
        System.out.println(n);
        System.out.println("Back:"+n.toStringBack());
        n.remove(1);
        System.out.println(n);
        System.out.println("Back:"+n.toStringBack());



    }//end main()
}//end Driver class
