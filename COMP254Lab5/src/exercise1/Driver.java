package exercise1;

import java.util.LinkedList;

import exercise1.LinkedBinaryTree.Node;

public class Driver {
	
	
	public static <E> Boolean inOrderNext(Position<E> p, LinkedBinaryTree<E> T, 
			Position<E> current,Boolean reached)
	{	
		
		//get left child of node if it exists
		
		if (T.left(current) != null)
		{
			reached = inOrderNext(p, T, T.left(current),reached);
		}
		
		if (current.equals(p))
		{
			reached = true;
		}
		else if (!current.equals(p) && reached == true)
		{
			//return the node following the target node
			System.out.printf("This should return %s\n",current.getElement());
			return true;
		}
		//visit node (inorder)
		System.out.printf("Current: %s\tTarget: %s\tReached: %s\n",current.getElement(),p.getElement(),reached);

		if (T.right(current) != null)
		{
			reached = inOrderNext(p, T, T.right(current),reached);
		}
		return reached;
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
		Position<Integer> target = p6;
		inOrderNext(target, tree, tree.root(),false);
		//System.out.println(next.getElement());
	}

}
