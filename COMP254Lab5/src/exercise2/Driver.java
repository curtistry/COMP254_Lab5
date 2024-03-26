package exercise2;

import exercise1.LinkedBinaryTree;
import exercise1.Position;

public class Driver {

	public static <E> int printPostOrder(LinkedBinaryTree<E> T, 
			Position<E> current)
	{	
		int heightL = 0;
		int heightR = 0;
		int treeHeight = 0;
		
		//get left child of node if it exists
		if (T.left(current) != null)
		{
			heightL = printPostOrder(T, T.left(current));
		}
		
		//get right child of node if it exists
		if (T.right(current) != null)
		{
			heightR = printPostOrder(T, T.right(current));
		}
		
		//increase height by 1 for each node visited
		treeHeight = Math.max(heightL, heightR) + 1;
		//visit node (postorder)
		System.out.printf("Current: %s\tHeight: %s\n",current.getElement(),treeHeight);
		return treeHeight;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		Position<Integer> p0 = tree.addRoot(1);
		Position<Integer> p1 = tree.addLeft(p0, 4);
		Position<Integer> p2 = tree.addRight(p0, 3);
		
		Position<Integer> p3 = tree.addLeft(p1, 7);
		Position<Integer> p4 = tree.addRight(p1, 9);
		
		Position<Integer> p5 = tree.addLeft(p3, 2);
		Position<Integer> p6 = tree.addRight(p3, 5);
		
		Position<Integer> p7 = tree.addLeft(p4, 12);
		Position<Integer> p8 = tree.addRight(p4, 15);
		
		//inorder(target position, the tree, the current position)
		printPostOrder(tree, tree.root());
	}

}
