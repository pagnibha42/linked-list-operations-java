public class CycleDetection {
	static class Node {
		int data;
		Node next;
		int flag;

		Node(int n) {
			data = n;
			next = null;
			flag = 0;
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

	static void detectCycle() {
		if (head == null) 
			return;

		Node current = head;

		while (current != null) {
			if (current.flag == 1) {
				System.out.println(current.data);
				break;
			}
			current.flag = 1;
			current = current.next;
		}
		if (current == null)
			System.out.println("No cycle detected.");
	}

	public static void main(String[] args) {
		addNode(1);
		addNode(10);
		addNode(3);
		addNode(4);
		addNode(5);
		tail.next = head.next;
		// if (head != null) {
		// 	tail.next = head.next;
		// 	tail = head;
		// }
		detectCycle();
	}
}