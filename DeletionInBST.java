package BinaryTree;

public class DeletionInBST {
    class Node 
	{ 
		int key; 
		Node left, right; 

		public Node(int item) 
		{ 
			key = item; 
			left = right = null; 
		} 
	} 

	Node root; 

	DeletionInBST() 
	{ 
		root = null; 
	} 

	void deleteKey(int key) 
	{ 
		root = Delete(root, key); 
	} 

	Node Delete(Node root, int value) 
	{
	    if(root == null){
			return null;
		}
		else if(value < root.key){
			root.left = Delete(root.left, value);
		}
		else if(value > root.key){
			root.right = Delete(root.right, value);
		}
		else{
			if(root.left == null && root.right == null){
				return null;
			}
			else if(root.left==null){
				return root.right;
			}
			else if(root.right==null){
				return root.left;
			}
			else{
				Node temp = findInorderSuccessor(root.right);
				temp.key=root.key;
				root.right=Delete(root.right, temp.key);
			}
		}
	
		return null; 
	} 


	Node findInorderSuccessor(Node node) 
	{ 
		if(root.left!=null){
			root=root.left;
		}
		return root;
	} 

	Node insertRec(Node root, int key) 
	{ 

		if (root == null) 
		{ 
			root = new Node(key); 
			return root; 
		} 

		if (key < root.key) 
			root.left = insertRec(root.left, key); 
		else if (key > root.key) 
			root.right = insertRec(root.right, key); 

		return root; 
	} 

	void inorder() 
	{ 
		inorderRec(root); 
	} 
    
     void insert(int key) 
    { 
        root = insertRec(root, key); 
    } 
    
	void inorderRec(Node root) 
	{ 
		if (root != null) 
		{ 
			inorderRec(root.left); 
			System.out.print(root.key + " "); 
			inorderRec(root.right); 
		} 
	} 

	public static void main(String[] args) 
	{ 
		Main tree = new Main(); 

		/* Let us create following BST 
			50 
		/	 \ 
		30	 70 
		/ \ / \ 
		20 40 60 80 */
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 

		System.out.println("Inorder traversal of the given tree"); 
		tree.inorder(); 

		System.out.println("\nDelete 20"); 
		tree.deleteKey(20); 
		System.out.println("Inorder traversal of the modified tree"); 
		tree.inorder(); 

		System.out.println("\nDelete 30"); 
		tree.deleteKey(30); 
		System.out.println("Inorder traversal of the modified tree"); 
		tree.inorder(); 

		System.out.println("\nDelete 50"); 
		tree.deleteKey(50); 
		System.out.println("Inorder traversal of the modified tree"); 
		tree.inorder(); 
	} 

}
