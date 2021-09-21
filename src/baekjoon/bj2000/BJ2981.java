package baekjoon.bj2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//검문
//숫자가 x0 ~ xN까지 정렬돼있고 어떤 수 m으로 나눠서 모두 나머지가 같을때 m을 출력
//x0 = m * z0(몫) + n(나머지), xN = m * zN + n으로 나타낼 수 있고
//둘을 연립해서 풀면 (xN - x0) = m * (zN - z0)가 된다.
//이때 (xN - x0)는 m의 배수이다. 즉, m은 (xN - x0)의 약수가 된다
//1은 문제에서 제외하므로 2 <= n <= (xN - x0)를 만족하는 약수를 찾는다.
//그리고 모든 수들에 대해 약수들로 나눴을때 나머지가 모두 같은지 확인한 후 같으면 그 약수를 출력한다.
public class BJ2981 {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = input.nextInt();
		}
		solve();
	}
	static void solve() {
		Arrays.sort(arr);
		int[] nums = div(arr[N - 1] - arr[0]);
		for(int num : nums) {
			boolean flag = true;
			int mod = arr[0] % num;
			for(int i = 1; i < N; i++) {
				if(arr[i] % num != mod) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.print(num + " ");
			}
		}
	}
	static int[] div(int num) {
		List<Integer> list = new ArrayList<>();
		list.add(num);
		for(int i = 2; i * i <= num; i++) {	// sqrt(num)까지만 해주면 약수를 모두 구할 수 있다. ( i * (num / i) = num )
			if(num % i == 0) {
				list.add(i);
				if(num / i != i) {
					list.add(num / i);
				}
			}
		}
		Collections.sort(list);
		int[] arr = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
}
