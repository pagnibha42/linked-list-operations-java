import java.util.*;

public class MergeSortedLists {
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

	static MergeSortedLists merge(Node head1, Node head2) {
		MergeSortedLists li = new MergeSortedLists();
		Node current1 = head1;
		Node current2 = head2;
		if (current1 == null && current2 == null)
			return null;
		while(current1 != null || current2 != null) {
			if (current1 == null) {
				li.addNode(current2.data);
				current2 = current2.next;
			}
			else if (current2 == null) {
				li.addNode(current1.data);
				current1 = current1.next;
			}
			else if (current1.data < current2.data) {
				li.addNode(current1.data);
				current1 = current1.next;
			} else if (current1.data > current2.data) {
				li.addNode(current2.data);
				current2 = current2.next;
			} else {
				li.addNode(current1.data);
				li.addNode(current2.data);
				current1 = current1.next;
				current2 = current2.next;
			}
		}
		return li;
	}

	public static void main(String[] args) {
		MergeSortedLists li1 = new MergeSortedLists();
		MergeSortedLists li2 = new MergeSortedLists();
		
		Scanner sc = new Scanner(System.in);
		int n1, n2, el;
		System.out.println("Enter no. of elements in 1st list: ");
		n1 = sc.nextInt();
		System.out.println("Enter elements in sorted manner line by line.");
		for (int i = 0; i < n1; i++) {
			el = sc.nextInt();
			li1.addNode(el);
		}

		System.out.println("Enter no. of elements in 2nd list: ");
		n2 = sc.nextInt();
		System.out.println("Enter elements in sorted manner line by line.");
		for (int i = 0; i < n2; i++) {
			el = sc.nextInt();
			li2.addNode(el);
		}

		li1.display();
		li2.display();

		MergeSortedLists li = merge(li1.head, li2.head);
		if (li != null)
			li.display();
	}
}