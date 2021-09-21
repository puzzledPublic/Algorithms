package programmers;
//기지국 설치 (그리디)
public class BaseStaionInstall {
	public static void main(String[] args) {
		int[] n = {11, 16};
		int[][] stations = {
				{4, 11},
				{9}
		};
		int[] w = {1, 2};
		
		for(int i = 0; i < n.length; i++) {
			System.out.println(solution(n[i], stations[i], w[i]));
		}
	}
	
	static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int next = 0, index = 1;	//이미 설치된 기지국 인덱스, 현재 탐색 위치
        while(index <= n){	//왼쪽부터 오른쪽까지 훑는다.
        	if(next < stations.length && stations[next] - w <= index && w <= stations[next] + w) {	//현재 탐색위치가 이미 설치된 기지국 범위에 포함되면
        		index = stations[next] + w + 1;	//탐색위치를 이미 설치된 기지국 위치 오른쪽 밖으로 이동시킨다.
        		next++;	//다음 설치된 기지국으로 갱신
        	}else {		//이미 설치된 기지국 범위에 포함되지 않는다면
        		index += 2 * w + 1;	//현재 탐색위치에서 오른쪽으로 w만큼 떨어진 위치에 설치 후 설치위치에서 다시 오른쪽으로 w만큼 떨어진 위치로 이동한다.
        		answer++;	//설치
        	}
        }
        
        return answer;
    }
}
