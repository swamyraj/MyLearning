package com.practice.java.top.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import sun.awt.geom.AreaOp.AddOp;

public class K_LargestSmallestElementsOfArray {

	public static void main(String[] args) {

		K_LargestSmallestElementsOfArray o =new K_LargestSmallestElementsOfArray();
		
		Integer arr[] = new Integer[] { 1, 23, 12, 9, 30, 2, 50 };
		int k = 3;
		
		//O(nlogn)+O(k)
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("thirdSmallest : "+arr[k-1]);
		int thirdSmallest = Arrays.stream(arr).sorted().limit(k).sorted(Collections.reverseOrder()).findFirst().get();
		System.out.println("thirdSmallest : "+thirdSmallest);
		System.out.println();
		Arrays.stream(arr).sorted(Collections.reverseOrder()).limit(k).forEach(i -> System.out.print(i+" "));

		
		arr = new Integer[] { 1, 23, 12, 9, 30, 2, 50 };
		k = 3;

		System.out.println();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Arrays.asList(arr));
		System.out.println(minHeap);
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		System.out.println(minHeap);
		
		PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
		maxheap.addAll(Arrays.asList(arr));
		System.out.println(maxheap);
		System.out.println(maxheap.poll());
		System.out.println(maxheap.poll());
		System.out.println(maxheap);
		
		//find kth largest using heap
		//O(n)+k*log(N)
		k=2;
		for(int i =0;i<k-1;i++) {
			maxheap.poll();
		}
		System.out.println("Kth largest element : "+maxheap.peek());
		
		
		
		
		o.KthLargestFromStream();
	}
	
	//logk time complexity
	//use maxHeap to find Kth smallest
	public void KthLargestFromStream(){
		int[] arr ={ 1, 23, 12, 9, 30, 2, 50 };
		int k = 3;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i : arr) {
			System.out.println(" kth largest:"+add(minHeap,i,k));
		}
		
	}

	private int add(PriorityQueue<Integer> minHeap,int i, int k) {
		
		if(minHeap.size() < k) {
			minHeap.add(i);
			return minHeap.size()==k?minHeap.peek():-1;
		}
		if(i>minHeap.peek()) {
			minHeap.poll();
			minHeap.add(i);
		}
		return minHeap.peek();
	}
	
	

}
