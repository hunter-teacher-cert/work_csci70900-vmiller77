import java.io.*;
import java.util.*;

public class BSTree {
  private TreeNode root;

  public BSTree(){
    root = null;
  }

  //
  public void delete(int key){
    if(root ==null){
      return; //nothing to delete
    }

    TreeNode front = root;
    TreeNode trailer = root;

    //do piggyback loop until find Node or null
    //or if the key isn't present
    while(front!=null && front.getValue() != key){
      if(front.getValue() < key){
        trailer = front;
        front = front.getRight();
      }else{
        trailer = front;
        front = front.getLeft();
      }
    }

    //if key not in tree nothing to do
    if(front == null){
        return;
    }

    System.out.println("Front: "+ front.getValue());
    System.out.println("Trailer: "+ trailer.getValue());

    //if we get here
    //front points to node we want to delete
    //trailer points to one above it
    boolean frontHasLeft = front.getLeft() != null;
    boolean frontHasRight = front.getRight() != null;


    //case 1:
    //front is leaf - point parent to null
    if(!frontHasLeft && !frontHasRight){
      System.out.println("Case 1");
      if(isLeftChild(trailer, front)){ //front node is the left child
        trailer.setLeft(null);
      }else{//front node is right child
        trailer.setRight(null);
      }


    //case 2:
    //check to see if front has 1 child
    //TODO - if the front is the root!
    }else if(frontHasLeft && !frontHasRight){ //left child
      System.out.println("Case 2");
      System.out.println("Trailer left:"+trailer.getLeft());
      System.out.println("Trailer right:"+trailer.getRight());
      if(isLeftChild(trailer,front)){ //check if front is a left child
        trailer.setLeft(front.getLeft()); //point parent(trailer) to front's left child
      }else if(root.getValue() == front.getValue()){//front is the root
        //replace root with child
        root = front.getLeft();
      }else{//front is right child
        trailer.setRight(front.getLeft()); //point parent(trailer) to front's left child
      }

    }else if(!frontHasLeft && frontHasRight){ //right child
      System.out.println("Case 2");
      if(isLeftChild(trailer,front)){//check if front is a left child
        trailer.setLeft(front.getRight());//point parent(trailer) to front's right child
      }else if(root.getValue() == front.getValue()){//front is root
        //replace root with child
        root = front.getRight();
      }else{//front is right child
        trailer.setRight(front.getRight());//point parent(trailer) to front's right child
      }

    }
    //case 3:
    //delete node with 2 children
    else{
      System.out.println("Case 3");
      //find node with largest value on fronts left subtree(will be a leaf)
      TreeNode replacement = front.getLeft();
      while(replacement.getRight() != null){
        replacement = replacement.getRight();
      }
      // //store it in temp
      // TreeNode temp = new TreeNode(replacement.getValue());

      //delete the replacement
      delete(replacement.getValue());

      //repoint temp to fronts left and right
      replacement.setLeft(front.getLeft());
      replacement.setRight(front.getRight());

      //repoint trailer to temp
      if(isLeftChild(trailer,front)){
        trailer.setLeft(replacement);
      }else{
        trailer.setRight(replacement);
      }

    //If the one to be deleted is the root also
      if(front.getValue() == trailer.getValue()){
        this.root = replacement;
      }

    }
  }

private boolean isLeftChild(TreeNode parent, TreeNode child){
  if(parent.getLeft() == null){
    return false;
  }
  return parent.getLeft().getValue() == child.getValue();
}
//in order
  private void traverse3(TreeNode current){
      if(current==null){
        return;
      }

      //recursively print out left sub tree
      traverse3(current.getLeft());

      //process current Node
      System.out.print(current.getValue()+",");

      //recursively print out right sub tree
      traverse3(current.getRight());
  }

  public void traverse3(){
    traverse3(root);
    System.out.println();
  }

  //postOrder
  private void traverse2(TreeNode current){
      if(current==null){
        return;
      }

      //recursively print out left sub tree
      traverse2(current.getLeft());

      //recursively print out right sub tree
      traverse2(current.getRight());

      //process current Node
      System.out.print(current.getValue()+",");

  }

  public void traverse2(){
    System.out.println();
  traverse2(root);
  }
//preOrder
  private void traverse(TreeNode current){
      if(current==null){
        return;
      }

      //process current Node
      System.out.print(current.getValue()+",");

      //recursively print out left sub tree
      traverse(current.getLeft());

      //recursively print out right sub tree
      traverse(current.getRight());
  }

public void traverse(){
  traverse(root);
}
  public void insert(int key){

    TreeNode newNode = new TreeNode(key);

    //if tree is empty then manually insert new node as root
    if(root == null){
      root = newNode;
      return;
    }

    TreeNode front = root;
    TreeNode trailer = null;

    while (front!=null){
  	    int frontValue = front.getValue(); //get the current value
  	    if (frontValue == key){ //key already in tree - don't need to insert
      		return;
  	    } else if (frontValue < key){
          trailer = front;
          front = front.getRight();
  	    } else {
          trailer = front;
    		  front = front.getLeft();
  		}
  	}
    //at this point front points to null
    //but trailer points to node that's before (above) where the new node goes
    int trailerValue = trailer.getValue();
    if(trailerValue < key){//then key goes to right side
      trailer.setRight(newNode);
    }else{//then key is less than and goes to left side
      trailer.setLeft(newNode);
    }

  }

  public int search(int key){
  	TreeNode current = root;

  	while (current!=null){
  	    int currentValue = current.getValue(); //get the current value
  	    if (currentValue == key){ //found it
      		return key;
  	    } else if (currentValue < key){ //need to go to right side of tree to search higher vals
      		current = current.getRight();
  	    } else { //need to go to left  side of tree to search lower vals
    		  current = current.getLeft();
  		}
  	}
  	return -1;
  }

  public void seed(){
    TreeNode t;

    t = new TreeNode(10);
    root = t;
    t = new TreeNode(5);
    root.setLeft(t);
    t = new TreeNode(20);
    root.setRight(t);

    root.getLeft().setRight( new TreeNode(8));

    t = new TreeNode(15);
    root.getRight().setLeft(t);

    t = new TreeNode(22);
    root.getRight().setRight(t);

  }

  public TreeNode getRoot(){
    return this.root;
  }


}
