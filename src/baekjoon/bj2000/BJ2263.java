package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//트리의 순회
public class BJ2263 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] inOrder = new int[N], postOrder = new int[N], temp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " "), st2 = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());	//중위순회 배열
			postOrder[i] = Integer.parseInt(st2.nextToken());	//후위순회 배열
			temp[inOrder[i]] = i; 	//postOrder에서 root를 inOrder에서의 인덱스로 찾기 위한 배열
		}
		printPreOrder(inOrder, postOrder, temp, 0, inOrder.length - 1, 0, postOrder.length - 1, sb);
		System.out.println(sb.substring(0, sb.length() - 1));
		br.close();
	}
	
	static void printPreOrder(int[] inOrder, int[] postOrder, int[] temp, int inStart, int inEnd, int postStart, int postEnd, StringBuilder sb){
		if(inEnd < inStart) {
			return;
		}else if(inEnd == inStart) {
			sb.append(inOrder[inStart] + " ");
			return;
		}else {
			int n = postOrder[postEnd], i = temp[n];	//n은 현재 루트, i는 inOrder배열에서 루트 인덱스
			sb.append(n + " ");	//현재 루트 출력
			printPreOrder(inOrder, postOrder, temp, inStart, i - 1, postStart, postStart + i - inStart - 1, sb); //루트 기준 왼쪽
			printPreOrder(inOrder, postOrder, temp, i + 1, inEnd, postStart + i - inStart, postEnd - 1, sb);	//루트 기준 오른쪽
		}
	}
}
