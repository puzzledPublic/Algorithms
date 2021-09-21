package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//섞기 수열, KOI 전국 2009 고등부
//한 원소에서 시작하여 자신으로 연결되는 한 사이클을 이루는 원소 개수들의 최소 공배수가 답이된다. 
public class Jungol2255	{
	
	static int arr[];
	static boolean visited[];
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N;	//수열 개수
		N = input.nextInt();

		list = new ArrayList<Integer>();	//사이클 횟수를 저장 할 배열
		arr = new int[N+1];					//수열을 저장 할 배열
		visited = new boolean[N+1];			//수열 원소를 방문 했는지 여부 배열
		
		//입력
		for(int i = 1; i < N + 1; i++){
			arr[i] = input.nextInt();
		}
		
		//계산
		int temp, count = 0;
		for(int i = 1; i < N + 1; i++){	//수열을 돌며
			if(!visited[i]){	//아직 방문 되지 않았다면
				temp = arr[i];	//현재 방문 수열 
				count = 0;		//사이클을 이루는 원소 개수 초기화
				while(temp != i){	//i를 시작하여 i로 끝나는 한 사이클이 완료 될때까지
					visited[temp] = true;	//방문하는 원소들은 그 사이클에만 존재하므로 방문 표시
					temp = arr[temp];	//다음 이어지는 원소로
					count++;			//사이클을 이루는 원소 개수 1 증가
				}
				list.add(count + 1);	//개수를 배열에 저장
			}
		}
		/*
		System.out.println(list.size());
		for(int i : list){
			System.out.print(i + " ");
		}
		System.out.println();
		*/
		
		long answer;	//최소 공배수 값이 int 범위를 넘어가므로 long 타입으로 선언
		
		if(list.size() >= 2){	// 개수들이 2개 이상인 경우의 lcm 구하기
			answer = lcm(list.get(0), list.get(1));
			for(int i = 2; i < list.size(); i++){
				answer = lcm(answer, list.get(i));
			}
		}
		else{
			answer = list.get(0);
		}
		
		
		//출력
		System.out.println(answer);
		
	}
	//최대 공약수 계산 함수
	static long gcd(long a, long b){
		if(b == 0){
			return a;
		}
		return gcd(b, a%b);
	}
	//최소 공배수 계산 함수
	static long lcm(long a, long b){
		long temp = gcd(a, b);
		if(temp == 0){
			return 0;
		}
		return a * b / temp;
	}
}

//시간 초과
/*public class Jungol2255 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n, count = 0, lcm;
		n = scanner.nextInt();
		if (n < 1 || n > 20000) {
			System.exit(0);
		}
		int[] item = new int[n];
		int[] temp = new int[n];
		int[] cycle = new int[n];
		int[] check = new int[n];
		for (int i = 0; i < n; i++) {
			item[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			temp[i] = item[item[i] - 1];
		}
		//count++;
		for (int i = 0; i < n; i++) { System.out.print(temp[i] + " "); }
		System.out.print(", ");
		 for (int i = 0; i < n; i++) { System.out.print(cycle[i] + " "); }
		 System.out.println();
		while (true) {

			for (int i = 0; i < n; i++) {
				temp[i] = item[temp[i] - 1];
				if (temp[i] != item[i]) {
					cycle[i]++;
				}
			}
			for (int i = 0; i < n; i++) { System.out.print(temp[i] + " "); }
			System.out.print(", ");
			 for (int i = 0; i < n; i++) { System.out.print(cycle[i] + " "); }
			 System.out.println();
			 
			if (!isSame(cycle, check, n)) {
				for (int i = 0; i < n; i++) {
					check[i] = cycle[i];
				}
			} else {
				break;
			}

		}
		lcm = cycle[0];
		for(int i = 1 ; i < n;i++){
			if(cycle[i]!=0){
				lcm = lcm * cycle[i] / get_gcd(lcm, cycle[i]);
			}
		}
		System.out.println(lcm);
	}

	static boolean isSame(int[] cycle, int[] check, int n) {
		for (int i = 0; i < n; i++) {
			if (cycle[i] != check[i]) {
				return false;
			}
		}
		return true;
	}

	static int get_gcd(int a, int b) {
		int r;
		while (true) {
			r = a % b;
			if (r == 0) {
				break;
			}
			a = b;
			b = r;
		}
		return b;
	}
}*/
