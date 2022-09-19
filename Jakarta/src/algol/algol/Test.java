package algol.algol;

import static algol.algol.Euclid.euclid;
import static algol.algol.Sorting.mergeSort;

public class Test {
    public static void main(String[] args) {

        int eu = euclid(60, 24);
        System.out.println(eu);
        int test2 = euclid(90, 40);
        System.out.println(test2);
        mergeSort(new int[]{2, 4, 6, 7, 3, 1, 3, 2, 4}, 4, 8);

    }


}
