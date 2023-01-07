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
    public static void swap(Node root){
        if(root==null){
            return;
        }
        Node temp= root.left;
        root.left=root.right;
        root.right=temp;
    }
	public static void convertToMirror(Node root)
	{
	    if(root==null){
	        return;
	    }
	    convertToMirror(root.left);
	    convertToMirror(root.right);
	    swap(root);
	}
    public static void main(String[] args)
	{

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);

		convertToMirror(root);
		preorder(root);
	}
    
}
