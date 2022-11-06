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
                case 1 -> {
                    arr = inputArray(scanner);
                    System.out.println("Enter search key");
                    int key = scanner.nextInt();
                    System.out.println(Searching.search(identifiers[1], arr, key));
                }
                case 2 -> {
                    arr = inputArray(scanner);
                    Sorting.sort(identifiers[1], arr);
                    printArray(arr);
                    System.out.println("\n");
                }
                case 3 -> {
                    scanner.close();
                    System.exit(0);
                }
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

    static int[] identifyProcessAndAlgorithm(Scanner scanner) {
        int processId = 0;
        int algorithmId = 0;
        System.out.println("Do you wish to search or sort");
        String process = scanner.next();
        if (process.equals("search")) {
            processId = 1;
            System.out.println("which searching algorithm do you wish to implement");
            System.out.println("\nlinear search \nbinary search");
        } else if (process.equals("sort")) {
            processId = 2;
            System.out.println("which sorting algorithm do you wish to implement");
            System.out.println("\nselection \n insertion \nshell \nquick \nmerge \n radix");
        } else {
            processId = 3;
        }
        if (processId != 3) {
            String algorithm = scanner.next();
            if (algorithm.equals("linear")) {
                algorithmId = 1;
            } else if (algorithm.equals("binary")) {
                algorithmId = 2;
            } else if (algorithm.equals("selection")) {
                algorithmId = 1;
            } else if (algorithm.equals("insertion")) {
                algorithmId = 2;
            } else if (algorithm.equals("shell")) {
                algorithmId = 3;
            } else if (algorithm.equals("quick")) {
                algorithmId = 4;
            } else if (algorithm.equals("merge")) {
                algorithmId = 5;
            } else if (algorithm.equals("radix")) {
                algorithmId = 6;
            }
        }
        int[] identifiers = {processId, algorithmId};
        return identifiers;
    }

    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
