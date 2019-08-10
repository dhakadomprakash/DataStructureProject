// A complete working Java program to demonstrate all insertion methods 
// on linked list 
class LinkedList {
	Node head; // head of list

	/* Linked list Node */
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Inserts a new Node at front of the list. */
	void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Inserts a new node after the given prev_node. */
	public void insertAfter(Node prev_node, int new_data) {
		/* 1. Check if the given Node is null */
		if (prev_node == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}

		/*
		 * 2 & 3: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 4. Make next of new Node as next of prev_node */
		new_node.next = prev_node.next;

		/* 5. make next of prev_node as new_node */
		prev_node.next = new_node;
	}

	/*
	 * Appends a new node at the end. This method is defined inside LinkedList class
	 * shown above
	 */
	public void append(int new_data) {
		/*
		 * 1. Allocate the Node & 2. Put in the data 3. Set next as null
		 */
		Node new_node = new Node(new_data);

		/*
		 * 4. If the Linked List is empty, then make the new node as head
		 */
		if (head == null) {
			head = new Node(new_data);
			return;
		}

		/*
		 * 4. This new node is going to be the last node, so make next of it as null
		 */
		new_node.next = null;

		/* 5. Else traverse till the last node */
		Node last = head;
		while (last.next != null)
			last = last.next;

		/* 6. Change the next of last node */
		last.next = new_node;
		return;
	}

	/*
	 * This function prints contents of linked list starting from the given node
	 */
	public void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}

	void deleteNode(int key) {
		Node temp = head, prev = null;

		// -if head node itself hold the key to be deleted

		if (head != null && temp.data == key) {
			head = temp.next;
			return;
		}
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null)
			return;
		prev.next = temp.next;
	}

	/*
	 * Function to get the nth node from the last of a linked list
	 */
	void printNthFromLast(int n) {
		int len = 0;
		Node temp = head;

		// 1) count the number of nodes in Linked List
		while (temp != null) {
			temp = temp.next;
			len++;
		}

		// check if value of n is not more than length of
		// the linked list
		if (len < n)
			return;

		temp = head;

		// 2) get the (len-n+1)th node from the beginning
		for (int i = 1; i < len - n + 1; i++)
			temp = temp.next;

		System.out.println(temp.data);
	}

	/* Function to print middle of linked list */
	void printMiddle() {
		Node slow_ptr = head;
		Node fast_ptr = head;
		if (head != null) {
			while (fast_ptr != null && fast_ptr.next != null) {
				fast_ptr = fast_ptr.next.next;
				slow_ptr = slow_ptr.next;
			}
			System.out.println("The middle element is [" + slow_ptr.data + "] \n");
		}
	}

	/*
	 * Counts the no. of occurences of a node (search_for) in a linked list (head)
	 */
	int count(int search_for) {
		Node current = head;
		int count = 0;
		while (current != null) {
			if (current.data == search_for)
				count++;
			current = current.next;
		}
		return count;
	}

	/*
	 * Driver program to test above functions. Ideally this function should be in a
	 * separate user class. It is kept here to keep code compact
	 */
	public static void main(String[] args) {
		/* Start with the empty list */
		LinkedList llist = new LinkedList();

		// Insert 6. So linked list becomes 6->NUllist
		llist.append(6);

		// Insert 7 at the beginning. So linked list becomes
		// 7->6->NUllist
		llist.push(7);

		// Insert 1 at the beginning. So linked list becomes
		// 1->7->6->NUllist
		llist.push(1);

		// Insert 4 at the end. So linked list becomes
		// 1->7->6->4->NUllist
		llist.append(4);

		// Insert 8, after 7. So linked list becomes
		// 1->7->8->6->4->NUllist
		llist.insertAfter(llist.head.next, 8);
		llist.deleteNode(4);
		llist.printMiddle();

		System.out.println("\nCreated Linked list is: ");
		llist.printList();
	}
}
// This code is contributed by Rajat Mishra 
