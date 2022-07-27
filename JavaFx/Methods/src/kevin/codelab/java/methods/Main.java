package kevin.codelab.java.methods;

public class Main {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        calculateScore(gameOver, score, levelCompleted, bonus);

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