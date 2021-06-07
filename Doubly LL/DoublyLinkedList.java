public class DoublyLinkedList {
	static class Node {
		int data;
		Node next, previous;

		Node (int n) {
			data = n;
			next = null;
			previous = null;
		}
	}

	static Node head = null, tail = null;

	static void addNode(int n) {
		Node newNode = new Node(n);
		
		if (head == null)
			head = tail = newNode;
		else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
	}

	static void display() {
		Node current = head;

		if (head == null)
			System.out.println("List is empty");
		else
			while (current != null) {
				if(current.next != null)
					System.out.print(current.data + " <-> ");
				else
					System.out.print(current.data + "\n");

				current = current.next;
			}
	}

	static void reverseDisplay() {
		Node current = head;
		
		if (head == null)
			System.out.println("List is empty");
		else
			while (current.next != null)
				current = current.next;

		while(current != null) {
			if(current.previous != null)
					System.out.print(current.data + " <-> ");
				else
					System.out.print(current.data + "\n");

				current = current.previous;
		}
	}

	public static void main(String[] args) {
		addNode(1);
		addNode(2);
		addNode(3);
		addNode(4);
		addNode(5);
		addNode(6);
		display();
		reverseDisplay();
	}
}