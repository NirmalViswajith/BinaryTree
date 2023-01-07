package BinaryTree;
import java.util.concurrent.atomic.AtomicInteger;

public class KthLargestElement {
    public static Node insert(Node root, int key)
	{
		if (root == null) {
			return new Node(key);
		}

		if (key < root.data) {
			root.left = insert(root.left, key);
		}

		else {
			root.right = insert(root.right, key);
		}

		return root;
	}
	public static Node kthLargestBST(Node root, AtomicInteger i, int k)
	{
	    if (root == null) {
            return null;
        }
        Node left = kthLargestBST(root.right, i, k);
        if (left != null) {
            return left;
        }
        if (i.incrementAndGet() == k) {
            return root;
        }
        return kthLargestBST(root.left, i, k);
	}

	public static Node kthLargestBST(Node root, int k)
	{
		AtomicInteger i = new AtomicInteger(0);

		return kthLargestBST(root, i, k);
	}

	public static void main(String[] args)
	{
		Node root = null;
		int[] keys = { 13, 14, 22, 25, 23, 32, 26,28,40};

		for (int key : keys) {
			root = insert(root, key);
		}

		int k = 3;
		Node node = kthLargestBST(root, k);

		if (node != null) {
			System.out.print(node.data);
		}
		else {
			System.out.print("Invalid Input");
		}
	}
}
class Node
{
	int data;
	Node left = null, right = null;

	Node(int data) {
		this.data = data;
	}
}
