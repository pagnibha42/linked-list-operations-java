import java.util.*;

public class Stack {
	
	static class Node {
		int data;
		Node next;
		//Node previous;
		Node(int data) {
			this.data = data;
			next = null;
			//previous = null;
		}
	}

	static Node top = null;
	static Node bottom = null;

	static boolean isEmpty() {
		return top == null;
	}

	static int peek() {
		if (isEmpty())
			return 0;
		return top.data;
	}

	static void push(int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			bottom = top = newNode;
			return;
		}
		newNode.next = top;
		top = newNode;
	}

	static void pop() {
		if (isEmpty())
			return;

		top = top.next;
	}

	static void display() {
		Node current = top;

		if (isEmpty())
			System.out.println("Stack is empty\n\n");
		else
			while (current != null) {
				if(current.next != null)
					System.out.println(" " + current.data + "\n |\n \\/ ");
				else
					System.out.println(" " + current.data + "\n\n");

				current = current.next;
			}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1 to push \n2 to pop \n3 to peek \n4 to check if empty \n5 to display \n0 to exit \n\nENTER CHOICE:");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("\nEnter number to be added: ");
					int n = sc.nextInt();
					push(n);
					break;
				case 2:
					if (peek() == 0)
						System.out.println("Stack is empty\n\n");
					else
						System.out.println(peek() + "\n\n");
					pop();
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