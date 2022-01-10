package baseball;

import static nextstep.utils.Randoms.pickNumberInRange;

public class Application {

    static int ball = 0, strike = 0;
    static StringBuilder number = new StringBuilder(), input = new StringBuilder();
    static String again;

    public static void answerInit() {
        ball = 0;
        strike = 0;
    }

    private static boolean checkInputValidation() {
        return !hasOverLength() && !hasSameNumber();
    }

    public static boolean hasOverLength() {
        return input.length() > 3;
    }

    public static boolean hasSameNumber() {
        int[] arr = new int[10]; //1-9

        for(int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i) - '0';
            arr[idx]++;
        }

        for(int i = 1; i < 10; i++){
            if(arr[i] >= 2) return true;
        }

        return false;
    }

    public static void normalizeInput() {
        if(input.length() == 2) {
            input.insert(0,"0");
        }else if(input.length() == 1) {
            input.insert(0,"00");
        }
    }

    public static void makeNewRandomNumber(){
        number.setLength(0);
        for(int i = 0; i < 3; i++){
            number.append(pickNumberInRange(1, 9));
        }
    }


    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
    }
}
