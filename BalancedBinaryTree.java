package BinaryTree;

public class BalancedBinaryTree {
   Node root;
   boolean isTreeBalanced(Node node) 
	{ 
	    int left, right;
	    if(node==null){
	        return true;
	    }
	    left = findHeight(node.left);
	    right = findHeight(node.right);
	    if(Math.abs(left-right)<=1 && isTreeBalanced(node.left) && isTreeBalanced(node.right)){
	        return true;
	    }
	    return false;
	} 

	int findHeight(Node node) 
	{ 
		if (node == null) 
			return 0; 

		return 1 + Math.max(findHeight(node.left), findHeight(node.right)); 
	}

	public static void main(String args[]) 
	{ 
		BalancedBinaryTree tree = new BalancedBinaryTree(); 
		tree.root = new Node(2); 
		tree.root.left = new Node(3); 
		tree.root.right = new Node(4); 
		tree.root.left.left = new Node(5); 
		tree.root.left.right = new Node(6); 
		tree.root.left.left.left = new Node(9); 

		if (tree.isTreeBalanced(tree.root)) 
			System.out.println("Tree is balanced"); 
		else
			System.out.println("Tree is not balanced"); 
	}
}
class Node { 
	int data; 
	Node left, right; 
	Node(int d) 
	{ 
		data = d; 
		left = right = null; 
	} 
} 
