public class ReverseLinkedList {

	class Node {

		int data;
		Node next;
		
		Node(int n)	{
			data = n;
			next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

	public void addNode(int data) {

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
	
	//Using iteration
	public void reverseNode() {
		Node previous = null;
		Node current = head;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}
	

	/*
	Using Recursion */
	// public Node reverseNode(Node head) {
	// 	if (head == null || head.next == null)
	// 		return head;

	// 	Node rest = reverseNode(head.next);
	// 	head.next.next = head;
	// 	head.next = null;

	// 	return rest;
	// }

	public void display() {
		Node current = head;
		if (head == null)
			System.out.println("List is empty");
		else {
			while (current != null) {
				if(current.next != null)
					System.out.print(current.data + " -> ");
				else
					System.out.print(current.data + "\n");

				current = current.next;
			}
		}
	}

	public static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		rll.addNode(2);
		rll.addNode(4);
		rll.addNode(8);
		rll.addNode(16);
		rll.addNode(32);
		rll.addNode(64);
		rll.display();
		rll.reverseNode();
		rll.display();
	}
}