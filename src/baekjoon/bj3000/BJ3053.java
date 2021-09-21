package baekjoon.bj3000;

import java.util.Scanner;
//택시 기하학
//유클리드 기하학에서 (x1, y1), (x2, y2)사이 길이는 root[(x2 - x1)^2 + (y2 - y1)^2]
//택시 기하학에서 (x1, y1), (x2, y2)사이 길이는 |x2 - x1| + |y2 - y1|
public class BJ3053 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		solve(input.nextInt());
	}
	static void solve(int r) {
		System.out.printf("%.6f\n",r * r * Math.PI); //유클리드 기하학의 원의 넓이
		System.out.printf("%.6f\n",r * r * 2.0);	//택시 기하학의 원의 넓이
	}
}
