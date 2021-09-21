package algorithmsForPS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//숙직 선생님 
public class AfcNightShiftTeacher {
	
	static int teacherPosition, someonePosition;
	static int power[] = new int[3];
	static int cache[] = new int[1000];
	static int cache2[] = new int[1200];
	static int ans = 2000;
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 1 <= teacherPosition <= someonePosition <= 1000
		teacherPosition = input.nextInt();	
		someonePosition = input.nextInt();
		// 1 <= power <= 100
		for(int i = 0 ; i < power.length; i++) {
			power[i] = input.nextInt();
		}
		
		//back(teacherPosition, 0);
		//System.out.println((ans != 2000) ? ans : -1);
		
		//nightShift();
		
		//nightShift2();
		nightShift3();
		
	}
	//전체탐색법
	static void back(int next, int cnt) {
		if(next > someonePosition) {
			return;
		}
		if(next == someonePosition) {
			if(cnt < ans) ans = cnt;
		}
		for(int i = 0 ; i < 3; i++) {
			back(next + power[i], cnt + 1);
		}
	}
	//큐를 사용한 방법
	static void nightShift() {
		queue.add(teacherPosition);
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			
			if(next == someonePosition) {
				System.out.println(cache2[next]);
				return;
			}
			for(int i = 0 ; i < 3; i++) {
				int temp = next + power[i];
				if(temp <= someonePosition && cache2[temp] == 0) {
					queue.add(temp);
					cache2[temp] = cache2[next] + 1;
					//System.out.println(temp + " " + cache2[temp] + " ");
				}
			}
		}
		
		System.out.println(-1);
	}
	//상향식 접근 방법, 동적 계획법
	static void nightShift2() {
		if(teacherPosition == someonePosition) {
			System.out.println(0);
		}
		else {
			Arrays.fill(cache, 10000);
			
			cache[teacherPosition] = 0;
			
			for(int i = teacherPosition + 1 ; i <= someonePosition ; i++) {
				int temp = 10000;
				for(int j = 0 ; j < 3; j++) {
					if(i - power[j] >= teacherPosition) {
						temp = Math.min(temp, cache[i - power[j]]);
					}
				}
				cache[i] = temp + 1;
			}
			
			if(cache[someonePosition] != 10000) {
				System.out.println(cache[someonePosition]);
			}
			else {
				System.out.println(-1);
			}
		}
	}
	
	static void nightShift3() {
		if(teacherPosition == someonePosition) {
			System.out.println(0);
		} else {
			Arrays.fill(cache, 987654321);
			cache[1] = 0;
			
			for(int i = 0; i < 3; i++) {
				cache[1 + power[i]] = 1; 
			}
			
			for(int i = 2; i <= someonePosition - teacherPosition + 1; i++) {
				int temp = 987654321;
				for(int j = 0; j < 3; j++) {
					if(i - power[j] >= 1) {
						temp = Math.min(temp, cache[i - power[j]]);
					}
				}
				cache[i] = temp + 1;
			}
		}
		
		System.out.println(cache[someonePosition - teacherPosition + 1]);
	}
}
