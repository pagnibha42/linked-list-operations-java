import java.util.*;

public class Queue {
	static class Node {
		int data;
		Node next;

		Node (int n) {
			this.data = n;
			next = null;
		}
	}

	static Node head = null, tail = null;

	static boolean isEmpty() {
		return head == null;
	}

	static int peek() {
		if (isEmpty())
			return 0;
		return head.data;
	}

	static void add(int data) {
		Node newNode = new Node(data);
		
		if (isEmpty()) {
			head = tail = newNode;
			return;
		}

		tail.next = newNode;
		tail = newNode;
	}

	static void remove() {
		if (isEmpty()) {
			//System.out.println("Queue is empty\n\n");
			return;
		}
		//System.out.println(head.data + "\n\n");
		//Node current = head;
		head = head.next;
	}

	static void display() {
		Node current = head;

		if (isEmpty())
			System.out.println("Queue is empty\n\n");
		else
			while (current != null) {
				if(current.next != null)
					System.out.print(current.data + " -> ");
				else
					System.out.print(current.data + "\n\n");

				current = current.next;
			}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1 to add \n2 to remove \n3 to peek \n4 to check if empty \n5 to display \n0 to exit \n\nENTER CHOICE:");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("\nEnter number to be added: ");
					int n = sc.nextInt();
					add(n);
					break;
				case 2:
					if (peek() == 0)
						System.out.println("Queue is empty\n\n");
					else
						System.out.println(peek() + "\n\n");
					remove();
					break;
				case 3:
					if (peek() == 0)
						System.out.println("Queue is empty\n\n");
					else
						System.out.println(peek() + "\n\n");
					break;
				case 4:
					if (isEmpty())
						System.out.println("Queue is empty\n\n");
					break;
				case 5:
					display();
					break;
				case 0:
					System.out.println("Bye\n\n");
					break;
				default:
					System.out.println("Wrong Choice\n\n");
					break;
			}
		} while (choice != 0);
	}
}