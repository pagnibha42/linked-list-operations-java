import java.util.*;

public class RemoveDuplicates {
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

	static void duplicateRemoval() {
		if (head == null) {
			System.out.println("Empty list");
			return;
		}

		Node current = head;

		while (current != null) {
			if (current.next == null)
				break;

			if (current.data == current.next.data) {
				current.next = current.next.next;
			}
			else
				current = current.next;
		}
		display();
	}

	public static void main(String[] args) {
		// addNode(1);
		// addNode(2);
		// addNode(2);
		// addNode(2);
		// addNode(3);
		// addNode(3);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of elements: ");
		int n = sc.nextInt();
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		if (n > 0) {
			System.out.println("Enter elements in one line by giving space: ");
			String[] els = sc.nextLine().split(" ");
			for (int i = 0; i < els.length; i++) 
				addNode(Integer.parseInt(els[i]));
		}
		display();
		duplicateRemoval();
	}
}