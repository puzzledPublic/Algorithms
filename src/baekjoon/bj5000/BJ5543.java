package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//상근날드
public class BJ5543 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] burger = new int[3], beverage = new int[2];
		for(int i = 0; i < 3; i++) {
			burger[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < 2; i++) {
			beverage[i] = Integer.parseInt(br.readLine());
		}
		solve(burger, beverage);
	}
	static void solve(int[] burger, int[] beverage) {
		int min = 987654321;
		for(int i = 0; i < burger.length; i++) {
			for(int j = 0; j < beverage.length; j++) {
				if(burger[i] + beverage[j] - 50 < min) {
					min = burger[i] + beverage[j] - 50;
				}
			}
		}
		System.out.println(min);
	}
}
