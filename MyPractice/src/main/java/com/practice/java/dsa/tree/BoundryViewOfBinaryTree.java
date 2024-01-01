package com.practice.java.dsa.tree;


//
public class BoundryViewOfBinaryTree {

	static class Node<T> {

		T data;
		Node<T> left;
		Node<T> right;
		int height;

		public Node(T data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

//  		  10
//	 	20       	30
//  40     50   60   	70
//       80  90

		Node<Integer> root = new Node<>(10);
		root.left = new Node<>(20);
		root.right = new Node<>(30);
		root.left.left = new Node<>(40);
		root.left.right = new Node<>(50);
		root.left.right.left = new Node<>(80);
		root.left.right.right = new Node<>(90);
		root.right.left = new Node<>(60);
		root.right.right = new Node<>(70);

		printBoundryView(root);
	}

	private static void printBoundryView(Node<Integer> root) {
		System.out.print(root.data + " ");
		printBoundryLeft(root.left);
		printLeaves(root);
		printBoundryRight(root.right);
	}

	private static void printBoundryLeft(Node<Integer> node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			System.out.print(node.data + " ");
			printBoundryLeft(node.left);
		}else if (node.right != null) {
			System.out.print(node.data + " ");
			printBoundryLeft(node.right);
		}
	}

	private static void printLeaves(Node<Integer> node) {
		if (node == null) {
			return;
		}
		printLeaves(node.left);
		if (node.left == null && node.right == null) {
			System.out.print(node.data + " ");
		}
		printLeaves(node.right);
	}

	private static void printBoundryRight(Node<Integer> node) {
		if (node == null) {
			return;
		}
		if (node.right != null) {
			printBoundryRight(node.right);
			System.out.print(node.data + " ");
		}else if (node.left != null) {
			printBoundryRight(node.left);
			System.out.print(node.data + " ");
		}
	}


}
