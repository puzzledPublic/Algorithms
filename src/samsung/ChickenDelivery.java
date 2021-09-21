package samsung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//치킨 배달 (백준 15686)
public class ChickenDelivery {
	static int N, M, result = 987654321;
	static List<ChickenDelivery.Position> housePositions, chickenPositions, tempPositions;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		M = input.nextInt();
		housePositions = new ArrayList<>();
		chickenPositions = new ArrayList<>();
		tempPositions = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int temp = input.nextInt();
				if(temp == 1) {
					housePositions.add(new ChickenDelivery.Position(i, j));
				} else if(temp == 2) {
					chickenPositions.add(new ChickenDelivery.Position(i, j));
				}
			}
		}
		if(chickenPositions.size() == M) {
			tempPositions = chickenPositions;
			System.out.println(minChickenPath());
		}
		else {
			solve(0, 0);
			System.out.println(result);
		}
	}
	
	static void solve(int index, int m) {
		if(m == M) {
			int k = minChickenPath();
			if(result > k) {
				result = k;
			}
			return;
		}
		if(index == chickenPositions.size()) {
			return;
		}
		Position p = chickenPositions.get(index);
		tempPositions.add(new ChickenDelivery.Position(p.x, p.y));
		solve(index + 1, m + 1);
		tempPositions.remove(tempPositions.size() - 1);
		solve(index + 1, m);
	}
	
	static int minChickenPath() {
		int re = 0, tmp, r;
		for(ChickenDelivery.Position h : housePositions) {
			tmp = 987654321;
			for(ChickenDelivery.Position c : tempPositions) {
				r = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
				if(tmp > r) {
					tmp = r;
				}
			}
			re += tmp;
		}
		return re;
	}
	
	static class Position {
		int x, y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
