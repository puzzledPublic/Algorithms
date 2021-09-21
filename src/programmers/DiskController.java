package programmers;

import java.util.PriorityQueue;

//디스크 컨트롤러
public class DiskController {
	public static void main(String[] args) {
		int[][][] jobs = {
				{{0, 3}, {1, 9}, {2, 6}},
				{{0, 11}, {2, 6}},
				{{2, 6}, {5, 2}},
				{{1, 9}, {2, 6}}
		};
		
		for(int i = 0; i < jobs.length; i++) {
			System.out.println(solution(jobs[i]));
		}
	}
	static class Job {
		int index, startTime, spendTime;
		public Job(int index, int startTime, int spendTime) {
			this.index = index;
			this.startTime = startTime;
			this.spendTime = spendTime;
		}
	}
	//SJF 스케줄링 알고리즘 (평균 대기시간, 반환시간을 최소화 한다)
	static int solution(int[][] jobs) {
        int answer = 0;
        //먼저 도착한 순으로 정렬
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
        	int diff = a.startTime - b.startTime;
        	if(diff == 0) {
        		return a.spendTime - b.spendTime;
        	}
        	return diff;
        });
        
        PriorityQueue<Job> pq2 = new PriorityQueue<>((a, b) -> {
        	int diff = a.spendTime - b.spendTime;
        	if(diff == 0) {
        		return a.startTime - b.startTime;
        	}
        	return diff;
        });
        
        for(int i = 0; i < jobs.length; i++) {
        	pq.add(new Job(i, jobs[i][0], jobs[i][1]));
        }
        //제일 먼저 도착한 프로세스부터 시작
        int endTime = pq.peek().startTime + pq.peek().spendTime;
        int result = pq.peek().spendTime;	//프로세스들의 대기시간 + 실행시간.
        pq.poll();
        Job current;
        while(!pq.isEmpty()) {
        	while(!pq.isEmpty() && pq.peek().startTime <= endTime) {	//현재 실행되는 프로세스가 끝나는 시점 전에 도착하는 프로세스들을 우선순위 큐에 담는다.
        		pq2.add(pq.poll());
        	}
        	if(pq2.isEmpty()) {		//담긴게 없으면 프로세스가 끝난 후에 프로세스가 도착한다는 뜻.
        		current = pq.poll();
        		endTime = current.startTime + current.spendTime;
        		result += current.spendTime;
        	}else {		//우선순위 큐에서 프로세스를 하나 꺼내 실행(이때 우선순위 큐는 프로세스 실행시간이 가장 짧은 순으로 갖는다). 끝나는 시점을 갱신한다.
        		current = pq2.poll();
        		endTime += current.spendTime;
        		result += endTime - current.startTime;
        	}
        }
        while(!pq2.isEmpty()) {		//아직 큐에 남은 프로세스가 있으면 하나씩 꺼내 실행.
        	current = pq2.poll();
        	endTime += current.spendTime;
        	result += endTime - current.startTime;
        }
        
        answer = result / jobs.length;	//평균을 낸다.
        return answer;
    }
}
