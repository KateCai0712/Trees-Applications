import java.io.*;
import java.util.*;               // for Stack class if needed
////////////////////////////////////////////////////////////////
class Node
   {
   public int iData;              // data item (key)
   public double dData;           // data item
   public Node leftChild;         // this node's left child
   public Node rightChild;        // this node's right child
   
   public Node(int i, double d) {
		iData = i;
		dData = d;
		leftChild = null;
		rightChild = null;
	}
   public Node() {
	   
   }

   }  // end class Node  
////////////////////////////////////////////////////////////////
class Tree
   {
   private Node root;             // first node of tree
   //ArrayList<Integer> arr = new ArrayList<Integer>();
// -------------------------------------------------------------
   public Tree()                  // constructor
      { setRoot(null); }            // no nodes in tree yet
   public Node getRoot() {
	   return root;
   }
   public void setRoot(Node root) {
	this.root = root;
   }
   public void insert(int id, double dd) //this method inserts a node of (id and dd) into the tree. (We are consider a BINARY SEARCH TREE by iData)
   {
	  Node newNode = new Node();    
	   newNode.iData = id;           
	   newNode.dData = dd;
	   if(getRoot()==null)                
	      setRoot(newNode);
	   else                          
	      {
	      Node current = getRoot();       
	      Node parent;
	      while(true)                
	         {
	         parent = current;
	         if(id < current.iData)  
	            {
	            current = current.leftChild;
	            if(current == null)  
	               {                 
	               parent.leftChild = newNode;
	               return;
	               }
	            }  
	         else                    
	            {
	            current = current.rightChild;
	            if(current == null)  
	               {                 
	               parent.rightChild = newNode;
	               return;
               }
            }  
         }  
      }  
   }  // end insert()
   private void inOrder(Node localRoot) //implement in Order traversal
   {
	   if(localRoot != null)
    {
	       inOrder(localRoot.leftChild);
	       System.out.print(localRoot.iData + " ");
	       inOrder(localRoot.rightChild);
    }
   }
   public ArrayList<Integer> inOrderArrayList(Node localRoot, ArrayList<Integer> arr) {
	   if(localRoot != null)
       {
		   inOrderArrayList(localRoot.leftChild, arr);
	       arr.add(localRoot.iData);
	       inOrderArrayList(localRoot.rightChild, arr);
       }
	   
       return arr;
   }
   public ArrayList<Integer> initializeArrayList(){
	   ArrayList<Integer> arr = new ArrayList<>();
	   return inOrderArrayList(root, arr);
   }
   public Boolean isOrNotBST(Node localRoot) {
   	//System.out.println("Size is " + initializeArrayList().size());
   	for(int i=0; i<initializeArrayList().size()-1; i++) {
   		//System.out.print(initializeArrayList().get(i) + " ");
   		if(initializeArrayList().get(i)>initializeArrayList().get(i+1))
   			return false;
   	}
   	return true;
   }
   
   public void isTreeBST(Node localRoot) //this method will take a tree as an input and will PRINT to the screen if the tree is a BST or NOT.
   {
   	if (isOrNotBST(localRoot))
   		System.out.println("The tree is a BST.");
   	else
   		System.out.println("The tree is NOT a BST.");
   } 
  }
   class AlgorithmOne
   {
   public static void main(String[] args) throws IOException
      {

      //You can modify this code of the main as much as you want - as longs as  ALL the methods above are being tested and called. 


      int value;
      int idata;
      Double dData;

      Tree theTree = new Tree();

       //... you change these inputs to build the tree, and/or can add other inputs to test the program. 
      //The tree is ordered by iData.  


      theTree.insert(50, 1.5);
      theTree.insert(25, 1.2);
      theTree.insert(75, 1.7);
      theTree.insert(12, 1.5);
      theTree.insert(37, 1.2);
      theTree.insert(43, 1.7);
      theTree.insert(30, 1.5);
      theTree.insert(33, 1.2);
      theTree.insert(87, 1.7);
      theTree.insert(93, 1.5);
      theTree.insert(97, 1.5);
      //theTree.getRoot().leftChild = new Node(100, 1.2);
      
	//System.out.println("Size is " + theTree.inOrderArrayList(theTree.getRoot(),theTree.arr).size());
	theTree.isTreeBST(theTree.getRoot());
      }
   }