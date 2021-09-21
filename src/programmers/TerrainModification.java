package programmers;
//지형 편집	(파라메트릭 서치)
public class TerrainModification {
	public static void main(String[] args) {
		int[][][] land = {
				{
					{1, 2},
					{2, 3}
				},
				{
					{4, 4, 3},
					{3, 2, 2},
					{2, 1, 0}
				},
				{
					{0,0},
					{1,0}
				}
		};
		int[] P = {3, 5, 1};	//블록 한 개를 추가하는 비용
		int[] Q = {2, 3, 2};	//블록 한 개를 제거하는 비용
		
		for(int i = 0; i < land.length; i++) {
			System.out.println(solution(land[i], P[i], Q[i]));
			
		}
	}
	//파라메트릭시 중간 값에 대한 판단 결정을 연습하는게 필요한듯. + 범위 (끝과 끝)에 대한 처리 연습
	//O(n^2 * logn)
	static long solution(int[][] land, int P, int Q) {
		long answer = -1;
		long start = 0, end = 0;
		
		for(int i = 0; i < land.length; i++) {		//N x N 지형에서 쌓인 블록 중 가장 높은 높이
			for(int j = 0; j < land.length; j++) {
				if(end < land[i][j]) {
					end = land[i][j];
				}
			}
		}
		
		for(int i = 0; i < 31; i++) {	//블록의 높이는 최대 10억 이므로 대략 2^30이다. 30번내로 답이 나오므로 31번만 돌려본다.
			long mid = (start + end) / 2;	//기준 높이
			long price = getPrice(land, P, Q, mid);		//높이 x 비용 그래프를 그려보면 대략 아래로 볼록한 2차 함수 그래프가 그려지며 기울기가 0으로 수렴하는 쪽으로 옮기면 된다.(핵심)
			long next = getPrice(land, P, Q, mid + 1);	//바로 다음 높이에 드는 비용
			
			if(price < next) {	//다음 높이 비용이 더 높으면 기울기가 양수이므로 높이를 낮춘다.
				end = mid;
			}else if(price > next){	//다음 높이 비용이 더 낮으면 기울기가 음수이므로 높이를 높인다.
				start = mid + 1;
			}
			answer = price;
		}
		
		return answer;
	}
	static long getPrice(int[][] land, int P, int Q, long mid) {	//기준 높이에 대해 드는 블록 추가, 제거 비용 합 계산.
		long price = 0;
		for(int j = 0; j < land.length; j++) {
			for(int k = 0; k < land.length; k++) {
				if(mid < land[j][k]) {
					price += (land[j][k] - mid) * (long)Q;
				}else {
					price += (mid - land[j][k]) * (long)P;
				}
			}
		}
		return price;
	}
}
