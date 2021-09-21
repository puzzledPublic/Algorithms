package kakao.kakao2018;

import java.util.Arrays;

public class ShuttleBus {
	static int[] n = {1, 2, 2, 1, 1, 10};	//운행 횟수
	static int[] t = {1, 10, 1, 1, 1, 60};	//배차 간격(분)
	static int[] m = {5, 2, 2, 5, 1, 45};	//탑승 제한 인원
	static String[][] timetable = { 
		{"08:00", "08:01", "08:02", "08:03"},
		{"09:10", "09:09", "08:00"},
		{"09:00", "09:00", "09:00", "09:00"},
		{"00:01", "00:01", "00:01", "00:01", "00:01"},
		{"23:59"},
		{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}
	};
	static int[][] times;
	public static void main(String[] args) {
		
		times = new int[n.length][];
		for(int i = 0 ; i < timetable.length; i++) {
			times[i] = new int[timetable[i].length];
			for(int j = 0; j < timetable[i].length; j++) {
				String[] st = timetable[i][j].split(":");
				int ft = Integer.parseInt(st[0]);
				int bt = Integer.parseInt(st[1]);
				times[i][j] = ft * 60 + bt;
			}
			Arrays.sort(times[i]);
		}
		for(int i = 0; i < n.length; i++) { 
			System.out.println(solve(n[i], t[i], m[i], times[i]));
		}
	}
	
	static String solve(int N, int T, int M, int[] arriveTimes) {
		int busTimeLimit = 9 * 60;
		int index = 0, personLimit = 0;
		for(int i = 0; i < N; i++) {
			personLimit = 0;
			for(int j = index; j < arriveTimes.length; j++) {
				if(arriveTimes[j] <= busTimeLimit) {
					index++;
					personLimit++;
					if(personLimit == M) {
						break;
					}
				}
			}
			busTimeLimit += T;
		}
		if(personLimit < M) {
			return numberToTimeString(busTimeLimit - T);
		}
		
		return numberToTimeString(arriveTimes[index - 1] - 1);
	}
	static String numberToTimeString(int number) {
		return number / 60 + ":" + ((number % 60) < 10 ? "0"+number % 60 : number % 60);
	}
}
