package programmers;

import java.util.*;

//다단계 칫솔 판매
public class PyramidToothbrushSelling {
    public static void main(String[] args) {
        String[][] enrolls = {
                {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
        };

        String[][] referrals = {
                {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
        };

        String[][] sellers = {
                {"young", "john", "tod", "emily", "mary"},
                {"sam", "emily", "jaimie", "edward"}
        };

        int[][] amounts = {
                {12, 4, 2, 5, 10},
                {2, 3, 5, 4},
        };

        for (int i = 0; i < enrolls.length; i++) {
            Arrays.stream(solution(enrolls[i], referrals[i], sellers[i], amounts[i])).forEach(r -> System.out.print(r + " "));
            System.out.println();
        }

    }

    static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};

        Map<String, Node> map = new HashMap<>();
        map.put("-root-", new Node(null));
        for (int i = 0; i < enroll.length; i++) {
            String e = enroll[i];
            String r = referral[i];
            Node p = r.equals("-") ? map.get("-root-") : map.get(r);
            map.put(e, new Node(p));
        }

        for (int i = 0; i < seller.length; i++) {
            map.get(seller[i]).distribute(amount[i] * 100);
        }

        List<Integer> results = new ArrayList<>();
        for (String e : enroll) {
            results.add(map.get(e).total);
        }


        return answer = results.stream().mapToInt(a -> a).toArray();
    }

    static class Node {
        Node parent;
        int total;

        Node(Node parent) {
            this.parent = parent;
        }

        void distribute(int won) {
            if (parent != null) {
                double w = ((double) won * 0.1d);
                int d = w < 1.0d ? 0 : (int) w;
                int t = w < 1.0d ? won : (int) Math.round((double) won - d);
                total += t;
                parent.distribute(d);
            }else {
                total += won;
            }
        }
    }
}
