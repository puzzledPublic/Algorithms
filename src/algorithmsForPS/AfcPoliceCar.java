package algorithmsForPS;

import java.util.Scanner;

public class AfcPoliceCar {
	static int N, w;
	static int cases[][];
	static int dist[][];
	static int answer = 987654321;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		w = input.nextInt();
		cases = new int[w + 2][2];
		dist = new int[w + 2][w + 2];
		for(int i = 2; i < w + 2; i++) {
			cases[i][0] = input.nextInt();
			cases[i][1] = input.nextInt();
		}
		cases[0][0] = cases[0][1] = 1;	//a 경찰차 위치
		cases[1][0] = cases[1][1] = N;	//b 경찰차 위치
		
		//모든 사건 위치 간의 거리를 미리 계산해 놓으면 효율 상승
		for(int i = 0; i < w + 2; i++) {
			for(int j = 0; j < w + 2; j++) {
				dist[i][j] = Math.abs(cases[i][0] - cases[j][0]) + Math.abs(cases[i][1] - cases[j][1]);
			}
		}
		solve(0, 1, 0);
		System.out.println(answer);
	}
	
	static void solve(int a, int b, int d) {	//경찰이 a, b 위치에 있고 이때 경찰차들이 움직인 거리의 합 d
		
		int next = Math.max(a, b) + 1;	//다음 사건은 순서대로 일어난다
		if(next == w + 2) {	//a 또는 b 가 마지막 사건에 도착하면
			if(answer > d) {	//최소 길이 합 검사 후 갱신
				answer = d;
			}
			return;
		}
		//solve(next, b, d + distance(a,next));	//a가 다음 위치로 움직이는 경우
		//solve(a, next, d + distance(b,next));	//b가 다음 위치로 움직이는 경우
		solve(next, b, d + dist[a][next]);
		solve(a, next, d + dist[b][next]);
	} 
	static int distance(int a, int b) {	//두 지점 사이의 거리
		return Math.abs(cases[a][0] - cases[b][0]) + Math.abs(cases[a][1] - cases[b][1]);
	}
	//그리디로 안풀림
	/*static int N, cases;
	static int accident[][];
	static int policeCar[][];
	static int answer;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		cases = input.nextInt();
		accident = new int[cases][2];
		
		policeCar = new int[2][2];
		policeCar[0][0] = 1;
		policeCar[0][1] = 1;
		policeCar[1][0] = N;
		policeCar[1][1] = N;
		
		for(int i = 0; i < cases; i++) {
			accident[i][0] = input.nextInt();
			accident[i][1] = input.nextInt();
		}
		
		solve();
		System.out.println(answer);
		for(Integer i : list) {
			System.out.println(i);
		}
	}
	
	static void solve() {
		int accidentX, accidentY;
		for(int i = 0; i < cases; i++) {
			accidentX = accident[i][0];
			accidentY = accident[i][1];
			
			double a = getDistance(accidentX, accidentY, policeCar[0][0], policeCar[0][1]);
			double b = getDistance(accidentX, accidentY, policeCar[1][0], policeCar[1][1]);
			System.out.println("a : " + a + " b : " + b);
			
			if(a > b) {
				answer += Math.abs(accidentX - policeCar[1][0]);
				answer += Math.abs(accidentY - policeCar[1][1]);
				policeCar[1][0] = accidentX;
				policeCar[1][1] = accidentY;
				list.add(2);
			}
			else {
				answer += Math.abs(accidentX - policeCar[0][0]);
				answer += Math.abs(accidentY - policeCar[0][1]);
				policeCar[0][0] = accidentX;
				policeCar[0][1] = accidentY;
				list.add(1);
			}
			
		}
	}
	
	static double getDistance(int x1, int y1, int x2, int y2) {
		int x, y;
		x = x1 - x2;
		y = y1 - y2;
		System.out.println((x * x + y * y));
		return Math.sqrt((double)(x * x + y * y));
	}*/
}
