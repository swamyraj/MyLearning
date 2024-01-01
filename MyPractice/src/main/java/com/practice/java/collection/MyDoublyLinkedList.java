package com.practice.java.collection;

public class MyDoublyLinkedList<T> {
	int size;
	Node<T> head;
	Node<T> tail;

	public void addLast(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			Node<T> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			newNode.previous = current;
			tail = newNode;
		}
		size++;
	}

	public void addFirst(T data) {
		if (head == null) {
			addLast(data);
		} else {
			Node<T> newNode = new Node<>(data);
			head.previous = newNode;
			newNode.next = head;
			head=newNode;
		}
		size++;
	}

	public T getFirst() {
		if (size <= 0) {
			throw new IndexOutOfBoundsException();
		}
		return head.data;
	}

	public T getLast() {
		if (size <= 0) {
			throw new IndexOutOfBoundsException();
		}
		return tail.data;
	}

	public void display() {
		Node<T> current = head;
		while (current != null) {
			System.out.print(" " + current.data);
			current = current.next;
		}
	}

	class Node<T> {
		T data;
		Node<T> next;
		Node<T> previous;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}

	public static void main(String[] args) {

		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();

		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.addFirst(50);
		list.addLast(60);
		list.addLast(70);
		list.display();
		System.out.println();

		System.out.println(list.getFirst());
		System.out.println(list.getLast());

	}
}
