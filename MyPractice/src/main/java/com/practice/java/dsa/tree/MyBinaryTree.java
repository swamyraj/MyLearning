package com.practice.java.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://www.youtube.com/watch?v=ec72AqFRB7U&list=PLt4nG7RVVk1hXIW5w54uKEN25MqHNS7_A

public class MyBinaryTree<T> {

	static class Node<T> {

		T data;
		Node<T> left;
		Node<T> right;
		int height;

		public Node(T data) {
			this.data = data;
		}
	}

	private void preOrder(Node<Integer> root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	private void inOrder(Node<Integer> root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	private void postOrder(Node<Integer> root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	private void inOrderUsingStack(Node<Integer> root) {
		if (root == null)
			return;

		Stack<Node<Integer>> stack = new Stack<MyBinaryTree.Node<Integer>>();
		Node<Integer> current = root;

		while (current != null || stack.size() > 0) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.print(current.data + " ");
			current = current.right;
		}
	}
	
	private void preOrderUsingStack(Node<Integer> root) {
		if (root == null)
			return;
		
		Stack<Node<Integer>> stack = new Stack<MyBinaryTree.Node<Integer>>();
		stack.push(root);
		
		while (stack.size() > 0) {
			Node<Integer> temp = stack.pop();
			System.out.print(temp.data + " ");
			if(temp.right!=null) {
				stack.push(temp.right);
			}
			if(temp.left!=null) {
				stack.push(temp.left);
			}
		}
	}
	
	private void postOrderUsingStack(Node<Integer> root) {
		if (root == null)
			return;

		Stack<Node<Integer>> stack1 = new Stack<MyBinaryTree.Node<Integer>>();
		Stack<Node<Integer>> stack2 = new Stack<MyBinaryTree.Node<Integer>>();
		stack1.push(root);

		while (stack1.size() > 0) {
			Node<Integer> temp = stack1.pop();

			if (temp.left != null) {
				stack1.push(temp.left);
			}
			if (temp.right != null) {
				stack1.push(temp.right);
			}
			stack2.push(temp);
		}

		while (stack2.size() > 0) {
			Node<Integer> temp = stack2.pop();
			System.out.print(temp.data + " ");
		}
	}

	
	
	
	public static void main(String[] args) {

		MyBinaryTree<Integer> t = new MyBinaryTree<>();

		//  	    10
		//	 	20       30
		//  40     50  60   70
		
		Node<Integer> root = new Node<>(10);
		root.left = new Node<>(20);
		root.right = new Node<>(30);
		root.left.left = new Node<>(40);
		root.left.right = new Node<>(50);
		root.right.left = new Node<>(60);
		root.right.right = new Node<>(70);

		System.out.print("preOrder : ");
		t.preOrder(root);
		System.out.println();
		
		System.out.print("preOrderUsingStack : ");
		t.preOrderUsingStack(root);
		System.out.println();
		
		System.out.print("inOrder : ");
		t.inOrder(root);
		System.out.println();
		
		System.out.print("inOrderUsingStack : ");
		t.inOrderUsingStack(root);
		System.out.println();
		
		System.out.print("postOrder : ");
		t.postOrder(root);
		System.out.println();
		
		System.out.print("postOrderUsingStack : ");
		t.postOrderUsingStack(root);
		System.out.println();
		
		System.out.print("printLeaves : ");
		t.printLeaves(root);
		System.out.println();
		
		System.out.println();
		int count = t.countOfNodes(root);
		System.out.println("countOfNodes : "+count);
		
		System.out.println();
		int countOfLeafNodes = t.countOfLeafNodes(root);
		System.out.println("countOfLeafNodes : "+countOfLeafNodes);
		
		System.out.println();
		int sum = t.sumOfNodes(root);
		System.out.println("sumOfNodes : "+sum);
		
		System.out.println();
		int diff = t.differencesOfEvenAndAddNodes(root);
		System.out.println("differencesOfEvenAndAddNodes : "+diff);
		
		System.out.println();
		int height = t.heightOfTree(root);
		System.out.println("heightOfTree : "+height);
		
		System.out.println();
		System.out.print("printNodesOfGivenLevel : ");
		t.printNodesOfGivenLevel(root,3);
		
		System.out.println();
		System.out.println();
		System.out.print("printValuesInLevelOrder : ");
		t.printValuesInLevelOrder(root);
		
		System.out.println();
		System.out.println();
		System.out.print("printValuesInLevelOrderFromBottom : ");
		t.printValuesInLevelOrderFromBottom(root);
		
		System.out.println();
		System.out.println();
		System.out.print("printValuesInLevelOrderUsingQueue : ");
		t.printValuesInLevelOrderUsingQueue(root);
		
		System.out.println();
		System.out.println();
		System.out.print("printValuesInLevelOrderFromBottomUsingQueueAndStack : ");
		t.printValuesInLevelOrderFromBottomUsingQueueAndStack(root);
		
	}

	private void printLeaves(Node<Integer> node) {
		if (node == null) {
			return;
		}
		printLeaves(node.left);
		if(node.left==null && node.right==null) {
			System.out.print(node.data+" ");
		}
		printLeaves(node.right);
	}
	
	private int countOfNodes(Node<Integer> root) {
		if (root == null)
			return 0;
		return 1 + countOfNodes(root.left) + countOfNodes(root.right);
	}
	
	private int countOfLeafNodes(Node<Integer> root) {
		if (root == null)
			return 0;
		if(root.left==null && root.right==null) {
			return 1;
		}
		return countOfLeafNodes(root.left)+countOfLeafNodes(root.right);
	}
	
	private int sumOfNodes(Node<Integer> root) {
		if (root == null)
			return 0;
		return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
	}

	private int differencesOfEvenAndAddNodes(Node<Integer> root) {
		if (root == null)
			return 0;
		return root.data - differencesOfEvenAndAddNodes(root.left) - differencesOfEvenAndAddNodes(root.right);
	}
	
	private int heightOfTree(Node<Integer> root) {
		if(root==null) {
			return -1;
		}
		return (Math.max(heightOfTree(root.left),heightOfTree(root.right)))+1;	
	}
	
	private void printNodesOfGivenLevel(Node<Integer> root, int level) {
		if (level == 0) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data + " ");
			return;
		}
		printNodesOfGivenLevel(root.left, level - 1);
		printNodesOfGivenLevel(root.right, level - 1);
	}

