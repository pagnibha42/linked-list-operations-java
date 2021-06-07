import java.util.*;

public class ListSum {
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

	int listToNum() {
		if (head == null)
			return 0;

		Node current = head;		
		int num = 0;
		while (current != null) {
			num = num * 10 + current.data;
			current = current.next;
		}
		int temp = num, rem, sum = 0;
		while (temp > 0) {
			rem = temp % 10;
			sum = sum * 10 + rem;
			temp /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		ListSum li1 = new ListSum();
		ListSum li2 = new ListSum();
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
		n1 = li1.listToNum();
		n2 = li2.listToNum();
		
		int sum = n1 + n2;
		int temp = sum, rem;
		ListSum liSum = new ListSum();
		
		while (temp > 0) {
			rem = temp % 10;
			//rev = rev * 10 + rem;
			liSum.addNode(rem);
			temp /= 10;
		}
		liSum.display();
	}
}