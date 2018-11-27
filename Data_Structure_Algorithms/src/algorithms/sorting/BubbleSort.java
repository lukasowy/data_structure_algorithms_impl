package algorithms.sorting;

public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) { // as many times as long is array
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 7, 5, 11, 0};

        bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
