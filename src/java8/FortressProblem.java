package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FortressProblem {

	static int longest;
	
	public static void main(String args[]){
	
		
	}
	public static int height(TreeNode root){
		
		List<Integer> heights = new ArrayList<>();
		
		for(int i = 0 ; i < root.list.size() ; i++){
			heights.add(height(root.list.get(i)));
		}
		
		if(heights.isEmpty()){
			return 0;
		}
		
		Collections.sort(heights);
		
		if(heights.size() >= 2){
			longest = Math.max(longest, 2 + heights.get(heights.size() - 2) + heights.get(heights.size() - 1));
		}
		
		return heights.get(heights.size()-1) + 1;
	}
	public static int solve(TreeNode root){
		
		longest = 0;
		int h = height(root);
		
		return Math.max(longest, h);
	}
	
	
}
class TreeNode{
	List<TreeNode> list;
}
