import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //put your code here
    // Create a new Scanner
    Scanner scanner = new Scanner(System.in);
    String output = scanner.nextLine();
    char ten;
    if (output.length() < 2){
      ten = '0';
    } else {
      ten = output.charAt(output.length() - 2);
    }
    System.out.println(ten);



  }
}