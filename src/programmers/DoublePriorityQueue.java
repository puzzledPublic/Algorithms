package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

//이중 우선순위 큐
public class DoublePriorityQueue {
	public static void main(String[] args) {
		String[][] operations = {
				{"I 16", "D 1"},
				{"I 7", "I 5", "I -5", "D -1"},
				{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"},
				{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}
		};
		for(int i = 0; i < operations.length; i++) {
			System.out.println(Arrays.toString(solution(operations[i])));
		}
	}
	static int[] solution(String[] arguments) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        for(int i = 0; i < arguments.length; i++) {
        	String[] s = arguments[i].split(" ");
        	switch(s[0]) {
        	case "I":
        		maxPQ.add(Integer.parseInt(s[1]));
        		minPQ.add(Integer.parseInt(s[1]));
        		break;
        	case "D":
        		if(minPQ.isEmpty()) {
        			break;
        		}
        		if(s[1].equals("1")) {
        			int max = maxPQ.poll();
        			minPQ.remove(max);
        		}else {
        			int min = minPQ.poll();
        			maxPQ.remove(min);
        		}
        		break;
        	}
        }
        answer[0] = maxPQ.isEmpty() ? 0 : maxPQ.poll();
        answer[1] = minPQ.isEmpty() ? 0 : minPQ.poll();
        return answer;
    }
}
