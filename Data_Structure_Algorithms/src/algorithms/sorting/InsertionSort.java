package algorithms.sorting;

public class InsertionSort {

    public static int[] insertSort(int[] arr) {

        int len = arr.length;

        for (int i = 1; i < len; i++) {

            int value = arr[i];
            int hole = i;

            while (hole > 0 && arr[hole - 1] > value) {
                arr[hole] = arr[hole - 1];
                hole--;
            }

            arr[hole] = value;

        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 4, 7, 5, 11, 0};

        insertSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
