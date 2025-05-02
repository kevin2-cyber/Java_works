import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //put your code here
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    int first = Character.getNumericValue(s.charAt(0));
    int second = Character.getNumericValue(s.charAt(1));
    int third = Character.getNumericValue(s.charAt(2));

    System.out.println(first + second + third);
  }
}