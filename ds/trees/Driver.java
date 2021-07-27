import java.io.*;
import java.util.*;


public class Driver {
    public static void main(String[] args) {
    	BSTree t = new BSTree();

      t.insert(10);
      t.insert(20);
      t.insert(5);
      t.insert(3);
      t.insert(25);
      t.insert(19);
      t.insert(7);
      t.insert(8);
      t.insert(26);
      t.insert(17);



      // t.traverse();
      // t.traverse2();
      // t.traverse3();
      System.out.println("Before any deletion");
      t.traverse3();


      //case 1 - front(8) is a leaf
      System.out.println("\n****delete(8)");
      t.delete(8);
      t.traverse3();

      //case 2 - front(25) has one child on right
      System.out.println("\n****delete(25)");
      t.delete(25);
      t.traverse3();

      //case 2 - front(19) has one child on left
      System.out.println("\n****delete(19)");
      t.delete(19);
      t.traverse3();

      //case 3 - front(20) has two leaf children
      System.out.println("\n****delete(20)");
      t.delete(20);
      t.traverse3();

      //case 3 - front(5) had two children(one leaf, one with child)
      System.out.println("\n****delete(5)");
      t.delete(5);
      t.traverse3();

      //case 3- front(10) has two children(both with child) and is a root
      t.insert(8);
      System.out.println("\n****delete(10)");
      t.delete(10);
      t.traverse3();
      System.out.println("\n****Root:"+ t.getRoot());

      System.out.println("\n****delete(3)");
      t.delete(3);
      t.traverse3();

      System.out.println("\n****delete(7)");
      t.delete(7);
      t.traverse3();

      System.out.println("\n****delete(8)");
      t.delete(8);
      t.traverse3();

    }
}
