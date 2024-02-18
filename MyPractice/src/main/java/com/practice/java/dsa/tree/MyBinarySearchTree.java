package com.practice.java.dsa.tree;

import java.util.HashSet;
import java.util.Set;

//      		8
//		3				10
//1			6					14
//		4		7			13
//
public class MyBinarySearchTree {

	static class Node {

		int data;
		Node left;
		Node right;

	}

	public Node insert(Node node, int value) {
		if (node == null) {
			Node newNode = new Node();
			newNode.data = value;
			newNode.left = null;
			newNode.right = null;
			return newNode;
		} else if (value < node.data) {
			node.left = insert(node.left, value);
		} else if (value > node.data) {
			node.right = insert(node.right, value);
		}
		return node;
	}

	// sorts asc : inorder traversal
	public void display(Node node) {
		if (node == null)
			return;
		display(node.left);
		System.out.print(" " + node.data);
		display(node.right);

	}

	public static void main(String[] args) {

		MyBinarySearchTree t = new MyBinarySearchTree();
		Node root = null;
		root = t.insert(root, 8);
		root = t.insert(root, 3);
		root = t.insert(root, 6);
		root = t.insert(root, 10);
		root = t.insert(root, 4);
		root = t.insert(root, 7);
		root = t.insert(root, 1);
		root = t.insert(root, 14);
		root = t.insert(root, 13);

		t.display(root);
		System.out.println();
		// t.deleteNode(root, 1);
		// t.deleteNode(root, 14);
		// t.deleteNode(root, 3);
		t.display(root);
		System.out.println();

		System.out.println(t.containsValue(root, 1));
		System.out.println(t.containsValue(root, 100));
		System.out.println();

		Node node = t.getParentNodeOfGivenValue(root, 8);
		Integer s = node == null ? null : node.data;
		System.out.println("parent of 8: " + s);
		System.out.println("parent of 1: " + t.getParentNodeOfGivenValue(root, 1).data);
		System.out.println("parent of 13: " + t.getParentNodeOfGivenValue(root, 13).data);
		System.out.println("parent of 6: " + t.getParentNodeOfGivenValue(root, 6).data);

		System.out.println("sibling of 6: " + t.getSiblingOfGivenValue(root, 6).data);
		System.out.println("sibling of 4: " + t.getSiblingOfGivenValue(root, 4).data);
		Node node1 = t.getSiblingOfGivenValue(root, 8);
		Integer s1 = node1 == null ? null : node1.data;
		System.out.println("sibling of 13: " + s1);
		
		t.checkIfPairExisits(root, 13, new HashSet<>());
		System.out.println();
		t.checkIfPairExisits(root, 18, new HashSet<>());
		System.out.println();
		
		System.out.println("2 nd smallest element: "+t.getKthSmallestElement(root, 2).data);
		System.out.println("9th smallest element: "+t.getKthSmallestElement(root, 9).data);
		
	}

	private Node deleteNode(Node node, int value) {

		if (node == null) {
			return null;
		}
		if (value < node.data) {
			node.left = deleteNode(node.left, value);
		} else if (value > node.data) {
			node.right = deleteNode(node.right, value);
		} else {

			if (node.left == null || node.right == null) {
				Node temp = null;
				temp = node.left == null ? node.right : node.left;
				if (temp == null) {
					return null;
				} else {
					return temp;
				}
			} else {
				Node successorNode = findSuccessorNode(node);
				node.data = successorNode.data;
				deleteNode(node.right, successorNode.data);

			}

		}

		return node;
	}

	private Node findSuccessorNode(Node node) {
		Node temp = node.right;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	public boolean containsValue(Node node, int value) {
		boolean flag = false;
		if (node == null) {
			return false;
		}
		while (node != null) {
			if (value == node.data) {
				flag = true;
				break;
			} else if (value < node.data) {
				node = node.left;
			} else if (value > node.data) {
				node = node.right;
			}

		}
		return flag;
	}

	public Node getParentNodeOfGivenValue(Node node, int value) {
		if (node == null) {
			return null;
		}

		Node previous = null;
		while (node != null) {
			if (value == node.data) {
				break;
			} else if (value < node.data) {
				previous = node;
				node = node.left;
			} else if (value > node.data) {
				previous = node;
				node = node.right;
			}
		}
		return previous;
	}
	
	public Node getSiblingOfGivenValue(Node node, int value) {
		if (node == null) {
			return null;
		}

		Node sibling = null;
		while (node != null) {
			if (value == node.data) {
				break;
			} else if (value < node.data) {
				sibling = node.right;
				node = node.left;
			} else if (value > node.data) {
				sibling = node.left;
				node = node.right;
			}
		}
		return sibling;
	}
	
	public void checkIfPairExisits(Node node, int sum, Set<Integer> set) {
		if (node == null)
			return;
		int key = sum - node.data;
		if (set.contains(key)) {
			System.out.println("Nodes (" + node.data + "," + key + ")");
		}
		set.add(node.data);
		checkIfPairExisits(node.left, sum, set);
		checkIfPairExisits(node.right, sum, set);
	}
	
	static int count=0;
	public Node getKthSmallestElement(Node node, int k) {
		if (node == null)
			return null;
		
		Node left = getKthSmallestElement(node.left, k);
		if(left!=null) {
			return left;
		}
		count++;
		if(count==k) {
			return node;
		}
		return getKthSmallestElement(node.right, k);
	}

}