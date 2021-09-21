package swExpertAcademy.D4;

import java.util.Scanner;

public class SWEA8189 {
	static class CusList {
		private int[] arr = new int[200];
		private int size = 0;
		
		public void add(int num) {
			arr[size++] = num;
		}
		public void print() {
			for(int i = 0; i < size; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
	static class CusQueue {
		private int[] arr = new int[3000];
		private int size = 0;
		private int sp = 0;
		private int ep = 0;
		public void push(int num) {
			arr[ep + 1] = num;
			ep++;
		}
		public int size() {
			return ep - sp;
		}
		public int front() {
			return arr[sp + 1];
		}
		public void pop() {
			sp++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
            
			
			CusQueue q = new CusQueue();
			CusQueue post = new CusQueue();
			for(int i = 0; i < N; i++) {
				int time = sc.nextInt();
				q.push(time);
				post.push(time);
			}
			
			int curTime = 0;
			
			CusList list = new CusList();
			CusQueue curPost = new CusQueue();
			
			while(q.size() != 0) {
				curTime++;
				if(post.size() != 0 && post.front() == curTime) {
					curPost.push(post.front());
					post.pop();
				}
				
				if(curPost.size() >= A || curTime - q.front() == B) {
					int len = curPost.size() / 2 + (curPost.size() % 2);
					for(int i = 0; i < len; i++) {
						list.add(curTime);
						q.pop();
						curPost.pop();
					}
				}
			}
			
			System.out.print("#" + test_case + " ");
			list.print();
			
		}
	}
}
//public class SWEA8189 {
//	static class CusList {
//		private int[] arr = new int[200];
//		private int size = 0;
//		
//		public void add(int num) {
//			arr[size++] = num;
//		}
//		public void print() {
//			for(int i = 0; i < size; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();
//		}
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T;
//		T=sc.nextInt();
//		
//		for(int test_case = 1; test_case <= T; test_case++)
//		{
//			int N = sc.nextInt();
//			int A = sc.nextInt();
//			int B = sc.nextInt();
//            
//			int[] letter = new int[N];
//			for(int i = 0; i < N; i++) {
//				letter[i] = sc.nextInt();
//			}
//			CusList list = new CusList();
//			int sp = -1, ep = 0;
//			
//			while(ep < N) {
//				int size = ep - sp;
//				if(size == A) {
//					int erase = size / 2 + (size % 2);
//					while(erase > 0) {
//						sp++;
//						list.add(letter[ep]);
//						erase--;
//					}
//				}
//				
//				size = ep - sp;
//				if(ep + 1 < N && letter[ep + 1] > letter[sp + 1] + B) {
//					int erase = size / 2 + (size % 2);
//					int eraseTime = letter[sp + 1];
////					System.out.println(eraseTime + B + " " + erase);
//					while(erase > 0) {
//						sp++;
//						list.add(eraseTime + B);
//						erase--;
//					}
//				}
//				ep++;
//			}
//			ep--;
////			System.out.println(sp + " " + ep);
//			while(sp < ep) {
//				int size = ep - sp;
//				int erase = size / 2 + (size % 2);
//				int eraseTime = letter[sp + 1];
//				while(erase > 0) {
//					sp++;
//					list.add(eraseTime + B);
//					erase--;
//				}
//			}
//			System.out.print("#" + test_case + " ");
//			list.print();
//		}
//	}
//}
