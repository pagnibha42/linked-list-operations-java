public class GetNodeValue {
	
	static class Node {
		int data;
		Node next;

		Node(int n) {
			data = n;
			next = null;
		}
	}

	static Node head = null;
	static Node tail = null;

	static void addNode(int n) {
		Node newNode = new Node(n);

		if (head == null)
			head = tail = newNode;
		else {
			tail.next = newNode;
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
					System.out.print(current.data + " -> ");
				else
					System.out.print(current.data + "\n");

				current = current.next;
			}
	}

	static void nodeVal(int n) {
		if (head == null)
			return;

		Node current = head;
		int i = 0;

		while (current != null && i < n) {
			current = current.next;
			i++;
		} 

		if (current == null || n < 0) {
			System.out.println("Invalid index");
			return;
		}
		System.out.println(current.data);
	}

	public static void main(String[] args) {
		addNode(1);
		addNode(2);
		addNode(3);
		addNode(4);
		addNode(5);
		addNode(6);
		display();
		nodeVal(-3);

	}
}