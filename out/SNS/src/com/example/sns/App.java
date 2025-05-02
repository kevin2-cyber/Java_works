package com.example.sns;

import java.util.Scanner;
/*
process ID = 1 => searching
process ID = 2 => sorting 

algorithm ID = 1 => DEPENDS ON PROCESS ID is either linear search or selection sort
algorithm ID = 2 => DEPENDS ON PROCESS ID is either binary search or insertion sort
algorithm ID = 3 => shell sort
algorithm ID = 4 => quick sort
algorithm ID = 5 => merge sort
algorithm ID = 6 => radix sort
*/
public class App {
    public static void main(String[] args){ 
        Scanner scanner = new Scanner(System.in);
        int[] identifiers;
        int[] arr;
        while(true){
            identifiers = identifyProcessAndAlgorithm(scanner);
            switch (identifiers[0]) {
                case 1 -> {
                    arr = inputArray(scanner);
                    System.out.println("Enter search key");
                    int key = scanner.nextInt();
                    System.out.print(Searching.search(identifiers[1], arr, key));
                }
                case 2 -> {
                    arr = inputArray(scanner);
                    Sorting.sort(identifiers[1], arr);
                    printArray(arr);
                    System.out.print("\n");
                }
                case 3 -> {
                    scanner.close();
                    System.exit(0);
                }
            }
        }  
    }
    
    static int[] inputArray(Scanner scanner){
        int n;
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size for array ");
        n = scanner.nextInt();

        int [] arr = new int[n];
        System.out.println("Enter elements of array");
        for (int i =0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        //scanner.close();
        return arr;
    

    }
    static int[] identifyProcessAndAlgorithm(Scanner scanner){
        int processID = 0;
        int algorithmID = 0;
        System.out.println("Do you wish to search or sort?"); 
        String process = scanner.next();
        if(process.equals("search")){
            processID = 1;
            System.out.println("which searching algorithm do you wish to implement");
            System.out.println("\nlinear search \nbinary search");
        }
        else if(process.equals("sort")){
            processID = 2;
            System.out.println("which sorting algorithm do you wish to implement");
            System.out.println("\nselection  \ninsertion  \nshell  \nquick  \nmerge  \nradix ");
        }
        else{
            processID = 3;
        }
        if (processID!=3){
            String algorithm = scanner.next();
            switch (algorithm) {
                case "linear", "selection" -> algorithmID = 1;
                case "binary", "insertion" -> algorithmID = 2;
                case "shell" -> algorithmID = 3;
                case "quick" -> algorithmID = 4;
                case "merge" -> algorithmID = 5;
                case "radix" -> algorithmID = 6;
            }
        }
        int[] identifiers = {processID, algorithmID};
        return identifiers;
    }
    static void printArray(int[]arr){
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
