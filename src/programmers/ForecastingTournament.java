package programmers;
//예상 대진표
public class ForecastingTournament {
	public static void main(String[] args) {
		int n = 2 << 10;
		int a = 4;
		int b =	10;
		System.out.println(solution(n, a, b));
	}
	
	static int solution(int n, int a, int b)
    {
        int answer = 0;
        while(a != b) {		//만날때까지
        	a = a % 2 == 0 ? a / 2 : (a / 2) + 1;	//무조건 이기므로 다음 번호를 받는다.
        	b = b % 2 == 0 ? b / 2 : (b / 2) + 1;
        	answer++;
        }
        return answer;
    }
}
