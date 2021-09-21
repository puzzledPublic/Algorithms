package programmers;
//예산
public class Budget {
	public static void main(String[] args) {
		
		int[][] budgets = {
				{120, 110, 140, 150},
				{1, 1, 100},
				{70, 80, 30, 40, 100},
				{120, 100, 100, 165},
		};
		int[] M = {485, 10000, 450, 485};
		
		for(int i = 0; i < budgets.length; i++) {			
			System.out.println(solution(budgets[i], M[i]));
		}
	}
	
	static int solution(int[] budgets, int M) {
        int answer = 0;
        int start = 1, mid = 0, end = 0, totalBuget = 0;
        for(int i = 0; i < budgets.length; i++) {	//budgets중 최대 요구예산을 찾는다.
        	if(end < budgets[i]) {
        		end = budgets[i];
        	}
        }
        while(start <= end) {	//이분탐색
        	mid = (start + end) / 2;
        	totalBuget = totalBudget(budgets, mid);
        	if(totalBuget == M) {
        		answer = M;
        		break;
        	}else if(totalBuget > M) {
        		end = mid - 1;
        	}else {
        		start = mid + 1;
        	}
        }
        answer = totalBuget > M ? mid - 1 : mid;
        return answer;
    }
	
	static int totalBudget(int[] budgets, int M) {	//상한액에 대한 총 예산
		int sum = 0;
		for(int i = 0; i < budgets.length; i++) {
			if(budgets[i] < M) {
				sum += budgets[i];
			}else {
				sum += M;
			}
		}
		return sum;
	}
}
