public class MiddleLinkedList {

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

	static void addNode(int data) {

		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	static void middleElement() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		
		current = head;
		int mid = count % 2 == 0 ? count / 2 : (count + 1) / 2;
		System.out.println(mid);
		for (int i = 1; i <= mid; i++) {
			if (i == mid) {
				System.out.println(current.data);
				break;
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {
		addNode(2);
		addNode(4);
		addNode(8);
		addNode(16);
		addNode(32);
		// addNode(64);
		middleElement();
	}

}