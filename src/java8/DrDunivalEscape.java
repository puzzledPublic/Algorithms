package java8;

import java.util.Arrays;
import java.util.Vector;
//두니발 박사의 탈옥
//종만북 8.17 

public class DrDunivalEscape {
	//정점끼리 연결돼 있는지 여부를 나타내는 배열 ( 무방향 그래프)
	static int[][] connected = { { 0, 1, 1, 1, 0 }, { 1, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 } };
	//각 정점마다 연결된 정점의 개수( 차수)
	static int[] deg = new int[5];
	//메모이제이션을 위한 캐쉬
	static double[][] cache = new double[10][10];
	// n = 정점 개수, d = 지나간 날짜, p = 시작점, q = 도착점
	static int n = 5, d = 2, p = 0, q = 0;

	public static void main(String[] args) {
		//무방향 그래프에서 각 정점의 차수를 구한다.
		for (int i = 0; i < connected.length; i++) {
			for (int j = 0; j < connected[0].length; j++) {
				if (connected[i][j] == 1) {
					deg[i]++;
				}
			}
		}
		//캐쉬 초기화
		for (int i = 0; i < cache.length; i++) {
			Arrays.fill(cache[i], -1.0);
		}
		// for(int i = 0; i < deg.length;i++){
		// System.out.print(deg[i] +" ");
		// }
		//탐색하는 경로를 나타낼 벡터
		Vector<Integer> path = new Vector<Integer>();
		//경로의 처음을 설정
		path.add(p);
		System.out.println(search(path));
		System.out.println(search2(p, 0));

	}

	// 전체 경로를 탐색하여 얻는 방법
	static double search(Vector<Integer> path) {
		if (path.size() == d + 1) {
			if (path.lastElement() != q) {
				return 0.0;
			}
			double ret = 1.0;
			for (int i = 0; i + 1 < path.size(); i++) {
				ret /= deg[path.get(i)];
			}
			return ret;
		}
		double ret = 0;

		for (int there = 0; there < n; there++) {
			if (connected[path.lastElement()][there] == 1) {
				path.add(there);
				ret += search(path);
				path.remove(path.size() - 1);
			}
		}
		return ret;
	}

	// 메모이제이션을 이용한 방법
	static double search2(int here, int days) {
		if (days == d) {
			return (here == q ? 1.0 : 0.0);
		}
		if (cache[here][days] > -0.5) {
			return cache[here][days];
		}
		cache[here][days] = 0.0;
		for (int there = 0; there < n; there++) {
			if (connected[here][there] == 1) {
				cache[here][days] += search2(there, days + 1) / deg[here];
			}
		}
		return cache[here][days];
	}
	//마지막날부터 거꾸로 구하는 방법
	static double search3(int here, int days){
		if(days == 0){
			return (here == p? 1.0:0.0);
		}
		if(cache[here][days] > -0.5){
			return cache[here][days];
		}
		cache[here][days]=0.0;
		for(int there = 0; there < n; there++){
			if(connected[here][there] == 1){
				cache[here][days] += search3(there, days - 1) / deg[here];
			}
		}
		return cache[here][days];
	}
}
