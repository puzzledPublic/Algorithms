package java8;

import java.util.Comparator;
import java.util.PriorityQueue;


public class MedianNumber {
	public static void main(String[] args) {
		
		Integer[] integ = {3, 5, 9, 10, 2};
		
		PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>((a, b) -> { return a - b; });
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>((a, b) -> { return b - a; });
		
		for(Integer i : integ) {
			
			if(minQueue.size() == maxQueue.size()) {
				maxQueue.add(i);
			}else {
				minQueue.add(i);
			}
			if(!minQueue.isEmpty() && !maxQueue.isEmpty() && maxQueue.peek() > minQueue.peek()) {
				Integer a = minQueue.poll();
				Integer b = maxQueue.poll();
				maxQueue.add(a);
				minQueue.add(b);
			}
			System.out.println("added number is " + i);
			if(minQueue.size() == maxQueue.size()) {
				System.out.println("median number is " + (maxQueue.peek() + minQueue.peek())/2);
			}
			else {
				System.out.println("median number is " + maxQueue.peek());
			}
		}
		
	}
}
