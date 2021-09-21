package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//28.3 고대어 사전(위상정렬)
public class AncientDictionary {
	static int[][] G = new int[26][26];
	static int n;
	static int[] V = new int[26];
	static List<Integer> S = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		List<String> words = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			words.add(input.next());
		}
		//받은 단어들을 서로 비교하며 알파벳의 상대적인 순서를 그래프(인접행렬)로 만듬
		for (int i = 1; i < n; i++) {
			int j = i - 1;
			int length = Math.min(words.get(i).length(), words.get(j).length());
			for (int k = 0; k < length; k++) {
				char a = words.get(j).charAt(k);
				char b = words.get(i).charAt(k);
				if (a != b) {
					G[(int) (a - 'a')][(int) (b - 'a')] = 1;
					break;
				}
			}
		}

		for (int i = 0; i < G.length; i++) {
			if(V[i]==0){
				dfs(i);
			}
		}
		Collections.reverse(S);
		
		
		for(int i : S){
			System.out.print((char)(i+'a')+" ");
		}

	}

	private static void dfs(int here) {
		V[here] = 1;
		for (int i = 0; i < G.length; i++) {
			if (G[here][i] == 1 && V[i] == 0) {
				dfs(i);
			}
		}
		S.add(here);
	}
}
