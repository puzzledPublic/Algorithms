package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//돌 게임6
public class BJ9660 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		//마지막 돌을 가져가는 자가 이기는것이고 한번에 1 or 3 or 4개의 돌만 가져갈 수 있다.
		//DP처럼 생각해보면 N - 1, N - 3, N - 4개의 돌에서 모두 이긴다면 무조건 먼저 시작한 사람이 지게 돼있다.
		//규칙을 찾아보면 N % 7 == 0이거나 N % 7 == 0일때 늦게 시작한 사람(창영)이 이긴다. 그 외에는 먼저 시작한 사람(상근)이 이긴다.
		System.out.println((N % 7 == 0 || N % 7 == 2) ? "CY" : "SK");
	}
}
