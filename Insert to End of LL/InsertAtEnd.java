import java.util.*;

public class InsertAtEnd {
	
	static class Node{
		int data;
		Node next;

		Node(int n) {
			data = n;
			next = null;
		} 
	}

	static Node head = null;
	static Node tail = null;

	static void addNode(int data) {
		Node newNode = new Node(data);

		if(head == null) {
			head = newNode;
			tail = newNode; 
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	static void reverse() {
		Node current = head;
		Node previous = null;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
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

	public static void main(String[] args) {
		addNode(1);
		addNode(2);
		addNode(3);
		addNode(4);
		display();
		Scanner sc = new Scanner(System.in);
		String[] datas = sc.nextLine().split(" ");
		for (int i = 0; i < datas.length; i++) {
			addNode(Integer.parseInt(datas[i]));
		}
		display();
		reverse();
		display();
	}
}