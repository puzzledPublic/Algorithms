package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
//트리 순회
public class BJ1991 {
	static class Tree{
		char root;
		Tree left, right;
		public Tree(char root) {
			this.root = root;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Tree[] tree = new Tree[N];
		for(int i = 0; i < N; i++) {	//N개의 트리 A ~ A + N 생성
			tree[i] = new Tree((char)(65 + i));
		}
		String[] ss;
		for(int i = 0; i < N; i++) {
			ss = br.readLine().split(" ");
			if(ss[1].charAt(0) != '.') {	//왼쪽자식이 있으면 생성
				tree[ss[0].charAt(0) - 65].left = tree[ss[1].charAt(0) - 65];
			}
			if(ss[2].charAt(0) != '.') {	//오른쪽자식이 있으면 생성
				tree[ss[0].charAt(0) - 65].right = tree[ss[2].charAt(0) - 65];
			}
		}
		solve(tree[0], bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(Tree root, Writer w) throws IOException {
		preOrder(root, w);	//전위
		w.write("\n");
		inOrder(root, w);	//중위
		w.write("\n");
		postOrder(root, w);	//후위
	}
	
	static void preOrder(Tree tree, Writer w) throws IOException {
		if(tree == null) {
			return;
		}
		w.write(tree.root);
		preOrder(tree.left, w);
		preOrder(tree.right, w);
	}
	static void inOrder(Tree tree, Writer w) throws IOException {
		if(tree == null) {
			return;
		}
		inOrder(tree.left, w);
		w.write(tree.root);
		inOrder(tree.right, w);
	}
	static void postOrder(Tree tree, Writer w) throws IOException {
		if(tree == null) {
			return;
		}
		postOrder(tree.left, w);
		postOrder(tree.right, w);
		w.write(tree.root);
	}
}
