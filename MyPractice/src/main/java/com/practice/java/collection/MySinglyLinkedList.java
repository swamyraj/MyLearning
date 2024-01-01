package com.practice.java.collection;

public class MySinglyLinkedList<T> {

	@SuppressWarnings("hiding")
	class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}

	}

	private Node<T> head;
	int size;

	MySinglyLinkedList() {
		this.head = null;
	}

	public void add(T element) {
		Node<T> newNode = new Node<>(element);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
	}

	public void remove() {
		head.data = null;
		head = head.next;
		size--;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for (int i = 0; i < index; i++) {
			head = head.next;
		}
		return head.data;
	}

	public void display() {
		Node<T> current = head;
		while (current != null) {
			System.out.print(" " + current.data);
			current = current.next;
		}
	}

	public static void main(String[] args) {
		MySinglyLinkedList<Integer> list = new MySinglyLinkedList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.display();
		System.out.println();
		list.remove();
		list.display();
		System.out.println();
		list.remove();
		list.display();
		System.out.println();
		System.out.println(list.get(0));
		System.out.println(list.get(2));

		list.mergeSort(list.head);
		

	}

	private Node<Integer> mergeSort(Node<Integer> head) {
		Node<Integer> result = null;
		while (head == null || head.next != null) {
			Node<Integer> mid = getMiddle(head);
			Node<Integer> nextOfMiddle = mid.next;
			mid.next = null;

			Node<Integer> left= mergeSort(head);
			Node<Integer> right= mergeSort(nextOfMiddle);
			result = merge(left, right);
		}
		
		while (result != null) {
			System.out.print(" " + result.data);
			result = result.next;
		}
		
		return result;
	}

	private Node<Integer> merge(Node<Integer> head, Node<Integer> nextOfMiddle) {
		Node<Integer> result = null;
		if (head == null)
			return nextOfMiddle;
		if (nextOfMiddle == null)
			return head;
		if (head.data <= nextOfMiddle.data) {
			result = nextOfMiddle;
			result.next = merge(head.next, nextOfMiddle);
		} else {
			result = nextOfMiddle;
			result.next = merge(head, nextOfMiddle.next);
		}
		return result;
	}

	private Node<Integer> getMiddle(Node<Integer> head) {
		Node<Integer> slow = head, fast = head;
		while (slow.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
