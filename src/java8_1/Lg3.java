package java8_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Lg3 {
	public static void main(String[] args) {
		int[][] healths = {
				{200, 120, 150},
				{300, 200, 500}
		};
		int[][][] items = {
				{
					{30, 100}, {500, 30}, {100, 400}, {600, 30}
				},
				{
					{1000, 600}, {400, 500}, {300, 100}
				}
		};
		for(int i = 0; i < healths.length; i++) {
			System.out.println(Arrays.toString(solution(healths[i], items[i])));
		}
	}
	static class Item {
		int index, attack, debuf;
		public Item(int index, int attack, int debuf) {
			this.index = index;
			this.attack = attack;
			this.debuf = debuf;
		}
	}
	static int[] solution(int[] healths, int[][] items) {
	       int[] answer = {};
	       
	       PriorityQueue<Item> pq = new PriorityQueue<>((a, b) -> a.debuf - b.debuf);
	       PriorityQueue<Item> pq2 = new PriorityQueue<>((a, b) -> b.attack - a.attack);
	     
	       Arrays.sort(healths);
	       int maxHealth = healths[healths.length - 1];
	      
	       for(int i = 0; i < items.length; i++) {
	    	   if(maxHealth - items[i][1] >= 100) {
	    		   pq.add(new Item(i + 1, items[i][0], items[i][1]));
	    	   }
	       }
	       List<Integer> list = new ArrayList<>();
	       
	       for(int i = 0; i < healths.length; i++) {
	    	   while(!pq.isEmpty() && healths[i] - pq.peek().debuf >= 100) {
	    		   pq2.add(pq.poll());
	    	   }
	    	   if(!pq2.isEmpty()) {
	    		   Item item = pq2.poll();
	    		   list.add(item.index);
	    	   }
	       }
	       
	       answer = list.stream().sorted().mapToInt(a -> a).toArray();
	       return answer;
	}
}
