package programmers;

//모음 사전
public class VowelDictionary {
    public static void main(String[] args) {
        String[] words = {"AAAAE", "AAAE", "I", "EIO"};

        for (String word : words) {
            System.out.println(solution(word));
        }
    }

    static int solution(String word) {
        int answer = 0;

        count = 0;
        result = -1;
        test(word,0);

        return answer = result;
    }

    static char[] words = new char[5];
    static char[] chs = {' ', 'A', 'E', 'I', 'O', 'U'};
    static int count = 0;
    static int result = -1;

    //A, E, I, O, U로 만드는 모든 5자리 문자열
    static void test(String word, int idx) {
        if(idx > 0 && words[idx - 1] == ' ') {  //이전 선택이 빈 문자열이면 문자열 완성.
            count++;
            if(idx - 1 == word.length()) {
                boolean same = true;
                for(int i = 0; i < idx - 1; i++) {
                    if(words[i] != word.charAt(i)) {
                        same = false;
                    }
                }
                if(same) {
                    result = count;
                }
            }
            return;
        }

        if(idx == 5) {  //5자리 문자열 완성
            count++;
            if(idx == word.length()) {
                boolean same = true;
                for(int i = 0; i < idx; i++) {
                    if(words[i] != word.charAt(i)) {
                        same = false;
                    }
                }
                if(same) {
                    result = count;
                }
            }
            return;
        }

        int start = idx == 0 ? 1 : 0;   //첫 시작은 빈 문자열이 아니어야 함.
        for(int i = start; i < chs.length; i++) {
            words[idx] = chs[i];
            test(word,idx + 1);
            words[idx] = '-';
        }
    }
}
