package io.sns.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] identifiers;
        int[] arr;
        while (true) {
            identifiers = identifyProcessAndAlgorithm(scanner);
            switch (identifiers[0]) {
                case 1:
                    arr = inputArray(scanner);
                    System.out.println("Enter search key");
                    int key = scanner.nextInt();
                    System.out.println(Searching.search(identifiers[1], arr, key));
                    break;
                case 2:
                    arr = inputArray(scanner);
                    Sorting.sort(identifiers[1], arr);
                    printArray(arr);
                    System.out.println("\n");
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }

    static int[] inputArray(Scanner scanner) {
        int n;
        System.out.println("Enter the size of the array ");
        n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements of array");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        return arr;
    }

    static int[] identifyProcessAndAlgorithm(Scanner scanner) {}
}
