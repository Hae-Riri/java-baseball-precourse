package baseball;

import static nextstep.utils.Randoms.pickNumberInRange;

import nextstep.utils.Console;

public class Application {

    static int ball = 0, strike = 0;
    static StringBuilder number = new StringBuilder(), input = new StringBuilder();
    static String again;

    public static void answerInit() {
        ball = 0;
        strike = 0;
    }

    public static void main(String[] args) {
        do {
            answerInit();
            play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            again = Console.readLine();
        } while (again.equals("1"));

        System.out.println("게임 끝");
    }

    public static void play() {
        makeNewRandomNumber();
        while (strike != 3) {
            answerInit();
            System.out.print("숫자를 입력해주세요 : ");
            input.setLength(0);
            input.append(Console.readLine());

            if(!checkInputValidation()) {
                System.out.println("[ERROR] 서로 다른 숫자로 이루어진 세 자리 이하의 값을 입력하세요.");
                return;
            }

            setStrikeAndBall();
            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            }else if(strike > 0 && ball > 0){
                System.out.println("\n" + strike + "스트라이크 "+ ball + "볼 ");
            }else if(strike == 0){
                System.out.println("\n" + ball + "볼");
            }else if(ball == 0){
                System.out.println("\n" + strike + "스트라이크");
            }
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void makeNewRandomNumber(){
        number.setLength(0);
        for(int i = 0; i < 3; i++){
            number.append(pickNumberInRange(1, 9));
        }
    }

    /**
     * Error : 사용자가 3자리를 초고하는 수, 반복된 수가 2개 이상 있는 숫자라면 에러
     * 사용자는 3자리 미만의 수를 쓸 수도 있다. 사용자 숫자가 3자리수 미만이면 0추가해서 비교하자
     * */
    private static boolean checkInputValidation() {
        if(input.length() > 3) return false;

        int[] arr = new int[10]; //1-9
        for(int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i) - '0';
            arr[idx]++;
        }
        for(int i = 1; i < 10; i++){
            if(arr[i] >= 2) return false;
        }

        if(input.length() == 2) {
            input.insert(0,"0");
        }else if(input.length() == 1) {
            input.insert(0,"00");
        }

        return true;
    }

    public static void setStrikeAndBall() {
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) == number.charAt(i)) {
                strike++;
                continue;
            }
            setBall(i);
        }
    }

    public static void setBall(int i){
        for (int j = 0; j < 3; j++) {
            if (i == j) {
                continue;
            }
            if (input.charAt(i) == number.charAt(j)) {
                ball++;
            }
        }
    }
}
