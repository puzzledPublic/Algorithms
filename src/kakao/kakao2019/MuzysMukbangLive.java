package kakao.kakao2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//4번 무지의 먹방 라이브
public class MuzysMukbangLive {
	public static void main(String[] args) {
		int[][] food_times = {
				{3, 1, 2},
				{1, 6, 10},//1 <= length <= 200,000, 1 <= element <= 100,000,000
		};
		int[] k = {5, 10};						//1 <= k <= 2 * 10^13
		
		for(int i = 0; i < food_times.length; i++) {
			System.out.println(solution(food_times[i], k[i]));
		}
	}
	
	static class Food {
		int index, leftTime;
		public Food(int index, int leftTime) {
			this.index = index;
			this.leftTime = leftTime;
		}
	}
	//ex food_times = [10, 1, 6], k = 10일 경우
	//food_times 를 오름차순으로 정렬 [1, 6, 10]
	//(가장 낮은 시간 * 남은 음식개수) <= k라면 (가장 낮은 시간 * 남은 음식개수)의 시간만큼 지나고 가장 처음으로 돌아올 수 있다.
	//위의 예에서 (1 * 3) <= 10이므로 3초를 지나면 food_times = [9, 0, 5]가 되며 index 1번을 먹을차례가 된다.
	//그런데 priorityQueue를 모두 돌며 (ex 3초의) 시간을 빼면 시간이 오래 걸리므로 전에 사용한 시간(prevTime)을 가지고 빠르게 계산할 수 있다.(오름차순이므로 뒤에것의 시간이 0이 되지는 않는다)
	//(가장 낮은 시간 * 남은 음식개수) > k라면 현재 남은 음식들을 k시간 내에 먹을 수 있다는 뜻이며 k를 빠르게 줄이기 위해 ((k / 남은 음식개수) * 남은 음식개수) 만큼 k에서 뺄 수 있다.
	//그렇게 되면 다음에 먹을 음식은 제일 앞의 인덱스가 되고 k <= 남은 음식개수가 된다. (예외는 남은 음식이 없을 수 있다)
	static int solution(int[] food_times, long k) {
        int answer = -1;	//먹을것이 없다면 -1출력
        PriorityQueue<Food> pq = new PriorityQueue<>((a, b) -> a.leftTime - b.leftTime);	//먹는 시간 별로 오름차순 정렬

        for(int i = 0; i < food_times.length; i++) {
        	pq.add(new Food(i + 1, food_times[i]));
        }
        int prevTime = 0;	//전에 사용한 시간
        while(!pq.isEmpty()) {
        	int size = pq.size();	//현재 남아있는 음식 수
        	if((long)(pq.peek().leftTime - prevTime) * size <= k) {		//(가장 낮은 시간 * 남은 음식개수) <= k라면
        		int leftTime = pq.poll().leftTime;
        		k -= ((long)leftTime - prevTime) * size;	//지난시간만큼 k에서 뺀다.
        		prevTime = leftTime;	//현재 시간을 전에 사용한 시간으로 변경
        	}else {		//(가장 낮은 시간 * 남은 음식개수) > k라면
        		long t = k / size;	//(k / 남은 음식개수)
        		k -= t * size;		//k -= (k / 남은 음식개수) * 남은 음식개수
        		break;
        	}
        }
        List<Food> list = new ArrayList<>();
        while(!pq.isEmpty()) {
        	Food f = pq.poll();
        	if(f.leftTime > 0) {	//인덱스 순 정렬을 위해 현재 남아있는 음식들을 리스트에 따로 저장
        		list.add(f);
        	}
        }
                
        if(!list.isEmpty()) {	//리스트가 비었다면 음식을 모두 먹은것.
        	Collections.sort(list, (a, b) -> a.index - b.index);	//인덱스 순으로 정렬
        	answer = list.get((int)k).index;	//처음에서 k번째만큼 떨어진 음식이 다음에 먹을 음식.
        }
        
        return answer;
    }
}
