import java.util.*;

public class MergeSortedListsWOExtraSpace {
	class Node {
		int data;
		Node next;

		Node(int value) {
			this.data = value;
			next = null;
		}
	}

	Node head = null, tail = null;

	void addNode(int n) {
		Node newNode = new Node(n);

		if (head == null)
			head = tail = newNode;
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	static void display(Node head) {
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

	static Node merge(Node head1, Node head2) {
		if (head1 == null)
			return head2;

		if (head2 == null)
			return head1;

		if (head1.data < head2.data) {
			head1.next = merge(head1.next, head2);
			return head1;
		} else {
			head2.next = merge(head1, head2.next);
			return head2;
		}
	}
	public static void main(String[] args) {
		MergeSortedListsWOExtraSpace li1 = new MergeSortedListsWOExtraSpace();
		MergeSortedListsWOExtraSpace li2 = new MergeSortedListsWOExtraSpace();
		
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
		display(merge(li1.head, li2.head));
	}
}