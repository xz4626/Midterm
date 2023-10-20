
public class BinaryTree {
	Node root;

	public BinaryTree() {

	}

	public void add(value) {

	}

	public Node find(value) {
		return null;
	}

	public void delete(value) {

	}

	public String toString() {
		// toString should print out the contents of the
		// binary tree in sorted order
		return null;
	}

	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		b.add(5);
		b.add(2);
		b.add(10);
		b.add(54);
		b.add(20);
		b.add(23);
		b.delete(20);
		b.find(20); // returns the Integer 20
		b.find(999); // returns null
		System.out.println(b.toString());
	}
}
