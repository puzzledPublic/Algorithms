package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//감소하는 수
public class BJ1038 {
	static int count = 0;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N > 1022) {	//1022번째(9876543210) 이후에 감소하는 수는 없다. (1022번째 이후인지 어떻게 알았냐면 동적계획법으로 계산)
			System.out.println(-1);
		}else if(N == 0){	//0번째 감소하는 수
			System.out.println(0);
		}else {	//그 외
			solve(N);
		}
	}
	
	static void solve(int n) {
		int[][] arr = new int[11][10];	//arr[i][j] = i번째 자리에 j번째 숫자가 왔을때 감소하는 수의 갯수
		int sum = 0, temp = 0;
		for(int i = 0; i < 10; i++) {	//첫번째 자리만 있을 경우에 감소하는 수는 한 가지뿐
			arr[1][i] = 1;
		}
		//감소하는 수를 출력해야 한다.
		//이때 감소하는 수로 동적계획법을 하면 순서가 틀어진다. (ex, arr[2][0]라면 10, 20, 30, 40...90 총 9개)
		//반대로 증가하는 수로 계산하면 (arr[2][0] = 02, 12 총 2개) 이를 뒤집어보면 감소하는 수가 되고 순서가 맞는다. 20, 21..
		//그러므로 몇번째내에 있는지 알기 위해 arr[i][j]를 감소하는 수가 아닌 증가하는 수로 생각하고 계산한다.
		//arr[i][j] = i번째 자리에 j번째 숫자가 왔을때 증가하는 수의 갯수
		for(int i = 2; i < arr.length; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j - 1; k >= 0; k--) {	//arr[i][j] = sum( arr[i - 1][0 <= k < j] )	현재 j보다 작은 i - 1번째들의 합
					arr[i][j] += arr[i - 1][k];
				}
			}
		}
		//갯수를 알아냈다면 갯수를 더해보면서 주어진 위치에 포함되는지 확인
		//temp는 그전 합계 sum은 현재 합계
		for(int i = 1; i < arr.length; i++) {
			for(int j = 1; j < 10; j++) {
				if(arr[i][j] != 0) {
					sum += arr[i][j];
					if(temp < n && sum >= n) {	//알고자 하는 위치가 범위안에 있으면
						StringBuilder sb = new StringBuilder();
//						System.out.println(i + " " +j + " " + (n - sum + arr[i][j]));
						System.out.print(j);	//제일 처음 숫자 출력
						//n - sum + arr[i][j]는 그 범위 내에서 알고자하는 상대적 위치
						recur(0, i - 1, n - sum + arr[i][j], sb);	// 상대적위치만큼 재귀로 나머지 i - 1자리 숫자를 만든다.
						return;
					}
					temp = sum;
				}
			}
		}
	}
	static void recur(int n, int e, int k, StringBuilder sb) {
		if(n == e) {	//숫자를 만들었고
			count++;
			if(count == k) {	//상대적위치만큼 이동? 만들었으면
				if(!flag) {
					System.out.println(sb);	//출력
					flag = true;
				}
			}
			return;
		}
		for(int i = 0; i < 10; i++) {
			if(sb.length() == 0 || sb.charAt(sb.length() - 1) - 48 > i) {
				sb.append(i);
				recur(n + 1, e, k, sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
