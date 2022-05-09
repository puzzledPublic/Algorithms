package programmers;

import java.util.Stack;

//표 편집
public class EditingChart {
    public static void main(String[] args) {
        int[] ns = {8, 8};
        int[] ks = {2, 2};
        String[][] cmds = {
                {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"},  //OOOOXOOO
                {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"},    //OOXOXOOO
        };

        for(int i = 0; i < ns.length; i++) {
            System.out.println(solution(ns[i], ks[i], cmds[i]));
        }
    }
    //"U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
    //"D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
    //"C":현재 선택된 행을 삭제한 후, 바래 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
    //"Z": 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행을 바뀌지 않습니다.
    static String solution(int n, int k, String[] cmd) {
        String answer = "";

        Stack<Node> removedNodes = new Stack<>();
        Node[] nodes = new Node[n];

        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }

        nodes[0].prev = nodes[n - 1].next = null;
        for(int i = 1; i < nodes.length; i++) {
            nodes[i - 1].next = nodes[i];
            nodes[i].prev = nodes[i - 1];
        }

        Node currNode = nodes[k];

        for(String ops : cmd) {
            String[] parsed = ops.split(" ");
            String op = parsed[0];
            int move;
            switch (op) {
                case "U":   //조건에 "U X, D X" 명령의 모든 X의 합이 1,000,000 이하라고 한다. 그래서 하나씩 이동해도 시간 초과는 나지 않음
                    move = Integer.parseInt(parsed[1]);
                    while(move != 0) {
                        currNode = currNode.prev;
                        move--;
                    }
                    break;
                case "D":
                    move = Integer.parseInt(parsed[1]);
                    while(move != 0) {
                        currNode = currNode.next;
                        move--;
                    }
                    break;
                case "C":
                    currNode.isRemoved = true;
                    removedNodes.push(currNode);

                    if(currNode.prev == null) {
                        currNode.next.prev = null;
                        currNode = currNode.next;
                    }else if(currNode.next == null) {
                        currNode.prev.next = null;
                        currNode = currNode.prev;
                    }else {
                        currNode.prev.next = currNode.next;
                        currNode.next.prev = currNode.prev;
                        currNode = currNode.next;
                    }

                    break;
                case "Z":
                    Node restoreNode = removedNodes.pop();
                    restoreNode.isRemoved = false;
                    if(restoreNode.prev == null) {
                        restoreNode.next.prev = restoreNode;
                    }else if(restoreNode.next == null) {
                        restoreNode.prev.next = restoreNode;
                    }else {
                        restoreNode.prev.next = restoreNode;
                        restoreNode.next.prev = restoreNode;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nodes.length; i++) {
            sb.append(nodes[i].isRemoved ? "X" : "O");
        }

        return answer = sb.toString();
    }

    static class Node {
        Node prev, next;
        boolean isRemoved;
    }
}
