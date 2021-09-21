package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostOrderTree {

	public static void main(String args[]){
		
		int[] a = {27,16,9,12,54,36,72};
		int[] b = {9,12,16,27,36,54,72};
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(int i : a){
			list1.add(i);
		}
		for(int i : b){
			list2.add(i);
		}
		printPostOrder(list1, list2);
		
	}
	public static void printPostOrder(List<Integer> preOrder, List<Integer> inOrder){
		
		int n = preOrder.size();
		
		if(preOrder.isEmpty()){
			return;
		}
		
		int root = preOrder.get(0);
		
		int l = findRoot(inOrder, root);
		
		int r = n - 1 - l;
		
		printPostOrder(slice(preOrder, 1, l+1 ),slice(inOrder, 0, l));
		printPostOrder(slice(preOrder, l+1, n), slice(inOrder, l+1, n));
		
		System.out.print(root+" ");
		
	}
	public static int findRoot(List<Integer> inOrder, int root){
		
		int l = 0;
		for(int i : inOrder){
			if(i==root){
				l = inOrder.indexOf(root);
			}
		}
		return l;
	}
	public static List<Integer> slice(List<Integer> order, int s, int e){
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=s ; i < e; i++){
			list.add(order.get(i));
		}
		return list;
	}
}
