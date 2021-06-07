
public class DeleteNode {

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

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
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

	static void delete(int n) {
		if (head == null) 
			return;

		Node current = head;

		if (n == 0)
        { 
            head = current.next;   // Change head 
            return; 
        } 
		
		int count = 0;
		while (current != null && count < n-1) {
			current = current.next;
			count++;
		}
		
		if (current == null || current.next == null)
			return;

		current.next = current.next.next;
	}

	public static void main(String[] args) {
		addNode(1);
		addNode(2);
		addNode(3);
		addNode(4);
		addNode(5);
		addNode(6);
		display();
		delete(4);
		display();
	}
}