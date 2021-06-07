package linkedList;

public class SinglyLinkedList {
	
	static class Node {

		int data;
		Node next;

		public Node(int n) {
			this.data = n;
			this.next = null;
		}
	}

	public static Node head = null;
	public static Node tail = null;

	public static void addNode(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public static void display() {
		Node current = head;

		if (head == null)
			System.out.println("List is empty");
		else
			while (current != null) {
				if(current.next != null)
					System.out.print(current.data + " -> ");
				else
					System.out.print(current.data + "\n");

				current = current.next;
			}
	}

	// public static void main(String[] ergs) {
	// 	SinglyLinkedList sll = new SinglyLinkedList();
	// 	sll.addNode(2);
	// 	sll.addNode(4);
	// 	sll.addNode(8);
	// 	sll.addNode(16);
	// 	sll.addNode(32);
	// 	sll.addNode(64);

	// 	sll.display();
	// }
}