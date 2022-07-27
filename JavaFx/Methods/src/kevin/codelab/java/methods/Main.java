package kevin.codelab.java.methods;

public class Main {
    public static void main(String[] args) {


        calculateScore(true, 800, 5, 100);

        calculateScore(true, 10000, 8, 200);


//        int[] num2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//
//        for (int i = 0; i < num2.length; i++) {
//            System.out.println("i = " + i);
//        }


    }

    public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            System.out.println("Your final score was " + finalScore);
        }
    }
}