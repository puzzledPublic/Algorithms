package java8;

import java.util.Arrays;

public class KakaoTest6 {

	static int arr[] = new int[100001];

	public static void main(String[] args) {
		// int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
		int[] sticker = { 1 };
		System.out.println(solution(sticker));
	}

	static int solution(int[] sticker) {
		int answer = -1;
		if (sticker.length < 4) {
			for (int i = 0; i < sticker.length; i++) {
				answer = Math.max(sticker[i], answer);
			}
		} else {

			int temp = sticker[sticker.length - 1];
			sticker[sticker.length - 1] = 0;

			arr[0] = sticker[0];
			arr[1] = 0;
			arr[2] = sticker[0] + sticker[2];
			int ret1 = -1;
			for (int i = 3; i < sticker.length; i++) {
				arr[i] += Math.max(arr[i - 2], arr[i - 3]) + sticker[i];
				ret1 = Math.max(arr[i], ret1);
			}

			Arrays.fill(arr, 0);
			sticker[sticker.length - 1] = temp;
			sticker[0] = 0;
			arr[0] = sticker[0];
			arr[1] = sticker[1];
			arr[2] = sticker[0] + sticker[2];
			int ret2 = -1;
			for (int i = 3; i < sticker.length; i++) {
				arr[i] += Math.max(arr[i - 2], arr[i - 3]) + sticker[i];
				ret2 = Math.max(arr[i], ret2);
			}

			answer = Math.max(ret1, ret2);
		}
		return answer;
	}
}
