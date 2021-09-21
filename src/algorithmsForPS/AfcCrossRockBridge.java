package algorithmsForPS;

import java.util.Scanner;

//돌다리 건너기(s)
public class AfcCrossRockBridge {
	static String roll, devilRoad, angelRoad;
	static int rollLength, bridgeLength;
	static int answer;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		roll = input.nextLine();
		devilRoad = input.nextLine();
		angelRoad = input.nextLine();
		
		rollLength = roll.length();
		bridgeLength = devilRoad.length();
		
		solve(0, 0, 'd');
		solve(0, 0, 'a');
		System.out.println(answer);
	}
	
	static void solve(int n, int d, char w) {
		if(n == rollLength) {
			answer++;
			return;
		}
		
		for(int i = d; i < bridgeLength; i++) {
			if(w == 'a') {
				if(angelRoad.charAt(i) == roll.charAt(n)) {
					solve(n + 1, i + 1, 'd');
				}
			}
			else {
				if(devilRoad.charAt(i) == roll.charAt(n)) {
					solve(n + 1, i + 1, 'a');
				}
			}
		}
	}
	
	
}
