import java.util.*;

public class PalindromList {
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

	static void palindromeCheck() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		
		Node current = head;
		int num = 0, revnum = 0, rem, temp;
		
		while (current != null) {
			if (current.data / 10 != 0) {
				System.out.println("Non-single element detected. Not a palindrome");
				return;
			}
			num = num * 10 + current.data;
			current = current.next;
		}

		temp = num;
		
		while (temp > 0) {
			rem = temp%10;
			revnum = revnum * 10 + rem;
			temp /= 10;
		}

		if (num == revnum)
			System.out.println("Palindrome List");
		else
			System.out.println("Not a palindrome list");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, el;
		System.out.println("Enter no. of elements in list: ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			el = sc.nextInt();
			addNode(el);
		}
		display();
		palindromeCheck();
	}
}