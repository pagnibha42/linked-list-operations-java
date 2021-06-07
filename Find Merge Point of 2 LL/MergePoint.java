import java.util.*;

public class MergePoint {
	
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

	static void mergePoint(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			System.out.println("No merge points");
			return;
		}
		
		Node current1 = head1;
		Node current2 = head2;
		
		int merge = 0, flag = 1;
		
		while (current1 != null) {
	
			while(current2 != null) {
				//System.out.println(current1.data + "  " + current2.data);
				if (current1.data == current2.data) {
					Node check1 = current1.next;
					Node check2 = current2.next;
					//System.out.println("check");
					while (check1 != null && check2 != null) {
						flag = 0;
						if (check1.data != check2.data || ((check1.next == null && check2.next != null) || (check2.next == null && check1.next != null))) {
							flag = 1;
							break; 
						}
			
						check1 = check1.next;
						check2 = check2.next;
					}
				}
			
				if (flag == 0) {
					merge = current1.data;
					break;
				}
				current2 = current2.next;
			}
			
			if (flag == 0)
				break;
			current2 = head2;
			current1 = current1.next;
		}
		if (flag == 1)
			System.out.println("No Merge Points");
		else
			System.out.println("Merge point: " + merge);
	}

	public static void main(String[] args) {
		MergePoint li1 = new MergePoint();
		MergePoint li2 = new MergePoint();
		Scanner sc = new Scanner(System.in);
		
		int n1, n2, el;
		
		System.out.println("Enter no. of elements in 1st list: ");
		n1 = sc.nextInt();
		System.out.println("Enter elements line by line.");
		for (int i = 0; i < n1; i++) {
			el = sc.nextInt();
			li1.addNode(el);
		}

		System.out.println("Enter no. of elements in 2nd list: ");
		n2 = sc.nextInt();
		System.out.println("Enter elements line by line.");
		for (int i = 0; i < n2; i++) {
			el = sc.nextInt();
			li2.addNode(el);
		}

		li1.display();
		li2.display();

		mergePoint(li1.head, li2.head);
	}
}