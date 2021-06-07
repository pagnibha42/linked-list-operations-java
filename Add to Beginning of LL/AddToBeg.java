import java.util.*;

public class AddToBeg {

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

	static void addToBeginning(int n) {
		Node newNode = new Node(n);

		if (head == null)
			head = tail = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
	}

	public static void main(String[] args) {
		int n, el;
		AddToBeg li1 = new AddToBeg();
		System.out.println("Enter no. of elements in list: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println("Enter elements in list: ");
		for (int i = 0; i < n; i++) {
			el = sc.nextInt();
			li1.addNode(el);
		}
		display();
		System.out.println("Enter number to be added to beginning: ");
		n = sc.nextInt();
		addToBeginning(n);
		display();
	}
}