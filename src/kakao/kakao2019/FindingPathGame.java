package kakao.kakao2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindingPathGame {
	public static void main(String[] args) {
		int[][] nodeinfo = {
				{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}
		};
		
		int[][] answer = solution(nodeinfo);
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < answer[0].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}
	static class Node {		//노드
		int index, x, y;
		Node(int index, int x, int y) {
			this.index = index;
			this.x = x;
			this.y = y;
		}
	}
	static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        List<Node> nodeList = new ArrayList<>();
        int right = -1;
        for(int i = 0; i < nodeinfo.length; i++) {
        	if(right < nodeinfo[i][0]) {	//가장 오른쪽에 위치하는 노드의 x값을 찾는다.
        		right = nodeinfo[i][0];
        	}
        	nodeList.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        Collections.sort(nodeList, (a, b) -> {	//y순으로 내림차순 정렬, x순으로 오름차순 정렬
        	return b.y - a.y == 0 ? a.x - b.x : b.y - a.y;
        });
        
        List<List<Node>> nodeTree = new ArrayList<>();	//노드로 만들 트리
        
        nodeTree.add(new ArrayList<>());
        nodeTree.get(0).add(nodeList.get(0));			//트리의 루트는 y값이 제일 큰 값 
        
        for(int i = 1; i < nodeList.size(); i++) {
        	if(nodeList.get(i).y != nodeList.get(i - 1).y) {	//y가 다르면 하위 레벨(자식)에 속한다.
        		nodeTree.add(new ArrayList<>());				//다음 레벨 생성
        		nodeTree.get(nodeTree.size() - 1).add(nodeList.get(i));	//노드 추가
        	}else {
        		nodeTree.get(nodeTree.size() - 1).add(nodeList.get(i));
        	}
        }
        
        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> postOrderList = new ArrayList<>();
        
        preOrder(nodeTree, preOrderList, nodeList.get(0), 1, -1, right + 1);	//전위순회
        postOrder(nodeTree, postOrderList, nodeList.get(0), 1, -1, right + 1);	//후위순회
        
        answer[0] = preOrderList.stream().mapToInt((a) -> a).toArray();			//int배열로 변환
        answer[1] = postOrderList.stream().mapToInt((a) -> a).toArray();
        
        return answer;
    }
	
	static void preOrder(List<List<Node>> nodeTree, List<Integer> preOrderList, Node root, int depth, int left, int right) {
		preOrderList.add(root.index);
		if(depth == nodeTree.size()) {
			return;
		}
		for(Node node : nodeTree.get(depth)) {
			if(left <= node.x && node.x < root.x) {
				preOrder(nodeTree, preOrderList, node, depth + 1, left, root.x);
			}
			if(root.x < node.x && node.x <= right) {
				preOrder(nodeTree, preOrderList, node, depth + 1, root.x, right);
			}
		}
	}
	static void postOrder(List<List<Node>> nodeTree, List<Integer> postOrderList, Node root, int depth, int left, int right) {
		if(depth == nodeTree.size()) {
			postOrderList.add(root.index);
			return;
		}
		for(Node node : nodeTree.get(depth)) {
			if(left <= node.x && node.x < root.x) {
				postOrder(nodeTree, postOrderList, node, depth + 1, left, root.x);
			}
			
			if(root.x < node.x && node.x <= right) {
				postOrder(nodeTree, postOrderList, node, depth + 1, root.x, right);
			}
		}
		postOrderList.add(root.index);
	}
}
