
class Node2{
	public int data;
	public Node2 leftChild;        
	public Node2 rightChild;
	
	public Node2(int d) {
		data = d;
		leftChild = null;
		rightChild = null;
	}
   }
   
class Tree2{
	Node2 root;
	boolean isBST(){
      if (root == null){
         return true;
      }
      return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }
   boolean isBST(Node2 root, int min, int max){
      if (root == null){
         return true;
      }
      if (root.data <= min || root.data >= max){
         return false;
      }
      return isBST(root.leftChild, min, root.data) && isBST(root.rightChild, root.data, max);
   }
}
class AlgorithmTwoRecursive {
	public static void main(String[] args) {
		Tree2 theTree = new Tree2();
        theTree.root = new Node2(3);
        theTree.root.leftChild = new Node2(1);
        theTree.root.rightChild = new Node2(12);
        theTree.root.rightChild.leftChild = new Node2(5);
        theTree.root.rightChild.rightChild = new Node2(14);
        theTree.root.rightChild.rightChild.rightChild = new Node2(48);
        //theTree.root.leftChild.leftChild = new Node2(2);
          // Function call
        if (theTree.isBST())
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");
	}
}