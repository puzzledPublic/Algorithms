package programmers;

public class TestCharacterType {
    public static void main(String[] args) {

        String[][] surveys = {
                {"AN", "CF", "MJ", "RT", "NA"},
                {"TR", "RT", "TR"}
        };

        int[][] choicess = {
                {5, 3, 2, 7, 5},
                {7, 1, 3}
        };

        for (int i = 0; i < surveys.length; i++) {
            System.out.println(solution(surveys[i], choicess[i]));
        }
    }

    static public String solution(String[] survey, int[] choices) {
        String answer = "";

        int[] ch = new int[26];

        for (int i = 0; i < survey.length; i++) {
            char left = survey[i].charAt(0);    //왼쪽 성향
            char right = survey[i].charAt(1);   //오른쪽 성향
            int choice = choices[i];    //선택
            int point = Math.abs(choice - 4);   //점수

            if (choice > 4) {   //동의
                ch[right - 'A'] += point;
            } else if (choice < 4) {    //비동의
                ch[left - 'A'] += point;
            }
        }

        char[][] order = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

        for (int i = 0; i < order.length; i++) {
            //해당 지표에 대해 점수가 높은걸 택한다. 점수가 같은 경우 알파벳순으로 앞선 것을 택한다.
            answer += ch[order[i][0] - 'A'] >= ch[order[i][1] - 'A'] ? order[i][0] : order[i][1];
        }

        return answer;
    }
}
