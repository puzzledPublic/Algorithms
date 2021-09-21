package programmers;
//점프와 순간이동
public class JumpAndTeleport {
	public static void main(String[] args) {
		int[] n = {5, 6, 5000};
		for(int i = 0; i < n.length; i++) {
			System.out.println(solution(n[i]));
		}
	}
	
	static int solution(int n) {
        int ans = 1;	//처음은 최소 한번 점프해야한다.
        while(n > 1) {	//목적지에서 거꾸로 오면서 계산한다.
        	if(n % 2 == 0) {	//n이 이전 위치에서 2배로 넘어올 수 있는가(짝수인가)? 그렇다면 n / 2로 돌아간다.
        		n /= 2;
        	}else {				//아니라면 홀수라는 뜻이고 점프 1을 소비한다.
        		n--;
        		ans++;
        	}
        }
        return ans;
    }
}
