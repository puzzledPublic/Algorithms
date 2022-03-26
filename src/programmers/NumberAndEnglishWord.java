package programmers;

//숫자 문자열과 영단어
public class NumberAndEnglishWord {
    public static void main(String[] args) {
        String[] ss = {
                "one4seveneight",   //1478
                "23four5six7",  //234567
                "2three45sixseven", //234567
                "123",  //123
                "oneone"    //11
        };

        for(String s : ss) {
            System.out.println(solution(s));
        }
    }

    static int solution(String s) {
        int answer = 0;

        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < words.length; i++) {
            s = s.replace(words[i], i + "");
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
