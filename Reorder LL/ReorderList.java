import java.util.*;

public class ReorderList {
	
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

	static void reorder() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		if (head.next == null || head.next.next == null)
			return;

		Node current = head;
		Node temp = tail;
		
		while (current.next.next != null)
			current = current.next;
				
		tail = current;
		tail.next = null;
		temp.next = head.next;
		head.next = temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1, n2, el;
		System.out.println("Enter no. of elements in 1st list: ");
		n1 = sc.nextInt();
		for (int i = 0; i < n1; i++) {
			el = sc.nextInt();
			addNode(el);
		}
		display();
		reorder();
		display();
	}
}