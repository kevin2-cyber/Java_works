package com.example.sns;

public class Searching {
    static String search(int algorithmID, int[] arr, int key){
        int solution = 0;
        int n = arr.length;
        String answer = "";
        switch (algorithmID) {
            case 1 -> solution = linearSearch(arr, key);
            case 2 -> solution = binarySearch(arr, 0, n - 1, key);
        }
        if(solution==-1){
            answer = "Sorry, your search key cannot be found!\n";
        }
        else if(solution==-2){
            answer = "cannot implement binary sort on unsorted array\n";
        }
        else{
            answer = Integer.toString(solution) + " was found in the array\n";
        }
        
        return answer;
    }
    static int linearSearch(int[] arr,int key){
        int n = arr.length;
        for (int j : arr) {
            if (key == j) {
                return key;
            }
        }
        return -1;
    }
    static int binarySearch(int[] arr,int l, int r, int key){
        int n = arr.length;
        if(isSorted(arr, n)){
            if (r >= l) {
                int mid = l + (r - l) / 2;
                if (arr[mid] == key)
                    return mid;
                if (arr[mid] > key)
                    return binarySearch(arr, l, mid - 1, key);
                return binarySearch(arr, mid + 1, r, key);
            }

            return -1;
        }
        return -2;
    }
    static boolean isSorted(int [] arr, int n){
        if (n == 0 || n == 1){
            return true;
        }
        for (int i=1; i<n;i++){
            if (arr[i-1]>arr[i]){
                return false;
            }
        }
        return true;
    }
}