	//O(n)2
	private void printValuesInLevelOrder(Node<Integer> root) {
		if (root == null)
			return;
		int height = heightOfTree(root);
		for (int i = 1; i <= height+1; i++) {
			printNodesOfGivenLevel(root, i);
		}
	}
	
	private void printValuesInLevelOrderFromBottom(Node<Integer> root) {
		if (root == null)
			return;
		int height = heightOfTree(root);
		for (int i = height+1; i >= 1; i--) {
			printNodesOfGivenLevel(root, i);
		}
	}
	
	
	private void printValuesInLevelOrderUsingQueue(Node<Integer> root) {
		if (root == null)
			return;
		Queue<Node<Integer>> q = new LinkedList<MyBinaryTree.Node<Integer>>();
		q.add(root);
		while (!q.isEmpty()) {
			Node<Integer> node = q.remove();
			System.out.print(node.data + " ");
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}

		}
	}
	
	private void printValuesInLevelOrderFromBottomUsingQueueAndStack(Node<Integer> root) {
		if (root == null)
			return;
		Queue<Node<Integer>> q = new LinkedList<MyBinaryTree.Node<Integer>>();
		Stack<Integer> stack = new Stack<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node<Integer> node = q.remove();
			stack.push(node.data);

			if (node.right != null) {
				q.add(node.right);
			}
			if (node.left != null) {
				q.add(node.left);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	

}
