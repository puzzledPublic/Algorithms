package java8;

import java.util.Arrays;

//순열
public class Permutation {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4};
		
//		while(nextPermutation(arr)) {
//			System.out.println(Arrays.toString(arr));
//		}
		int[] arr2 = new int[]{4, 3, 2, 1};
		while(prePermutation(arr2)) {
			System.out.println(Arrays.toString(arr2));
		}
		
//		int[] arr3 = new int[4];
//		boolean[] chk = new boolean[4];
//		recurPermutaion(arr3, chk, 0);
	}
	
	static boolean nextPermutation(int[] arr) {
		int i = arr.length - 1, j = arr.length - 1;	//맨뒤에서 시작
		while(i > 0 && arr[i] <= arr[i - 1]) {	//오름차순인 동안 i를 앞으로 전진
			i--;
		}
		if(i == 0) {	//전부 오름차순이면 마지막 순열이다.
			return false;
		}
		while(arr[i - 1] >= arr[j]) {	//i - 1번째에 들어갈 다음 숫자를 찾는다.
			j--;
		}
		
		int temp = arr[i - 1];	//교환
		arr[i - 1] = arr[j];
		arr[j] = temp;
		
		j = arr.length - 1;	//다시 끝에 두고
		
		while(i < j) {	//i -> <- j 서로 교환
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return true;
	}
	static boolean prePermutation(int[] arr) {
		int i = arr.length - 1, j = arr.length - 1;
		
		while(i > 0 && arr[i] >= arr[i - 1]) {
			i--;
		}
		
		if(i == 0) {
			return false;
		}
		
		while(arr[i - 1] <= arr[j]) {
			j--;
		}
		
		int temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;
		j = arr.length - 1;
		
		while(i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		
		return true;
	}
	static void recurPermutaion(int[] arr, boolean chk[], int n) {
		if(n == arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(!chk[i]) {
				chk[i] = true;
				arr[n] = i + 1;
				recurPermutaion(arr, chk, n + 1);
				chk[i] = false;
			}
		}
	}
}
