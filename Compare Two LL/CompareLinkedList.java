import java.util.*;

public class CompareLinkedList {
	class Node {
		int data;
		Node next;

		Node(int n) {
			data = n;
			next = null;
		}
	}

	Node head = null;
	Node tail = null;

	void addNode(int n) {
		Node newNode = new Node(n);

		if (head == null)
			head = tail = newNode;
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	void display() {
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

	static boolean compare(CompareLinkedList li1, CompareLinkedList li2) {
		int flag = 0;
		Node current1 = li1.head, current2 = li2.head;
		
		while (current1 != null && current2 != null) {
			if (current1.data != current2.data) {
				flag = 1;
				break;
			}
			current1 = current1.next;
			current2 = current2.next;
		}
		
		if (flag == 0)
			return true;
		return false;
	}

	public static void main(String[] args) {
		CompareLinkedList li1 = new CompareLinkedList();
		CompareLinkedList li2 = new CompareLinkedList();
		Scanner sc = new Scanner(System.in);
		int n1, n2, el;
		System.out.println("Enter no. of elements in 1st list: ");
		n1 = sc.nextInt();
		for (int i = 0; i < n1; i++) {
			el = sc.nextInt();
			li1.addNode(el);
		}

		System.out.println("Enter no. of elements in 2nd list: ");
		n2 = sc.nextInt();
		for (int i = 0; i < n2; i++) {
			el = sc.nextInt();
			li2.addNode(el);
		}
		
		li1.display();
		li2.display();

		if (n1 != n2)
			System.out.println("Different list");
		else {
			if (compare(li1, li2))
				System.out.println("Same list");
			else
				System.out.println("Different list");
		}
	}
}