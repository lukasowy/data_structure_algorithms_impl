package algorithms.sorting;

public class SelectSort {

    public static int[] selectSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {

            int min = i;

            //find smallest from min to n-1
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }

            //swap
            int tem = arr[i];
            arr[i] = arr[min];
            arr[min] = tem;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 7, 5};

        selectSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
