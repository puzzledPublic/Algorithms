package algorithmsForPS;
//노드 간의 거리 (문제해결을 위한 창의적 알고리즘)
public class AfcDistanceOfNodes {
	public static void main(String[] args) {
		System.out.println(solve(200000,342));
		
		System.out.println(solve2(200000, 342));
	}
	
	static int solve(int a, int b){
		
		if(a == b){
			return 0;
		}
		int ret = 0;
		if(a > b){
			ret = solve(a / 2, b) + 1;
		}
		if(a < b){
			ret = solve(a, b / 2) + 1;
		}
		return ret;
	}
	
	static int solve2(int a, int b) {
		int distance = 0;
		while(a != b) {
			if(a > b) {
				a /= 2;
			}
			else {
				b /= 2;
			}
			distance++;
		}
		return distance;
	}
}
