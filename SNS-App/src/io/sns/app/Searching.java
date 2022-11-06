package io.sns.app;

public class Searching {
    static String search(int algorithmId, int[] arr, int key) {
        int solution = 0;
        int n = arr.length;
        String answer = "";
        switch (algorithmId) {
            case 1 -> solution = linearSearch(arr, key);
            case 2 -> solution = binarySearch(arr, 0, n - 1, key);
        }
        if (solution == -1) {
            answer = "Sorry, your search key cannot be found!\n";
        } else if (solution == -2) {
            answer = "cannot implement binary search on unsorted array\n";
        } else {
            answer = solution  +  "was found in the array\n";
        }
        return answer;
    }

    static int linearSearch(int[] arr, int key) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (key == arr[i]) {
                return key;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int l, int r, int key) {
        int n = arr.length;
        if (isSorted(arr, n)) {
            if (r >= l) {
                int mid = l + (r - l) / 2;
                if (arr[mid] == key) {
                    return mid;
                }
                if (arr[mid] > key) {
                    return binarySearch(arr, l, mid - 1, key);
                }
                return binarySearch(arr, mid + 1, r, key);
            }
            return -1;
        }
        return -2;
    }

    static boolean isSorted(int[] arr, int n) {
        if (n == 0||n == 1) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

}
