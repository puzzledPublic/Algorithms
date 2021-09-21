package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TruckOfCrossingABridge {
	public static void main(String[] args) {
		int[] bridge_length = {2, 100, 100, 1, 4, 2, 2};
		int[] weight = {10, 100, 100, 5, 12, 5, 10};
		int[][] truck_weights = {
				{7, 4, 5, 6},
				{10},
				{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
				{4, 1, 3, 4, 2, 1},
				{4, 2, 5, 8, 6, 2, 4, 9},
				{1, 1, 1, 4, 1, 9, 1, 1},
				{9, 4, 8, 1, 5}
		};
		
		for(int i = 0; i < bridge_length.length; i++) {
			System.out.println(solution(bridge_length[i], weight[i], truck_weights[i]));
			System.out.println();
		}
	}
	static class Truck {
		int weight, time;
		public Truck(int weight, int time) {
			this.weight = weight;	//
			this.time = time;	//트럭이 다리에 진입하는 시간
		}
	}
	static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;        
        int current_weight = 0;	//현재 다리에 오른 트럭들의 총 무게
        int time = 1;
        Queue<Truck> queue = new LinkedList<>();	//현재 다리에 있는 트럭을 담는 큐
        for(int i = 0; i < truck_weights.length; i++) {
        	if(current_weight + truck_weights[i] <= weight && (!queue.isEmpty() && time - queue.peek().time < bridge_length)) {	//현재 다리 무게가 다음 트럭 무게를 버틸 수 있고, 다리에 자리가 남아있다면
        		System.out.println(truck_weights[i] + " - " + time);
        		queue.add(new Truck(truck_weights[i], time++));
        		current_weight += truck_weights[i];
        	}else {
        		int tt = 1;
        		while(!queue.isEmpty() && (current_weight + truck_weights[i] > weight || time - queue.peek().time >= bridge_length)) {	//다리 무게가 다음 트럭 무게를 버틸 수 없거나, 다리 길이만큼 버스가 차있다면 최대한 다리를 통과시킨다.
        			Truck t = queue.poll();
        			tt = t.time + bridge_length;
        			current_weight -= t.weight;		//다리를 지난 트럭 무게를 감소
        		}
        		time = tt;	//다음 트럭의 진입시간.
        		current_weight += truck_weights[i];	//현재 다리의 무게 다음 트럭 무게만큼 증가
        		System.out.println(truck_weights[i] + " - " + time);
        		queue.add(new Truck(truck_weights[i], time++));
        	}
        }
		while(!queue.isEmpty()) {
			time = queue.poll().time;
		}
		answer = time + bridge_length;
        return answer;
    }
}
