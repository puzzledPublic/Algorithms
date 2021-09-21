package samsung;

import java.util.Arrays;
import java.util.Scanner;

//사다리 조작 (백준 15684)
public class LadderManipulation {
	static int N, M, H, Min = 987654321;
	static int[][] ladder;	//i번째 세로 사다리에서 j번째 가로 사다리가 존재 함 (ladder[i][j] > -1)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		H = input.nextInt();
		ladder = new int[N][H];
		for(int i = 0; i < N; i++) {	// -1은 가로 사다리가 없음을 나타냄
			Arrays.fill(ladder[i], -1);
		}
		for(int i = 0; i < M; i++) {	//초기 사다리 만들기
			int a = input.nextInt() - 1;
			int b = input.nextInt() - 1;
			ladder[b][a] = b + 1;
			ladder[b + 1][a] = b;
		}
		//for debugging
		/*for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print((ladder[j][i] < 0 ? ladder[j][i] : " " + ladder[j][i]) + " ");
			}
			System.out.println();
		}System.out.println();*/
		solve(0);
		System.out.println(Min > 3 ? -1 : Min);
	}
	static void solve(int n) {
		if(isManipulated()) {	//사다리가 완성 됐다면
			if(Min > n) {
				Min = n;	//최저값 갱신
				//for debugging
				/*for(int i = 0; i < H; i++) {
					for(int j = 0; j < N; j++) {
						System.out.print((ladder[j][i] < 0 ? ladder[j][i] : " " + ladder[j][i]) + " ");
					}
					System.out.println();
				}System.out.println();*/
			}
			return;
		}
		if(n == 3) {	//사다리는 3개만 추가 가능
			return;
		}
		for(int k = 0; k < N - 1; k++) {	//모든 세로 사다리에서 각 가로 사다리에 대해 완전탐색
			for(int i = 0; i < H; i++) {
				if(ladder[k][i] == -1 && ladder[k + 1][i] == -1) {	//사다리를 놓을 수 있는지 확인
					ladder[k][i] = k + 1;
					ladder[k + 1][i] = k;
					solve(n + 1);
					ladder[k][i] = -1;
					ladder[k + 1][i] = -1;
				}
			}
		}
	}
	static boolean isManipulated() {
		for(int i = 0; i < N; i++) {
			if(!search(i, i)) {		//각 세로 사다리에서 내려갔을때 자기 자신인지 확인
				return false;
			}
		}
		return true;
	}
	static boolean search(int next, int start) {
		int index = 0;
		boolean result = false;
		while(index < H) {
			for(int i = index; i < H; i++) {
				index++;
				if(ladder[next][i] > -1) {
					next = ladder[next][i];
					break;
				}
			}
		}
		if(start == next) {
			result = true;
		}
		return result;
	}
}
