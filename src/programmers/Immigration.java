package programmers;
//입국심사
public class Immigration {
	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};
		System.out.println(solution(n, times));
	}
	
	static int solution(int n, int[] times) {
        int answer = 0;
        int max = 0;	//심사원들 중 걸리는 시간의 최대값
        for(int i = 0; i < times.length; i++) {
        	if(max < times[i]) {
        		max = times[i];
        	}
        }
        long start = 1, end = (long)max * (long)n;	//시작시간 ~ 끝나는 시간 중 최대값(심사원들 중 걸리는 시간의 최대값 * 대기자 수)
        
        while(start < end) {	//이분탐색(lower bound)
        	long mid = (start + end) / 2;
        	System.out.println(start + " " + end + " " + mid);
        	int t = 0;
        	for(int i = 0; i < times.length; i++) {	//시간내에 대기자들을 모두 처리할 수 있는지 확인
        		t += mid / times[i];
        	}
        	if(t >= n) {	//시간내 처리할 수 있는 사람 수가 대기자 수 보다 크거나 같다면 시간을 줄인다.
        		end = mid;
        	}else {
        		start = mid + 1;
        	}
        }
        answer = (int)end;
        return answer;
    }
}
