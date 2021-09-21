package programmers;
//네트워크
public class NetworkDFS {
	public static void main(String[] args) {
		int[] n = {3, 3};
		int[][][] computers = {
				{
					{1,1,0}, 
					{1,1,0}, 
					{0,0,1}
				},
				{
					{1,1,0}, 
					{1,1,1}, 
					{0,1,1}
				}
		};
		for(int i = 0; i < n.length; i++) {
			System.out.println(solution(n[i], computers[i]));
		}
	}
	
	static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];
        for(int i = 0; i < n; i++) {
        	if(!chk[i]) {
        		dfs(computers, chk, i);
        		answer++;
        	}
        }
        return answer;
    }
	static void dfs(int[][] computers, boolean[] chk, int start) {
		chk[start] = true;
		for(int i = 0; i < computers.length; i++) {
			if(computers[start][i] == 1 && !chk[i]) {
				dfs(computers, chk, i);
			}
		}
	}
}
