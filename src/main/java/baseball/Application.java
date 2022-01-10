package baseball;

import static nextstep.utils.Randoms.pickNumberInRange;

import java.util.Arrays;
import nextstep.utils.Console;

public class Application {

    static int ball = 0, strike = 0;
    static StringBuilder number = new StringBuilder(), input = new StringBuilder();
    static String again;
    static int[] count = new int[10];

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        do{
            answerReset();
            game();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            again = Console.readLine();
        } while (again.equals("1"));

        System.out.println("게임 끝");
    }

    public static void answerReset() {
        ball = 0;
        strike = 0;
    }

    public static void game() {
        makeNewRandomNumber();

        while(strike != 3) {
            answerReset();

            System.out.println("숫자를 입력해주세요 : ");
            input.setLength(0);
            input.append(Console.readLine());

            if(!inputValidation()) {
                System.out.println("[ERROR] 서로 다른 숫자로 이루어진 세 자리 값을 입력하세요.");
                return;
            }

            countStrikeAndBall();
            printAnswer();
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void makeNewRandomNumber(){
        number.setLength(0);
        Arrays.fill(count, 0);
        for(int i = 0; i < 3; i++){
            int pickNum = pickNumberInRange(1, 9);
            number.append(pickNum);
            count[pickNum]++;
        }
    }

    private static boolean inputValidation() {
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

    public static void countStrikeAndBall() {
        for(int i = 0; i < 3; i++) {
            if(input.charAt(i) == number.charAt(i)) strike++;
            else if(count[input.charAt(i) - '0'] > 0){
                ball++;
            }
        }
    }

    public static void printAnswer() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }else if(strike > 0 && ball > 0){
            System.out.println("\n" + strike + "스트라이크 "+ ball + "볼");
        }else if(strike == 0){
            System.out.println("\n" + ball + "볼");
        }else if(ball == 0){
            System.out.println("\n" + strike + "스트라이크");
        }
    }
}
