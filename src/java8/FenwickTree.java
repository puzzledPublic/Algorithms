package java8;

//펜윅 트리 (Fenwick Tree or Binary Indexed Tree)
//수시로 갱신되는 배열에서 구간합을 구할때 유용
public class FenwickTree {
	static int n = 10;
	static int[] tree = new int[11];
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		for(int i = 1; i < arr.length; i++) {	//펜윅트리를 업데이트해 초기화 해줘야한다.
			update(i, arr[i]);
		}
		
		for(int i = 1; i < arr.length; i++) {
			System.out.println("1 ~ " + i + " 위치까지의 합: " + sum(i));
		}
	}
	
	//합구하기, A[1] ~ A[i]까지의 합. (A[i] ~ A[j]의 합은 sum(j) - sum(i - 1)로 알 수 있다.)
	static int sum(int i) {
		int ans = 0;
		while(i > 0) {
			ans += tree[i];
			i -= (i & -i);	//(i & -i)는 i의 오른쪽의 마지막 1비트만 남기는 연산이고 이를 i에서 뺴주면 i의 마지막 1비트를 제거하게 된다. 이 값은 다음에 더할 값의 위치를 알려준다.
		}
		return ans;
	}
	
	//변경
	static void update(int i, int num) {
		while(i <= n) {
			tree[i] += num;
			i += (i & -i);	//sum과 반대로 +를 해주므로서 마지막 1비트에 1을 더해서 나오는 값으로 다음에 업데이트할 위치를 알게 된다.
		}
	}
}
