package com.practice.java.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class DifferentViewOfBinaryTree {

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
		DifferentViewOfBinaryTree t = new DifferentViewOfBinaryTree();

		//  	    10
		//	 	20       30
		//  40     50  60   70
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
		
		System.out.print("printLeftView : ");
		t.printLeftView(root, 0);
		System.out.println();
		
		System.out.print("printRightView : ");
		t.printRightView(root, 0);
		System.out.println();

		System.out.print("printTopView : ");
		t.printTopView(root);
		System.out.println();

		System.out.print("printBottomView : ");
		t.printBottomView(root);
		System.out.println();
	}

	int maxLevelLeftView = 0;

	private void printLeftView(Node<Integer> root, int level) {
		if (root == null) {
			return;
		}
		while (level >= maxLevelLeftView) {
			System.out.print(root.data + " ");
			maxLevelLeftView++;
		}
		printLeftView(root.left, level + 1);
		printLeftView(root.right, level + 1);
	}
	
	int maxLevelRightView = 0;

	private void printRightView(Node<Integer> root, int level) {
		if (root == null) {
			return;
		}
		while (level >= maxLevelRightView) {
			System.out.print(root.data + " ");
			maxLevelRightView++;
		}
		printRightView(root.right, level + 1);
		printRightView(root.left, level + 1);
	}

	private void printTopView(Node<Integer> root) {
		if (root == null) {
			return;
		}
		Queue<Node<Integer>> q = new LinkedList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node<Integer> temp = q.remove();
			int h = temp.height;
			if (map.get(h) == null) {
				map.put(h, temp.data);
			}
			if (temp.left != null) {
				temp.left.height = h - 1;
				q.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.height = h + 1;
				q.add(temp.right);
			}
		}
		System.out.print(map.values());
	}

	private void printBottomView(Node<Integer> root) {
		if (root == null) {
			return;
		}
		Queue<Node<Integer>> q = new LinkedList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node<Integer> temp = q.remove();
			int h = temp.height;
			map.put(h, temp.data);

			if (temp.left != null) {
				temp.left.height = h - 1;
				q.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.height = h + 1;
				q.add(temp.right);
			}
		}
		System.out.print(map.values());
	}
	
}
