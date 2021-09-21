package samsung;

import java.util.Scanner;

//경사로 (백준 14890)
public class SlopeWay {
	static int N, L;
	static int[][] Map;
	static int result;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		L = input.nextInt();
		Map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				Map[i][j] = input.nextInt();
			}
		}
		solve();
		System.out.println(result);
	}
	
	static void solve() {
		int count = 1;
		//행방향
		for(int i = 0; i < N; i++) {
			count = 1;
			for(int j = 0; j < N - 1; j++) {
				if(Map[i][j] == Map[i][j + 1]) {	//현재 높이가 다음과 같을때
					count++;
				}
				else if(Map[i][j] - Map[i][j + 1] == -1) {	//현재 높이가 다음 높이보다 1 작을때
					if(count < L) {
						result -= 1;
						break;
					}else {
						count = 1;
					}
				}
				else if(Map[i][j] - Map[i][j + 1] == 1) {	//현재 높이가 다음 높이보다 1 클때 
					count = 1;
					for(int k = j + 1; k < N - 1; k++){
						if(Map[i][k] != Map[i][k + 1]) {
							break;
						}else {
							count++;
						}
					}
					if(count < L) {
						result -= 1;
						break;
					}else {
						j += (L - 1);
						count = 0;
					}
				}else {	//다음 높이와 차이가 1 이상일때
					result -= 1;
					break;
				}
			}
			result += 1;
		}
		//열방향
		for(int i = 0; i < N; i++) {
			count = 1;
			for(int j = 0; j < N - 1; j++) {
				if(Map[j][i] == Map[j + 1][i]) {
					count++;
				}
				else if(Map[j][i] - Map[j + 1][i] == -1) {
					if(count < L) {
						result -= 1;
						break;
					}else {
						count = 1;
					}
				}
				else if(Map[j][i] - Map[j + 1][i] == 1) {
					count = 1;
					for(int k = j + 1; k < N - 1; k++){
						if(Map[k][i] != Map[k + 1][i]) {
							break;
						}else {
							count++;
						}
					}
					if(count < L) {
						result -= 1;
						break;
					}else {
						j += (L - 1);
						count = 0;
					}
				}else {
					result -= 1;
					break;
				}
			}
			result += 1;
		}
	}
}
