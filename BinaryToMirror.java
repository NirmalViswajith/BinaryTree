package BinaryTree;

public class BinaryToMirror {
    public static class Node
    {
    	int data;
    	Node left = null, right = null;
    
    	Node(int data) {
    		this.data = data;
    	}
    }
   
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data+ "");
        preorder(root.left);
        preorder(root.right);
    }
	public static Node convertToMirror(Node root)
	{
	    if(root==null){
	        return null;
	    }
	    Node left = convertToMirror(root.left);
	    Node right = convertToMirror(root.right);
	    root.left = right;
	    root.right=left;
	    return root;
	    
	}

	public static void main(String[] args)
	{

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);

		
		
		
		preorder(convertToMirror(root));
	}    
}
