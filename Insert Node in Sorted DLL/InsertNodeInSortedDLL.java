public class InsertNodeInSortedDLL {
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

	static void insertNode(int n) {
		Node current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		Node newNode = new Node(n);
		while (current != null) {
			if (current.data > n) {
				if (current.previous != null) {
					newNode.previous = current.previous;
					current.previous.next = newNode;
				}
				newNode.next = current;
				current.previous = newNode;
				if (newNode.previous == null)
					head = newNode;
				break;
			}
			current = current.next;
		}
		if(current == null) {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
	}

	public static void main(String args[]) {
		// addNode(1);
		// addNode(2);
		// addNode(4);
		// addNode(6);
		// addNode(9);
		display();
		insertNode(0);
		display();		
		insertNode(9);
		display();
		insertNode(23);
		display();
	}
}