package algorithmsForPS;

//자연수 분할
public class AfcPartitioned {
	
	static int[] A = new int[30];
	static int COUNT;
	public static void main(String[] args) {
		solve(5, 5);
	}
	
	static void solve(int n, int k){
		if(n == 0){
			for(int i = 0 ; i < COUNT ; i++){
				System.out.print(A[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i = Math.min(n, k) ; i >= 1 ; i--){
				A[COUNT++] = i;
				System.out.println("n : "+ n + " i : " + i +" -> solve(" + (n - i) + ", " + k + ")");
				solve(n - i, k);
				COUNT--;
		}
	}
}
